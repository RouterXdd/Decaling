package decal.content;

import arc.*;
import arc.util.*;
import arc.math.*;
import arc.struct.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import decal.world.blocks.distribution.*;
import decal.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.*;
import mindustry.entities.part.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.type.ItemStack.*;

public class DecalingBlocks {
    public static Block

    //environment
    decayfloor, decaywall, oreFragment, decaystone,

    //defence
    decalwall, decalwalllarge, timewall, timewallLarge,

    //crafting
    changer, repairer,

    //production
    test,

    //distribution
    lightLink,

    //turrets
    cluster, starflood, interleet,
    //units
    timeFactory, timeRefabricator, timeAssembler, decayModule, decayModuleT2,
    //for modmakers
    airStrike;

    public void load() {
        //environment
        decayfloor = new Floor("decay-floor"){{
            itemDrop = DecalingItems.oldmateria;
            playerUnmineable = true;
            status = DecalingStatus.decaling;
            statusDuration = 180f;
            variants = 3;
        }};
        decaywall = new StaticWall("decay-wall"){{
        variants = 3;
        }};
        decaystone = new Floor("decay-stone"){{
        variants = 3;
        }};
         oreFragment = new OreBlock(DecalingItems.timefragment);
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
        //production
        
        //distribution
        lightLink = new TransferLink("light-link") {{
            requirements(Category.distribution, ItemStack.with(
                DecalingItems.oldmateria, 5,
                Items.graphite, 2
                ));
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
                damage = 16f;
                length = -30f;
                speed = 6f;
                lifetime = 33f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

                fragBullet = new ContinuousFlameBulletType(){{
                damage = 8f;
                length = 0f;
                speed = 4f;
                drag = 0.07f;
                lifetime = 71f;
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;
            }};

                fragBullets = 6;
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
                colors = new Color[]{Color.valueOf("b8ccf2").a(0.35f), Color.valueOf("c0d6ff").a(0.5f), Color.valueOf("ffffff").a(0.6f), Color.valueOf("ffffff"), Color.white};
                flareColor = Color.valueOf("ffffff");

                lightColor = hitColor = flareColor;

                status = DecalingStatus.timeswap2;
                statusDuration = 80f;
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

        timeRefabricator = new Reconstructor("time-refabricator"){{
            requirements(Category.units, with(DecalingItems.oldmateria, 200, DecalingItems.timefragment, 80, Items.silicon, 100));
            regionSuffix = "-decay";

            size = 3;
            consumePower(4.2f);
            consumeItems(with(DecalingItems.decaygraphite, 65, DecalingItems.timefragment, 40));

            constructTime = 60f * 30f;
            researchCostMultiplier = 0.75f;

            upgrades.addAll(
            new UnitType[]{DecalingUnits.hour, DecalingUnits.clock}
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
        decayModule = new UnitAssemblerModule("decay-module"){{
            requirements(Category.units, with(Items.lead, 500, DecalingItems.oldmateria, 300, DecalingItems.decaygraphite, 200));
            consumePower(2f);
            regionSuffix = "-decay";

            size = 3;
        }};
        decayModuleT2 = new UnitAssemblerModule("decay-modulet2"){{
            requirements(Category.units, with(Items.lead, 800, DecalingItems.oldmateria, 600, DecalingItems.decaygraphite, 400, DecalingItems.timefragment, 250));
            consumePower(3.7f);
            regionSuffix = "-decay";
            tier = 2;
            size = 5;
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
