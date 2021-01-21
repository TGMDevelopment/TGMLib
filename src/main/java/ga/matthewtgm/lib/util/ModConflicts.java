package ga.matthewtgm.lib.util;

import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;

public class ModConflicts extends ArrayList<String> {

    public boolean isConflictLoaded(String conflict) {
        return Loader.isModLoaded(conflict) && this.get(this.indexOf(conflict)) != null;
    }

}