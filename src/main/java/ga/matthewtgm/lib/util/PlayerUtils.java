package ga.matthewtgm.lib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class PlayerUtils {

    /**
     * Adds layers to the player skin (Capes, wings, etc)
     * @param layer the layer being added
     */
    public void addLayer(LayerRenderer layer) {

        try {

            Method method = RendererLivingEntity.class.getDeclaredMethod("addLayer", LayerRenderer.class);
            method.setAccessible(true);

            Field field = RenderManager.class.getDeclaredField("skinMap");
            field.setAccessible(true);

            for (Object render : ((Map<RenderPlayer, Object>) field.get(Minecraft.getMinecraft().getRenderManager())).values()) {
                method.invoke(render, layer);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}