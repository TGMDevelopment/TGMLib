package ga.matthewtgm.lib.util.keybindings;

/**
 * Custom keybind used to create a {@link net.minecraft.client.settings.KeyBinding}.
 * Must be used along with {@link KeyBindManager}.
 */
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

    /**
     * Action performed on key press
     */
    public abstract void onPressed();

}