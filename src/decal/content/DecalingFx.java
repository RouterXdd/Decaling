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

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class DecalingFx{
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();
    public static TextureRegion missileRegion = Core.atlas.find("decal-missile");
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
            smallTimeLaserCharge = new Effect(80f, 100f, e -> {
                color(DecalPal.darkTime);
                stroke(e.fin() * 2f);
                Lines.circle(e.x, e.y, 3f + e.fout() * 100f);

                Fill.circle(e.x, e.y, e.fin() * 16);

                randLenVectors(e.id, 20, 40f * e.fout(), (x, y) -> {
                    Fill.circle(e.x + x, e.y + y, e.fin() * 5f);
                    Drawf.light(e.x + x, e.y + y, e.fin() * 15f, DecalPal.darkTime, 0.7f);
                });

                color();

                Fill.circle(e.x, e.y, e.fin() * 6);
                Drawf.light(e.x, e.y, e.fin() * 16f, DecalPal.darkTime, 0.7f);
            }),
    changeMode = new Effect(50f, 50f, e -> {
        color(DecalPal.darkTime);
        stroke(e.fin() * 2f);
        Lines.square(e.x, e.y, 4f, 0);
    }),
            crystal = new Effect(30f, 30f, e -> {
                color(DecalPal.ancident);
                stroke(2f - e.fin() * 2.2f);
                Lines.square(e.x, e.y, 5f, 45);
            }),
            crystalFade = new Effect(30f, 30f, e -> {
                color(DecalPal.ancident);
                stroke(2f - e.fin() * 2.2f);
                Lines.square(e.x, e.y, 5f - e.finpow() * 4f, e.rotation + 45f);
            }),
            bigCrystal = new Effect(42f, 30f, e -> {
                color(DecalPal.ancident);
                stroke(2.6f - e.fin() * 2.2f);
                Lines.square(e.x, e.y, 5f + e.finpow() * 6f,45 * e.fin() * 3);
                color(DecalPal.ancident);
                stroke(2f - e.fin() * 2.2f);
                Lines.square(e.x, e.y, 3f, 45);
            }),
            crystalExplosion = new Effect(50f, 30f, e -> {
                color(DecalPal.ancident);
                stroke(2.6f - e.fin() * 2.2f);
                Lines.square(e.x, e.y, 6f - e.finpow() * 5f,45 * e.fin() * -3);
            }),
            crystalShoot = new Effect(8, e -> {
                color(DecalPal.ancident, Pal.bulletYellow, e.fin());
                float w = 2f + 7 * e.fout();
                Drawf.tri(e.x, e.y, w, 17f * e.fout(), e.rotation);
                Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
            }),
            ancientCapture = new Effect(35f, 30f, e -> {
                color(DecalPal.ancident);
                stroke(2f - e.fin() * 2.2f);
                Lines.square(e.x, e.y, 6f - e.finpow() * e.rotation * 2f, 45);
            }),
            viliniteCraft = new Effect(20f, 30f, e -> {
                color(DecalPal.vilinite);
                stroke(2f + e.fin() * 2.2f);
                Drawf.square(e.x, e.y, 6f - e.finpow() * e.rotation * 2f, 45);
            }),
    regen = new Effect(50f, 30f, e -> {
        color(DecalPal.vilinite);
        rand.setSeed(e.id);
        for(int i = 0; i < 3; i++){
            v.trns(rand.random(360f), rand.random(e.finpow() * 14f)).add(e.x, e.y);
            Fill.square(v.x, v.y, rand.random(0.6f, 1.4f));
        }
    }),
            volcanoVent = new Effect(55f, 30f, e -> {
                    color(e.color, DecalPal.volcanoBlueColor, e.fin());

                    alpha(e.fslope() * 0.78f);

                    float length = 4f + e.finpow() * 10f;
                    rand.setSeed(e.id);
                    for(int i = 0; i < rand.random(3, 5); i++){
                        v.trns(rand.random(360f), rand.random(length));
                        Fill.circle(e.x + v.x, e.y + v.y, rand.random(2.1f, 3.7f) + e.fslope() * 1.1f);
                    }
            }).layer(Layer.darkness - 1),
            rushMove = new Effect(50f, 20f, e -> {
                color(Color.darkGray);
                rand.setSeed(e.id);
                for(int i = 0; i < 3; i++){
                    v.trns(rand.random(360f), rand.random(e.finpow() * 40f)).add(e.x, e.y);
                    Fill.square(v.x, v.y, rand.random(11f, 14f));
                }
            }),
            regenWave = new Effect(11, e -> {
                color(DecalPal.vilinite);
                stroke(e.fout() * 2f);
                Lines.square(e.x, e.y, 6f, 0);
                color(DecalPal.darkTime);
                stroke(e.fout() * 2f);
                Lines.square(e.x, e.y, 6f, 45);
            }),
            resumeDespawn = new Effect(16, e -> {
                e.scaled(7, i -> {
                    stroke(3f * i.fout());
                    Lines.circle(e.x, e.y, 3f + i.fin() * 10f);
                });

                color(Color.gray);

                randLenVectors(e.id, 6, 2f + 19f * e.finpow(), (x, y) -> {
                    Fill.circle(e.x + x, e.y + y, e.fout() * 3f + 0.5f);
                    Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
                });

                color(DecalPal.darkTime, DecalPal.darkTime, Color.gray, e.fin());
                stroke(1.5f * e.fout());

                randLenVectors(e.id + 1, 8, 1f + 23f * e.finpow(), (x, y) -> {
                    lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
                });
                color(DecalPal.darkTime);
                stroke(e.fin() * 2f);
                Lines.circle(e.x, e.y, 2f + e.fout() * 80f);

                color(DecalPal.darkTime);
                alpha(e.fout(Interp.pow4Out));
                float size = 10f + e.fout(Interp.pow10In) * 30f;
                Draw.rect(Icon.cancel.getRegion(), e.x, e.y, size, size);
            }),
            shadowTeleport = new Effect(60f, 80f, e -> {
                color(Color.black);
                randLenVectors(e.id, 20 + (int)(e.rotation * 4), e.rotation * 2f + e.rotation * e.finpow(), (x, y) -> {
                    Fill.circle(e.x + x, e.y + y, 1f + e.fout() * (3f + e.rotation));
                });
            }),
            shadowDeath = new Effect(60f, 80f, e -> {
                color(Color.white);
                randLenVectors(e.id, 20 + (int)(e.rotation * 4), e.rotation * 9f + e.rotation * e.finpow(), (x, y) -> {
                    Fill.circle(e.x + x, e.y + y, 1f + e.fout() * (2f + e.rotation));
                });
            }),
            apparitionMove = new Effect(40f, 70f, e ->{
                color(Color.white);
                alpha(e.fout(Interp.pow4Out));
                float size = 10f + e.fout() * 30f;
                Draw.rect("decal-apparition-trail", e.x, e.y, size, size);
            }),
            NickelbreakBlock = new Effect(12, e -> {
                color(DecalPal.nickelColor);
                stroke(3f - e.fin() * 2f);
                Lines.square(e.x, e.y, tilesize / 2f * e.rotation + e.fin() * 3f);

                randLenVectors(e.id, 2 + (int)(e.rotation * 4), e.rotation * 2f + (tilesize * e.rotation) * e.finpow(), (x, y) -> {
                    Fill.square(e.x + x, e.y + y, 1f + e.fout() * (3f + e.rotation), 45);
                });
            }),
            ZincbreakBlock = new Effect(12, e -> {
                color(DecalPal.zincColor);
                stroke(3f - e.fin() * 2f);
                Lines.square(e.x, e.y, tilesize / 2f * e.rotation + e.fin() * 3f);

                randLenVectors(e.id, 2 + (int)(e.rotation * 4), e.rotation * 2f + (tilesize * e.rotation) * e.finpow(), (x, y) -> {
                    Fill.square(e.x + x, e.y + y, 1f + e.fout() * (3f + e.rotation), 45);
                });
            }),
            OxygenbreakBlock = new Effect(12, e -> {
                color(DecalPal.oxygenColor);
                stroke(3f - e.fin() * 2f);
                Lines.square(e.x, e.y, tilesize / 2f * e.rotation + e.fin() * 3f);

                randLenVectors(e.id, 2 + (int)(e.rotation * 4), e.rotation * 2f + (tilesize * e.rotation) * e.finpow(), (x, y) -> {
                    Fill.square(e.x + x, e.y + y, 1f + e.fout() * (3f + e.rotation), 45);
                });
            }),
            ArgusbreakBlock = new Effect(12, e -> {
                color(DecalPal.argusColor);
                stroke(3f - e.fin() * 2f);
                Lines.square(e.x, e.y, tilesize / 2f * e.rotation + e.fin() * 3f);

                randLenVectors(e.id, 2 + (int)(e.rotation * 4), e.rotation * 2f + (tilesize * e.rotation) * e.finpow(), (x, y) -> {
                    Fill.square(e.x + x, e.y + y, 1f + e.fout() * (3f + e.rotation), 45);
                });
            }),
    launchMissile = new Effect(50, e -> {
        color(Pal.engine);


        e.scaled(25f, f -> {
            stroke(f.fout() * 2f);
            Lines.circle(e.x, e.y, 4f + f.finpow() * 30f);
        });

        stroke(e.fout() * 2f);
        rect(missileRegion, e.x, e.y);

        randLenVectors(e.id, 24, e.finpow() * 50f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            lineAngle(e.x + x, e.y + y, ang, e.fout() * 4 + 1f);
        });
    })

    ;
}