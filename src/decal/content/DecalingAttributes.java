package decal.content;

import mindustry.world.meta.Attribute;

public class DecalingAttributes {
    public static Attribute decay, timedrive;

    public static void load() {
        decay = Attribute.add("decay");
        timedrive = Attribute.add("timedrive");

    }
}