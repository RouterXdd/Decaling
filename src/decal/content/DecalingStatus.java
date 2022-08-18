package decal.content;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.content.*;
import decal.graphics.*;

import static mindustry.Vars.*;

public class DecalingStatus {
        public static StatusEffect
        decaling, timeswap1, timeswap2, timeswap3, rush;
   public static void load(){
    decaling = new StatusEffect("decaying"){{
            color = Color.valueOf("3a3a3a");
            speedMultiplier = 0.7f;
            reloadMultiplier = 0.65f;
            damage = 0.15f;
            effect = Fx.oily;
            }};
            timeswap1 = new StatusEffect("time-swap1"){{
            color = DecalPal.darkTime;
            speedMultiplier = -0.2f;
            }};
            timeswap2 = new StatusEffect("time-swap2"){{
            color = DecalPal.darkTime;
            speedMultiplier = -0.5f;
            }};
            timeswap3 = new StatusEffect("time-swap3"){{
            color = DecalPal.darkTime;
            speedMultiplier = -1f;
            }};
            rush = new StatusEffect("rush"){{
                color = DecalPal.rushCol;
                speedMultiplier = 1.25f;
                reloadMultiplier = 1.10f;
            }};
    }
}