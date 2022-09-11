package decal.content;

import mindustry.world.meta.Attribute;

public class DecalingAttributes {
    public static Attribute decay;

    public static void load() {
        decay = Attribute.add("decay");
    }
}
