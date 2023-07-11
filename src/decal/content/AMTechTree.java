package decal.content;

import static mindustry.content.TechTree.*;

public class AMTechTree {
    public void load(){
        DecalingPlanets.ancientMachine.techTree = nodeRoot("ancientMachine", DecalingPlanets.ancientMachine, true, () -> {
            node(DecalingBlocks.coreReturn,() -> {
            });
            node(DecalingBlocks.corrupter,() -> {
            });
        });
    }
}
