package decal.world.type;

import arc.*;
import arc.util.*;
import decal.content.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.world.*;

import static mindustry.Vars.*;

public class CaptureBlock extends Block{
    public float captureInvicibility = 60f * 15f;

    public CaptureBlock(String name){
        super(name);
        replaceable = alwaysReplace = false;
        buildType = CaptureBuilding::new;
        solid = true;
    }
    @Override
    public boolean canBreak(Tile tile){
        return state.rules.editor || state.rules.infiniteResources;
    }
    public class CaptureBuilding extends Building {
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
                //block is invincible for several seconds to prevent recapture
                ((CaptureBlock.CaptureBuilding)tile.build).iframes = captureInvicibility;
            }
        }
    }
}
