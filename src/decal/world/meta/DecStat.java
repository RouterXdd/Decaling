package decal.world.meta;

import arc.*;
import arc.struct.*;
import mindustry.world.meta.*;

import java.util.*;

public class DecStat implements Comparable<Stat> {
    public static final Seq<DecStat> allStat = new Seq<>();

    public static final Stat

            repairChance = new Stat("repairChance"),
            healAmount = new Stat("healAmount"),
            mirrorChance = new Stat("mirrorChance"),
            Yinsability = new Stat("Y glitch"),
            Xinsability = new Stat("X glitch");

    public final StatCat category;
    public final String name;
    public final int id;

    public DecStat(String name, StatCat category){
        this.category = category;
        this.name = name;
        id = allStat.size;
        allStat.add(this);
    }

    public DecStat(String name){
        this(name, StatCat.general);
    }

    public String localized(){
        return Core.bundle.get("stat." + name.toLowerCase(Locale.ROOT));
    }

    @Override
    public int compareTo(Stat o){
        return id - o.id;
    }
}
