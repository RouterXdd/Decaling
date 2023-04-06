package decal.world.blocks.defence;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public abstract class NeoplasmaWall extends DecalingWall {
    public TextureRegion[] regions = new TextureRegion[16];
    public final int timerUse = timers++;
    public Color baseColor = Pal.neoplasm1;
    public float reload = 250f;
    public float range = 0f;
    public float healPercent = 12f;
    public float useTime = 400f;

    public NeoplasmaWall(String name){
        super(name);
        solid = true;
        update = true;
        hasPower = true;
        hasItems = true;
        emitLight = false;
        suppressable = false;
        buildType = NeoplasmaWallBuild::new;
    }

    @Override
    public void setStats(){
        stats.timePeriod = useTime;
        super.setStats();

        stats.add(Stat.repairTime, (int)(100f / healPercent * reload / 60f), StatUnit.seconds);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);

        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, baseColor);

        indexer.eachBlock(player.team(), x * tilesize + offset, y * tilesize + offset, range, other -> true, other -> Drawf.selected(other, Tmp.c1.set(baseColor).a(Mathf.absin(4f, 1f))));

        drawPotentialLinks(x, y);
        drawOverlay(x * tilesize + offset, y * tilesize + offset, rotation);
    }
    @Override
    public void load() {
        super.load();

        for (int i = 0; i < regions.length; i++) {
            regions[i] = Core.atlas.find(name + "-" + i);
        }
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list) {
        if(plan.tile() == null) return;

        byte[] b = {0, 0};

        list.each(other -> {
            if (other.breaking || other == plan || !other.block.hasPower || other.samePos(plan)) return;
            for (int i = 0; i < 4; i++) {
                Point2 p = Geometry.d4[i];

                if (other.x == plan.x + p.x && other.y == plan.y + p.y && (b[1] & 1 << 3-i) == 0) {
                    b[0] += 1 << 3 - i;
                    b[1] += 1 << 3 - i;
                }
            }
        });

        Draw.rect(b[0] >= 16 ? regions[0] : regions[b[0]], plan.drawx(), plan.drawy());
    }

    public class NeoplasmaWallBuild extends DecalingWallBuild implements Ranged {
        public float heat, charge = Mathf.random(reload), smoothEfficiency;

        protected byte curTile = 0, checkedNearby = 0;

        @Override
        public void onProximityUpdate() {
            super.onProximityUpdate();

            //reset the mask
            curTile = 0;
            checkedNearby = 0;

            for (int i = 0; i < 4; i++) {
                Point2 p = Geometry.d4[i];
                Building build = world.build(tileX() + p.x, tileY() + p.y);
                if (build == null || !build.isValid() || build.team != this.team) continue;

                if (build.block.hasPower && ((checkedNearby & 1 << 3-i) == 0)) {
                    curTile += 1 << 3 - i;
                    checkedNearby += 1 << 3 - i;
                }
            }
        }
        @Override
        public float range(){
            return range;
        }

        @Override
        public void updateTile(){
            boolean canHeal = !checkSuppression();

            smoothEfficiency = Mathf.lerpDelta(smoothEfficiency, efficiency, 0.08f);
            heat = Mathf.lerpDelta(heat, efficiency > 0 && canHeal ? 1f : 0f, 0.08f);
            charge += heat * delta();


            if(optionalEfficiency > 0 && timer(timerUse, useTime) && canHeal){
                consume();
            }

            if(charge >= reload && canHeal){
                float realRange = range;
                charge = 0f;

                indexer.eachBlock(this, realRange, b -> b.damaged() && !b.isHealSuppressed(), other -> {
                    other.heal(other.maxHealth() * (healPercent) / 100f * efficiency);
                    other.recentlyHealed();
                    Fx.healBlockFull.at(other.x, other.y, other.block.size, baseColor, other.block);
                });
            }
        }

        @Override
        public double sense(LAccess sensor){
            if(sensor == LAccess.progress) return Mathf.clamp(charge / reload);
            return super.sense(sensor);
        }

        @Override
        public void drawSelect(){
            float realRange = range;

            indexer.eachBlock(this, realRange, other -> true, other -> Drawf.selected(other, Tmp.c1.set(baseColor).a(Mathf.absin(4f, 1f))));

            Drawf.dashCircle(x, y, realRange, baseColor);
        }

        @Override
        public void draw(){
            super.draw();

            Draw.rect(curTile >= 16 ? regions[0] : regions[curTile], x, y);

            Draw.color(baseColor);
            Draw.alpha(heat * Mathf.absin(Time.time, 50f / Mathf.PI2, 1f) * 0.5f);
            Draw.alpha(1f);

            Draw.reset();
        }

        @Override
        public void drawLight(){
            Drawf.light(x, y, lightRadius * smoothEfficiency, baseColor, 0.7f * smoothEfficiency);
        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.f(heat);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            heat = read.f();
        }
    }
}