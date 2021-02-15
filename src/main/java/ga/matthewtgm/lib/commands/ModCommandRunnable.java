package ga.matthewtgm.lib.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

import java.util.Collections;
import java.util.List;

public abstract class ModCommandRunnable {

    public abstract String getCommandString();

    public abstract String getCommandUsage();

    public abstract int getRequiredPermissionLevel();

    public abstract void process(EntityPlayer sender, String[] args) throws CommandException;

    public List<String> getCommandAliases() {
        return Collections.emptyList();
    }

    public List<String> getTabCompleteOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

}