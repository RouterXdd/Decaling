package decal.world.abilities;

import arc.util.*;
import decal.content.DecalingFx;
import mindustry.entities.abilities.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;

public class RegenField extends Ability {
    public float amount, range;
    public Effect healEffect = DecalingFx.regen;
    public Effect activeEffect = Fx.none;
    public boolean parentizeEffects = false;
    protected boolean wasHealed = false;

    public RegenField(float amount, float range){
        this.amount = amount;
        this.range = range;
    }

    @Override
    public void update(Unit unit){
            wasHealed = false;

            Units.nearby(unit.team, unit.x, unit.y, range, other -> {
                if(other.damaged()){
                    healEffect.at(other, parentizeEffects);
                    wasHealed = true;
                }
                other.heal((unit.maxHealth * amount / 100f) * Time.delta);
            });

            if(wasHealed){
                activeEffect.at(unit, range);
            }
    }
}
