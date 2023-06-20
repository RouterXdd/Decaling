package decal.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class DecalingLiquids {
    public static Liquid deuterium, gasOxygen, tritium;
    public static void load() {

        deuterium = new Liquid("deuterium", Color.valueOf("A6A3D4")) {{
            gas = true;
            temperature = -0.5f;
        }};
        gasOxygen = new Liquid("oxygen-gas", Color.valueOf("b8c9df")) {{
            gas = true;
            temperature = 0.5f;
        }};
        tritium = new Liquid("tritium", Color.valueOf("aaea91")) {{
            gas = true;
            temperature = 0.5f;
        }};
    }
}
