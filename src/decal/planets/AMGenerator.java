package decal.planets;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.noise.*;
import decal.content.*;
import mindustry.ai.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.generators.*;
import mindustry.type.*;
import mindustry.world.*;

import static mindustry.Vars.*;

public class AMGenerator extends PlanetGenerator {
    public static boolean alt = true;

    DecalinBase basegen = new DecalinBase();
    float scl = 3f;

    Block[][] arr =
            {
                    { Blocks.darkPanel1, DecalingBlocks.ancientFloor, Blocks.metalFloor, Blocks.darkPanel1, DecalingBlocks.ancientFloor},
                    {Blocks.darkPanel1, DecalingBlocks.ancientFloor, DecalingBlocks.ancientFloor, Blocks.darkPanel1, Blocks.metalFloor},
            };

    {
        defaultLoadout = DecalingLoadouts.basicReturn;
    }

    float water = 2f / arr[0].length;

    float rawHeight(Vec3 position) {
        position = Tmp.v33.set(position).scl(scl);
        return (Mathf.pow(Simplex.noise3d(seed, 7, 0.5f, 1f / 3f, position.x, position.y, position.z), 2.8f));
    }

    @Override
    public void generateSector(Sector sector) {

        //these always have bases
        if (sector.id == 2 || sector.id == 8) {
            sector.generateEnemyBase = true;
            sector.threat = 10;
            return;
        }

        Ptile tile = sector.tile;

        boolean any = false;
        float poles = Math.abs(tile.v.y);
        float noise = Noise.snoise3(tile.v.x, tile.v.y, tile.v.z, 0.001f, 0.58f);

        if (noise + poles / 7.1 > 0.15 && poles > 0.24) {
            any = true;
        }

        if (noise < 0.17) {
            for (Ptile other : tile.tiles) {
                var osec = sector.planet.getSector(other);

                //no sectors near start sector!
                if (
                        osec.id == sector.planet.startSector || //near starting sector
                                osec.generateEnemyBase && poles < 0.85 || //near other base
                                (sector.preset != null && noise < 0.1) //near preset
                ) {
                    return;
                }
            }
        }

        sector.generateEnemyBase = any;
    }

    @Override
    public float getHeight(Vec3 position) {
        float height = rawHeight(position);
        return Math.max(height, water);
    }

    @Override
    public Color getColor(Vec3 position) {
        return getBlock(position).mapColor;
    }

    @Override
    public void genTile(Vec3 position, TileGen tile) {
        tile.floor = getBlock(position);
        tile.block = tile.floor.asFloor().wall;

        if (Ridged.noise3d(seed + 3, position.x, position.y, position.z, 2, 27) > 0.26) {
            tile.block = Blocks.air;
        }
    }


    Block getBlock(Vec3 position) {
        float height = rawHeight(position);
        Tmp.v31.set(position);
        height *= 1.2f;
        height = Mathf.clamp(height);

        Block res = arr[Mathf.clamp((int) (height * arr.length), 0, arr[0].length - 1)][Mathf.clamp((int) (height * arr[0].length), 0, arr[1].length - 2)];
        return res;
    }

    @Override
    protected float noise(float x, float y, double octaves, double falloff, double scl, double mag) {
        Vec3 v = sector.rect.project(x, y).scl(6f);
        return Simplex.noise3d(seed, octaves, falloff, 1f / scl, v.x, v.y, v.z) * (float) mag;
    }

    @Override
    protected void generate() {

        class Room {
            int x, y, radius;
            ObjectSet<Room> connected = new ObjectSet<>();

            Room(int x, int y, int radius) {
                this.x = x;
                this.y = y;
                this.radius = radius;
                connected.add(this);
            }

            void join(int x1, int y1, int x2, int y2) {
                float nscl = rand.random(100f, 140f) * 7f;
                int stroke = rand.random(4, 6);
                brush(pathfind(x1, y1, x2, y2, tile -> (tile.solid() ? 50f : 0f) + noise(tile.x, tile.y, 2, 0.4f, 1f / nscl) * 500, Astar.manhattan), stroke);
            }

            void connect(Room to) {
                if (!connected.add(to) || to == this) return;

                Vec2 midpoint = Tmp.v1.set(to.x, to.y).add(x, y).scl(0.5f);
                rand.nextFloat();

                if (alt) {
                    midpoint.add(Tmp.v2.set(1, 0f).setAngle(Angles.angle(to.x, to.y, x, y) + 90f * (rand.chance(0.5) ? 1f : -1f)).scl(Tmp.v1.dst(x, y) * 2f));
                } else {
                    //add randomized offset to avoid straight lines
                    midpoint.add(Tmp.v2.setToRandomDirection(rand).scl(Tmp.v1.dst(x, y)));
                }

                midpoint.sub(width / 2f, height / 2f).limit(width / 2f / Mathf.sqrt3).add(width / 2f, height / 2f);

                int mx = (int) midpoint.x, my = (int) midpoint.y;

                join(x, y, mx, my);
                join(mx, my, to.x, to.y);
            }

        }

        float constraint = 1.2f;
        float radius = width / 2f / Mathf.sqrt3;
        int rooms = rand.random(1, 2);
        Seq<Room> roomseq = new Seq<>();

        for (int i = 0; i < rooms; i++) {
            Tmp.v1.trns(rand.random(360f), rand.random(radius / constraint));
            float rx = (width / 2f + Tmp.v1.x);
            float ry = (height / 2f + Tmp.v1.y);
            float maxrad = radius - Tmp.v1.len();
            float rrad = Math.min(rand.random(9f, maxrad / 2f), 30f);
            roomseq.add(new Room((int) rx, (int) ry, (int) rrad));
        }

        //check positions on the map to place the player spawn. this needs to be in the corner of the map
        Room spawn = null;
        Seq<Room> enemies = new Seq<>();
        int enemySpawns = rand.random(1, Math.max((int) (sector.threat * 4), 1));
        int offset = rand.nextInt(360);
        float length = width / 2.55f - rand.random(13, 23);
        int angleStep = 5;
        int waterCheckRad = 5;
        for (int i = 0; i < 360; i += angleStep) {
            int angle = offset + i;
            int cx = (int) (width / 2 + Angles.trnsx(angle, length));
            int cy = (int) (height / 2 + Angles.trnsy(angle, length));

            int waterTiles = 0;

            //check for water presence
            for (int rx = -waterCheckRad; rx <= waterCheckRad; rx++) {
                for (int ry = -waterCheckRad; ry <= waterCheckRad; ry++) {
                    Tile tile = tiles.get(cx + rx, cy + ry);
                    if (tile == null || tile.floor().liquidDrop != null) {
                        waterTiles++;
                    }
                }
            }

            if (waterTiles <= 4 || (i + angleStep >= 360)) {
                roomseq.add(spawn = new Room(cx, cy, rand.random(8, 14)));

                for (int j = 0; j < enemySpawns; j++) {
                    float enemyOffset = rand.range(60f);
                    Tmp.v1.set(cx - width / 2f, cy - height / 2f).rotate(180f + enemyOffset).add(width / 2f, height / 2f);
                    Room espawn = new Room((int) Tmp.v1.x, (int) Tmp.v1.y, rand.random(8, 16));
                    roomseq.add(espawn);
                    enemies.add(espawn);
                }

                break;
            }
        }

        //clear radius around each room
        for (Room room : roomseq) {
            erase(room.x, room.y, room.radius);
        }

        //randomly connect rooms together
        int connections = rand.random(Math.max(rooms - 1, 1), rooms + 2);
        for (int i = 0; i < connections; i++) {
            roomseq.random(rand).connect(roomseq.random(rand));
        }

        for (Room room : roomseq) {
            spawn.connect(room);
        }

        Room fspawn = spawn;

        int tlen = tiles.width * tiles.height;
        int total = 0, waters = 0;

        for (int i = 0; i < tlen; i++) {
            Tile tile = tiles.geti(i);
            if (tile.block() == Blocks.air) {
                total++;
                if (tile.floor().liquidDrop == Liquids.water) {
                    waters++;
                }
            }
        }

        Seq<Block> ores = Seq.with(Blocks.oreCopper, Blocks.oreLead, Blocks.oreScrap);
        float poles = Math.abs(sector.tile.v.y);
        float nmag = 0.6f;
        float scl = 1f;
        float addscl = 1.3f;

        if(Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x, sector.tile.v.y, sector.tile.v.z)*nmag + poles > 0.25f*addscl){
            ores.add(Blocks.oreCoal, Blocks.oreBeryllium);
        }

        if(Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x + 1, sector.tile.v.y, sector.tile.v.z)*nmag + poles > 0.5f*addscl){
            ores.add(Blocks.oreTitanium);
        }

        if(Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x + 2, sector.tile.v.y, sector.tile.v.z)*nmag + poles > 0.7f*addscl){
            ores.add(Blocks.oreThorium, Blocks.oreTungsten);
        }

        FloatSeq frequencies = new FloatSeq();
        for (int i = 0; i < ores.size; i++) {
            frequencies.add(rand.random(-0.1f, 0.01f) - i * 0.01f + poles * 0.04f);
        }

        pass((x, y) -> {
            if (!floor.asFloor().hasSurface()) return;

            int offsetX = x - 4, offsetY = y + 23;
            for (int i = ores.size - 1; i >= 0; i--) {
                Block entry = ores.get(i);
                float freq = frequencies.get(i);
                if (Math.abs(0.5f - noise(offsetX, offsetY + i * 999, 2, 0.7, (40 + i * 2))) > 0.22f + i * 0.01 &&
                        Math.abs(0.5f - noise(offsetX, offsetY - i * 999, 1, 1, (30 + i * 4))) > 0.37f + freq) {
                    ore = entry;
                    break;
                }
            }
        });

        trimDark();

        inverseFloodFill(tiles.getn(spawn.x, spawn.y));

        tech();
        ints.clear();
        ints.ensureCapacity(width * height / 4);

        //remove invalid ores
        for (Tile tile : tiles) {
            if (tile.overlay().needsSurface && !tile.floor().hasSurface()) {
                tile.setOverlay(Blocks.air);
            }
        }
        Schematics.placeLaunchLoadout(spawn.x, spawn.y);

        for (Room espawn : enemies) {
            tiles.getn(espawn.x, espawn.y).setOverlay(Blocks.spawn);
        }

        if (sector.hasEnemyBase()) {
            basegen.generate(tiles, enemies.map(room -> tiles.getn(room.x, room.y)), tiles.get(spawn.x, spawn.y), state.rules.waveTeam, sector, sector.threat);
            state.rules.attackMode = sector.info.attack = true;
        } else {
            state.rules.winWave = sector.info.winWave = 10 + 5 * (int) Math.max(sector.threat * 10, 1);
            state.rules.attackMode = sector.info.attack = false;
        }


        state.rules.waveSpacing = Mathf.lerp(60 * 65 * 2, 60f * 60f * 1f, Math.max(sector.threat - 0.4f, 0f));
        state.rules.waves = true;
        state.rules.env = sector.planet.defaultEnv;
        state.rules.enemyCoreBuildRadius = 400f;

        state.rules.spawns = AMWaves.generate(sector.threat, new Rand(), state.rules.attackMode);
    }

    @Override
    public void postGenerate(Tiles tiles) {
    }
}
