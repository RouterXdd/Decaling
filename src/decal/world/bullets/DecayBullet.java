package decal.world.bullets;

import arc.graphics.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;

public class DecayBullet extends BasicBulletType {
    public float decayRange = 30, decayDamage = 1;
    public DecayBullet(float speed, float damage) {
        super(speed, damage);
    }
    @Override
    public void update(Bullet b) {
        Units.nearbyEnemies(b.team, b.x, b.y, decayRange, other -> {
            other.damageContinuousPierce(decayDamage);
        });
    }
    @Override
    public void draw(Bullet b) {
        super.draw(b);
        Drawf.circles(b.x, b.y, decayRange, new Color(Color.valueOf("232323")));
    }
}
