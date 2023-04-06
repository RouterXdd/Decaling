package decal.world.blocks.power;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.Mathf;
import arc.math.geom.*;
import arc.util.*;
import mindustry.core.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.meta.*;

import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class WireWall extends Wall {
    public TextureRegion[] regions = new TextureRegion[16];
    public final int timerDamage = timers++;

    public float cooldown = 60f;
    public float tileDamage = 0f;
    public float damage = 6;
    public int length = 4;
    public int tendrils = 8;
    public Color lightningColor = Pal.lancerLaser;
    public int shots = 2;
    public float inaccuracy = 0f;
    public @Nullable BulletType bullet;
    public boolean electricity = true;
    public WireWall(String name) {
        super(name);
        group = BlockGroup.power;
        consumesPower = outputsPower = true;
        consumePowerBuffered(5f);
        underBullets = true;
        solid = false;
        hasShadow = false;
    }
    @Override
    public void load() {
        super.load();

        for (int i = 0; i < regions.length; i++) {
            regions[i] = Core.atlas.find(name + "-" + i);
        }
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        drawPotentialLinks(x, y);
        drawOverlay(x * tilesize + offset, y * tilesize + offset, rotation);
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

        Draw.rect( b[0] >= 16 ? regions[0] : regions[b[0]], plan.drawx(), plan.drawy());
    }
    @Override
    public void setBars(){
        super.setBars();
        addBar("power", makePowerBalance());
        addBar("batteries", makeBatteryBalance());
    }

    public static Func<Building, Bar> makePowerBalance(){
        return entity -> new Bar(() ->
                Core.bundle.format("bar.powerbalance",
                        ((entity.power.graph.getPowerBalance() >= 0 ? "+" : "") + UI.formatAmount((long)(entity.power.graph.getPowerBalance() * 60)))),
                () -> Pal.powerBar,
                () -> Mathf.clamp(entity.power.graph.getLastPowerProduced() / entity.power.graph.getLastPowerNeeded())
        );
    }
    public static Func<Building, Bar> makeBatteryBalance(){
        return entity -> new Bar(() ->
                Core.bundle.format("bar.powerstored",
                        (UI.formatAmount((long)entity.power.graph.getLastPowerStored())), UI.formatAmount((long)entity.power.graph.getLastCapacity())),
                () -> Pal.powerBar,
                () -> Mathf.clamp(entity.power.graph.getLastPowerStored() / entity.power.graph.getLastCapacity())
        );
    }
    public class PowerWireBuild extends WallBuild {
        protected byte curTile = 0, checkedNearby = 0;

        @Override
        public void draw() {
            Draw.rect( curTile >= 16 ? regions[0] : regions[curTile], x, y);
        }

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
        public void unitOn(Unit unit){
            if(enabled && unit.team != team && timer(timerDamage, cooldown) && electricity){
                triggered();
                damage(tileDamage);
            }
        }

        public void triggered() {
            for (int i = 0; i < tendrils; i++) {
                Lightning.create(team, lightningColor, damage, x, y, Mathf.random(360f), length);
            }
            if (bullet != null) {
                for (int i = 0; i < shots; i++) {
                    bullet.create(this, x, y, (360f / shots) * i + Mathf.random(inaccuracy));
                }
            }
        }

        @Override
        public void drawSelect() {

        }
    }
}
