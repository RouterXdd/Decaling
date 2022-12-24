package decal.world.abilities;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import decal.content.*;
import decal.graphics.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;

public class StealDecayField extends Ability {
    public float range = 30, damage = 1, percentAmount = 0.5f;
    public StealDecayField( float range, float damage) {
        this.range = range;
        this.damage = damage;
    }

    @Override
    public String localized() {
        return Core.bundle.format("ability.stealfield", range / 8f, damage);
    }

    @Override
    public void update(Unit unit) {
        Units.nearbyEnemies(unit.team, unit.x, unit.y, range, other -> {
            other.damageContinuousPierce(damage);
            unit.heal((unit.maxHealth * percentAmount / 100f) * Time.delta);
        });
    }
    @Override
    public void draw(Unit unit) {
        super.draw(unit);
        Drawf.circles(unit.x, unit.y, range, new Color(Color.valueOf("b8ccf2")));
    }
}
