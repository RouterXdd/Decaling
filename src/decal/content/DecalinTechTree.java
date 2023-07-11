package decal.content;

import arc.struct.*;
import arc.util.*;
import decal.world.blocks.campaning.TimeMachine;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.Vars.*;
import static mindustry.content.TechTree.*;
import static decal.content.DecalingSectors.*;

public class DecalinTechTree {
    public void load(){
        DecalingPlanets.decalin.techTree = nodeRoot("decalin", DecalingPlanets.decalin, true, () -> {
            nodeProduce(DecalingItems.oldmateria, () -> {
                nodeProduce(DecalingItems.timefragment, () -> {
                    nodeProduce(DecalingItems.timeEssence, () -> {
                    });
                });

                nodeProduce(Items.silicon, () -> {
                    nodeProduce(DecalingItems.viliniteAlloy, () -> {
                    });
                });
                nodeProduce(Items.graphite, () -> {
                    nodeProduce(DecalingItems.decaygraphite, () -> {
                        nodeProduce(DecalingItems.reliteplate, () -> {
                        });
                    });
                });
                nodeProduce(Items.lead, () -> {
                });
            });
            node(DecalingBlocks.repairer, Seq.with(new Produce(DecalingItems.oldmateria)), () -> {
                node(DecalingBlocks.changer, Seq.with(new SectorComplete(forgotLand)),() -> {
                    node(DecalingBlocks.recreator, () -> {
                        node(DecalingBlocks.pressureClet,Seq.with(new SectorComplete(orbitalCenter)),() -> {
                            node(DecalingBlocks.timeElectric, () -> {
                            });
                        });
                    node(DecalingBlocks.vilineForge, Seq.with(new SectorComplete(repairTerminal)),() -> {
                    });
                        node(DecalingBlocks.recycler, Seq.with(new SectorComplete(orbitalCenter)),() -> {
                        });
                        node(DecalingBlocks.decayIncinerator, Seq.with(new SectorComplete(junkyard)),() -> {
                        });
                    });
                });
            });
            node(DecalingBlocks.decalwall, Seq.with(new Produce(DecalingItems.oldmateria)), () -> {
                node(DecalingBlocks.timewall, Seq.with(new Produce(DecalingItems.timefragment)), () -> {
                    node(DecalingBlocks.decayBarrier, Seq.with(new SectorComplete(repairTerminal)),() -> {
                    });
                    node(DecalingBlocks.timewallLarge, () -> {
                    });
                    node(DecalingBlocks.automaticDoor, () -> {
                    });
                    node(DecalingBlocks.viliniteWall, () -> {
                        node(DecalingBlocks.viliniteWallLarge, () -> {
                        });
                        node(DecalingBlocks.mirrorWall, () -> {
                            node(DecalingBlocks.mirrorWallLarge, () -> {
                            });
                        });
                    });
                });
                node(DecalingBlocks.decalwalllarge, () -> {
                });
            });
            node(DecalingBlocks.cluster, () -> {
                node(DecalingBlocks.starflood, Seq.with(new Produce(DecalingItems.timefragment)), () -> {
                    node(DecalingBlocks.interleet, Seq.with(new SectorComplete(forgotLand)), () -> {
                        node(DecalingBlocks.crystalFer, () -> {
                            node(DecalingBlocks.rollIn, () -> {
                                node(DecalingBlocks.paradox, Seq.with(new OnSector(orbitalCenter)),() -> {
                                });
                            });
                            node(DecalingBlocks.decaynir,Seq.with(new OnSector(trainPath)),() -> {
                            });
                        });
                        node(DecalingBlocks.confronter, Seq.with(new SectorComplete(repairTerminal)),() -> {
                            node(DecalingBlocks.missileter, Seq.with(new Produce(DecalingItems.viliniteAlloy)),() -> {
                                node(DecalingBlocks.orbitalCannon, Seq.with(new SectorComplete(orbitalCenter)),() -> {
                                    node(DecalingBlocks.prototypeRift, Seq.with(new OnSector(timeSiege)),() -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(DecalingBlocks.decayconsider, () -> {
                node(DecalingBlocks.timeDriver, Seq.with(new OnSector(highPeaks)),() -> {
                });
                node(DecalingBlocks.wire, () -> {
                    node(DecalingBlocks.largeWire, () -> {
                    });
                    node(DecalingBlocks.armoredWire, () -> {
                        node(DecalingBlocks.largeArmoredWire, () -> {
                        });
                    });
                });
            });
            node(DecalingBlocks.mover, () -> {
                node(DecalingBlocks.decaySorter, () -> {
                });
                node(DecalingBlocks.lightLink, () -> {
                    node(DecalingBlocks.mediumLink, Seq.with(new SectorComplete(forgotLand)),() -> {
                        node(DecalingBlocks.heavyLink, Seq.with(new SectorComplete(highPeaks)),() -> {
                        });
                    });
                });
            });
            node(DecalingBlocks.decayFactory, Seq.with(new SectorComplete(forgotLand)),() -> {
                node(DecalingBlocks.decayModule, () -> {
                    node(DecalingBlocks.decayModuleT2, () -> {
                    });
                });
                node(DecalingBlocks.decayRefabricator, Seq.with(new SectorComplete(sectureBase)),() -> {
                    node(DecalingUnits.remove, () -> {
                    });
                    node(DecalingBlocks.decayAssembler, Seq.with(new SectorComplete(orbitalCenter)),() -> {
                        node(DecalingUnits.destroy, () -> {
                        });
                        node(DecalingUnits.obliterate, Seq.with(new Research(DecalingBlocks.decayModule)),() -> {
                        });
                        node(DecalingUnits.annihilate, Seq.with(new Research(DecalingBlocks.decayModule)),() -> {
                        });
                    });
                });
                node(DecalingUnits.clear, () -> {
                });
                node(DecalingUnits.refate, Seq.with(new SectorComplete(junkyard)),() -> {
                });
                node(DecalingBlocks.timeFactory, Seq.with(new SectorComplete(forgotLand)),() -> {
                    node(DecalingUnits.hour, () -> {
                    });
                    node(DecalingBlocks.timeRefabricator, Seq.with(new SectorComplete(sectureBase)),() -> {
                        node(DecalingUnits.clock, () -> {
                        });
                        node(DecalingBlocks.timeAssembler, Seq.with(new SectorComplete(orbitalCenter)),() -> {
                            node(DecalingUnits.timer, () -> {
                            });
                            node(DecalingUnits.day, Seq.with(new Research(DecalingBlocks.decayModule)),() -> {
                            });
                            node(DecalingUnits.year, Seq.with(new Research(DecalingBlocks.decayModuleT2)),() -> {
                            });
                        });
                    });
                });
            });
            node(DecalingBlocks.test, () -> {
                node(DecalingBlocks.oreCrusher, () -> {
                    node(DecalingBlocks.tectonicBomber, Seq.with(new SectorComplete(orbitalCenter)),() -> {

                    });
                });
            });
            node(forgotLand, () -> {
                node(sectureBase, Seq.with(new SectorComplete(forgotLand)),() -> {
                    node(repairTerminal, Seq.with(new SectorComplete(sectureBase)),() -> {
                        node(junkyard, Seq.with(new SectorComplete(repairTerminal)),() -> {

                        });
                        node(highPeaks, Seq.with(new SectorComplete(repairTerminal)),() -> {
                            node(trainPath, Seq.with(new SectorComplete(highPeaks)),() -> {

                            });
                            node(orbitalCenter, Seq.with(new SectorComplete(highPeaks)),() -> {
                                node(timeSiege, Seq.with(new SectorComplete(orbitalCenter)),() -> {
                                    node(dimensionRift, Seq.with(new SectorComplete(timeSiege), new DecalingObjectives.ActivateTimeMachine(DecalingBlocks.timeMachine)),() -> {

                                    });
                                    node(DecalingPlanets.oldDecalin, Seq.with(new DecalingObjectives.ActivateTimeMachine(DecalingBlocks.timeMachine), new Research(DecalingBlocks.timeMachine)),() -> {
                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(DecalingBlocks.coreDry, () -> {
                node(DecalingBlocks.coreDecay, Seq.with(new SectorComplete(repairTerminal)),() -> {
                });
                node(DecalingBlocks.werehouse, Seq.with(new OnSector(repairTerminal)),() -> {
                });
            });
            node(DecalingBlocks.timeMachine, Seq.with(new SectorComplete(timeSiege)),() -> {
            });
        });
    }
}