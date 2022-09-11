package decal.world.blocks.defence;

import arc.math.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.world.*;

public class BlockDestroyer extends Block{
    public Block[] toDestroy = {};
    public Effect effect = Fx.shockwave, breakEffect = Fx.reactorExplosion, selfKillEffect = Fx.massiveExplosion;

    public BlockDestroyer(String name){
        super(name);

        solid = update = true;
        rebuildable = true;
    }

    @Override
    public boolean canBreak(Tile tile){
        return Vars.state.isEditor();
    }

    public class BlockDestroyerBuild extends Building{

        @Override
        public void updateTile(){
            if(Mathf.equal(efficiency, 1f)){
                effect.at(this);
                for(var other : Vars.state.teams.active){
                    if(team != other.team){
                        for(var block : toDestroy){
                            other.getBuildings(block).copy().each(b -> {
                                breakEffect.at(b);
                                b.kill();
                            });
                        }
                    }
                }
                selfKillEffect.at(this);
                kill();
            }
        }
    }
}
