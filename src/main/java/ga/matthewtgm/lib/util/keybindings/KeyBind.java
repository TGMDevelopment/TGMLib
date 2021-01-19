package ga.matthewtgm.lib.util.keybindings;

import org.lwjgl.input.Keyboard;

public abstract class KeyBind {

    public abstract String getDescription();
    public abstract int getKey();
    public abstract void onPressed();

    public boolean isPressed() {
        return this.getKey() == Keyboard.getEventKey() && Keyboard.getEventKeyState();
    }

}