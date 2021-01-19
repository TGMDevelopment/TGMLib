package ga.matthewtgm.lib.util.guiscreens;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.util.List;

public abstract class GuiAppendedButton {

    public GuiScreen parent;
    public List<GuiButton> buttonList;

    public abstract int getId();
    public abstract int getX();
    public abstract int getY();
    public int getWidth() {
        return 200;
    }
    public int getHeight() {
        return 20;
    }
    public abstract String getText();

    public abstract void onClicked();

}