package decal.world.blocks.defence;

import arc.scene.ui.layout.*;
import arc.util.Nullable;
import decal.content.*;
import mindustry.content.Blocks;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.Vars.world;
public class ModesPowerTurret extends PowerTurret{
    public @Nullable Block modeTurret;

    public ModesPowerTurret(String name, Block modeTurret){
        super(name);
        configurable = true;
        buildType = ModesPowerTurretBuild::new;
        this.modeTurret = modeTurret;
    }
    public class ModesPowerTurretBuild extends PowerTurretBuild {

        public void change() {

            Tile tile = world.tileWorld(x, y);
            if (modeTurret != null) {
                tile.setBlock(modeTurret, team, 0);
            }
        }
        @Override
        public void buildConfiguration(Table table) {
            table.button(Icon.flipX, Styles.clearTogglei, () -> {
                if (potentialEfficiency == 1) {
                    change();
                }
                deselect();
            }).size(50);
        }
    }
}
