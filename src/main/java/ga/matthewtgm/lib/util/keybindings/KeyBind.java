package ga.matthewtgm.lib.util.keybindings;

import org.lwjgl.input.Keyboard;

public abstract class KeyBind {

    private final String description;
    public int keyCode;

    public KeyBind(String description, int keyCode) {
        this.description = description;
        this.keyCode = keyCode;
    }

    public String getDescription() {
        return description;
    }

    public abstract void onPressed();

}