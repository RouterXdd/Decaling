package decal.world.bullets;

import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import decal.content.*;
import decal.graphics.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;

public class LightPointBulletType extends BulletType {
    private static float cdist = 0f;
    private static Unit result;

    public Color color = DecalPal.ancident;
    public float trailSpacing = 10f;
    public Effect trailEffect = DecalingFx.crystalFade;

    public LightPointBulletType(){
        scaleLife = true;
        lifetime = 100f;
        collides = false;
        reflectable = false;
        keepVelocity = false;
        backMove = false;
        lightningLength = 12;
        lightningLengthRand = 8;
        lightningDamage = 30;
    }

    @Override
    public void init(Bullet b){
        super.init(b);

        float px = b.x + b.lifetime * b.vel.x,
                py = b.y + b.lifetime * b.vel.y,
                rot = b.rotation();

        Geometry.iterateLine(0f, b.x, b.y, px, py, trailSpacing, (x, y) -> {
            trailEffect.at(x, y, rot);
        });

        b.time = b.lifetime;
        b.set(px, py);

        //calculate hit entity

        cdist = 0f;
        result = null;
        float range = 1f;

        Units.nearbyEnemies(b.team, px - range, py - range, range*2f, range*2f, e -> {
            if(e.dead() || !e.checkTarget(collidesAir, collidesGround) || !e.hittable()) return;

            e.hitbox(Tmp.r1);
            if(!Tmp.r1.contains(px, py)) return;

            float dst = e.dst(px, py) - e.hitSize;
            if((result == null || dst < cdist)){
                result = e;
                cdist = dst;
            }
        });

        if(result != null){
            b.collision(result, px, py);
        }else if(collidesTiles){
            Building build = Vars.world.buildWorld(px, py);
            if(build != null && build.team != b.team){
                build.collision(b);
            }
        }
        Lightning.create(b, color, lightningDamage, b.x, b.y, b.rotation(), lightningLength + Mathf.random(lightningLengthRand));
        Lightning.create(b, color, lightningDamage, b.x, b.y, b.rotation(), lightningLength + Mathf.random(lightningLengthRand));
        Lightning.create(b, color, lightningDamage, b.x, b.y, b.rotation(), lightningLength + Mathf.random(lightningLengthRand));

        b.remove();

        b.vel.setZero();
    }
}
