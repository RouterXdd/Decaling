package decal;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import decal.content.*;

public class Decaling extends Mod{

    public Decaling(){
        Log.info("Loaded Decaling constructor.");
    }

    @Override
    public void loadContent(){
        new DecalingItems().load();
        new DecalingStatus().load();
        
        new DecalingUnits().load();
        new DecalingBlocks().load();


        
    }

}
