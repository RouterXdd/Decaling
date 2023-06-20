package decal.world.type;

import arc.graphics.*;
import decal.world.meta.DecStat;
import mindustry.type.*;
import mindustry.world.meta.Stat;

public class DecayItem extends Item {
    public float decay = 0f;
    public DecayItem(String name, Color color){
        super(name);
        this.color = color;
    }
    @Override
    public void setStats(){
        stats.addPercent(Stat.explosiveness, explosiveness);
        stats.addPercent(Stat.flammability, flammability);
        stats.addPercent(Stat.radioactivity, radioactivity);
        stats.addPercent(Stat.charge, charge);
        stats.addPercent(DecStat.decay, decay);
    }
}
