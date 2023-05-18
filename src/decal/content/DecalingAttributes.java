package decal.content;

import mindustry.world.meta.Attribute;

public class DecalingAttributes {
    public static Attribute decay;
    public static Attribute timedrive;
    public static Attribute volcano;

    public static void load() {
        decay = Attribute.add("decay");
        timedrive = Attribute.add("timedrive");
        volcano = Attribute.add("volcano");
    }
}