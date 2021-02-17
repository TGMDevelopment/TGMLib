package ga.matthewtgm.lib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ChatUtils {

    private static ChatUtils INSTANCE;

    public static ChatUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ChatUtils();
        return INSTANCE;
    }

    public void sendMessage(String prefix, String msg) {
        if (Minecraft.getMinecraft().thePlayer == null) return;
        if (prefix == null) return;
        if (msg == null) return;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(prefix + " " + msg));
    }

    public void sendMessage(String prefix, ChatComponentText msg) {
        if (Minecraft.getMinecraft().thePlayer == null) return;
        if (prefix == null) return;
        if (msg == null) return;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(prefix + " " + msg));
    }

}