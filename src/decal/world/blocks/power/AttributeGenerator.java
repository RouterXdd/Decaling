package decal.world.blocks.power;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import decal.content.*;
import decal.graphics.*;
import mindustry.graphics.*;
import mindustry.world.blocks.power.*;
import mindustry.world.meta.*;

public class AttributeGenerator extends PowerGenerator {

    public boolean drawHeat = true;
    public Attribute attribute = DecalingAttributes.timedrive;
    public TextureRegion rotatorRegion;
    public TextureRegion heatRegion;
    public TextureRegion topRegion;

    public AttributeGenerator(String name){
        super(name);
        flags = EnumSet.of(BlockFlag.generator);
        envEnabled = Env.any;
    }
    @Override
    public TextureRegion[] icons() {
        return new TextureRegion[]{region, rotatorRegion, topRegion};
    }

    @Override
    public void setStats(){
        super.setStats();
        stats.remove(generationType);
        stats.add(generationType, powerProduction * 60.0f, StatUnit.powerSecond);
    }
    @Override
    public void load() {
        super.load();
        rotatorRegion = Core.atlas.find(this.name + "-rotator");
        topRegion = Core.atlas.find(this.name + "-top");
        heatRegion = Core.atlas.find(this.name + "-heat");
    }

    public class AttributeGeneratorBuild extends GeneratorBuild{
        public float rotatorAngle = 0f;

        @Override
        public void updateTile(){
            productionEfficiency = attribute.env();
            rotatorAngle += productionEfficiency;
        }
        @Override
        public void draw() {
            float warmup = 0.2f;
            float s = 0.3f;
            float ts = 0.6f;
            super.draw();
            if(drawHeat){
                Draw.color(DecalPal.darkTime);
                Draw.alpha(warmup * ts * (1f - s + Mathf.absin(Time.time, 4f, s)));
                Draw.blend(Blending.additive);
                Draw.rect(heatRegion, x, y);
                Draw.blend();
                Draw.color();
            }
            Drawf.spinSprite(rotatorRegion, x, y, rotatorAngle);

            Draw.rect(topRegion, x, y);

            Draw.z(Layer.blockAfterCracks);

        }
    }
}
