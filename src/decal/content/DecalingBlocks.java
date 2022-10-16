package decal.content;

import arc.graphics.*;
import arc.struct.*;
import decal.world.blocks.campaning.*;
import decal.world.blocks.distribution.*;
import decal.world.blocks.power.*;
import decal.world.blocks.production.*;
import decal.world.blocks.storage.*;
import decal.graphics.*;
import decal.world.blocks.defence.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.defense.turrets.*;


import static mindustry.type.ItemStack.*;

public class DecalingBlocks{
    public static Block

    //environment
    decayfloor, decaywall, oreFragment, decaystone, oreMateria, decaystoneWall, purIce, purIceWall,

    //defence
    decalwall, decalwalllarge, timewall, timewallLarge,

    //breackers


    //crafting
    changer, repairer, recreator, vilineForge, pressureClet,

    //production
    test, oreCrusher, tectonicBomber,

    //power
    decayconsider, wire, largeWire, timeDriver,

    //storage
    coreDry,

    //distribution
    lightLink, mediumLink, heavyLink ,mover, test2,

    //turrets
    cluster, starflood, interleet, confronter, missileter, preletT1, preletT2, crystalFer, orbitalCannon, metalBlast, metalBlastV2,

    //units
    timeFactory, decayFactory, timeRefabricator, decayRefabricator,timeAssembler,decayAssembler, decayModule, decayModuleT2, wallConstructor,
    //CUMpaning
    timeMachine,
    //for modmakers
    airStrike;

    public void load() {
        //environment
        decayfloor = new Floor("decay-floor"){{
            attributes.set(DecalingAttributes.decay, 1f);
            itemDrop = DecalingItems.oldmateria;
            playerUnmineable = true;
            status = DecalingStatus.decaling;
            statusDuration = 180f;
            variants = 3;
        }};
        decaywall = new StaticWall("decay-floor-wall"){{
        variants = 3;
        }};
        decaystoneWall = new StaticWall("decay-stone-wall"){{
            variants = 3;
        }};
        decaystone = new Floor("decay-stone"){{
        attributes.set(DecalingAttributes.decay, 0.4f);
        variants = 3;
        }};
         oreFragment = new OreBlock(DecalingItems.timefragment){{
             oreDefault = true;
         }};
         oreMateria = new OreBlock(DecalingItems.oldmateria){{
             oreDefault = true;
         }};
        purIce = new Floor("pur-ice"){{
            dragMultiplier = 0.35f;
            speedMultiplier = 0.9f;
            attributes.set(Attribute.water, 0.4f);
            albedo = 0.65f;
        }};
        purIceWall = new StaticWall("pur-ice-wall");
        //defence
    decalwall = new Wall("decalwall"){{
            requirements(Category.defense, with(DecalingItems.oldmateria, 6));
            health = 620;
        }};
    decalwalllarge = new Wall("decalwall-large"){{
            requirements(Category.defense, with(DecalingItems.oldmateria, 24));
            size = 2;
            health = 620 * 4;
        }};
        timewall = new Wall("timewall"){{
            requirements(Category.defense, with(
                DecalingItems.oldmateria, 12,
                DecalingItems.timefragment, 6
                ));
            health = 960;
        }};
    timewallLarge = new Wall("timewall-large"){{
            requirements(Category.defense, with(
                DecalingItems.oldmateria, 48,                
                DecalingItems.timefragment, 24
                ));
            size = 2;
            health = 960 * 4;
        }};
        //crafting
        changer = new GenericCrafter("changer") {{
        requirements(Category.crafting, with(
            DecalingItems.oldmateria, 60,
            Items.graphite, 48,
            Items.silicon, 34
            ));
            health = 140;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(DecalingItems.decaygraphite, 1);
            craftTime = 64f;
            size = 3;
            itemCapacity = 12;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumeItems(with(Items.graphite, 1, DecalingItems.oldmateria, 3));
        }};
        repairer = new Separator("repairer"){{
            requirements(Category.crafting, with(DecalingItems.oldmateria, 80));
            results = with(
                Items.lead, 5,
                Items.graphite, 3,
                Items.silicon, 2,
                DecalingItems.timefragment, 1
            );
            hasPower = true;
            craftTime = 48f;
            size = 2;

            consumePower(0.7f);
            consumeItem(DecalingItems.oldmateria, 4);
        }};
        recreator = new Separator("recreator"){{
            requirements(Category.crafting, with(DecalingItems.oldmateria, 130,DecalingItems.timefragment, 60, DecalingItems.decaygraphite, 35));
            results = with(
                    Items.lead, 3,
                    Items.graphite, 4,
                    Items.silicon, 4,
                    DecalingItems.timefragment, 2
            );
            hasPower = true;
            craftTime = 28f;
            size = 3;
            itemCapacity = 20;

            consumePower(1.4f);
            consumeItem(DecalingItems.oldmateria, 5);
        }};
        vilineForge = new GenericCrafter("viline-forge") {{
            requirements(Category.crafting, with(
                    DecalingItems.oldmateria, 100,
                    DecalingItems.decaygraphite, 35,
                    Items.silicon, 60
            ));
            health = 210;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(DecalingItems.viliniteAlloy, 1);
            craftTime = 64f;
            size = 3;
            itemCapacity = 10;
            drawer = new DrawMulti(new DrawDefault(),new DrawPistons(){{sinMag = 10f;}}, new DrawFlame());

            consumePower(2.1f);
            consumeItems(with(Items.graphite, 2, Items.silicon, 3, DecalingItems.timefragment, 2));
        }};
        pressureClet = new GenericCrafter("pressure-clet") {{
            requirements(Category.crafting, with(
                    DecalingItems.oldmateria, 170,
                    DecalingItems.decaygraphite, 80,
                    Items.silicon, 120,
                    DecalingItems.timefragment, 85
            ));
            scaledHealth = 80;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(DecalingItems.reliteplate, 2);
            craftTime = 80f;
            size = 3;
            itemCapacity = 20;
            drawer = new DrawMulti(
            new DrawDefault(),
            new DrawRegion(){{
                suffix = ("-spinner");
                rotateSpeed = 3;
                spinSprite = true;
            }},
            new DrawRegion(){{
                suffix = ("-spinner");
                rotateSpeed = -3;
                spinSprite = true;
            }});

            consumePower(2.8f);
            consumeItems(with(DecalingItems.oldmateria, 5, Items.silicon, 4, Items.lead, 6, DecalingItems.timefragment, 4));
        }};
        //production
        test = new RotateDrill("driller"){{
            requirements(Category.production, with(DecalingItems.oldmateria, 25));
            size = 2;
            tier = 2;
            drillTime = 190;
            researchCost = with(DecalingItems.oldmateria, 125);
        }};
        oreCrusher = new BurstDrill("ore-Crusher"){{
            requirements(Category.production, with(DecalingItems.oldmateria, 40, Items.silicon, 15));
            size = 3;
            tier = 3;
            drillTime = 470;
        }};
        tectonicBomber = new BurstDrill("tectonic-bomber"){{
            requirements(Category.production, with(DecalingItems.oldmateria, 120, Items.silicon, 75, DecalingItems.timefragment, 100, DecalingItems.decaygraphite, 70));
            size = 5;
            tier = 4;
            drillTime = 246;
            itemCapacity = 80;
            consumePower(0.75f);
        }};
        //power
        decayconsider = new ThermalGenerator("decay-consider"){{
            requirements(Category.power, with(DecalingItems.oldmateria, 40));
            attribute = DecalingAttributes.decay;
            powerProduction = 2f / 8.4f;
            displayEfficiency = false;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.04f;
            size = 1;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;

            drawer = new DrawMulti(new DrawDefault(),
            new DrawPistons(){{
                sinMag = 1f;
            }});

            fogRadius = 3;
            researchCost = with(DecalingItems.oldmateria, 30);
        }};
        wire = new Wall("wire"){{
            requirements(Category.power, with(
                    DecalingItems.oldmateria, 5,
                    Items.silicon, 2
            ));
            health = 30;
            group = BlockGroup.power;
            consumesPower = outputsPower = true;
            consumePowerBuffered(5f);
            researchCost = with(DecalingItems.oldmateria, 20,Items.silicon, 16);
        }};
        largeWire = new Wall("large-wire"){{
            requirements(Category.power, with(
                    DecalingItems.oldmateria, 20,
                    Items.silicon, 8
            ));
            size = 2;
            health = 120;
            group = BlockGroup.power;
            consumesPower = outputsPower = true;
            consumePowerBuffered(20f);
        }};
        timeDriver = new AttributeGenerator("time-driver"){{
            requirements(Category.power, with(DecalingItems.oldmateria, 540, Items.graphite, 460, Items.silicon, 300, DecalingItems.timefragment, 280));
            scaledHealth = 148;
            size = 3;
            powerProduction = 4.8f;
            fogRadius = 3;
        }};
        //storage
        coreDry = new DrillCore("core-dry"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(DecalingItems.oldmateria, 1200, Items.graphite, 600, Items.lead, 800));
            alwaysUnlocked = true;

            tier = 2;
            isFirstTier = true;
            unitType = DecalingUnits.decray;
            health = 1000;
            itemCapacity = 3500;
            drillTime = 80;
            size = 3;

            unitCapModifier = 10;
        }};
        //distribution
        lightLink = new TransferLink("light-link") {{
            requirements(Category.distribution, ItemStack.with(
                DecalingItems.oldmateria, 5,
                Items.graphite, 2
                ));
        }};
        mediumLink = new TransferLink("medium-link") {{
            requirements(Category.distribution, ItemStack.with(
                    DecalingItems.oldmateria, 10,
                    DecalingItems.decaygraphite, 3
            ));
            size = 2;
            linkRange = 73;
            maxLinks = 3;
            arrowSpacing = 10f;
            arrowSpeed = 0.6f;
            transferTime = 0.6f;
        }};
        heavyLink = new TransferLink("heavy-link") {{
            requirements(Category.distribution, ItemStack.with(
                    DecalingItems.oldmateria, 40,
                    DecalingItems.timefragment, 15,
                    DecalingItems.decaygraphite, 20
            ));
            size = 3;
            linkRange = 154;
            maxLinks = 1;
            arrowSpacing = 16f;
            arrowSpeed = 0.8f;
            transferTime = 0.8f;
        }};
        mover = new Duct("mover"){{
            requirements(Category.distribution, with(DecalingItems.oldmateria, 1));
            health = 120;
            researchCost = with(DecalingItems.oldmateria, 10);
            speed = 2.96f;
        }};
        test2 = new LiquidDriver("test"){{
            requirements(Category.distribution, with(DecalingItems.oldmateria, 1));
            range = 8;
        }};
        //turrets
        cluster = new ItemTurret("cluster"){{
            requirements(Category.turret, with(
                DecalingItems.oldmateria, 78,
                Items.lead, 45,
                Items.graphite, 60
                ));
                health = 570;
                size = 2;
                reload = 50f;
                range = 146f;
                recoil = 1.2f;
                shoot = new ShootSpread(3, 26f);
                coolant = consumeCoolant(0.2f);
                outlineColor = DecalPal.decalOutline;
                ammo(
                    DecalingItems.oldmateria, new BasicBulletType(){{
                    height = 9f;
                    width = 7f;
                    speed = 4f;
                    lifetime = 36.5f;
                    ammoMultiplier = 2.2f;
                    damage = 8f;
                    homingPower = 0.08f;
                    homingRange = 9f;
                    status = DecalingStatus.decaling;
                    statusDuration = 60f * 2f;
                    }});
                drawer = new DrawTurret("decay-"){{
                parts.add(new RegionPart("-recoil"){{
                    progress = PartProgress.reload;
                    moveY = -2.3f;
                    mirror = false;
                    heatColor = Color.red;
                }});
            }};
            researchCost = with(DecalingItems.oldmateria, 100, Items.lead, 100, Items.silicon, 100);
        }};
        starflood = new PowerTurret("starflood"){{
            requirements(Category.turret, with(
                DecalingItems.oldmateria, 115,
                Items.silicon, 75,
                Items.graphite, 60,
                DecalingItems.timefragment, 40
                ));
                health = 890;
                size = 2;
                reload = 70f;
                range = 198f;
                recoil = 1.45f;
                coolant = consumeCoolant(0.2f);
                consumePower(3.2f);
                outlineColor = DecalPal.decalOutline;
                drawer = new DrawTurret("decay-");
                    shootType = new ContinuousFlameBulletType(){{
                damage = 11.8f;
                length = -30f;
                speed = 6f;
                lifetime = 33f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

                fragBullet = new ContinuousFlameBulletType(){{
                damage = 7.3f;
                length = 0f;
                speed = 4f;
                drag = 0.07f;
                lifetime = 71f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};

                fragBullets = 4;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.5f;
                fragLifeMin = 0.4f;
            }};
        }};
        interleet = new PowerTurret("interleet"){{
            requirements(Category.turret, with(
                DecalingItems.oldmateria, 90,
                Items.silicon, 80,
                DecalingItems.decaygraphite, 55,
                DecalingItems.timefragment, 70
                ));
                health = 780;
                size = 2;
                reload = 5f;
                range = 260f;
                recoil = 0f;
                coolant = consumeCoolant(0.2f);
                consumePower(6f);
                outlineColor = DecalPal.decalOutline;
                shootY = 0f;
                drawer = new DrawTurret("decay-");
                shoot = new ShootSummon(0f, 0f, 240f, 360f);
                    shootType = new ContinuousFlameBulletType(){{
                damage = 20f;
                length = 0f;
                drag = 0.065f;
                speed = 8f;
                lifetime = 34f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), DecalPal.darkTime};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

                status = DecalingStatus.timeswap2;
                statusDuration = 80f;
            }};
        }};
        confronter = new ContinuousTurret("confronter"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 120,
                    Items.silicon, 90,
                    DecalingItems.decaygraphite, 75,
                    DecalingItems.timefragment, 58
            ));
            scaledHealth = 130;
            size = 2;
            reload = 20f;
            range = 96f;
            recoil = 0f;
            targetHealing = true;
            coolant = consumeCoolant(0.2f);
            consumePower(3.6f);
            outlineColor = DecalPal.decalOutline;
            shootY = -1.8f;
            drawer = new DrawTurret("decay-");
            shootType = new ContinuousFlameBulletType(){{
                damage = 4f;
                length = 96f;
                healPercent = 3f;
                collidesTeam = true;
                lifetime = 45f;
                pierceCap = 0;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

            }};
        }};
        missileter = new ItemTurret("missileter"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 120,
                    Items.silicon, 75,
                    Items.graphite, 60,
                    DecalingItems.viliniteAlloy, 30
            ));
            targetHealing = true;
            scaledHealth = 190;
            size = 2;
            reload = 26f;
            range = 190f;
            recoil = 0f;
            shoot = new ShootSummon(0f, 0f, 0f, 360f);
            coolant = consumeCoolant(0.45f);
            outlineColor = DecalPal.decalOutline;
            ammo(
                    DecalingItems.viliniteAlloy, new BasicBulletType(){{
                        ammoMultiplier = 1f;
                        damage = 0f;
                        collidesTeam = true;
                        spawnUnit = new MissileUnitType("heal-missile"){{
                            speed = 5.6f;
                            rotateSpeed = 4f;
                            maxRange = 6f;
                            lifetime = 60f * 1.55f;
                            outlineColor = Pal.darkOutline;
                            engineColor = trailColor = DecalPal.vilinite;
                            health = 60;
                            loopSoundVolume = 0.1f;
                            constructor = TimedKillUnit::create;
                            immunities.add(DecalingStatus.decaling);
                            collidesTeam = true;

                            weapons.add(new Weapon() {{
                                shootCone = 360f;
                                mirror = false;
                                reload = 1f;
                                shootOnDeath = true;
                                bullet = new ExplosionBulletType(50f, 20f) {{
                                    shootEffect = Fx.massiveExplosion;
                                    healPercent = 3;
                                    collidesTeam = true;
                                }};
                            }});
                        }};
                    }});
            drawer = new DrawTurret("decay-");
            researchCost = with(DecalingItems.oldmateria, 600, Items.silicon, 375, Items.graphite, 300, DecalingItems.viliniteAlloy, 150);
        }};
        preletT1 = new UpgradeblePowerTurret("prelet-t1"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 120,
                    Items.silicon, 140,
                    DecalingItems.decaygraphite, 55,
                    DecalingItems.timefragment, 85,
                    DecalingItems.timeEssence, 10
            ));
            upgradeTurret = DecalingBlocks.preletT2;
            upgradecost = new ItemStack(DecalingItems.timefragment, 50);
            scaledHealth = 175;
            size = 3;
            reload = 12f;
            range = 140f;
            recoil = 1.2f;
            itemCapacity = 30;
            coolant = consumeCoolant(0.6f);
            consumePower(5.7f);
            outlineColor = DecalPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new LaserBulletType(){{
                damage = 40f;
                length = 140f;
                lifetime = 26f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.white.a(0.6f), Color.white, Color.white};

                lightColor = hitColor;

                status = DecalingStatus.timeswap1;
                statusDuration = 120f;
            }};
        }};
        preletT2 = new PowerTurret("prelet-t2"){{
            requirements(Category.turret, BuildVisibility.debugOnly, with(
                    DecalingItems.oldmateria, 120,
                    Items.silicon, 140,
                    DecalingItems.decaygraphite, 55,
                    DecalingItems.timefragment, 115,
                    DecalingItems.timeEssence, 10
            ));
            scaledHealth = 195;
            size = 3;
            reload = 10f;
            range = 150f;
            recoil = 1.2f;
            shoot = new ShootSpread(3, 6);
            coolant = consumeCoolant(0.6f);
            consumePower(6.3f);
            outlineColor = DecalPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new LaserBulletType(){{
                damage = 40f;
                length = 140f;
                lifetime = 26f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.white.a(0.6f), Color.white, Color.white};

                lightColor = hitColor;

                status = DecalingStatus.timeswap1;
                statusDuration = 140f;
            }};
        }};
        crystalFer = new ItemTurret("crystal-fer"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 210,
                    Items.silicon, 160,
                    DecalingItems.decaygraphite, 65,
                    DecalingItems.timefragment, 110
            ));
            scaledHealth = 142;
            size = 3;
            reload = 70f;
            range = 184f;
            recoil = 1.3f;
            shoot.shots = 5;
            shoot.shotDelay = 6f;
            targetGround = false;
            coolant = consumeCoolant(0.6f);
            outlineColor = DecalPal.decalOutline;
            ammo(
                    DecalingItems.timefragment, new BasicBulletType(){{
                        height = 12f;
                        width = 9f;
                        speed = 6f;
                        lifetime = 30.6f;
                        ammoMultiplier = 2.4f;
                        collidesGround = false;
                        damage = 26f;
                        homingPower = 0.1f;
                        homingRange = 11f;
                        status = DecalingStatus.timeswap1;
                        statusDuration = 60f * 0.8f;
                    }});
            drawer = new DrawTurret("decay-");
            researchCost = with(DecalingItems.oldmateria, 210,
                    Items.silicon, 160,
                    DecalingItems.decaygraphite, 65,
                    DecalingItems.timefragment, 110
            );
        }};
        orbitalCannon = new ItemTurret("omega-cannon"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 900,
                    Items.lead, 1100,
                    DecalingItems.decaygraphite, 460,
                    DecalingItems.timefragment, 750,
                    DecalingItems.reliteplate, 600
            ));
            rotateSpeed = 20f;
            scaledHealth = 230;
            size = 5;
            reload = 800f;
            range = 3000f;
            recoil = 2f;
            coolant = consumeCoolant(5f);
            outlineColor = DecalPal.decalOutline;
            ammo(
                    DecalingItems.timefragment, new BasicBulletType(){{
                        height = 32f;
                        width = 18f;
                        speed = 5f;
                        lifetime = 600f;
                        damage = 800f;
                        sprite = "decal-orbital";
                        trailColor = DecalPal.darkTime;
                        trailLength = 30;
                        trailWidth = 5;
                        ammoMultiplier = 1;
                        pierce = true;
                        pierceBuilding = true;
                    }});
            drawer = new DrawTurret("decay-");
            ammoPerShot = 40;
            maxAmmo = 40;
        }};
        metalBlast = new ModesPowerTurret("metal-blast"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 240,
                    Items.silicon, 180,
                    DecalingItems.decaygraphite, 75,
                    DecalingItems.timefragment, 145,
                    DecalingItems.reliteplate, 50
            ));
            modeTurret = DecalingBlocks.metalBlastV2;
            scaledHealth = 195;
            size = 3;
            reload = 11f;
            range = 180f;
            recoil = 1.2f;
            coolant = consumeCoolant(0.6f);
            consumePower(3.35f);
            outlineColor = DecalPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new BasicBulletType(){{
                height = 24f;
                width = 14f;
                speed = 6f;
                lifetime = 30f;
                damage = 4f;
                sprite = "decal-orbital";
                ammoMultiplier = 1;
            }};
        }};
        metalBlastV2 = new ModesPowerTurret("metal-blast-v2"){{
            requirements(Category.turret, BuildVisibility.debugOnly,with(
                    DecalingItems.oldmateria, 240,
                    Items.silicon, 180,
                    DecalingItems.decaygraphite, 75,
                    DecalingItems.timefragment, 145,
                    DecalingItems.reliteplate, 50
            ));
            modeTurret = DecalingBlocks.metalBlast;
            scaledHealth = 195;
            size = 3;
            reload = 60f;
            range = 180f;
            recoil = 1.2f;
            coolant = consumeCoolant(0.6f);
            consumePower(3.9f);
            outlineColor = DecalPal.decalOutline;
            drawer = new DrawTurret("decay-");
            shootType = new BasicBulletType(){{
                height = 26f;
                width = 15f;
                speed = 6f;
                lifetime = 30f;
                damage = 50f;
                sprite = "decal-orbital";
                ammoMultiplier = 1;
                pierce = true;
                pierceCap = 4;
                pierceBuilding = true;
            }};
        }};
        //units
        timeFactory = new UnitFactory("time-factory"){{
            requirements(Category.units, with(Items.silicon, 200, Items.graphite, 300, DecalingItems.timefragment, 60));
            size = 3;
            configurable = false;
            plans.add(new UnitPlan(DecalingUnits.hour, 60f * 40f, with(DecalingItems.timefragment, 20, Items.silicon, 40)));
            regionSuffix = "-decay";
            fogRadius = 3;
            researchCostMultiplier = 0.65f;
            consumePower(2.6f);
        }};
        decayFactory = new UnitFactory("decay-factory"){{
            requirements(Category.units, with(Items.silicon, 220, Items.graphite, 270, DecalingItems.oldmateria, 140));
            size = 3;
            plans.add(new UnitPlan(DecalingUnits.clear, 60f * 34f, with(DecalingItems.oldmateria, 35, Items.silicon, 30)));
            regionSuffix = "-decay";
            fogRadius = 3;
            researchCostMultiplier = 0.65f;
            consumePower(2.6f);
        }};

        timeRefabricator = new Reconstructor("time-refabricator"){{
            requirements(Category.units, with(DecalingItems.oldmateria, 200, DecalingItems.timefragment, 80, Items.silicon, 100));
            regionSuffix = "-decay";

            size = 3;
            consumePower(4.2f);
            consumeItems(with(DecalingItems.decaygraphite, 65, DecalingItems.timefragment, 40));

            constructTime = 60f * 42f;
            researchCostMultiplier = 0.75f;

            upgrades.addAll(
            new UnitType[]{DecalingUnits.hour, DecalingUnits.clock}
            );
        }};
        decayRefabricator = new Reconstructor("decay-refabricator"){{
            requirements(Category.units, with(DecalingItems.oldmateria, 220, DecalingItems.decaygraphite, 90, Items.silicon, 140));
            regionSuffix = "-decay";

            size = 3;
            consumePower(4.2f);
            consumeItems(with(DecalingItems.decaygraphite, 40, DecalingItems.oldmateria, 50));

            constructTime = 60f * 35f;
            researchCostMultiplier = 0.75f;

            upgrades.addAll(
                    new UnitType[]{DecalingUnits.clear, DecalingUnits.remove}
            );
        }};
        timeAssembler = new UnitAssembler("time-assembler"){{
            requirements(Category.units, with(DecalingItems.decaygraphite, 200, DecalingItems.oldmateria, 600, DecalingItems.timefragment, 200, Items.graphite, 500, Items.silicon, 900));
            regionSuffix = "-decay";
            droneType = DecalingUnits.timeAssemblyDrone;
            size = 3;
            plans.add(
            new AssemblerUnitPlan(DecalingUnits.timer, 60f * 60f, PayloadStack.list(DecalingUnits.hour, 4, DecalingBlocks.decalwalllarge, 10)),
            new AssemblerUnitPlan(DecalingUnits.day, 60f * 60f * 3f, PayloadStack.list(DecalingUnits.clock, 6, DecalingBlocks.timewallLarge, 20)),
            new AssemblerUnitPlan(DecalingUnits.year, 60f * 60f * 6f, PayloadStack.list(DecalingUnits.hour, 8, DecalingUnits.clock, 8, DecalingBlocks.decalwalllarge, 20, DecalingBlocks.timewallLarge, 20))
            );
            consumePower(3.7f);
            areaSize = 15;
        }};
        decayAssembler = new UnitAssembler("decay-assembler"){{
            requirements(Category.units, with(DecalingItems.decaygraphite, 300, DecalingItems.oldmateria, 680, Items.graphite, 650, Items.silicon,1100));
            regionSuffix = "-decay";
            droneType = DecalingUnits.decayAssemblyDrone;
            size = 3;
            plans.add(
                    new AssemblerUnitPlan(DecalingUnits.destroy, 60f * 60f, PayloadStack.list(DecalingUnits.clear, 4, DecalingBlocks.decalwalllarge, 12))
                    );
            consumePower(3.7f);
            areaSize = 15;
        }};
        decayModule = new UnitAssemblerModule("decay-module"){{
            requirements(Category.units, with(Items.lead, 500, DecalingItems.oldmateria, 300, DecalingItems.decaygraphite, 200,DecalingItems.viliniteAlloy, 150));
            consumePower(2f);
            regionSuffix = "-decay";

            size = 3;
        }};
        decayModuleT2 = new UnitAssemblerModule("decay-modulet2"){{
            requirements(Category.units, with(Items.lead, 800, DecalingItems.oldmateria, 600, DecalingItems.decaygraphite, 400, DecalingItems.timefragment, 250,DecalingItems.viliniteAlloy, 260));
            consumePower(3.7f);
            regionSuffix = "-decay";
            tier = 2;
            size = 5;
        }};
       wallConstructor = new Constructor("constructor"){{
            requirements(Category.units, with(DecalingItems.oldmateria, 250, Items.silicon, 180, Items.graphite, 150, DecalingItems.decaygraphite, 60));
            regionSuffix = "-decay";
            hasPower = true;
            buildSpeed = 0.42f;
            consumePower(3f);
            size = 3;
            filter = Seq.with(DecalingBlocks.decalwalllarge, DecalingBlocks.timewallLarge);
        }};
        //CUMpaning
        timeMachine = new TimeMachine("time-machine"){{
            requirements(Category.effect, BuildVisibility.debugOnly, with());
            health = 6000;
            size = 5;
            itemCapacity = 2000;
            breakable = true;
            solid = true;
            update = true;
            configurable = true;
            consumePower(36);
            consumeItems(with(DecalingItems.oldmateria, 1600,DecalingItems.timefragment, 2000, DecalingItems.timeEssence, 900));
        }};
        //for modmakers
        airStrike = new ItemTurret("air-strike"){{
            requirements(Category.turret, BuildVisibility.debugOnly, with());
                health = 780;
                size = 4;
                reload = 65f;
                range = 280f;
                recoil = 0f;
                coolant = consumeCoolant(0.4f);
                outlineColor = DecalPal.decalOutline;
                shootY = 0f;
                shoot = new ShootSummon(0f, 0f, 280f, 360f);
                ammo(
                    Items.blastCompound, new BasicBulletType(){{
                    height = 0f;
                    width = 0f;
                    speed = 0f;
                    lifetime = 60f;
                    damage = 0f;
                    ammoMultiplier = 1f;

                    fragBullet = new ShrapnelBulletType(){{
                    length = 70;
                    damage = 80f;
                    width = 12f;
                    toColor = Pal.redSpark;
                    }};
                    fragBullets = 8;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.5f;
                fragLifeMin = 0.4f;
                    }});
        }};
    }
}
