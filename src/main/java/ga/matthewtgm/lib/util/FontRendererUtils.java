package ga.matthewtgm.lib.util;

import net.minecraft.client.gui.FontRenderer;

public class FontRendererUtils {

    private static FontRendererUtils INSTANCE;

    public static FontRendererUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new FontRendererUtils();
        return INSTANCE;
    }

    public void drawCenteredString(FontRenderer fontRendererIn, String text, float x, float y, int color) {
        fontRendererIn.drawStringWithShadow(text, (x - fontRendererIn.getStringWidth(text) / 2), y, color);
    }

    public void drawCenteredString(FontRenderer fontRendererIn, String text, double x, double y, int color) {
        fontRendererIn.drawStringWithShadow(text, (float) (x - fontRendererIn.getStringWidth(text) / 2), (float) y, color);
    }

}