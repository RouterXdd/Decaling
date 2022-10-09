package decal.content;

import arc.util.*;
import decal.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;


public class DecalingWeather {
    public static Weather decayStorm;
    public static void load() {

        decayStorm = new ParticleWeather("decay-storm") {{
            drawParticles = false;
            drawNoise = true;
            noiseColor = DecalPal.decalOutline;
            useWindVector = true;
            baseSpeed = 3.4f;
            force = 0.25f;
            sound = Sounds.wind;
            soundVol = 0.9f;
            duration = 5.6f * Time.toMinutes;
            attrs.set(DecalingAttributes.decay, 1.2f);
            attrs.set(DecalingAttributes.timedrive, 1f);
        }};
    }
}
