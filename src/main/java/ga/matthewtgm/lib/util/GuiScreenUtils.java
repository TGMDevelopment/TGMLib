package ga.matthewtgm.lib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Used to enhance bits of code relating to the Minecraft {@link GuiScreen}.
 */
public class GuiScreenUtils {

    private static GuiScreenUtils INSTANCE;
    private GuiScreen screenToOpen;

    /**
     * @return an instance of {@link GuiScreenUtils}.
     */
    public static GuiScreenUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GuiScreenUtils();
        return INSTANCE;
    }

    /**
     * Opens a {@link GuiScreen}. (will be most commonly used in commands.)
     *
     * @param screen the screen to open.
     */
    public void open(GuiScreen screen) {
        this.screenToOpen = screen;
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Fixes button text. (Minecraft doesn't automatically change the text on buttons when clicked.)
     *
     * @param button the button to fix.
     * @param text   the text to set.
     */
    public void fixDisplayText(GuiButton button, String text) {
        try {
            button.displayString = text;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    protected void onTick(TickEvent event) {
        Minecraft.getMinecraft().displayGuiScreen(this.screenToOpen);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}