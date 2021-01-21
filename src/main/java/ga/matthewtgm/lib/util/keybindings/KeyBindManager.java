package ga.matthewtgm.lib.util.keybindings;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import java.util.ArrayList;
import java.util.List;

public class KeyBindManager {

    private static final KeyBindManager INSTANCE = new KeyBindManager();
    private final List<KeyBind> keyBinds = new ArrayList<>();
    private KeyBinding asKeyBinding;

    public static KeyBindManager getInstance() {
        return INSTANCE;
    }

    public void addKeyBind(KeyBind keyBind) {
        this.keyBinds.add(keyBind);
    }

    public void init(String modName) {
        for (KeyBind keyBind : this.keyBinds) {
            ClientRegistry.registerKeyBinding(asKeyBinding = new KeyBinding(keyBind.getDescription(), keyBind.keyCode, modName));
        }
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    protected void onKeyPressed(InputEvent.KeyInputEvent event) {
        for (KeyBind keyBind : this.keyBinds) {
            if (!asKeyBinding.isPressed()) return;
            keyBind.onPressed();
        }
    }

}