package decal.content;

import mindustry.world.meta.Attribute;

public class DecalingAttributes {
    public static Attribute decay, timedrive, volcano, zinc;

    public static void load() {
        decay = Attribute.add("decay");
        timedrive = Attribute.add("timedrive");
        volcano = Attribute.add("volcano");
        zinc = Attribute.add("zinc");
    }
}