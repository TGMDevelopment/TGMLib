package ga.matthewtgm.lib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.lang.reflect.Field;
import java.util.List;

public class GuiScreenUtils {

    private static GuiScreenUtils INSTANCE;
    private GuiScreen screenToOpen;

    public static GuiScreenUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GuiScreenUtils();
        return INSTANCE;
    }

    public void open(GuiScreen screen) {
        this.screenToOpen = screen;
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void fixDisplayText(List<GuiButton> buttonList, int buttonId, String text) {
        try {
            buttonList.get(buttonId).displayString = text;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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