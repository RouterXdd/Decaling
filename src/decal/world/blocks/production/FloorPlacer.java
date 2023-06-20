package decal.world.blocks.production;

import arc.graphics.g2d.*;
import arc.util.Time;
import decal.content.*;
import decal.graphics.*;
import decal.world.meta.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.world;

public class FloorPlacer extends Block {

    public float range = 8f;
    public final int timerUse = timers++;
    public float useTime = 100f;
    public float timeMultiplier = 10f;
    public Block floor;
    public Effect placeEffect = DecalingFx.NickelbreakBlock;
    public DrawBlock drawer = new DrawDefault();
    public FloorPlacer(String name,Block floor) {
        super(name);
        this.floor = floor;
        hasPower = true;
        hasItems = true;
        consumesPower = true;
        solid = true;
        update = true;
        emitLight = true;
        lightRadius = 30f;
        lightColor = DecalPal.vilinite;

        buildType = FloorPlacerBuild::new;
    }
    @Override
    public void setStats(){
        stats.timePeriod = useTime;
        super.setStats();

        stats.add(DecStat.corruptTime, (int)(useTime * timeMultiplier / 60f), StatUnit.seconds);
    }

    @Override
    public void load(){
        super.load();

        drawer.load(this);
    }
    @Override
    public TextureRegion[] icons(){
        return drawer.finalIcons(this);
    }
    public class FloorPlacerBuild extends Building {
        public float createTime;
        public float progress;
        public boolean firstCorrupt = true;
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
        public void updateTile() {
            if(efficiency > 0) {
                progress += getProgressIncrease(useTime * timeMultiplier);
                if (optionalEfficiency > 0 && timer(timerUse, useTime)) {
                    consume();
                }
                createTime += Time.delta;
                if(progress >= 1f && firstCorrupt){
                    corrupt(range);
                    firstCorrupt = false;
                }
            }
        }


        public void corrupt(float range) {
            for (float i = -range; i <= range; i += 8) {
                for (float j = -range; j <= range; j += 8) {
                    Tile tile = world.tileWorld(x + i, y + j);

                    if (tile == null || tile.floor().hasBuilding()) continue;

                    if (tile.floor() != Blocks.air) placeEffect.at(x + i, y + j);
                    tile.setFloor(floor.asFloor());
                }
            }
        }
    }
}
