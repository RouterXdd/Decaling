package decal.content;

import arc.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;

public class DecalingIcons {
    public static TextureRegion timeSiegeIcon;
    public static void load() {
        /* Final sector icon */
        timeSiegeIcon = Core.atlas.find("decal-time-siege");

        Icon.icons.put("decal-teleport-star", Core.atlas.getDrawable("decal-teleport-star"));
    }
}
