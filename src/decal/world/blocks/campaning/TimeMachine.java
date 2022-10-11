package decal.world.blocks.campaning;

import arc.*;
import arc.graphics.g2d.*;
import arc.scene.ui.layout.*;
import mindustry.*;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.ui.*;
import mindustry.world.*;

public class TimeMachine extends Block {

    public TextureRegion rotatorRegion;
    public TimeMachine(String name) {
        super(name);
        buildType = TimeMachineBuild::new;
    }
    @Override
    public void load() {
        super.load();
        rotatorRegion = Core.atlas.find(this.name + "-rotator");
    }
    public class TimeMachineBuild extends Building {

        @Override
        public void buildConfiguration(Table table) {
            table.button(Icon.upOpen, Styles.clearTogglei, () -> {
                if (canConsume() && potentialEfficiency == 1) {
                    items.clear();
                    Vars.ui.showInfo("[red]THaT iS Not FiNiSHeD. Do you uNDeRSTaND?");
                    Core.app.openURI("https://" + "www.youtube.com/" + "watch?" + "v=s_9iYNDN_bw");
                }
                deselect();
            }).size(40);
        }
        @Override
        public void draw() {
            Drawf.spinSprite(rotatorRegion, x, y, 90);
            Drawf.spinSprite(rotatorRegion, x, y, -90);
        }
    }
}
