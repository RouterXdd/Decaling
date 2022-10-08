package decal.content;
import mindustry.type.*;

import static decal.content.DecalingPlanets.*;

public class DecalingSectors {
    public static SectorPreset
    forgotLand, sectureBase, repairTerminal;

    public static void load(){
        forgotLand = new SectorPreset("forgot-land", decalin, 16){{
            alwaysUnlocked = true;
            captureWave = 25;
            difficulty = 3;
            startWaveTimeMultiplier = 2.1f;
        }};
        sectureBase = new SectorPreset("secture-base", decalin, 164){{
            difficulty = 5;
        }};
        repairTerminal = new SectorPreset("repair-terminal", decalin, 133){{
            difficulty = 6;
        }};
    }
}