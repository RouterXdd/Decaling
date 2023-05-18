package decal.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import decal.world.blocks.campaning.*;
import decal.world.blocks.distribution.*;
import decal.world.blocks.environment.*;
import decal.world.blocks.power.*;
import decal.world.blocks.production.*;
import decal.world.blocks.storage.*;
import decal.graphics.*;
import decal.world.blocks.defence.*;
import decal.world.bullets.*;
import decal.world.meta.*;
import mindustry.entities.*;
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
import mindustry.world.blocks.storage.*;
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
    decayfloor, decaywall, oreFragment, decaystone, oreMateria, decaystoneWall, purIce, purIceWall, crystalBoulder, neoplasmaLiquidFloor, neoFloor,
    neoWall, roughNeoFloor, oreIod, nickelWallOre, cadmiunWallOre, obliteWallOre, purVent, redVent,

    //defence
    decalwall, decalwalllarge, timewall, timewallLarge, decayBarrier, viliniteWall, viliniteWallLarge, mirrorWall, mirrorWallLarge, iodWall,

    //breakers


    //crafting
    changer, repairer, recreator, vilineForge, pressureClet, timeElectric, recycler, decayIncinerator,

    //production
    test, oreCrusher, tectonicBomber,

    cliffBore,

    //power
    decayconsider, wire, largeWire, timeDriver, armoredWire, largeArmoredWire, hydrothermalPP,

    //storage
    coreDry, coreDecay, werehouse, coreBorn, coreRuin,

    //distribution
    lightLink, mediumLink, heavyLink ,mover, decaySorter, test2,

    neoLoader, neoUnloader,

    NIC,NDB,

    //turrets
    cluster, starflood, interleet, confronter, missileter, decaynir, preletT1, preletT2, crystalFer, rollIn, paradox, orbitalCannon, metalBlast, metalBlastV2, prototypeRift,

    neoShooter, unstable,

    icelinerSpawner,

    wreck,

    //units
    timeFactory, decayFactory, timeRefabricator, decayRefabricator,timeAssembler,decayAssembler, decayModule, decayModuleT2, wallConstructor,

    harvoneFactory,
    //CUMpaning
    timeMachine,
    //special
    creeperCell,
    //for modmakers
    airStrike;

    public void load() {
        Blocks.incinerator.requirements(Category.crafting, with(Items.copper, 10, Items.lead, 40, Items.graphite, 30));
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
         oreFragment = new OreBlock(DecalingItems.timefragment);
         oreMateria = new OreBlock(DecalingItems.oldmateria);
        purIce = new Floor("pur-ice"){{
            dragMultiplier = 0.35f;
            speedMultiplier = 0.9f;
            attributes.set(Attribute.water, 0.4f);
            albedo = 0.65f;
        }};
        purIceWall = new StaticWall("pur-ice-wall");
        neoplasmaLiquidFloor = new Floor("neoplasm-liquid-floor") {{
            speedMultiplier = 0.55f;
            variants = 0;
            drownTime = 110f;

            liquidDrop = Liquids.neoplasm;
            isLiquid = true;
            liquidMultiplier = 0.8f;
            cacheLayer = DecalingShaders.neoplasmLayer;
        }};
        neoFloor = new Floor("neo-floor") {{
            variants = 3;
        }};
        roughNeoFloor = new Floor("rough-neo-floor") {{
            variants = 3;
        }};
        neoWall = new StaticWall("neo-wall"){{
            variants = 3;
            Blocks.grass.asFloor().wall = Blocks.shrubs;
            neoFloor.asFloor().wall = this;
            roughNeoFloor.asFloor().wall = this;
        }};
        oreIod = new OreBlock(DecalingItems.iod);
        nickelWallOre = new OreBlock("nickel-wall-ore"){{
            wallOre = true;
            itemDrop = DecalingItems.nickel;
            variants = 2;
        }};
        cadmiunWallOre = new OreBlock("cadmium-wall-ore"){{
            wallOre = true;
            itemDrop = DecalingItems.cadmium;
            variants = 2;
        }};
        obliteWallOre = new OreBlock("oblite-wall-ore"){{
            wallOre = true;
            itemDrop = DecalingItems.oblite;
            variants = 3;
        }};
        purVent = new VolcanoVent("pur-vent"){{
            blendGroup = Blocks.bluemat;
            parent = Blocks.bluemat;
            attributes.set(DecalingAttributes.volcano, 1);
        }};
        redVent = new VolcanoVent("red-vent"){{
            blendGroup = Blocks.redmat;
            parent = Blocks.redmat;
            effectColor = DecalPal.volcanoRedColor;
            attributes.set(DecalingAttributes.volcano, 1);
        }};

        crystalBoulder = new Prop("crystal-boulder"){{
            variants = 2;
            decayfloor.asFloor().decoration = this;
        }};
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
             decayBarrier= new DirectionalForceProjector("decay-barrier"){{
                requirements(Category.effect, with(DecalingItems.oldmateria, 180,
                        Items.graphite, 85,
                        Items.silicon, 110,
                        DecalingItems.decaygraphite, 60,
                        DecalingItems.viliniteAlloy, 50
                ));
                size = 3;
                width = 70f;
                length = 40;
                shieldHealth = 2800f;
                cooldownNormal = 2f;
                cooldownBrokenBase = 0.5f;

                consumePower(5.5f);
            }};
        viliniteWall = new DecalingWall("vilinite-wall"){{
            requirements(Category.defense, with(DecalingItems.viliniteAlloy, 6));
            health = 1280;
            repairChance = 0.05f;
            healAmount = 60f;
            repairHit = true;
        }};
        viliniteWallLarge = new DecalingWall("vilinite-wall-large"){{
            requirements(Category.defense, with(DecalingItems.viliniteAlloy, 24));
            health = 1280 * 4;
            repairChance = 0.05f;
            healAmount = 240f;
            repairHit = true;
            size = 2;
        }};
        mirrorWall = new DecalingWall("mirror-wall"){{
            requirements(Category.defense, with(DecalingItems.viliniteAlloy, 8, DecalingItems.reliteplate, 4));
            health = 2000;
            mirrorChance = 0.1f;
            absorbLasers = true;
        }};
        mirrorWallLarge = new DecalingWall("mirror-wall-large"){{
            requirements(Category.defense, with(DecalingItems.viliniteAlloy, 32, DecalingItems.reliteplate, 16));
            health = 2000 * 4;
            size = 2;
            mirrorChance = 0.1f;
            absorbLasers = true;
        }};
        iodWall = new NeoplasmaWall("iod-wall"){{
            requirements(Category.defense, with(DecalingItems.iod, 8));
            health = 400;
            healPercent = 5f;
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
        timeElectric = new GenericCrafter("time-electric") {{
            requirements(Category.crafting, with(
                    DecalingItems.decaygraphite, 165,
                    Items.silicon, 180,
                    DecalingItems.timefragment, 100,
                    DecalingItems.reliteplate, 40
            ));
            scaledHealth = 96;
            craftEffect = Fx.smoke;
            outputItems = with(DecalingItems.timeEssence, 1, DecalingItems.oldmateria, 2);
            craftTime = 120f;
            size = 3;
            itemCapacity = 24;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFrames(){{
                        frames = 4;
                        interval = 2f;
                    }},
                    new DrawFlame(){{
                        flameColor = DecalPal.darkTime;
                        flameRadius = 4f;
                    }});

            consumePower(2.8f);
            consumeItems(with(DecalingItems.timefragment, 6, DecalingItems.decaygraphite, 2 , DecalingItems.viliniteAlloy, 1));
        }};
        recycler = new Separator("recycler"){{
            requirements(Category.crafting, with(DecalingItems.oldmateria, 320,DecalingItems.timefragment, 180, DecalingItems.decaygraphite, 100, DecalingItems.viliniteAlloy, 50, DecalingItems.reliteplate, 20));
            results = with(
                    Items.lead, 3,
                    Items.graphite, 3,
                    Items.silicon, 3,
                    DecalingItems.timefragment, 3,
                    DecalingItems.decaygraphite, 3,
                    DecalingItems.viliniteAlloy, 2
            );
            hasPower = true;
            craftTime = 15f;
            size = 4;
            itemCapacity = 40;

            consumePower(3.8f);
            consumeItem(DecalingItems.oldmateria, 10);
        }};
        decayIncinerator = new Incinerator("decay-incinerator"){{
            requirements(Category.crafting, with(DecalingItems.oldmateria, 370, Items.silicon, 190, DecalingItems.decaygraphite, 90, DecalingItems.timefragment, 240));
            health = 580;
            size = 3;
            envEnabled |= Env.space;
            consumePower(2f);
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
        cliffBore = new BeamDrill("cliff-bore"){{
            requirements(Category.production, with(DecalingItems.nickel, 40, DecalingItems.cadmium, 30));
            health = 270;

            drillTime = 220f;
            tier = 2;
            size = 2;
            range = 1;
            fogRadius = 3;
            researchCost = with(DecalingItems.nickel, 40, DecalingItems.cadmium, 30);

            consumeLiquid(DecalingLiquids.deuterium, 1f / 60f).boost();
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
        wire = new WireWall("wire"){{
            requirements(Category.power, with(
                    DecalingItems.oldmateria, 5,
                    Items.silicon, 2
            ));
            health = 30;
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
        armoredWire = new WireWall("armored-wire"){{
            requirements(Category.power, with(
                    DecalingItems.reliteplate, 2,
                    Items.silicon, 4
            ));
            health = 100;
            armor = 20f;
            absorbLasers = true;
            electricity = false;
            group = BlockGroup.power;
            consumesPower = outputsPower = true;
            consumePowerBuffered(5f);
        }};
        largeArmoredWire = new Wall("large-armored-wire"){{
            requirements(Category.power, with(
                    DecalingItems.reliteplate, 8,
                    Items.silicon, 16
            ));
            size = 2;
            health = 400;
            absorbLasers = true;
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
        hydrothermalPP = new ThermalGenerator("hydrothermal-power-plant"){{
            requirements(Category.power, with(DecalingItems.nickel, 500, DecalingItems.cadmium, 350, DecalingItems.oxygen, 230, DecalingItems.oblite, 160));
            attribute = DecalingAttributes.volcano;
            displayEfficiencyScale = 1f / 25f;
            minEfficiency = 25f - 0.0001f;
            powerProduction = 4f;
            displayEfficiency = false;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.22f;
            size = 5;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;

            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.8f * 9f){{
                blurThresh = 0.01f;
            }});

            hasLiquids = true;
            outputLiquid = new LiquidStack(DecalingLiquids.deuterium, 5f / 220f);
            liquidCapacity = 100f;
            fogRadius = 5;
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
        coreDecay = new DrillCore("core-decay"){{
            requirements(Category.effect, with(DecalingItems.oldmateria, 3200, Items.graphite, 2600, Items.lead, 2900, Items.silicon, 1890, DecalingItems.viliniteAlloy, 1300));

            tier = 3;
            unitType = DecalingUnits.melair;
            health = 4000;
            itemCapacity = 6000;
            drillTime = 60;
            size = 4;

            unitCapModifier = 16;
        }};
        werehouse = new StorageBlock("werehouse"){{
            requirements(Category.effect, with(DecalingItems.oldmateria, 400, DecalingItems.timefragment, 250, DecalingItems.decaygraphite, 160));
            size = 2;
            itemCapacity = 400;
            scaledHealth = 55;
            consumesPower = false;
            conductivePower = true;
            consumePowerBuffered(500f);
        }};
        coreBorn = new CoreBlock("core-born"){{
            requirements(Category.effect, with(DecalingItems.iod, 1200));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = DecalingUnits.child;
            health = 400;
            itemCapacity = 1000;
            size = 1;

            unitCapModifier = 6;
        }};
        coreRuin = new CoreBlock("core-ruin"){{
            requirements(Category.effect, with(DecalingItems.nickel, 1700, DecalingItems.cadmium, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = DecalingUnits.recuperate;
            health = 4200;
            itemCapacity = 4500;
            size = 4;

            unitCapModifier = 14;
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
            linkRange = 200;
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
        decaySorter = new Sorter("decay-sorter"){{
            requirements(Category.distribution, with(DecalingItems.oldmateria, 5));
            buildCostMultiplier = 3f;
        }};
        test2 = new LiquidDriver("test"){{
            requirements(Category.distribution, with(DecalingItems.oldmateria, 1));
            range = 58;
        }};
        neoLoader = new UnitCargoLoader("neo-loader"){{
            requirements(Category.distribution, with(DecalingItems.iod, 70));
            envEnabled = DecalingEnv.neolaspmatic;
            unitType = DecalingUnits.transporter;

            size = 1;
            buildTime = 60f * 9f;
            polySides = 4;
            polyRadius = 3;
            polyColor = Pal.neoplasm1;

            itemCapacity = 50;
            researchCost = with(DecalingItems.iod, 200);
        }};
        neoUnloader = new UnitCargoUnloadPoint("neo-unloader"){{
            requirements(Category.distribution, with(DecalingItems.iod, 80));
            envEnabled = DecalingEnv.neolaspmatic;
            size = 1;

            itemCapacity = 100;

            researchCost = with(DecalingItems.iod, 160);
        }};
        NIC = new Conveyor("nic"){{
            requirements(Category.distribution, with(DecalingItems.nickel, 3));
            health = 20;
            researchCost = with(DecalingItems.nickel, 30);
            speed = 2f;
        }};
        NDB = new DuctBridge("ndb"){{
            requirements(Category.distribution, with(DecalingItems.nickel, 10, DecalingItems.cadmium, 3));
            health = 100;
            speed = 2f;
            researchCostMultiplier = 0.4f;
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
                drawer = new DrawTurret("decay-"){{
                    parts.addAll(
                            new ShapePart(){{
                                progress = PartProgress.warmup.delay(0.1f);
                                color = DecalPal.darkTime;
                                hollow = true;
                                stroke = 0f;
                                strokeTo = 1.8f;
                                radius = 3.2f;
                                layer = Layer.effect;
                                y = 0;
                                rotateSpeed = 8f;
                                x = 0;
                            }});
                }};
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
            shootY = -1.6f;
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
        decaynir = new ItemTurret("decaynir"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 144,
                    Items.lead, 175,
                    Items.graphite, 110,
                    DecalingItems.decaygraphite, 86
            ));
            scaledHealth = 195;
            size = 3;
            reload = 38f;
            range = 190f;
            recoil = 1.5f;
            coolant = consumeCoolant(0.3f);
            outlineColor = DecalPal.decalOutline;
            ammo(
                    DecalingItems.decaygraphite, new DecayBullet(4f, 36f){{
                        height = 12f;
                        width = 9f;
                        lifetime = 47.5f;
                        ammoMultiplier = 2.6f;
                        status = DecalingStatus.decaling;
                        statusDuration = 60f * 3f;
                        decayRange = 18f;
                        decayDamage = 0.6f;
                    }},
                    Items.silicon, new DecayBullet(4f, 24f){{
                        height = 11f;
                        width = 8f;
                        lifetime = 47.5f;
                        ammoMultiplier = 1.4f;
                        homingPower = 0.08f;
                        homingRange = 9f;
                        decayRange = 11f;
                        decayDamage = 0.2f;
                    }});
            drawer = new DrawTurret("decay-"){{
                parts.add(new RegionPart("-recoil"){{
                    progress = PartProgress.reload;
                    moveY = -2.3f;
                    mirror = false;
                    heatColor = Color.red;
                }});
            }};
        }};
        preletT1 = new UpgradeblePowerTurret("prelet-t1"){{
            requirements(Category.turret, BuildVisibility.hidden, with(
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
            shoot = new ShootSummon(0f, 7f, 7f, 0f);
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
            drawer = new DrawTurret("decay-"){{
                parts.addAll(
                        new ShapePart(){{
                            progress = PartProgress.warmup.delay(0.1f);
                            color = DecalPal.darkTime;
                            hollow = true;
                            stroke = 0f;
                            strokeTo = 2f;
                            radius = 5f;
                            circle = true;
                            layer = Layer.effect;
                            y = 10;
                            x = 0;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup.delay(0.1f);
                            color = DecalPal.darkTime;
                            hollow = true;
                            stroke = 0f;
                            strokeTo = 1.6f;
                            triLength = 0;
                            triLengthTo = 2.4f;
                            haloRadius = 6;

                            radius = 6f;
                            tri = true;
                            layer = Layer.effect;
                            y = 10;
                            haloRotateSpeed = 6f;
                            x = 0;
                        }}
                        );
            }};
            researchCost = with(DecalingItems.oldmateria, 210,
                    Items.silicon, 160,
                    DecalingItems.decaygraphite, 65,
                    DecalingItems.timefragment, 110
            );
        }};
        rollIn = new ContinuousTurret("roll-in"){{
            requirements(Category.turret, with(DecalingItems.oldmateria, 430,
                    Items.silicon, 230,
                    DecalingItems.decaygraphite, 170,
                    DecalingItems.timefragment, 320,
                    DecalingItems.viliniteAlloy, 210
            ));

            shootType = new PointLaserBulletType(){{
                damage = 10f;
                buildingDamageMultiplier = 0.4f;
                lightColor = color = hitColor = DecalPal.darkTime;
                status = DecalingStatus.timeStop;
                statusDuration = 30;
                trailWidth = 4;
                trailLength = 40;
                trailColor = DecalPal.darkTime;
            }};

            drawer = new DrawTurret("decal-"){{
                var heatp = DrawPart.PartProgress.warmup.blend(p -> Mathf.absin(2f, 1f) * p.warmup, 0.2f);
                parts.add(new RegionPart("-mid"){{
                            heatProgress = heatp;
                            progress = PartProgress.warmup;
                            heatColor = DecalPal.darkTime;
                            moveY = -8f;
                            mirror = false;
                            under = true;
                        }});
            }};
            coolant = consumeCoolant(0.6f);
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.laserbeam;

            shootWarmupSpeed = 0.1f;
            shootCone = 360f;

            aimChangeSpeed = 2f;
            rotateSpeed = 2f;

            shootY = 0.5f;
            outlineColor = DecalPal.decalOutline;
            size = 4;
            range = 250f;
            scaledHealth = 210;

            unitSort = UnitSorts.farthest;

            consumePower(6);
            consumeItem(DecalingItems.timefragment, 8);
        }};
        paradox = new ItemTurret("paradox"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 540,
                    Items.silicon, 230,
                    DecalingItems.decaygraphite, 340,
                    DecalingItems.timefragment, 320,
                    DecalingItems.viliniteAlloy, 240
            ));
            scaledHealth = 320;
            size = 4;
            reload = 350f;
            range = 600f;
            recoil = 3f;
            shoot.firstShotDelay = 40f;
            shootY = -2;
            coolant = consumeCoolant(0.6f);
            outlineColor = DecalPal.decalOutline;
            consumePower(4.5f);
            ammo(
                    DecalingItems.timefragment, new BasicBulletType(){{
                        height = 14f;
                        width = 10f;
                        speed = 10f;
                        lifetime = 60f;
                        ammoMultiplier = 2f;
                        damage = 120f;
                        pierce = true;
                        status = DecalingStatus.timeCrack;
                        statusDuration = 60f * 4f;
                        buildingDamageMultiplier = 0.8f;
                        backColor = DecalPal.darkTime;
                        frontColor = DecalPal.darkTime;
                        trailLength = 5;
                        trailWidth = 2;
                        trailColor = DecalPal.darkTime;
                    }});
            drawer = new DrawTurret("decay-"){{
                parts.add(new RegionPart("-ray"){{
                    progress = PartProgress.warmup;
                    moveY = 2.4f;
                    moveX = -2.4f;
                    mirror = true;
                    heatColor = DecalPal.darkTime;
                    under = true;
                }});
            }};
            ammoPerShot = 5;
            maxAmmo = 30;
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
                        buildingDamageMultiplier = 0.5f;
                    }});
            drawer = new DrawTurret("decay-");
            ammoPerShot = 40;
            maxAmmo = 40;
        }};
        metalBlast = new ModesPowerTurret("metal-blast", metalBlastV2){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 240,
                    Items.silicon, 180,
                    DecalingItems.decaygraphite, 75,
                    DecalingItems.timefragment, 145,
                    DecalingItems.reliteplate, 50
            ));
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
        metalBlastV2 = new ModesPowerTurret("metal-blast-v2", metalBlast){{
            requirements(Category.turret, BuildVisibility.debugOnly,with(
                    DecalingItems.oldmateria, 240,
                    Items.silicon, 180,
                    DecalingItems.decaygraphite, 75,
                    DecalingItems.timefragment, 145,
                    DecalingItems.reliteplate, 50
            ));
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
        prototypeRift = new PayloadAmmoTurret("prototype-rift"){{
            requirements(Category.turret, with(
                    DecalingItems.oldmateria, 1270,
                    Items.silicon, 780,
                    Items.graphite, 970,
                    DecalingItems.timefragment, 980,
                    DecalingItems.viliniteAlloy, 580,
                    DecalingItems.timeEssence, 200
            ));
            scaledHealth = 890;
            size = 5;
            reload = 200f;
            range = 360f;
            recoil = 1.45f;
            coolant = consumeCoolant(0.2f);
            consumePower(3.2f);
            outlineColor = DecalPal.decalOutline;
            drawer = new DrawTurret("decay-");
            ammo(
                    DecalingBlocks.timewallLarge, new BasicBulletType(){{
                        height = 20f;
                        width = 20f;
                        speed = 6f;
                        lifetime = 60f;
                        damage = 100f;
                        sprite = "large-orb";
                        frontColor = DecalPal.darkTime;
                        backColor = DecalPal.darkTime;
                        trailColor = DecalPal.darkTime;
                        trailLength = 20;
                        trailWidth = 5;
                        ammoMultiplier = 1;
                        pierce = true;
                        pierceCap = 5;
                        pierceBuilding = true;
                        reloadMultiplier = 1;
                        intervalBullet = new ContinuousFlameBulletType(){{
                            damage = 10f;
                            length = 100f;
                            lifetime = 60f;
                            pierceCap = 3;
                            colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                            flareColor = Color.valueOf("ffffff");

                            lightColor = hitColor = flareColor;
                        }};

                        bulletInterval = 4f;
                        intervalRandomSpread = 360f;
                        intervalBullets = 2;
                        intervalAngle = 360f;
                        intervalSpread = 360f;
                    }});
        }};
        neoShooter = new ItemTurret("neo-shooter"){{
            requirements(Category.turret, with(
                    DecalingItems.iod, 80
            ));
            envEnabled = DecalingEnv.neolaspmatic;
            health = 570;
            size = 2;
            reload = 60f;
            range = 160f;
            recoil = 1.2f;
            shoot.shots = 3;
            shoot.shotDelay = 6;
            coolant = consumeCoolant(0.2f);
            outlineColor = Pal.neoplasmOutline;
            ammo(
                    DecalingItems.iod, new BasicBulletType(){{
                        height = 11f;
                        width = 8f;
                        speed = 5f;
                        lifetime = 32f;
                        ammoMultiplier = 2.2f;
                        damage = 30f;
                    }});
            drawer = new DrawTurret("neo-"){{
                parts.addAll(
                        new ShapePart(){{
                            progress = PartProgress.warmup.delay(0.1f);
                            color = Pal.neoplasm1;
                            stroke = 0f;
                            strokeTo = 0.7f;
                            sides = 3;
                            rotation = -90;
                            radius = 2f;
                            layer = Layer.effect;
                            y = -3.5f;
                            x = 0;
                        }});
            }};
            researchCost = with(DecalingItems.iod, 300);
        }};
        unstable = new ItemTurret("unstable"){{
            requirements(Category.turret, with(
                    DecalingItems.iod, Mathf.random(140, 380)
            ));
            envEnabled = DecalingEnv.neolaspmatic;
            health = Mathf.random(600, 800);
            size = 2;
            reload = Mathf.random(60, 200);
            range = Mathf.random(100, 300);
            recoil = Mathf.random(1, 3);
            shoot.shots = Mathf.random(1, 8);
            shoot.shotDelay = Mathf.random(4, 16);
            coolant = consumeCoolant(Mathf.random(0.01f, 0.03f));
            outlineColor = Pal.neoplasmOutline;
            ammo(
                    DecalingItems.iod, new BasicBulletType(){{
                        height = Mathf.random(10, 16);
                        width = Mathf.random(8, 12);
                        speed = Mathf.random(4, 6);
                        lifetime = Mathf.random(30, 50);
                        damage = Mathf.random(40, 70);
                    }});
            drawer = new DrawTurret("neo-"){{
                parts.addAll(
                        new ShapePart(){{
                            progress = PartProgress.warmup.delay(0.1f);
                            color = Pal.neoplasm1;
                            stroke = 0f;
                            strokeTo = 0.7f;
                            sides = 5;
                            rotation = -90;
                            radius = 2f;
                            layer = Layer.effect;
                            y = -3.5f;
                            x = 0;
                        }});
            }};
            researchCost = with(DecalingItems.iod, 800);
        }};
        icelinerSpawner = new UnitCargoLoader("iceliner-spawner"){{
            requirements(Category.turret, with());
            health = 800;
            unitType = DecalingUnits.iceliner;
            acceptsItems = false;

            size = 2;
            buildTime = 60f * 12f;
            polySides = 3;
            polyRadius = 4.2f;
            polyColor = DecalPal.icelin;

            itemCapacity = 0;
        }};
        wreck = new ItemTurret("wreck"){{
            requirements(Category.turret, with(
                    DecalingItems.nickel, 120, DecalingItems.cadmium, 70
            ));
            scaledHealth = 200;
            size = 3;
            reload = 30f;
            range = 300f;
            recoil = 2f;
            coolant = consumeCoolant(0.3f);
            outlineColor = DecalPal.tantrosOutline;
            ammo(
                    DecalingItems.nickel, new BasicBulletType(4f, 20f){{
                        height = 11f;
                        width = 8f;
                        lifetime = 75f;
                        ammoMultiplier = 1.4f;
                        weaveMag = 2.6f;
                        weaveRandom = true;
                        weaveScale = 6;
                        trailColor = frontColor = backColor = DecalPal.nickelColor;
                        trailLength = 10;
                        homingPower = 0.1f;
                        homingRange = 250;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                    }},
                    DecalingItems.zincum, new BasicBulletType(4f, 30f){{
                        height = 11f;
                        width = 8f;
                        lifetime = 75f;
                        ammoMultiplier = 1.4f;
                        weaveMag = 2.6f;
                        weaveRandom = true;
                        weaveScale = 8;
                        trailColor = frontColor = backColor = DecalPal.zincColor;
                        trailLength = 10;

                        homingRange = 250;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                        incendAmount = 6;
                        incendChance = 1;
                        incendSpread = 30;
                    }});
            drawer = new DrawTurret("tantros-");
            researchCost = with(DecalingItems.nickel, 240, DecalingItems.cadmium, 140);
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
            plans.add(
                    new UnitPlan(DecalingUnits.clear, 60f * 34f, with(DecalingItems.oldmateria, 35, Items.silicon, 30)),
                    new UnitPlan(DecalingUnits.refate, 60f * 45f, with(DecalingItems.oldmateria, 50, Items.silicon, 30, Items.lead, 45))
            );
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
                    new AssemblerUnitPlan(DecalingUnits.destroy, 60f * 60f, PayloadStack.list(DecalingUnits.clear, 4, DecalingBlocks.decalwalllarge, 12)),
                    new AssemblerUnitPlan(DecalingUnits.obliterate, 60f * 60f * 3f, PayloadStack.list(DecalingUnits.remove, 6, DecalingBlocks.timewallLarge, 20)),
                    new AssemblerUnitPlan(DecalingUnits.annihilate, 60f * 60f * 6f, PayloadStack.list(DecalingUnits.clear, 8, DecalingUnits.remove, 8, DecalingBlocks.decalwalllarge, 20, DecalingBlocks.viliniteWallLarge, 20))
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
            requirements(Category.units, with(Items.lead, 800, DecalingItems.oldmateria, 600, DecalingItems.decaygraphite, 400, DecalingItems.timefragment, 250,DecalingItems.viliniteAlloy, 260,DecalingItems.reliteplate, 190,DecalingItems.timeEssence, 70));
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
            filter = Seq.with(DecalingBlocks.decalwalllarge, DecalingBlocks.timewallLarge, DecalingBlocks.viliniteWallLarge);
        }};
        harvoneFactory = new UnitFactory("harvone-factory"){{
            requirements(Category.units, with(DecalingItems.nickel, 300, DecalingItems.cadmium, 100));
            size = 3;
            plans.add(
                    new UnitPlan(DecalingUnits.harvone, 2400f, with(DecalingItems.nickel, 90, DecalingItems.cadmium, 50))
            );
            fogRadius = 3;
            researchCostMultiplier = 0.7f;
            consumePower(3.25f);
        }};
        //CUMpaning
        timeMachine = new TimeMachine("time-machine"){{
            requirements(Category.effect, BuildVisibility.campaignOnly, with(DecalingItems.oldmateria, 3580, Items.silicon, 3700, Items.graphite, 2860, DecalingItems.decaygraphite, 1950, DecalingItems.timefragment, 2980, DecalingItems.timeEssence, 1300, DecalingItems.reliteplate, 2350));
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
        //special
        creeperCell = new Wall("creeper-cell"){{
            requirements(Category.effect,BuildVisibility.editorOnly, with());
            health = 600;
            size = 1;
            unitCapModifier = 0;
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
                shootEffect = DecalingFx.launchMissile;
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
