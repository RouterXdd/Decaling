package decal.graphics;
import arc.*;
import arc.graphics.*;
import arc.graphics.Texture.*;
import arc.graphics.g2d.*;
import decal.world.meta.DecalingEnv;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class EnvRender {
    public static void init() {
        Core.assets.load("sprites/distortAlpha.png", Texture.class);

        renderer.addEnvRenderer(DecalingEnv.neolaspmatic, () -> {
            Texture tex = Core.assets.get("sprites/distortAlpha.png", Texture.class);
            if (tex.getMagFilter() != TextureFilter.linear) {
                tex.setFilter(TextureFilter.linear);
                tex.setWrap(TextureWrap.repeat);
            }

            Draw.z(state.rules.fog ? Layer.fogOfWar + 1 : Layer.weather - 1);
            Weather.drawNoiseLayers(tex, Pal.neoplasm1, 1000f, 0.24f, 0.4f, 1f, 1f, 0f, 4, -1.3f, 0.7f, 0.8f, 0.9f);
            Draw.reset();
        });
    }
}
