package ga.matthewtgm.lib.util;

import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;

//TODO: MAKE THIS BETTER

/**
 * An ArrayList class used to check for conflicts in mods.
 */
public class ModConflicts extends ArrayList<String> {

    /**
     * Checks for the conflict.
     *
     * @param conflict the modid of the conflicting mod.
     * @return whether the mod is loaded or not.
     */
    public boolean isConflictLoaded(String conflict) {
        return Loader.isModLoaded(conflict) && this.get(this.indexOf(conflict)) != null;
    }

}