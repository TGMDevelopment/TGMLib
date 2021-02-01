package ga.matthewtgm.lib.util.keybindings;

import ga.matthewtgm.lib.TGMLib;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to add Minecraft keybinds with ease.
 */
public class KeyBindManager {

    private static final KeyBindManager INSTANCE = new KeyBindManager();
    private final Map<KeyBind, KeyBinding> keyBinds = new HashMap<>();
    private KeyBinding asKeyBinding;

    public static KeyBindManager getInstance() {
        return INSTANCE;
    }

    public void addKeyBind(KeyBind keyBind) {
        this.keyBinds.put(keyBind, new KeyBinding(keyBind.getDescription(), keyBind.keyCode, TGMLib.getInstance().getModName()));
    }

    /**
     * Should be called after adding all mod keybinds
     */
    public void init() {
        this.keyBinds.forEach((keyBind, keyBindinding) -> {
            ClientRegistry.registerKeyBinding(keyBindinding);
        });
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    protected void onKeyPressed(InputEvent.KeyInputEvent event) {
        this.keyBinds.forEach((keyBind, keyBinding) -> {
            if (!keyBinding.isPressed()) return;
            keyBind.onPressed();
        });
    }

}