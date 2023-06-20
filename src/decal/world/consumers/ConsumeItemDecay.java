package decal.world.consumers;

import decal.world.type.*;
import mindustry.world.consumers.*;
import mindustry.gen.*;

public class ConsumeItemDecay extends ConsumeItemFilter {

    public DecayItem Decayitem;
    public float minDecay;

    public ConsumeItemDecay(float minCharge){
        this.minDecay = minCharge;
        filter = DecayItem -> Decayitem.decay >= this.minDecay;
    }

    public ConsumeItemDecay(){
        this(0.2f);
    }

    @Override
    public float efficiencyMultiplier(Building build){
        var DecayItem = getConsumed(build);
        return Decayitem == null ? 0f : Decayitem.decay;
    }
}
