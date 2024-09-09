package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.CommonPlayerLikeEntityRenderer;
import com.iafenvoy.sow.render.ArdoniEntityRenderer;
import com.iafenvoy.sow.render.NetheranEntityRenderer;
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
        EntityRendererRegistry.register(SowEntities.ENDER_KNIGHT, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GRIM, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.IGNEOUS, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.TIDE_SINGER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.DEATH_SINGER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.AEGUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KALTARIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MENDORIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SENDARIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HUBRIS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.RIA, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.THALLEOUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GALLEOUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SENN, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ZULIUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.TYGREN, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.OSIVIAN, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.LUCIDIUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ZINAIDA, ArdoniEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.FELDEN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KIYOSHI, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NIIKA, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.ABBIGAIL, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ALEC, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.BIGGERTON_BARTENDER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.BIGGERTON_CIVILIAN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.DARLENE, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.EDDY, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HAWKEN, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.CHRONOS, NetheranEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.PYTHUS, NetheranEntityRenderer::new);
    }
}
