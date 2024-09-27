package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowRenderers;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class SongsOfWarClient {
    public static void init() {
        SowRenderers.registerEntityRenderers();
    }

    public static void process() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.PEAS.get());
    }
}
