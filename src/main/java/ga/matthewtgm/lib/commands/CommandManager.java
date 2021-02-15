package ga.matthewtgm.lib.commands;

import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;

public class CommandManager {

    private static CommandManager INSTANCE;

    public static CommandManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CommandManager();
        return INSTANCE;
    }

    public void register(ICommand command) {
        ClientCommandHandler.instance.registerCommand(command);
    }

}