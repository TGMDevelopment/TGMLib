package ga.matthewtgm.lib.util.guiscreens;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class GuiAppendingManager {

    private static GuiAppendingManager INSTANCE = new GuiAppendingManager();

    public static GuiAppendingManager getInstance() {
        return INSTANCE;
    }

    private final List<GuiAppendedButton> appendedButtons = new ArrayList<>();
    private GuiScreen screenToAddTo;

    /**
     * Should be called inside {@link net.minecraftforge.client.event.GuiOpenEvent}
     * @param screen the screen to append the button to
     * @param button the button to append. An instance of {@link GuiAppendedButton}
     */
    public void appendButton(GuiScreen screen, GuiAppendedButton button) {
        this.screenToAddTo = screen;
        this.appendedButtons.add(button);
    }

    public void init() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    protected void onGuiInit(GuiScreenEvent.InitGuiEvent event) {
        if(event.gui != this.screenToAddTo) return;
        for (GuiAppendedButton appendedButton : this.appendedButtons) {
            appendedButton.parent = event.gui;
            appendedButton.buttonList = event.buttonList;
            event.buttonList.add(new GuiButton(appendedButton.getId(), appendedButton.getX(), appendedButton.getY(), appendedButton.getWidth(), appendedButton.getHeight(), appendedButton.getText()));
        }
    }

    @SubscribeEvent
    protected void onGuiActionPerformed(GuiScreenEvent.ActionPerformedEvent event) {
        if(event.gui != this.screenToAddTo) return;
        for (GuiAppendedButton appendedButton : this.appendedButtons) {
            if (event.button.id == appendedButton.getId()) {
                appendedButton.onClicked();
            }
        }
    }

}