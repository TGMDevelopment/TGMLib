package ga.matthewtgm.lib.util;

import net.minecraft.client.gui.FontRenderer;

/**
 * Used along with {@link FontRenderer} to make things regarding font rendering just a little nicer.
 */
public class FontRendererUtils {

    private static FontRendererUtils INSTANCE;

    /**
     * @return an instance of {@link FontRendererUtils}.
     */
    public static FontRendererUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new FontRendererUtils();
        return INSTANCE;
    }

    /**
     * Draws a string centered on the X and Y coordinates given.
     *
     * @param fontRendererIn Minecraft font renderer instance.
     * @param text           the text to render.
     * @param x              x coordinate.
     * @param y              y coordinate.
     * @param color          the colour of the text.
     */
    public void drawCenteredString(FontRenderer fontRendererIn, String text, float x, float y, int color) {
        fontRendererIn.drawStringWithShadow(text, (x - fontRendererIn.getStringWidth(text) / 2), y, color);
    }

    /**
     * Draws a string centered on the X and Y coordinates given.
     *
     * @param fontRendererIn Minecraft font renderer instance.
     * @param text           the text to render.
     * @param x              x coordinate.
     * @param y              y coordinate.
     * @param color          the colour of the text.
     */
    public void drawCenteredString(FontRenderer fontRendererIn, String text, double x, double y, int color) {
        fontRendererIn.drawStringWithShadow(text, (float) (x - fontRendererIn.getStringWidth(text) / 2), (float) y, color);
    }

}