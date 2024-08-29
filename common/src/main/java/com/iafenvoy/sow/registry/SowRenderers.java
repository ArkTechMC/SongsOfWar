package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.render.ArdoniEntityRenderer;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public final class SowRenderers {
    public static void registerBlockRenderers() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.AGGRESSIUM_PRIME_SONG.get(), SowBlocks.MOBILIUM_PRIME_SONG.get(), SowBlocks.PROTISIUM_PRIME_SONG.get(), SowBlocks.SUPPORIUM_PRIME_SONG.get());
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(SowEntities.ARDONI, ArdoniEntityRenderer::new);
    }

}
