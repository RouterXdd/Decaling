package decal.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;
import decal.graphics.*;

import static mindustry.content.Items.*;

public class DecalingItems {
     public static Item
    oldmateria;
    public static Item decaygraphite;
    public static Item timefragment;
    public static Item viliniteAlloy;
    public static Item timeEssence;
    public static Item reliteplate;

    public static final Seq<Item> decalinItems = new Seq<>();
    public static void load(){
        oldmateria = new Item("oldmateria", Color.valueOf("1a1a1a")){{
            hardness = 1;
            cost = 0.8f;
            healthScaling = 0.86f;
        }};
        decaygraphite = new Item("decay-graphite", Color.valueOf("2d2d2d")){{
            hardness = 2;
            cost = 1.65f;
        }};
        timefragment = new Item("time-fragment", Color.valueOf("b8ccf2")){{
            hardness = 3;
            cost = 1.8f;
            healthScaling = 1.24f;
        }};
        viliniteAlloy = new Item("vilinite-alloy", Color.valueOf("1a7000")){{
            hardness = 4;
            cost = 2.4f;
        }};
        timeEssence = new Item("time-essence", Color.valueOf("cddaf3")){{
            hardness = 5;
            cost = 3.6f;
            healthScaling = 1.6f;
        }};
        reliteplate = new Item("relite-plate", Color.valueOf("3c3c3c")){{
            hardness = 5;
            cost = 4.1f;
            healthScaling = 2.1f;
        }};
        decalinItems.addAll(
                oldmateria, timefragment, decaygraphite, lead, silicon, graphite, viliniteAlloy, timeEssence, reliteplate
        );
    }
}