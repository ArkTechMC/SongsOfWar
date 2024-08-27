package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class SongsOfWarClient {
    public static void init() {
    }

    public static void process() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.AGGRESSIUM_PRIME_SONG.get(), SowBlocks.MOBILIUM_PRIME_SONG.get(), SowBlocks.PROTISIUM_PRIME_SONG.get(), SowBlocks.SUPPORIUM_PRIME_SONG.get());
    }
}
