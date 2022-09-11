package decal.world.abilities;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import decal.content.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;

public class DecayField extends Ability {
    public float range = 30, damage = 1;
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

        Draw.color(Color.valueOf("232323"));
        Drawf.circles(unit.x, unit.y, range);
    }
}
