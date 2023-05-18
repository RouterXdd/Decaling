package decal.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;
import decal.graphics.*;

import static mindustry.content.Items.*;

public class DecalingItems {
     public static Item oldmateria, decaygraphite, timefragment, viliniteAlloy, timeEssence, reliteplate, iod, nickel, cadmium, oxygen, zincum, oblite;

    public static final Seq<Item> decalinItems = new Seq<>();
    public static final Seq<Item> oldDecalinItems = new Seq<>();
    public static final Seq<Item> oldTantrosItems = new Seq<>();
    public static final Seq<Item> tantrosItems = new Seq<>();
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
            frames = 2;
            frameTime = 16f;
            hardness = 5;
            cost = 3.6f;
            healthScaling = 1.6f;
        }};
        reliteplate = new Item("relite-plate", Color.valueOf("3c3c3c")){{
            hardness = 5;
            cost = 4.1f;
            healthScaling = 2.1f;
        }};
        iod = new Item("iod", Color.valueOf("db4325")){{
            hardness = 1;
            cost = 1.2f;
            healthScaling = 1.4f;
        }};
        nickel = new Item("nickel", Color.valueOf("765682")){{
            hardness = 2;
            cost = 1.5f;
            healthScaling = 1.2f;
            flammability = 1.5f;
            explosiveness = 0.65f;
        }};
        cadmium = new Item("cadmium", Color.valueOf("99C0C9")){{
            hardness = 1;
            cost = 1.3f;
            flammability = 0.25f;
            explosiveness = 0.5f;
        }};
        oxygen = new Item("oxygen", Color.valueOf("74b5b5")){{
            hardness = 2;
            cost = 1.15f;
            charge = 0.7f;
        }};
        zincum = new Item("zincum", Color.valueOf("9d3d3d")){{
            hardness = 2;
            cost = 1.6f;
            flammability = 0.8f;
        }};
        oblite = new Item("oblite", Color.valueOf("B1B5A5")){{
            hardness = 4;
            cost = 2.1f;
        }};
        decalinItems.addAll(
                oldmateria, timefragment, decaygraphite, lead, silicon, graphite, viliniteAlloy, timeEssence, reliteplate
        );
        oldDecalinItems.addAll(
                iod, coal
        );
        tantrosItems.addAll(
                nickel, cadmium, zincum, oxygen, oblite
        );
    }
}