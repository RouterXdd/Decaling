package decal.content;

import arc.graphics.*;
import arc.struct.*;
import decal.world.meta.*;
import decal.world.units.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import decal.graphics.*;
import decal.world.abilities.*;

public class DecalingUnits {
 public static UnitType
 //time
 hour, clock, timer, day, year, timeAssemblyDrone, pause, resume, timeEntity,
 //core
 decray, melair,
 //decay
 clear, remove, destroy, obliterate, annihilate, decayAssemblyDrone, rush,
 //support
 refate,t2, recursion,
 //neo
 transporter, child,
 //ice
 iceliner,
 //tantros
 recuperate, harvone, lysis, reef, ornicus, vertex,
 //ancient
 retor,
 //bosses
 shadow, apparition
    ;
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
                    parentizeEffects = true;
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
                    parentizeEffects = true;
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
            bounded = false;
            constructor = BuildingTetherPayloadUnit::create;
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
         bounded = false;
         constructor = BuildingTetherPayloadUnit::create;
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
     pause = new UnitType("pause"){{
         hovering = true;
         shadowElevation = 0.1f;
         constructor = ElevationMoveUnit::create;

         drag = 0.07f;
         speed = 1.8f;
         rotateSpeed = 5f;
         outlineColor = DecalPal.decalOutline;
         accel = 0.09f;
         health = 1560f;
         armor = 1f;
         hitSize = 11f;
         engineOffset = 6f;
         engineSize = 2f;
         itemCapacity = 0;
         useEngineElevation = false;
         researchCostMultiplier = 0f;

         abilities.add(new MoveEffectAbility(0f, -6f, DecalPal.darkTime, Fx.missileTrailShort, 4f){{
             teamColor = true;
         }});

         for(float f : new float[]{-3f, 3f}){
             parts.add(new HoverPart(){{
                 x = 4f;
                 y = f;
                 mirror = true;
                 radius = 6f;
                 phase = 90f;
                 stroke = 2f;
                 layerOffset = -0.001f;
                 color = DecalPal.darkTime;
             }});
         }

         weapons.add(new Weapon("decal-pause-weapon"){{
             shootSound = Sounds.blaster;
             y = -2f;
             x = 4f;
             top = true;
             mirror = true;
             reload = 40f;
             baseRotation = -35f;
             shootCone = 360f;

             shoot = new ShootSpread(3, 14f);

             bullet = new BasicBulletType(5f, 10){{
                 homingPower = 0.2f;
                 homingDelay = 4f;
                 width = 8f;
                 height = 12f;
                 lifetime = 30f;
                 shootEffect = Fx.sparkShoot;
                 smokeEffect = Fx.shootBigSmoke;
                 hitColor = backColor = trailColor = DecalPal.darkTime;
                 frontColor = Color.white;
                 trailWidth = 1.5f;
                 trailLength = 5;
                 hitEffect = despawnEffect = Fx.hitBulletColor;
                 status = DecalingStatus.timeCrack;
                 statusDuration = 40;
             }};
         }});
     }};
     resume = new UnitType("resume"){{
         health = 2140;
         speed = 2f;
         hitSize = 14f;
         drag = 0.08f;
         accel = 0.1f;
         flying = true;
         range = 220f;
         deathExplosionEffect = DecalingFx.resumeDespawn;
         constructor = UnitEntity::create;
         engineOffset = 12.4f;
         engineSize = 0f;
         outlineColor = DecalPal.decalOutline;
         immunities.add(DecalingStatus.decaling);
         immunities.add(DecalingStatus.timeCrack);
         parts.add(new HaloPart(){{
                       progress = PartProgress.life;
                       color = DecalPal.darkTime;
                       layer = Layer.effect + 6;
                       y = 2;

                       haloRotation = 0f;
                       shapes = 2;
                       hollow = false;
                       triLength = 18f;
                       haloRadius = 1.5f;
                       tri = true;
                       radius = 2.5f;
                       haloRotateSpeed = 8;

                   }},
                 new HaloPart(){{
                     progress = PartProgress.life;
                     color = DecalPal.darkTime;
                     layer = Layer.effect + 6;
                     y = 2;

                     haloRotation = 0f;
                     shapes = 2;
                     hollow = false;
                     triLength = 2f;
                     shapeRotation = 180f;
                     haloRadius = 1.5f;
                     tri = true;
                     radius = 2.5f;
                     haloRotateSpeed = 8;

                 }});
         weapons.add(
                 new Weapon("decal-resume-weapon"){{
                     shootSound = Sounds.blaster;
                     reload = 4f;
                     x = 4f;
                     y = 2f;
                     top = false;
                     layerOffset = -1;
                     rotate = true;
                     rotationLimit = 40;
                     bullet = new BasicBulletType(5, 3){{
                         homingPower = 0.3f;
                         homingDelay = 5f;
                         width = 6f;
                         height = 10f;
                         lifetime = 30f;
                         shootEffect = Fx.sparkShoot;
                         smokeEffect = Fx.shootBigSmoke;
                         hitColor = backColor = trailColor = DecalPal.darkTime;
                         frontColor = Color.white;
                         trailWidth = 1.2f;
                         trailLength = 4;
                         hitEffect = despawnEffect = Fx.hitBulletColor;
                         status = DecalingStatus.timeCrack;
                         statusDuration = 30;
                     }};
                 }});
     }};
     //the boss
     timeEntity = new UnitType("time-entity"){{
         hovering = true;
         constructor = UnitEntity::create;

         drag = 0.1f;
         speed = 8f;
         rotateSpeed = 8f;
         outlineColor = DecalPal.decalOutline;
         accel = 0.06f;
         health = 30000f;
         armor = 10f;
         hitSize = 26f;
         engineOffset = 6f;
         engineSize = 0f;
         itemCapacity = 0;
         useEngineElevation = false;
         researchCostMultiplier = 0f;

         abilities.add(new MoveEffectAbility(0f, 0f, DecalPal.darkTime, Fx.missileTrail, 4f)
                 , new MoveEffectAbility(3f, -2f, DecalPal.darkTime, Fx.missileTrailShort, 4f)
                 , new MoveEffectAbility(-3f, -2f, DecalPal.darkTime, Fx.missileTrailShort, 4f));
             parts.add(new HaloPart(){{
                 progress = PartProgress.life;
                 color = DecalPal.darkTime;
                 layer = Layer.effect;
                 y = 0;

                 haloRotation = 0f;
                 shapes = 5;
                 triLength = 14f;
                 haloRadius = 17f;
                 tri = false;
                 radius = 8f;
             }},
                     new HaloPart(){{
                         progress = PartProgress.life;
                         color = DecalPal.darkTime;
                         layer = Layer.effect;
                         y = 0;
                         haloRotateSpeed = -4;

                         shapes = 4;
                         triLengthTo = 8f;
                         haloRotation = 45f;
                         haloRadius = 8f;
                         tri = true;
                         radius = 6f;
                     }},
         new HaloPart(){{
             progress = PartProgress.life;
             color = DecalPal.darkTime;
             layer = Layer.effect;
             y = 0;
             haloRotateSpeed = 4;

             shapes = 4;
             triLengthTo = 8f;
             haloRotation = 45f;
             haloRadius = 8f;
             tri = true;
             radius = 6f;
         }},
                     new ShapePart(){{
                         progress = PartProgress.life;
                         color = Color.black.a(1);
                         circle = true;
                         hollow = false;
                         stroke = 1.6f;
                         radius = 4f;
                         layer = Layer.effect;
                         y = 0;
                         rotateSpeed = 0;
                     }}
                     );
             parts.add(new ShapePart(){{
                 progress = PartProgress.life;
                 color = DecalPal.darkTime;
                 circle = true;
                 hollow = true;
                 stroke = 1.5f;
                 radius = 6f;
                 layer = Layer.effect;
                 y = 0;
                 rotateSpeed = 0;
             }});

         weapons.add(new Weapon("time-weapon"){{
             shootSound = Sounds.blaster;
             y = 0f;
             x = 0f;
             top = true;
             mirror = false;
             reload = 20f;
             inaccuracy = 360f;
             shootCone = 360f;

             shoot.shots = 4;
             bullet = new BasicBulletType(6f, 40){{
                 homingPower = 0.3f;
                 homingDelay = 4f;
                 width = 10f;
                 height = 16f;
                 lifetime = 50f;
                 shootEffect = Fx.sparkShoot;
                 smokeEffect = Fx.shootBigSmoke;
                 hitColor = backColor = trailColor = DecalPal.darkTime;
                 frontColor = Color.white;
                 trailWidth = 1.8f;
                 trailLength = 7;
                 hitEffect = despawnEffect = Fx.hitBulletColor;
                 status = DecalingStatus.timeCrack;
                 statusDuration = 50;
             }};
             parts.add(new ShapePart(){{
                 progress = PartProgress.life;
                 color = DecalPal.darkTime;
                 circle = true;
                 hollow = false;
                 radius = 1f;
                 layer = Layer.effect;
                 y = 1.8f;
                 rotateSpeed = 0;
             }});
         }},
                 new Weapon("LASOR"){{
                     shootSound = Sounds.laserblast;
                     chargeSound = Sounds.lasercharge;
                     reload = 500f;
                     x = 0f;
                     y = 2f;
                     top = true;
                     mirror = false;
                     shootY = 1.3f;
                     shoot.firstShotDelay = DecalingFx.smallTimeLaserCharge.lifetime;
                     shootStatus = StatusEffects.unmoving;
                     shootStatusDuration = DecalingFx.smallTimeLaserCharge.lifetime;
                     cooldownTime = 500f;
                     bullet = new LaserBulletType(){{
                         length = 240f;
                         damage = 200f;
                         width = 20f;

                         lifetime = 65f;

                         lightningSpacing = 20f;
                         lightningLength = 3;
                         lightningDelay = 1f;
                         lightningLengthRand = 15;
                         lightningDamage = 100;
                         lightningAngleRand = 40f;
                         largeHit = true;
                         lightColor = lightningColor = DecalPal.darkTime;
                         parentizeEffects = true;
                         chargeEffect = DecalingFx.smallTimeLaserCharge;
                         sideAngle = 15f;
                         sideWidth = 0f;
                         sideLength = 0f;
                         colors = new Color[]{DecalPal.darkTime.cpy().a(0.4f), DecalPal.darkTime, Color.white};
                     }};
                 }});
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
     melair = new UnitType("melair"){{
         controller = u -> new BuilderAI();
         flying = true;
         drag = 0.04f;
         accel = 0.16f;
         range = 160f;
         hitSize = 15f;
         speed = 2.55f;
         health = 500;
         mineSpeed = 7f;
         mineTier = 2;
         buildSpeed = 1f;
         engineSize = 2.4f;
         engineOffset = 6.8f;
         constructor = UnitEntity::create;
         immunities.add(DecalingStatus.decaling);
         outlineColor = DecalPal.decalOutline;
         abilities.add(new StealDecayField(50f, 0.4f, 0.2f));
         weapons.add(new Weapon("main-melair-weap"){{
             reload = 8f;
             x = 0f;
             y = 0f;
             top = false;
             shoot = new ShootHelix();
             bullet = new MissileBulletType(){{
                 height = 14f;
                 width = 8f;
                 speed = 4f;
                 lifetime = 34f;
                 damage = 10f;
                 status = DecalingStatus.decaling;
                 statusDuration = 10f * 2f;
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
            rotate = false;
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
         range = 150f;
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
     obliterate = new UnitType("obliterate"){{
         speed = 0.26f;
         hitSize = 56f;
         health = 5120;
         range = 200f;
         outlineColor = DecalPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DecalingStatus.decaling);
         abilities.add(new DecayField(130f, 2f));
         weapons.add(new Weapon("decal-artillery-decay-weapon"){{
             reload = 75f;
             x = 8f;
             y = -4f;
             top = false;
             mirror = true;
             ejectEffect = Fx.casing1;
             bullet = new ShrapnelBulletType(){{
                 width = 7f;
                 length = 26;
                 lifetime = 30f;
                 damage = 60;
                 pierce = true;
                 pierceCap = 3;
                 pierceBuilding = true;
                 status = DecalingStatus.decaling;
                 statusDuration = 30f;
             }};
         }});
     }};
     annihilate = new UnitType("annihilate"){{
         controller = u -> new DefenderAI();
         speed = 0.18f;
         hitSize = 73f;
         health = 21000;
         armor = 10f;
         outlineColor = DecalPal.decalOutline;
         constructor = MechUnit::create;
         immunities.add(DecalingStatus.decaling);
         abilities.add(new DecayField(160f, 2.8f));
         weapons.add(new RepairBeamWeapon("decal-artillery-decay-weapon"){{
             x = 0f;
             y = -7f;
             beamWidth = 1f;
             top = false;
             mirror = false;
             ejectEffect = Fx.casing1;
             repairSpeed = 1.5f;
             laserColor = DecalPal.decalOutline;
             healColor = DecalPal.decalOutline;
             bullet = new BulletType(){{
                 maxRange = 160f;
             }};
         }});
     }};
     refate = new UnitType("refate"){{
         health = 325;
         speed = 2.8f;
         controller = u -> new DefenderAI();
         hitSize = 8f;
         drag = 0.032f;
         flying = true;
         range = 78f;
         faceTarget = true;
         circleTarget = false;
         constructor = UnitEntity::create;
         engineOffset = 5.2f;
         engineSize = 1.5f;
         outlineColor = DecalPal.decalOutline;
         immunities.add(DecalingStatus.decaling);
         abilities.add(new RegenField(0.2f, 32f));
         weapons.add(new Weapon("main-weapon"){{
             reload = 30f;
             x = 0f;
             y = 1f;
             top = false;
             ejectEffect = Fx.casing1;
             mirror = false;
             bullet = new BasicBulletType(3.5f, 12){{
                 width = 7f;
                 height = 9f;
                 lifetime = 22.3f;
                 status = DecalingStatus.decaling;
                 statusDuration = 20f;
             }};
         }});
     }};
     recursion = new UnitType("recursion"){{
         health = 2780;
         speed = 3.2f;
         controller = u -> new BuilderAI();
         hitSize = 27f;
         drag = 0.02f;
         flying = true;
         range = 106f;
         faceTarget = true;
         circleTarget = false;
         constructor = UnitEntity::create;
         engineOffset = 2.2f;
         engineSize = 2.3f;
         outlineColor = DecalPal.decalOutline;
         immunities.add(DecalingStatus.decaling);
         buildSpeed = 1f;
         drawBuildBeam = false;
         weapons.add(new BuildWeapon("decal-recursion-weapon"){{
             rotate = true;
             rotateSpeed = 7f;
             mirror = true;
             top = true;
             x = -8f;
             y = -2f;
             shootY = 1f;
         }});
     }};
     rush = new UnitType("rush"){{
         hitSize = 8f * 3.6f;
         flying = true;
         drag = 0.06f;
         accel = 0.1f;
         range = 200f;
         speed = 4f;
         health = 50000;
         engineSize = 0f;
         engineOffset = 7.4f;
         constructor = UnitEntity::create;
         immunities.add(DecalingStatus.decaling);
         outlineColor = DecalPal.decalOutline;
         abilities.add(new DecayField(20f, 200f));
         abilities.add(new MoveEffectAbility(){{
             effect = DecalingFx.rushMove;
             y = -3f;
             interval = 7f;
         }});
     }};
     transporter = new UnitType("transporter"){{
         controller = u -> new CargoAI();

         flying = true;
         drag = 0.07f;
         accel = 0.11f;
         speed = 1.7f;
         health = 170;
         engineSize = 1.9f;
         engineOffset = 2.4f;
         payloadCapacity = 0f;
         targetable = false;
         bounded = false;
         constructor = BuildingTetherPayloadUnit::create;
         outlineColor = Pal.neoplasmOutline;
         isEnemy = false;
         hidden = true;
         useUnitCap = false;
         logicControllable = false;
         playerControllable = false;
         allowedInPayloads = false;
         envEnabled = Env.any;
         envDisabled = Env.none;
     }};
     iceliner = new UnitType("iceliner"){{
         health = 600;
         speed = 0f;
         hitSize = 14f;
         flying = true;
         range = 120f;
         faceTarget = true;
         circleTarget = false;
         constructor = BuildingTetherPayloadUnit::create;
         engineOffset = 5.8f;
         engineSize = 2.6f;
         outlineColor = DecalPal.decalOutline;
         weapons.add(new Weapon("main-weapon"){{
             reload = 40f;
             x = 0f;
             y = 2f;
             top = false;
             ejectEffect = Fx.casing1;
             mirror = false;
             bullet = new BasicBulletType(4f, 30){{
                 width = 9f;
                 height = 12f;
                 lifetime = 30f;
             }};
         }});
     }};
     child = new UnitType("child"){{
         controller = u -> new BuilderAI();
         envEnabled = DecalingEnv.neolaspmatic;
         flying = true;
         drag = 0.04f;
         accel = 0.13f;
         range = 160f;
         speed = 3.8f;
         health = 240;
         mineSpeed = 5f;
         mineTier = 2;
         buildSpeed = 0.6f;
         engineSize = 2.6f;
         engineOffset = 4.7f;
         constructor = UnitEntity::create;
         outlineColor = Pal.neoplasmOutline;
         weapons.add(new Weapon("main-weap"){{
             reload = 30f;
             x = 0f;
             y = 0f;
             top = false;
             bullet = new BasicBulletType(){{
                 height = 13f;
                 width = 6f;
                 speed = 5f;
                 lifetime = 32f;
                 damage = 20f;
                 buildingDamageMultiplier = 0.01f;
             }};
         }});
     }};
     recuperate = new UnitType("recuperate"){{
         controller = u -> new BuilderAI();
         envEnabled = Env.underwater;
         hitSize = 8;
         flying = true;
         drag = 0.08f;
         accel = 0.1f;
         range = 160f;
         speed = 4.7f;
         health = 140;
         armor = 3;
         mineWalls = true;
         mineSpeed = 5.6f;
         mineTier = 3;
         buildSpeed = 1.3f;
         engineSize = 0f;
         engineOffset = 0f;
         constructor = UnitEntity::create;
         outlineColor = DecalPal.tantrosOutline;
         itemCapacity = 40;
         setEnginesMirror(
                 new UnitEngine(4.8f, -5.2f, 2f, -45f)
         );

         weapons.add(new Weapon("main-weap"){{
             reload = 40f;
             x = 0f;
             y = 0f;
             top = false;
             mirror = false;
             bullet = new MissileBulletType(5f, 20){{
                 height = 13f;
                 width = 6f;
                 lifetime = 70f;
                 weaveMag = 3.4f;
                 weaveRandom = true;
                 weaveScale = 10;
                 buildingDamageMultiplier = 0.01f;
                 shootSound = Sounds.missile;
                 trailLength = 30;
                 homingRange = 100;
                 hitEffect = Fx.blastExplosion;
                 despawnEffect = Fx.blastExplosion;
             }};
         }});
     }};
     harvone = new UnitType("harvone"){{
         controller = u -> new MinerAI(){{
           mineItems = Seq.with(DecalingItems.nickel, DecalingItems.cadmium);
           targetItem = DecalingItems.nickel;
         }};
         hitSize = 4;
         envEnabled = Env.underwater;

         defaultCommand = UnitCommand.mineCommand;

         flying = true;
         drag = 0.08f;
         accel = 0.09f;
         speed = 3.5f;
         armor = 2;
         health = 70;
         engineSize = 1.2f;
         engineOffset = 3.5f;
         range = 50f;
         isEnemy = false;
         mineWalls = true;
         itemCapacity = 25;

         ammoType = new PowerAmmoType(500);
         constructor = UnitEntity::create;
         mineTier = 3;
         mineSpeed = 3.5f;
     }};
     lysis = new UnitType("lysis"){{
         controller = u -> new MinerAI(){{
             mineItems = Seq.with(DecalingItems.oblite);
             targetItem = DecalingItems.oblite;
         }};
         envEnabled = Env.underwater;
         hitSize = 10;

         defaultCommand = UnitCommand.mineCommand;

         flying = true;
         drag = 0.08f;
         accel = 0.09f;
         speed = 3.5f;
         armor = 2;
         health = 460;
         engineSize = 2.1f;
         engineOffset = 4.6f;
         range = 50f;
         isEnemy = false;
         mineWalls = true;
         itemCapacity = 40;

         ammoType = new PowerAmmoType(1000);
         constructor = UnitEntity::create;
         mineTier = 4;
         mineSpeed = 5f;
     }};
     reef = new UnitType("reef"){{
         envEnabled = Env.underwater | Env.terrestrial;
         hitSize = 12;
         flying = false;
         range = 100f;
         rotateSpeed = 9;
         speed = 1.4f;
         health = 600;
         armor = 2;
         itemCapacity = 45;
         constructor = MechUnit::create;
         outlineColor = DecalPal.tantrosOutline;

         weapons.add(new Weapon("main-weap"){{
             reload = 15f;
             x = 0f;
             y = 0f;
             top = false;
             mirror = false;
             inaccuracy = 10;
             bullet = new MissileBulletType(5f, 10){{
                 height = 9f;
                 width = 5f;
                 lifetime = 20f;
                 shootSound = Sounds.missile;
                 trailLength = 20;
                 hitEffect = Fx.flakExplosion;
                 despawnEffect = Fx.flakExplosion;
             }};
         }});
     }};
     ornicus = new UnitType("ornicus"){{
         envEnabled = Env.underwater | Env.terrestrial;
         hitSize = 18;
         flying = false;
         rotateSpeed = 7;
         speed = 0.7f;
         health = 1445;
         armor = 8;
         itemCapacity = 90;
         constructor = MechUnit::create;
         outlineColor = DecalPal.tantrosOutline;

         weapons.add(new Weapon("decal-pulse-weapon"){{
             reload = 30f;
             x = 6f;
             y = 0f;
             shootY = 5f;
             top = true;
             mirror = true;
             rotate = true;
             bullet = new SapBulletType(){{
                 length = 50f;
                 width = 0.5f;
                 damage = 20;
                 knockback = 1.6f;
                 lifetime = 40f;
                 shootSound = Sounds.sap;
                 hitEffect = Fx.sapped;
                 despawnEffect = Fx.none;
                 hitColor = color = DecalPal.lightGreen;
             }};
         }});
     }};
     vertex = new UnitType("vertex"){{
         envEnabled = Env.underwater;
         hitSize = 15;
         flying = true;
         drag = 0.07f;
         accel = 0.16f;
         range = 160f;
         speed = 2.6f;
         health = 360;
         armor = 5;
         rotateSpeed = 3;
         engineSize = 0f;
         engineOffset = 0f;
         constructor = UnitEntity::create;
         outlineColor = DecalPal.tantrosOutline;
         itemCapacity = 40;

         weapons.add(new Weapon("main-weap"){{
             reload = 50f;
             x = 0f;
             y = 3f;
             top = false;
             mirror = false;
             bullet = new MissileBulletType(5f, 20){{
                 ammoMultiplier = 1f;
                 damage = 0f;
                 speed = 1000f;
                 spawnUnit = new MissileUnitType("vertex-torpedo"){{
                     speed = 4f;
                     rotateSpeed = 1.7f;
                     maxRange = 50f;
                     lifetime = 40f;
                     outlineColor = DecalPal.tantrosOutline;
                     engineColor = trailColor = DecalPal.oxygenColor;
                     trailLength = 7;
                     health = 130;
                     hitSize = 3;
                     fogRadius = 3;
                     loopSoundVolume = 0.1f;
                     constructor = TimedKillUnit::create;
                     useUnitCap = false;

                     weapons.add(new Weapon() {{
                         shootCone = 360f;
                         mirror = false;
                         reload = 1f;
                         shootOnDeath = true;
                         killShooter = true;
                         bullet = new ExplosionBulletType(48f, 30f);
                     }});
                 }};
             }};
         }});
     }};
     retor = new UnitType("retor"){{
         hitSize = 8;
         flying = true;
         drag = 0.08f;
         accel = 0.1f;
         range = 40f;
         speed = 3.2f;
         health = 1240;
         armor = 7;
         engineSize = 2.8f;
         engineOffset = 7f;
         constructor = UnitEntity::create;
         outlineColor = Pal.darkOutline;
         itemCapacity = 20;

         weapons.add(new Weapon("main-weap"){{
             reload = 50f;
             x = 0f;
             y = 3f;
             top = false;
             mirror = false;
             bullet = new LaserBulletType(){{
                 length = 34f;
                 damage = 80;
                 width = 6f;
                 lifetime = 10f;
                 shootSound = Sounds.lasershoot;
                 colors = new Color[]{DecalPal.ancident.a(0.35f), DecalPal.ancident.a(0.5f), DecalPal.ancident.a(0.6f), Color.white, Color.white};
                 hitEffect = Fx.hitLancer;
                 despawnEffect = Fx.hitLancer;
             }};
         }});
     }};
     shadow = new ShadowBossType("shadow"){{
         envEnabled = Env.any;
         health = 40000;
         armor = 200;
         speed = 2f;
         hitSize = 30f;
         drag = 0.3f;
         flying = true;
         faceTarget = true;
         constructor = UnitEntity::create;
         immunities.addAll();
         engineOffset = 0f;
         engineSize = 0f;
         outlineColor = Color.black;
         range = 200;
         outlineRadius = 0;
         createWreck = false;
         deathExplosionEffect = DecalingFx.shadowDeath;
         shadowElevation = 0;
         parts.add(new HaloPart(){{
             progress = PartProgress.life;
             color = Color.black;
             layer = Layer.effect + 6;

             haloRotation = 0f;
             shapes = 3;
             hollow = false;
             triLength = 18f;
             haloRadius = 0.8f;
             tri = true;
             radius = 2.6f;
             haloRotateSpeed = 8;

         }},
                 new HaloPart(){{
                     progress = PartProgress.life;
                     color = Color.black;
                     layer = Layer.effect + 6;

                     haloRotation = 0f;
                     shapes = 3;
                     hollow = false;
                     triLength = 18f;
                     haloRadius = 0.8f;
                     tri = true;
                     radius = 2.6f;
                     haloRotateSpeed = -8;

                 }});
         weapons.add(new Weapon("shadow-weapon1"){{
             reload = 200f;
             x = 0f;
             y = 0f;
             top = false;
             shoot.shots = 5;
             shoot.shotDelay = 5;
             bullet = new BulletType(){{
                 damage = 0f;
                 speed = 0f;
                 lifetime = 0f;
                 hitEffect = Fx.none;
                 spawnUnit = new MissileUnitType("shadow-bullet"){{
                     speed = 2.4f;
                     rotateSpeed = 3f;
                     maxRange = 50f;
                     lifetime = 160f;
                     engineOffset = 0f;
                     engineSize = 0f;
                     outlineColor = Color.black;
                     outlineRadius = 0;
                     health = 400;
                     hitSize = 5;
                     fogRadius = 3;
                     constructor = TimedKillUnit::create;
                     useUnitCap = false;
                     parts.add(new HaloPart(){{
                                   progress = PartProgress.life;
                                   color = Color.black;
                                   layer = Layer.effect + 6;

                                   haloRotation = 0f;
                                   shapes = 2;
                                   hollow = false;
                                   triLength = 9f;
                                   haloRadius = 0.8f;
                                   tri = true;
                                   radius = 2f;
                                   haloRotateSpeed = 8;

                               }});
                     weapons.add(new Weapon() {{
                         shootCone = 360f;
                         mirror = false;
                         reload = 1f;
                         shootOnDeath = true;
                         bullet = new ExplosionBulletType(80f, 40f);
                     }});
                 }};
             }};
         }},
                 new Weapon("shadow-weapon2"){{
                     reload = 760f;
                     x = 0f;
                     y = 0f;
                     top = false;
                     shoot.shots = 8;
                     shoot.shotDelay = 4;
                     bullet = new BulletType(){{
                         damage = 0f;
                         speed = 0f;
                         lifetime = 0f;
                         hitEffect = Fx.none;
                         spawnUnit = new UnitType("shadow-swarmling"){{
                             speed = 2f;
                             range = 8;
                             crushDamage = 0.02f;
                             rotateSpeed = 1.4f;
                             engineOffset = 0f;
                             engineSize = 0f;
                             outlineColor = Color.black;
                             outlineRadius = 0;
                             health = 500;
                             armor = 10;
                             hitSize = 8;
                             allowLegStep = false;
                             fogRadius = 6;
                             constructor = MechUnit::create;
                             useUnitCap = false;

                             weapons.add(new Weapon() {{
                                 x = 0;
                                 y = 3;
                                 shootCone = 20f;
                                 mirror = false;
                                 reload = 20f;
                                 bullet = new BasicBulletType(5f, 30f){{
                                     width = 0.1f;
                                     height = 0.1f;
                                     lifetime = 2;
                                 }};
                             }});
                         }};
                     }};
                 }});
     }};
     apparition = new UnitType("apparition"){{
         controller = u -> new FlyingAI();
         envEnabled = Env.any;
         health = 20000;
         range = 1;
         armor = 300;
         speed = 1.2f;
         hitSize = 26f;
         drag = 0.2f;
         flying = true;
         faceTarget = false;
         constructor = UnitEntity::create;
         immunities.addAll();
         engineOffset = 0f;
         engineSize = 0f;
         outlineColor = Color.black;
         outlineRadius = 0;
         createWreck = false;
         deathExplosionEffect = DecalingFx.shadowDeath;
         shadowElevation = 0;
         targetFlags = new BlockFlag[]{BlockFlag.core, null};
         weapons.add(new Weapon("main-weap"){{
             reload = 100f;
             x = 0f;
             y = 0f;
             top = false;
             mirror = false;
             bullet = new BasicBulletType(){{
                 height = 1f;
                 damage = 400;
                 width = 1f;
                 lifetime = 1f;
                 shootSound = Sounds.lasershoot;
                 hitEffect = Fx.hitLancer;
                 despawnEffect = Fx.hitLancer;
             }};
         }});
     }};
 }
}