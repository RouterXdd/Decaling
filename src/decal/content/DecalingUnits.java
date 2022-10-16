package decal.content;

import arc.graphics.*;
import mindustry.ai.types.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import decal.graphics.*;
import decal.world.abilities.*;

public class DecalingUnits {
 public static UnitType
 //time
 hour, clock, timer, day, year, timeAssemblyDrone,
 //core
 decray,
 //decay
 clear, remove, destroy, obliterate, annihilate, decayAssemblyDrone;
 public static void load(){
    //air time units
    hour = new UnitType("hour"){{
    health = 185;
    speed = 2.65f;
    hitSize = 8f;
    drag = 0.03f;
    flying = true;
    range = 60f;
    faceTarget = false;
    circleTarget = true;
    constructor = UnitEntity::create;
    immunities.add(DecalingStatus.decaling);
    engineOffset = 5.65f;
    engineSize = 1.7f;
    outlineColor = DecalPal.decalOutline;
    weapons.add(new Weapon("main-hour-weap"){{
            reload = 28.8f;
            x = 0f;
            y = 1.8f;
            top = false;
            bullet = new ContinuousFlameBulletType(){{
                damage = 4.4f;
                length = 0f;
                speed = 0.3f;
                lifetime = 178f;
                homingPower = 0.08f;
                homingRange = 4f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
        }});
    }};
    clock = new UnitType("clock"){{
    health = 625;
    speed = 2.3f;
    hitSize = 22f;
    drag = 0.04f;
    flying = true;
    range = 82f;
    constructor = UnitEntity::create;
    immunities.add(DecalingStatus.decaling);
    engineOffset = 8.95f;
    engineSize = 2.4f;
    outlineColor = DecalPal.decalOutline;
    weapons.add(
        new Weapon("main-clock-weap"){{
            reload = 32f;
            x = 0f;
            y = -0.2f;
            top = false;
            bullet = new ContinuousFlameBulletType(){{
                damage = 23f;
                length = 96f;
                lifetime = 58f;
                pierceCap = 2;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
        }});
    }};
    timer = new UnitType("timer"){{
    health = 1260;
    speed = 1.86f;
    hitSize = 28.4f;
    drag = 0.06f;
    flying = true;
    range = 260f;
    constructor = UnitEntity::create;
    engineOffset = 12.4f;
    engineSize = 4.8f;
    outlineColor = DecalPal.decalOutline;
    immunities.add(DecalingStatus.decaling);
    weapons.add(
        new Weapon("main-timer-weap"){{
            reload = 158.8f;
            x = 0f;
            y = 4f;
            top = false;
            inaccuracy = 26f;
            shoot.shots = 10;
            shoot.shotDelay = 4;
            bullet = new BasicBulletType(){{
                    height = 9f;
                    width = 7f;
                    speed = 5f;
                    lifetime = 54f;
                    damage = 18f;
                    homingPower = 0.08f;
                    homingRange = 9f;
                    status = DecalingStatus.timeswap1;
                    statusDuration = 40f;
            fragBullet = new ContinuousFlameBulletType(){{
                damage = 2f;
                length = 0f;
                speed = 0f;
                lifetime = 128f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
            fragBullets = 1;
            }};
        }});
    }};
    day = new UnitType("day"){{
    health = 8900;
    speed = 1.26f;
    hitSize = 36.5f;
    drag = 0.082f;
    flying = true;
    range = 320f;
    constructor = UnitEntity::create;
    immunities.add(DecalingStatus.decaling);
    engineOffset = 12.4f;
    engineSize = 4.8f;
    outlineColor = DecalPal.decalOutline;
    weapons.add(new Weapon("main-day-weap"){{
            reload = 98.8f;
            x = 0f;
            y = 9f;
            top = false;
            shoot = new ShootSpread(9, 8f);
            shoot.shotDelay = 3;
            bullet = new BasicBulletType(){{
                    height = 15f;
                    width = 12f;
                    speed = 5f;
                    lifetime = 68f;
                    damage = 30f;
                    status = DecalingStatus.timeswap2;
                    statusDuration = 65f;
            }};
        }});
        weapons.add(new Weapon("decal-sub-day-weap"){{
            reload = 189.8f;
            x = 18f;
            y = 0f;
            top = true;
            rotate = true;
            continuous = true;
            shootY = 1.3f;
            bullet = new ContinuousLaserBulletType(){{
                    length = 136;
                    lifetime = 98f;
                    damage = 25f;
                    drawSize = 80f;
                    colors = new Color[]{DecalPal.darkTime.cpy().a(.2f), DecalPal.darkTime.cpy().a(.5f), DecalPal.darkTime.cpy().mul(1.2f), Color.white};
            }};
            shootStatus = DecalingStatus.rush;
            shootStatusDuration = 120f;
        }});
    }};
    year = new UnitType("year"){{
    health = 18600;
    armor = 6;
    speed = 0.78f;
    drag = 0.11f;
    hitSize = 53f;
    flying = true;
    range = 355f;
    constructor = UnitEntity::create;
    immunities.add(DecalingStatus.decaling);
    engineOffset = 19.4f;
    engineSize = 6.8f;
    outlineColor = DecalPal.decalOutline;
        weapons.add(new Weapon("main-year-weap"){{
            shootSound = Sounds.laserblast;
            chargeSound = Sounds.lasercharge;
            reload = 350f;
            x = 7f;
            y = -2f;
            top = true;
            mirror = false;
            shootY = 1.3f;
            shoot.firstShotDelay = DecalingFx.timeLaserCharge.lifetime;
            shootStatus = StatusEffects.unmoving;
            shootStatusDuration = 120f;
            cooldownTime = 350f;
            bullet = new LaserBulletType(){{
                    length = 380f;
                    damage = 300f;
                    width = 30f;

                    lifetime = 65f;

                    lightningSpacing = 50f;
                    lightningLength = 3;
                    lightningDelay = 0.8f;
                    lightningLengthRand = 15;
                    lightningDamage = 680;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = DecalPal.darkTime;

                    status = DecalingStatus.timeswap3;
                    statusDuration = 65f;

                    chargeEffect = DecalingFx.timeLaserCharge;
                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{DecalPal.darkTime.cpy().a(0.4f), DecalPal.darkTime, Color.white};
                }};
        }});
        weapons.add(new Weapon("main-year-weap"){{
            shootSound = Sounds.laserblast;
            chargeSound = Sounds.lasercharge;
            reload = 350f;
            x = -7f;
            y = -2f;
            top = true;
            mirror = false;
            shootY = 1.3f;
            shoot.firstShotDelay = DecalingFx.timeLaserCharge.lifetime;
            shootStatus = StatusEffects.unmoving;
            shootStatusDuration = 120f;
            cooldownTime = 350f;
            bullet = new LaserBulletType(){{
                    length = 380f;
                    damage = 300f;
                    width = 30f;

                    lifetime = 65f;

                    lightningSpacing = 50f;
                    lightningLength = 3;
                    lightningDelay = 0.8f;
                    lightningLengthRand = 15;
                    lightningDamage = 680;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = DecalPal.darkTime;

                    status = DecalingStatus.timeswap3;
                    statusDuration = 65f;

                    chargeEffect = DecalingFx.timeLaserCharge;
                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{DecalPal.darkTime.cpy().a(0.4f), DecalPal.darkTime, Color.white};
                }};
        }});
        weapons.add(new Weapon("decal-sub-year-weap"){{
            reload = 74.7f;
            x = 13f;
            y = -11.7f;
            top = true;
            shoot.shots = 4;
            shoot.shotDelay = 3;
            bullet = new ContinuousFlameBulletType(){{
                damage = 13.65f;
                length = -47f;
                speed = 5f;
                lifetime = 71f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};
        }});
    }};
    timeAssemblyDrone = new UnitType("time-assembly-drone"){{
            controller = u -> new AssemblerAI();

            flying = true;
            drag = 0.06f;
            accel = 0.11f;
            speed = 1.3f;
            health = 120;
            engineSize = 2.3f;
            engineOffset = 6.5f;
            payloadCapacity = 0f;
            targetable = false;
            constructor = UnitEntity::create;
            immunities.add(DecalingStatus.decaling);
            outlineColor = DecalPal.decalOutline;
            isEnemy = false;
            hidden = true;
            useUnitCap = false;
            logicControllable = false;
            playerControllable = false;
            allowedInPayloads = false;
            createWreck = false;
            envEnabled = Env.any;
            envDisabled = Env.none;
            abilities.add(new ForceFieldAbility(50f, 4f, 800f, 60f * 3));
        }};
     decayAssemblyDrone = new UnitType("decay-assembly-drone"){{
         controller = u -> new AssemblerAI();

         flying = true;
         drag = 0.06f;
         accel = 0.11f;
         speed = 1.3f;
         health = 120;
         engineSize = 2.3f;
         engineOffset = 6.5f;
         payloadCapacity = 0f;
         targetable = false;
         constructor = UnitEntity::create;
         immunities.add(DecalingStatus.decaling);
         outlineColor = DecalPal.decalOutline;
         isEnemy = false;
         hidden = true;
         useUnitCap = false;
         logicControllable = false;
         playerControllable = false;
         allowedInPayloads = false;
         createWreck = false;
         envEnabled = Env.any;
         envDisabled = Env.none;
         abilities.add(new DecayField(26f, 0.5f));
     }};
    decray = new UnitType("decray"){{
        controller = u -> new BuilderAI();
        flying = true;
        drag = 0.05f;
        accel = 0.13f;
        range = 115f;
        speed = 2.3f;
        health = 200;
        mineSpeed = 5f;
        mineTier = 2;
        buildSpeed = 0.85f;
        engineSize = 2.1f;
        engineOffset = 5.3f;
        constructor = UnitEntity::create;
        immunities.add(DecalingStatus.decaling);
        outlineColor = DecalPal.decalOutline;
        weapons.add(new Weapon("main-decray-weap"){{
                reload = 12f;
                x = 0f;
                y = 0f;
                top = false;
                bullet = new BasicBulletType(){{
                height = 12f;
                width = 6f;
                speed = 4f;
                lifetime = 34f;
                damage = 12f;
                homingPower = 0.08f;
                homingRange = 12f;
                status = DecalingStatus.decaling;
                statusDuration = 34f * 2f;
                buildingDamageMultiplier = 0.01f;
            }};
        }});
    }};
    clear = new UnitType("clear"){{
        speed = 0.6f;
        hitSize = 9f;
        health = 260;
        outlineColor = DecalPal.decalOutline;
        constructor = MechUnit::create;
        immunities.add(DecalingStatus.decaling);
        abilities.add(new DecayField(36f, 0.8f));
        weapons.add(new Weapon("decal-decay-weapon"){{
            reload = 22f;
            x = 5f;
            y = 0f;
            top = false;
            ejectEffect = Fx.casing1;
            bullet = new BasicBulletType(2.5f, 9){{
                width = 7f;
                height = 9f;
                lifetime = 60f;
                status = DecalingStatus.decaling;
                statusDuration = 16f;
            }};
        }});
    }};
     remove = new UnitType("remove"){{
         speed = 0.48f;
         hitSize = 16f;
         health = 740;
         outlineColor = DecalPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DecalingStatus.decaling);
         abilities.add(new DecayField(58f, 1.2f));
         weapons.add(new Weapon("decal-decay-weapon"){{
             reload = 30f;
             x = 7f;
             y = 0f;
             top = false;
             ejectEffect = Fx.casing1;
             bullet = new BasicBulletType(3f, 12){{
                 width = 7f;
                 height = 10f;
                 lifetime = 60f;
                 status = DecalingStatus.decaling;
                 statusDuration = 16f;
             }};
         }});
         weapons.add(new Weapon("decal-decay-weapon"){{
             reload = 42f;
             x = 4f;
             y = 3f;
             top = true;
             ejectEffect = Fx.casing1;
             bullet = new BasicBulletType(3.5f, 20){{
                 width = 8f;
                 height = 10f;
                 lifetime = 68f;
                 status = DecalingStatus.decaling;
                 statusDuration = 20f;
             }};
         }});
     }};
     destroy = new UnitType("destroy"){{
         speed = 0.34f;
         hitSize = 31f;
         health = 1470;
         outlineColor = DecalPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DecalingStatus.decaling);
         abilities.add(new DecayField(94f, 1.7f));
         weapons.add(new Weapon("decal-artillery-decay-weapon"){{
             reload = 174f;
             x = 0f;
             y = 0f;
             top = false;
             mirror = false;
             ejectEffect = Fx.casing1;
             bullet = new ArtilleryBulletType(2.6f, 30){{
                 width = 18f;
                 height = 18f;
                 lifetime = 60f;
                 splashDamage = 176;
                 splashDamageRadius = 56;
                 status = DecalingStatus.decaling;
                 statusDuration = 30f;
             }};
         }});
     }};
 }
}