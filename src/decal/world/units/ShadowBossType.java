package decal.world.units;

import arc.Events;
import arc.math.*;
import arc.util.*;
import decal.*;
import decal.content.*;
import mindustry.*;
import mindustry.core.*;
import mindustry.entities.Damage;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.type.*;

public class ShadowBossType extends UnitType {
    public DecalingObjectives.ShadowDefeat content;

    public boolean doublesArmor = true;

    public float reload = 200;

    protected float timer;
    public ShadowBossType(String name) {
        super(name);
    }
    @Override
    public void update(Unit unit){

        if (Vars.state.isPaused()){
            Events.fire(new EventType.StateChangeEvent(GameState.State.paused, GameState.State.playing));
        }
        if (unit.health <= unit.maxHealth / 2){
            timer += Time.delta;
            if (doublesArmor){
                DecalingFx.shadowTeleport.at(unit.x, unit.y);
                unit.armor(unit.armor * 2.5f);
                doublesArmor = false;
            }
            if (timer >= reload) {
                Damage.damage(unit.aimX, unit.aimY, 2, 100);
                timer = 0;
            }
        }
    }
    @Override
    public void killed(Unit unit) {
        super.killed(unit);
        if (Vars.state.isCampaign()) {
            content.complete();
        } else{
            if (!Vars.state.isCampaign() && Decaling.showMessages()) {
                Vars.ui.showText("@Uh-oh", "@wrongMode");
            }
        }
    }
}
