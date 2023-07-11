package decal.world.abilities;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import decal.graphics.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.graphics.*;

import static mindustry.Vars.*;

public class DecayField extends Ability {
    public float range, damage;
    public DecayField( float range, float damage) {
        this.range = range;
        this.damage = damage;
    }

    @Override
    public String localized() {
        return Core.bundle.format("ability.decayfield", range / 8f, damage);
    }

    @Override
    public void update(Unit unit) {
        Units.nearbyEnemies(unit.team, unit.x, unit.y, range, other -> {
            other.damageContinuousPierce(damage);
        });

    }
    @Override
    public void draw(Unit unit) {
        super.draw(unit);

        Draw.z(Layer.shields);

        Draw.color(DecalPal.decalOutline);

        if(renderer.animateShields){
            Fill.poly(unit.x, unit.y, 360, range);
        }else{
            Lines.stroke(1.5f);
            Draw.alpha(0.09f + Mathf.clamp(0.08f * 0f));
            Fill.poly(unit.x, unit.y, 360, range);
            Draw.alpha(1f);
            Lines.poly(unit.x, unit.y, 360, range);
            Draw.reset();
        }
    }
}
