package decal.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import decal.planets.*;


public class DecalingPlanets {
    public static Planet
    decalin;

    public static void load(){
         decalin = new Planet("decalin", Planets.sun, 1f, 3){{
            defaultCore = DecalingBlocks.coreDry;
            sectorSeed = 3;
            generator = new DecalinPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
             cloudMeshLoader = () -> new MultiMesh(
                     new HexSkyMesh(this, 6, 0.1f, 0.23f, 5, Color.valueOf("393939").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                     new HexSkyMesh(this, 3, 0.2f, 0.19f, 5, Color.valueOf("555555").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                     new HexSkyMesh(this, 2, 0.3f, 0.27f, 5, Color.valueOf("686868").a(0.55f), 4, 0.35f, 1.35f, 0.45f)
             );
            accessible = true;
            alwaysUnlocked = true;
            atmosphereColor = Color.valueOf("393939");
            startSector = 16;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.3f;
            clearSectorOnLose = true;
            ruleSetter = r -> {
                r.waveTeam = DecalingTeams.decayed;
                r.attributes.clear();
                r.attributes.set(DecalingAttributes.timedrive, 0.4f);
                r.showSpawns = true;
                r.fog = false;
                r.onlyDepositCore = false;
            };
             unlockedOnLand.add(DecalingBlocks.coreDry);
        }};

}}