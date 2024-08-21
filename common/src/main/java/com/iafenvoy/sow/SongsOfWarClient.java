package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.render.RenderLayer;

public class SongsOfWarClient {
    public static void init() {
    }

    public static void process() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.AGGRESSIUM_CUBE.get(), SowBlocks.MOBILIUM_CUBE.get(), SowBlocks.PROTISIUM_CUBE.get(), SowBlocks.SUPPORIUM_CUBE.get());
    }
}
