package decal.world.blocks.defence;

import arc.scene.ui.layout.Table;
import decal.content.DecalingBlocks;
import mindustry.gen.Icon;
import mindustry.type.ItemStack;
import mindustry.ui.Styles;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.turrets.PowerTurret;

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
