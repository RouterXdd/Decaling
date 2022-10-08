package decal.content;

import arc.util.Time;
import decal.graphics.DecalPal;
import mindustry.gen.Sounds;
import mindustry.type.Weather;
import mindustry.type.weather.ParticleWeather;


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
