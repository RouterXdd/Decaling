package decal.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.units.UnitAssembler.*;
import decal.graphics.*;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class DecalingFx{
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static final Effect

    timeLaserCharge = new Effect(80f, 100f, e -> {
        color(DecalPal.darkTime);
        stroke(e.fin() * 2f);
        Lines.circle(e.x, e.y, 4f + e.fout() * 100f);

        Fill.circle(e.x, e.y, e.fin() * 20);

        randLenVectors(e.id, 20, 40f * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 5f);
            Drawf.light(e.x + x, e.y + y, e.fin() * 15f, DecalPal.darkTime, 0.7f);
        });

        color();

        Fill.circle(e.x, e.y, e.fin() * 10);
        Drawf.light(e.x, e.y, e.fin() * 20f, DecalPal.darkTime, 0.7f);
    }),
    changeMode = new Effect(50f, 50f, e -> {
        color(DecalPal.darkTime);
        stroke(e.fin() * 2f);
        Lines.square(e.x, e.y, 4f, 0);
    }),
    regen = new Effect(50f, 30f, e -> {
        color(DecalPal.vilinite);
        rand.setSeed(e.id);
        for(int i = 0; i < 3; i++){
            v.trns(rand.random(360f), rand.random(e.finpow() * 14f)).add(e.x, e.y);
            Fill.square(v.x, v.y, rand.random(0.6f, 1.4f));
        }
    }),
            regenWave = new Effect(11, e -> {
                color(DecalPal.vilinite);
                stroke(e.fout() * 2f);
                Lines.square(e.x, e.y, 6f, 0);
                color(DecalPal.darkTime);
                stroke(e.fout() * 2f);
                Lines.square(e.x, e.y, 6f, 45);
            })

    ;
}