package decal.world.blocks.defence;

import arc.*;
import arc.audio.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import decal.world.meta.DecStat;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class DecalingWall extends Wall {
    public float repairChance = -1f;
    public float healAmount = 40f;
    public boolean repairHit;

    public Color repairColor = Pal.heal;
    public DecalingWall(String name){
        super(name);
        solid = true;
        destructible = true;
        group = BlockGroup.walls;
        buildCostMultiplier = 6f;
        canOverdrive = false;
        drawDisabled = false;
        crushDamageMultiplier = 5f;
        priority = TargetPriority.wall;

        //it's a wall of course it's supported everywhere
        envEnabled = Env.any;
        buildType = DecalingWallBuild::new;
    }

    @Override
    public void setStats(){
        super.setStats();

        if(repairChance > 0f){
            stats.add(DecStat.repairChance, repairChance * 100, StatUnit.percent);
            stats.add(DecStat.healAmount, healAmount, StatUnit.none);
        }
    }

    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{Core.atlas.find(Core.atlas.has(name) ? name : name + "1")};
    }

    public class DecalingWallBuild extends Building{
        public float hit;

        @Override
        public void draw(){
            super.draw();

            if(repairHit){
                if(hit < 0.0001f) return;

                Draw.color(repairColor);
                Draw.alpha(hit * 0.5f);
                Draw.blend(Blending.additive);
                Fill.rect(x, y, tilesize * size, tilesize * size);
                Draw.blend();
                Draw.reset();

                if(!state.isPaused()){
                    hit = Mathf.clamp(hit - Time.delta / 10f);
                }
            }
        }

        @Override
        public boolean collision(Bullet bullet){
            super.collision(bullet);

            hit = 1f;

            if(repairChance > 0f) {
                if(Mathf.chance(repairChance)) {
                    this.heal(healAmount);
                }
            }

            return true;
        }
    }
}