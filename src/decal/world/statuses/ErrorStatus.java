package decal.world.statuses;

import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import decal.world.meta.*;

public class ErrorStatus extends StatusEffect{
        public float Yinsability = Mathf.random(-1, 1);
        public float Xinsability = Mathf.random(-1, 1);
        public float insabilityChance = 0.005f;
    public ErrorStatus(String name) {
        super(name);
        effectChance = 1;
        healthMultiplier = 0.5f;
        effect = new Effect(60, e -> Draw.color(e.fin()));
        permanent = true;
    }

    @Override
    public void update(Unit unit, float time) {
        Yinsability = Mathf.random(-1, 1);
        Xinsability = Mathf.random(-1, 1);
        if(Mathf.chance(insabilityChance)) {
            unit.move(unit.y + Yinsability, unit.x + Xinsability);
        }
    }

    @Override
    public void setStats() {
        super.setStats();
        stats.add(DecStat.Yinsability, Yinsability, StatUnit.blocks);
        stats.add(DecStat.Xinsability, Xinsability, StatUnit.blocks);
    }
}
