package ga.matthewtgm.lib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class GuiScreenUtils {

    private static GuiScreenUtils INSTANCE = new GuiScreenUtils();
    public static GuiScreenUtils getInstance() {
        return INSTANCE;
    }

    private GuiScreen screenToOpen;

    public void open(GuiScreen screen) {
        this.screenToOpen = screen;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    protected void onTick(TickEvent event) {
        Minecraft.getMinecraft().displayGuiScreen(this.screenToOpen);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}