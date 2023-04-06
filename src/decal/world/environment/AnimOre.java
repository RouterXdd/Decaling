package decal.world.environment;

import arc.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.type.Item;
import mindustry.world.blocks.environment.*;

import java.util.Arrays;

public class AnimOre extends OreBlock {
    int frames = 5;
    int transitionFrames = 0;
    int frameTime = 4;
    public TextureRegion se;

    public AnimOre(Item ore) {
        super(ore);

    }
    //AHAHAHAHAHAHAHA
    @Override
    public void load(){
        super.load();

        if(frames > 0){
            TextureRegion[] regions = new TextureRegion[frames * (transitionFrames + 1)];

            if(transitionFrames <= 0){
                for(int i = 1; i <= frames; i++){
                    regions[i - 1] = Core.atlas.find(name + Arrays.toString(variantRegions) + i);
                }
            }else{
                for(int i = 0; i < frames; i++){
                    regions[i * (transitionFrames + 1)] = Core.atlas.find(name + Arrays.toString(variantRegions) + (i + 1));
                    for(int j = 1; j <= transitionFrames; j++){
                        int index = i * (transitionFrames + 1) + j;
                        regions[index] = Core.atlas.find(name + Arrays.toString(variantRegions) + "-t" + index);
                    }
                }
            }
            Events.run(EventType.Trigger.update, () -> {
                int frame = (int)(Time.globalTime / frameTime) % regions.length;
            });
        }
    }
    @Override
    public void loadIcon(){
        super.loadIcon();

        if(frames > 0){
            TextureRegion[] regions = new TextureRegion[frames * (transitionFrames + 1)];

            if(transitionFrames <= 0){
                for(int i = 1; i <= frames; i++){
                    regions[i - 1] = Core.atlas.find(name + i);
                }
            }else{
                for(int i = 0; i < frames; i++){
                    regions[i * (transitionFrames + 1)] = Core.atlas.find(name + (i + 1));
                    for(int j = 1; j <= transitionFrames; j++){
                        int index = i * (transitionFrames + 1) + j;
                        regions[index] = Core.atlas.find(name + "-t" + index);
                    }
                }
            }

            fullIcon = new TextureRegion(fullIcon);
            uiIcon = new TextureRegion(uiIcon);

            Events.run(EventType.Trigger.update, () -> {
                int frame = (int)(Time.globalTime / frameTime) % regions.length;

                fullIcon.set(regions[frame]);
                uiIcon.set(regions[frame]);
            });
        }
    }
}
