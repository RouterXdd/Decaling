package decal.world.blocks.defence;

import arc.scene.ui.layout.*;
import decal.content.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.Vars.world;

public class UpgradeblePowerTurret extends PowerTurret {

        public Block upgradeTurret = DecalingBlocks.cluster;

        public ItemStack upgradecost;

    public UpgradeblePowerTurret(String name){
        super(name);
        configurable = true;
        buildType = UpgradeblePowerTurretBuild::new;
    }
    public class UpgradeblePowerTurretBuild extends PowerTurretBuild {

        public void upgrade() {
            Tile tile = world.tileWorld(x, y);
            tile.setBlock(upgradeTurret, team);

        }
        @Override
        public void buildConfiguration(Table table) {
            table.button(Icon.upOpen, Styles.clearTogglei, () -> {
                if (team.data().core().items.has(new ItemStack[]{upgradecost})) {
                    upgrade();
                    team.data().core().items.remove(upgradecost);
                }
                deselect();
            }).size(50);
        }
    }
}
