package decal.content;

import arc.*;
import decal.world.blocks.campaning.*;
import mindustry.ctype.*;

import static mindustry.game.Objectives.*;

public class DecalingObjectives {
    public static class ActivateTimeMachine implements Objective {
        public UnlockableContent content;

        public ActivateTimeMachine(UnlockableContent content) {
            this.content = content;
        }
        @Override
        public boolean complete() {
            return content.unlocked();
        }

        @Override
        public String display() {
            return Core.bundle.format("requirement.activate", content.localizedName);
        }
    }
}
