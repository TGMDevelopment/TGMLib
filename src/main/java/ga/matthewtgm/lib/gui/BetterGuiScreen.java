package ga.matthewtgm.lib.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public abstract class BetterGuiScreen extends GuiScreen {

    /**
     * Adds all buttons to the GuiScreen and calls any other constructor-like methods.
     */
    @Override
    public abstract void initGui();

    /**
     * Parses the players button actions.
     */
    @Override
    protected abstract void actionPerformed(GuiButton button) throws IOException;

    /**
     * Call {@code BetterGuiScreen#drawButtons} inside this method.
     *
     * @param mouseX the x positioning of the mouse on the monitor.
     * @param mouseY the y positioning of the mouse on the monitor.
     * @param partialTicks unused.
     */
    @Override
    public abstract void drawScreen(int mouseX, int mouseY, float partialTicks);

    @Override
    public abstract boolean doesGuiPauseGame();

    /**
     * Draws the buttons to the screen, required.
     *
     * @param mouseX the x positioning of the mouse on the monitor.
     * @param mouseY the y positioning of the mouse on the monitor.
     */
    protected void drawComponents(int mouseX, int mouseY) {
        for (int i = 0; i < this.buttonList.size(); ++i)
        {
            this.buttonList.get(i).drawButton(this.mc, mouseX, mouseY);
        }

        for (int j = 0; j < this.labelList.size(); ++j)
        {
            this.labelList.get(j).drawLabel(this.mc, mouseX, mouseY);
        }
    }

    public abstract GuiScreen getParent();

}