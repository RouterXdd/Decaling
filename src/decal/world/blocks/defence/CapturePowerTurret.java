package decal.world.blocks.defence;

import arc.*;
import arc.util.*;
import decal.content.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.Vars.*;

public class CapturePowerTurret extends PowerTurret {
    public float captureInvicibility = 60f * 15f;

    public CapturePowerTurret(String name){
        super(name);
        replaceable = alwaysReplace = breakable = false;
        buildType = CapturePowerTurretBuild::new;
    }
    @Override
    public boolean canBreak(Tile tile){
        return state.rules.editor || state.rules.infiniteResources;
    }
    public class CapturePowerTurretBuild extends PowerTurretBuild {
        public Team lastDamage = Team.derelict;

        public float iframes = -1f;

        @Override
        public void damage(@Nullable Team source, float damage){
            if(iframes > 0) return;

            if(source != null && source != team){
                lastDamage = source;
            }
            super.damage(source, damage);
        }
        @Override
        public void onDestroyed(){
                //just create an explosion, no fire. this prevents immediate recapture
                Damage.dynamicExplosion(x, y, 0, 0, 3, tilesize * block.size / 2f, state.rules.damageExplosions);
                Fx.commandSend.at(x, y, 140f);
                DecalingFx.ancientCapture.at(x, y, 45f);
        }
        @Override
        public void afterDestroyed(){
                if(!net.client()){
                    tile.setBlock(block, lastDamage);
                }

                //delay so clients don't destroy it afterwards
                Core.app.post(() -> tile.setNet(block, lastDamage, 0));

                //building does not exist on client yet
                if(!net.client()){
                    //core is invincible for several seconds to prevent recapture
                    ((CapturePowerTurret.CapturePowerTurretBuild)tile.build).iframes = captureInvicibility;
                }
        }
    }
}
