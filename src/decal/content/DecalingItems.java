package decal.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;
import decal.graphics.*;

import static mindustry.content.Items.*;

public class DecalingItems {
     public static Item
    oldmateria, decaygraphite, timefragment, viliniteAlloy;
    public static void load(){
        oldmateria = new Item("oldmateria", Color.valueOf("1a1a1a")){{
            hardness = 1;
            cost = 0.8f;
        }};
        decaygraphite = new Item("decay-graphite", Color.valueOf("2d2d2d")){{
            hardness = 2;
            cost = 1.65f;
        }};
        timefragment = new Item("time-fragment", Color.valueOf("b8ccf2")){{
            hardness = 3;
            cost = 1.8f;
        }};
        viliniteAlloy = new Item("vilinite-alloy", Color.valueOf("1a7000")){{
            hardness = 4;
            cost = 2.4f;
        }};
    }
}