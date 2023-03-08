package decal;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import decal.graphics.DecalPal;
import decal.world.meta.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.Icon;
import mindustry.graphics.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.type.Weather;
import mindustry.ui.dialogs.*;
import decal.content.*;
import java.util.*;

import static arc.Core.*;
import static mindustry.Vars.*;


public class Decaling extends Mod{
    @Override
    public void init(){
        super.init();
        LoadedMod mod = mods.locateMod("decal");
        if(!headless){
            //from Omaloon by xStaBUx
            Func<String, String> stringf = value -> bundle.get("mod." + value);

            mod.meta.displayName = stringf.get(mod.meta.name + ".name");
            //Random subtitles vote
            String [] r = {
                    bundle.get("mod.decal.subtitle1"),
                    bundle.get("mod.decal.subtitle2"),
                    bundle.get("mod.decal.subtitle3"),
                    bundle.get("mod.decal.subtitle4"),
                    bundle.get("mod.decal.subtitle5")
            };
            Random rand = new Random();
            String mogus = String.valueOf(
                    r[rand.nextInt(5)]
            );
            mod.meta.subtitle = "[#000000]"+"v"+mod.meta.version+"[]" +"\n"+ mogus;
        }
        Vars.renderer.addEnvRenderer(DecalingEnv.neolaspmatic, () -> {
            Texture tex = Core.assets.get("sprites/distortAlpha.png", Texture.class);
            if (tex.getMagFilter() != Texture.TextureFilter.linear) {
                tex.setFilter(Texture.TextureFilter.linear);
                tex.setWrap(Texture.TextureWrap.repeat);
            }

            Draw.z(Layer.weather - 1);
            Weather.drawNoiseLayers(tex, Pal.neoplasm1, 1000f, 0.2f, 0.8f, 1.2f, 0.6f, 0.4f, 4, -1.2f, 0.7f, 0.8f, 0.9f);
            Draw.reset();
        });
    }
    public Decaling(){
        Log.info("Loaded Decaling constructor.");
    }

    @Override
    public void loadContent(){
        new DecalingTeams().load();
        new DecalingAttributes().load();
        new DecalingItems().load();
        new DecalingStatus().load();
        new DecalingWeather().load();
        new DecalingUnits().load();
        new DecalingBlocks().load();
        new DecalingLoadouts().load();
        new DecalingPlanets().load();
        new DecalingSectors().load();
        new DecalinTechTree().load();
    }

}
