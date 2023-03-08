package decal.world.blocks.defence;

import arc.graphics.g2d.*;
import mindustry.world.blocks.defense.*;

public abstract class NeoplasmaWall extends Wall {
    public TextureRegion[] connections;
    public NeoplasmaWall(String name){
        super(name);
    }
    @Override
    public void load() {
        super.load();

    }
}
