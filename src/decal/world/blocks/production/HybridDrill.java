package decal.world.blocks.production;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;


import static mindustry.Vars.*;
/*
public class HybridDrill extends LiquidBlock{
    public float pumpAmount = 0.2f;
    public float consumeTime = 60f * 5f;
    public DrawBlock drawer = new DrawMulti(new DrawDefault(), new DrawPumpLiquid());
        public float hardnessDrillMultiplier = 50f;

    protected final ObjectIntMap<Item> oreCount = new ObjectIntMap<>();
    protected final Seq<Item> itemArray = new Seq<>();


    public int tier;

    public float drillTime = 300;

    public float liquidBoostIntensity = 1.6f;

    public float warmupSpeed = 0.015f;

    public @Nullable Item blockedItem;


    protected @Nullable Item returnItem;
    protected int returnCount;

    public boolean drawMineItem = true;
 
    public Effect drillEffect = Fx.mine;

    public float drillEffectRnd = -1f;

    public float rotateSpeed = 2f;

    public Effect updateEffect = Fx.pulverizeSmall;

    public float updateEffectChance = 0.02f;

    public boolean drawRim = false;
    public boolean drawSpinSprite = true;
    public Color heatColor = Color.valueOf("ff5512");
    public TextureRegion rimRegion = Core.atlas.find(this.name + "-rim");
    public TextureRegion rotatorRegion = Core.atlas.find(this.name + "-rotator");
    public TextureRegion topRegion = Core.atlas.find(this.name + "-top");
    public TextureRegion itemRegion = Core.atlas.find(this.name + "-item");

    public HybridDrill(String name) {
        super(name);
        floating = true;
        update = true;
        solid = true;
        group = BlockGroup.drills;
        hasLiquids = true;
        liquidCapacity = 5f;
        hasItems = true;
        ambientSound = Sounds.drill;
        ambientSoundVolume = 0.018f;

        envEnabled |= Env.space;
    }
    @Override
    public void setStats(){
        super.setStats();
        stats.add(Stat.output, 60f * pumpAmount * size * size, StatUnit.liquidSecond);

        stats.add(Stat.drillTier, StatValues.blocks(b -> b instanceof Floor f && !f.wallOre && f.itemDrop != null &&
            f.itemDrop.hardness <= tier && f.itemDrop != blockedItem && (indexer.isBlockPresent(f) || state.isMenu())));

        stats.add(Stat.drillSpeed, 60f / drillTime * size * size, StatUnit.itemsSecond);
        if(liquidBoostIntensity != 1){
            stats.add(Stat.boostEffect, liquidBoostIntensity * liquidBoostIntensity, StatUnit.timesSpeed);
    }
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);

        Tile tile = world.tile(x, y);
        if(tile == null) return;

        float amount = 0f;
        Liquid liquidDrop = null;

        for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            if(canPump(other)){
                if(liquidDrop != null && other.floor().liquidDrop != liquidDrop){
                    liquidDrop = null;
                    break;
                }
                liquidDrop = other.floor().liquidDrop;
                amount += other.floor().liquidMultiplier;
            }
        }

        if(liquidDrop != null){
            float width = drawPlaceText(Core.bundle.formatFloat("bar.pumpspeed", amount * pumpAmount * 60f, 0), x, y, valid);
            float dx = x * tilesize + offset - width/2f - 4f, dy = y * tilesize + offset + size * tilesize / 2f + 5, s = iconSmall / 4f;
            float ratio = (float)liquidDrop.fullIcon.width / liquidDrop.fullIcon.height;
            Draw.mixcol(Color.darkGray, 1f);
            Draw.rect(liquidDrop.fullIcon, dx, dy - 1, s * ratio, s);
            Draw.reset();
            Draw.rect(liquidDrop.fullIcon, dx, dy, s * ratio, s);
        }
                countOre(tile);

        if(returnItem != null){
            float width = drawPlaceText(Core.bundle.formatFloat("bar.drillspeed", 60f / getDrillTime(returnItem) * returnCount, 2), x, y, valid);
            float dx = x * tilesize + offset - width/2f - 4f, dy = y * tilesize + offset + size * tilesize / 2f + 5, s = iconSmall / 4f;
            Draw.mixcol(Color.darkGray, 1f);
            Draw.rect(returnItem.fullIcon, dx, dy - 1, s, s);
            Draw.reset();
            Draw.rect(returnItem.fullIcon, dx, dy, s, s);

            if(drawMineItem){
                Draw.color(returnItem.color);
                Draw.rect(itemRegion, tile.worldx() + offset, tile.worldy() + offset);
                Draw.color();
            }
        }else{
            Tile to = tile.getLinkedTilesAs(this, tempTiles).find(t -> t.drop() != null && (t.drop().hardness > tier || t.drop() == blockedItem));
            Item item = to == null ? null : to.drop();
            if(item != null){
                drawPlaceText(Core.bundle.get("bar.drilltierreq"), x, y, valid);
            }
        }

    }

    @Override
    public void load(){
        super.load();
        drawer.load(this);
    }

    @Override
    public TextureRegion[] icons(){
         return new TextureRegion[]{region, rotatorRegion, topRegion};
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        if(isMultiblock()){
            Liquid last = null;
            for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
                if(other.floor().liquidDrop == null) continue;
                if(other.floor().liquidDrop != last && last != null) return false;
                last = other.floor().liquidDrop;
            }
            return last != null;
        }else{
            return canPump(tile);
        }
        if(isMultiblock()){
            for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
                if(canMine(other)){
                    return true;
                }
            }
            return false;
        }else{
            return canMine(tile);
        }
    }

    @Override
    public void setBars(){
        super.setBars();


        addBar("drillspeed", (DrillBuild e) ->
             new Bar(() -> Core.bundle.format("bar.drillspeed", Strings.fixed(e.lastDrillSpeed * 60 * e.timeScale(), 2)), () -> Pal.ammo, () -> e.warmup));
        addLiquidBar((HybridDrillBuild build) -> build.liquidDrop);
    }

    protected boolean canPump(Tile tile){
        return tile != null && tile.floor().liquidDrop != null;
    }

    public class HybridDrillBuild extends LiquidBuild{
        public float consTimer;
        public float amount = 0f;
        public @Nullable Liquid liquidDrop = null;

        @Override
        public void draw(){
            drawer.draw(this);
        }

        @Override
        public void drawLight(){
            super.drawLight();
            drawer.drawLight(this);
        }

        @Override
        public void pickedUp(){
            amount = 0f;
        }

        @Override
        public double sense(LAccess sensor){
            if(sensor == LAccess.totalLiquids) return liquidDrop == null ? 0f : liquids.get(liquidDrop);
            return super.sense(sensor);
        }

        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();

            amount = 0f;
            liquidDrop = null;

            for(Tile other : tile.getLinkedTiles(tempTiles)){
                if(canPump(other)){
                    liquidDrop = other.floor().liquidDrop;
                    amount += other.floor().liquidMultiplier;
                }
            }
        }

        @Override
        public boolean shouldConsume(){
            return liquidDrop != null && liquids.get(liquidDrop) < liquidCapacity - 0.01f && enabled;
        }

        @Override
        public void updateTile(){
            if(efficiency > 0 && liquidDrop != null){
                float maxPump = Math.min(liquidCapacity - liquids.get(liquidDrop), amount * pumpAmount * edelta());
                liquids.add(liquidDrop, maxPump);


                if((consTimer += delta()) >= consumeTime){
                    consume();
                    consTimer = 0f;
                }
            }

            if(liquidDrop != null){
                dumpLiquid(liquidDrop);
            }
        }
    }
    @Override
    public void init(){
        super.init();
        if(drillEffectRnd < 0) drillEffectRnd = size;
    }

    @Override
    public void drawPlanConfigTop(BuildPlan plan, Eachable<BuildPlan> list){
        if(!plan.worldContext) return;
        Tile tile = plan.tile();
        if(tile == null) return;

        countOre(tile);
        if(returnItem == null || !drawMineItem) return;

        Draw.color(returnItem.color);
        Draw.rect(itemRegion, plan.drawx(), plan.drawy());
        Draw.color();
    }

    public Item getDrop(Tile tile){
        return tile.drop();
    }


    public float getDrillTime(Item item){
        return drillTime + hardnessDrillMultiplier * item.hardness;
    }


    protected void countOre(Tile tile){
        returnItem = null;
        returnCount = 0;

        oreCount.clear();
        itemArray.clear();

        for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            if(canMine(other)){
                oreCount.increment(getDrop(other), 0, 1);
            }
        }

        for(Item item : oreCount.keys()){
            itemArray.add(item);
        }

        itemArray.sort((item1, item2) -> {
            int type = Boolean.compare(!item1.lowPriority, !item2.lowPriority);
            if(type != 0) return type;
            int amounts = Integer.compare(oreCount.get(item1, 0), oreCount.get(item2, 0));
            if(amounts != 0) return amounts;
            return Integer.compare(item1.id, item2.id);
        });

        if(itemArray.size == 0){
            return;
        }

        returnItem = itemArray.peek();
        returnCount = oreCount.get(itemArray.peek(), 0);
    }

    public boolean canMine(Tile tile){
        if(tile == null || tile.block().isStatic()) return false;
        Item drops = tile.drop();
        return drops != null && drops.hardness <= tier && drops != blockedItem;
    }

    public class DrillBuild extends Building{
        public float progress;
        public float warmup;
        public float timeDrilled;
        public float lastDrillSpeed;

        public int dominantItems;
        public Item dominantItem;

        @Override
        public boolean shouldConsume(){
            return items.total() < itemCapacity && enabled;
        }

        @Override
        public boolean shouldAmbientSound(){
            return efficiency > 0.01f && items.total() < itemCapacity;
        }

        @Override
        public float ambientVolume(){
            return efficiency * (size * size) / 4f;
        }

        @Override
        public void drawSelect(){
            if(dominantItem != null){
                float dx = x - size * tilesize/2f, dy = y + size * tilesize/2f, s = iconSmall / 4f;
                Draw.mixcol(Color.darkGray, 1f);
                Draw.rect(dominantItem.fullIcon, dx, dy - 1, s, s);
                Draw.reset();
                Draw.rect(dominantItem.fullIcon, dx, dy, s, s);
            }
        }

        @Override
        public void pickedUp(){
            dominantItem = null;
        }

        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();

            countOre(tile);
            dominantItem = returnItem;
            dominantItems = returnCount;
        }

        @Override
        public void updateTile(){
            if(dominantItem == null){
                return;
            }

            if(timer(timerDump, dumpTime)){
                dump(items.has(dominantItem) ? dominantItem : null);
            }

            timeDrilled += warmup * delta();

            float delay = getDrillTime(dominantItem);

            if(items.total() < itemCapacity && dominantItems > 0 && efficiency > 0){
                float speed = Mathf.lerp(1f, liquidBoostIntensity, optionalEfficiency) * efficiency;

                lastDrillSpeed = (speed * dominantItems * warmup) / delay;
                warmup = Mathf.approachDelta(warmup, speed, warmupSpeed);
                progress += delta() * dominantItems * speed * warmup;

                if(Mathf.chanceDelta(updateEffectChance * warmup))
                    updateEffect.at(x + Mathf.range(size * 2f), y + Mathf.range(size * 2f));
            }else{
                lastDrillSpeed = 0f;
                warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
                return;
            }

            if(dominantItems > 0 && progress >= delay && items.total() < itemCapacity){
                offload(dominantItem);

                progress %= delay;

                if(wasVisible) drillEffect.at(x + Mathf.range(drillEffectRnd), y + Mathf.range(drillEffectRnd), dominantItem.color);
            }
        }

        @Override
        public double sense(LAccess sensor){
            if(sensor == LAccess.progress && dominantItem != null) return Mathf.clamp(progress / getDrillTime(dominantItem));
            return super.sense(sensor);
        }

        @Override
        public void drawCracks(){}

        public void drawDefaultCracks(){
            super.drawCracks();
        }

        @Override
        public void draw(){
            float s = 0.3f;
            float ts = 0.6f;

            Draw.rect(region, x, y);
            Draw.z(Layer.blockCracks);
            drawDefaultCracks();

            Draw.z(Layer.blockAfterCracks);
            if(drawRim){
                Draw.color(heatColor);
                Draw.alpha(warmup * ts * (1f - s + Mathf.absin(Time.time, 3f, s)));
                Draw.blend(Blending.additive);
                Draw.rect(rimRegion, x, y);
                Draw.blend();
                Draw.color();
            }

            if(drawSpinSprite){
                Drawf.spinSprite(rotatorRegion, x, y, timeDrilled * rotateSpeed);
            }else{
                Draw.rect(rotatorRegion, x, y, timeDrilled * rotateSpeed);
            }

            Draw.rect(topRegion, x, y);

            if(dominantItem != null && drawMineItem){
                Draw.color(dominantItem.color);
                Draw.rect(itemRegion, x, y);
                Draw.color();
            }
        }

        @Override
        public byte version(){
            return 1;
        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.f(progress);
            write.f(warmup);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            if(revision >= 1){
                progress = read.f();
                warmup = read.f();
            }
        }
    }

}
*/