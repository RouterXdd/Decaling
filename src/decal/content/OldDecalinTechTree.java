package decal.content;

import arc.struct.*;
import mindustry.game.*;

import static decal.content.DecalingSectors.*;
import static mindustry.content.TechTree.*;

public class OldDecalinTechTree {
    public void load(){
        DecalingPlanets.oldDecalin.techTree = nodeRoot("oldDecalin", DecalingPlanets.oldDecalin, true, () -> {
            node(DecalingBlocks.coreBorn,() -> {
            });

        });
    }
}
