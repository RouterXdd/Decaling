package decal.content;

import arc.graphics.Color;
import mindustry.game.Team;
import mindustry.graphics.Pal;

public class DecalingTeams {
    public static Team decayed, oldCrux, shared, neoplastic;

    public static void load() {
        decayed = newTeam(12, "decayed", Color.valueOf("333333"));
        oldCrux = newTeam(13, "old-crux", Color.valueOf("f31f1f"));
        shared = newTeam(14, "unknown", Color.valueOf("937232"));
        neoplastic = newTeam(6, "neoplastic", Pal.neoplasm1);
    }

    //modify any of 256 teams' properties
    private static Team newTeam(int id, String name, Color color) {
        Team team = Team.get(id);
        team.name = name;
        team.color.set(color);

        team.palette[0] = color;
        team.palette[1] = color.cpy().mul(0.75f);
        team.palette[2] = color.cpy().mul(0.5f);

        for(int i = 0; i < 3; i++){
            team.palettei[i] = team.palette[i].rgba();
        }

        return team;
    }
}
