package ga.matthewtgm.lib.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class ModCommand extends CommandBase {

    private final ModCommandRunnable runnable;

    public ModCommand(ModCommandRunnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public String getCommandName() {
        return this.runnable.getCommandString();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return this.runnable.getRequiredPermissionLevel();
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return this.runnable.getCommandUsage();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        this.runnable.process((EntityPlayer) sender.getCommandSenderEntity(), args);
        if (this.runnable.getArguments() != null) {
            for (ModCommandArgument argument : this.runnable.getArguments()) {
                if (args[argument.getArgNum()] != null) {
                    if (args[argument.getArgNum()].toLowerCase().equalsIgnoreCase(argument.getArgString()))
                        argument.process();
                }
            }
        }
    }

    @Override
    public List<String> getCommandAliases() {
        return this.runnable.getCommandAliases();
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        List<String> options = new ArrayList<>();
        this.runnable.getArguments().forEach(opt -> options.add(opt.getArgString()));
        return new ArrayList<>(options);
    }

}