package decal.content;
import mindustry.type.*;

import static decal.content.DecalingPlanets.*;

public class DecalingSectors {
    public static SectorPreset
    forgotLand, sectureBase, repairTerminal, highPeaks, orbitalCenter, timefacility, junkyard;

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
        highPeaks = new SectorPreset("high-peaks", decalin, 34){{
            captureWave = 50;
            difficulty = 7;
            startWaveTimeMultiplier = 1.6f;
        }};
        orbitalCenter = new SectorPreset("orbital-center", decalin, 67){{
            difficulty = 9;
        }};
        junkyard = new SectorPreset("junkyard", decalin, 62){{
            captureWave = 30;
            difficulty = 6;
        }};
    }
}
