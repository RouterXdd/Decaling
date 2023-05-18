package decal.world.blocks.campaning;

import arc.*;
import arc.graphics.g2d.*;
import arc.scene.ui.layout.*;
import decal.content.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;

public class TimeMachine extends Block {
    public DecalingObjectives.ActivateTimeMachine content;
    public Planet planet;
    public TextureRegion rotatorRegion;
    public TextureRegion plasmaRegion;
    public TimeMachine(String name) {
        super(name);
        buildType = TimeMachineBuild::new;
    }
    @Override
    public void load() {
        super.load();
        rotatorRegion = Core.atlas.find(this.name + "-rotator");
        plasmaRegion = Core.atlas.find(this.name + "-plasma");
    }
    public class TimeMachineBuild extends Building {
        @Override
        public void buildConfiguration(Table table) {
            table.button(Icon.upOpen, Styles.clearTogglei, () -> {
                if (Vars.state.isCampaign() && canConsume() && potentialEfficiency == 1) {
                    content.complete();
                    if (planet != null) {
                        planet.alwaysUnlocked = true;
                    }
                    Vars.ui.showInfo("@unlockedTime");
                    items.clear();
                } else {
                    if (!Vars.state.isCampaign() && canConsume() && potentialEfficiency == 1) {
                        Vars.ui.showInfo("@noCustom");
                        Core.app.openURI("https://www.youtube.com/watch?v=s_9iYNDN_bw");
                        return;
                    }
                }
                deselect();
            }).size(40);
        }
        @Override
        public void draw() {
            Drawf.spinSprite(rotatorRegion, x, y, 45);
            Draw.rect(plasmaRegion, x, y);
        }
    }
}
