package decal.content;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import decal.world.statuses.ErrorStatus;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.content.*;
import decal.graphics.*;

import static mindustry.Vars.*;

public class DecalingStatus {
        public static StatusEffect
        decaling, timeswap1, timeswap2, timeswap3, rush, timeCrack, timeStop, anotherTimeline, errorTest, crystallized;
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
            rush = new StatusEffect("rushS"){{
                color = DecalPal.rushCol;
                speedMultiplier = 1.25f;
                reloadMultiplier = 1.10f;
            }};
       timeCrack = new StatusEffect("time-crack"){{
           color = DecalPal.darkTime;
           speedMultiplier = 0.9f;
           reloadMultiplier = 0.85f;
           dragMultiplier = 1.4f;
       }};
       timeStop = new StatusEffect("time-stop"){{
           color = DecalPal.darkTime;
           speedMultiplier = 0f;
           reloadMultiplier = 0f;
       }};
       anotherTimeline = new StatusEffect("another-timeline"){{
           color = DecalPal.darkTime;
           damageMultiplier = 0f;
           healthMultiplier = 10000000f;
           effect = DecalingFx.changeMode;
       }};
        errorTest = new ErrorStatus("error-test"){{
           color = DecalPal.icelin;
       }};
       crystallized = new StatusEffect("crystallized"){{
           color = DecalPal.ancident;
           damageMultiplier = 0.9f;
           healthMultiplier = 0.85f;
           speedMultiplier = 0.7f;
           effect = DecalingFx.crystal;
       }};
    }
}