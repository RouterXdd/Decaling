package decal.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class DecalingLiquids {
    public static Liquid deuterium;
    public static void load() {

        deuterium = new Liquid("deuterium", Color.valueOf("A6A3D4")) {{
            gas = true;
            temperature = -0.5f;
        }};
    }
}
