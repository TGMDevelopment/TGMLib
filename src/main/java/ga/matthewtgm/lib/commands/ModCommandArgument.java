package ga.matthewtgm.lib.commands;

public abstract class ModCommandArgument {
    public abstract int getArgNum();
    public abstract String getArgString();
    public abstract void process();
}