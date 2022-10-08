package decal.world.blocks.power;

import arc.Core;
import arc.graphics.Blending;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.struct.EnumSet;
import arc.util.Time;
import decal.content.DecalingAttributes;
import decal.graphics.DecalPal;
import mindustry.graphics.Layer;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.Env;
import mindustry.world.meta.StatUnit;

public class AttributeGenerator extends PowerGenerator {

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
        return new TextureRegion[]{
                this.region, this.rotatorRegion
        };
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
            float warmup = 0.1f;
            float s = 0.3f;
            float ts = 0.6f;
            super.draw();
            Draw.rect(rotatorRegion, x, y, rotatorAngle);

            Draw.z(Layer.blockAfterCracks);
            if(drawArrow){
                Draw.color(DecalPal.darkTime);
                Draw.alpha(warmup * ts * (1f - s + Mathf.absin(Time.time, 3f, s)));
                Draw.blend(Blending.additive);
                Draw.rect(heatRegion, x, y);
                Draw.blend();
                Draw.color();
            }
            Draw.rect(topRegion, x, y);
        }
    }
}
