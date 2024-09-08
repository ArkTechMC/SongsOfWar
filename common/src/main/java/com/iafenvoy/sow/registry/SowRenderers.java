package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.CommonPlayerLikeEntityRenderer;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.CanActiveSwordItem;
import com.iafenvoy.sow.render.ArdoniEntityRenderer;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class SowRenderers {
    public static void registerBlockRenderers() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.AGGRESSIUM_PRIME_SONG.get(), SowBlocks.MOBILIUM_PRIME_SONG.get(), SowBlocks.PROTISIUM_PRIME_SONG.get(), SowBlocks.SUPPORIUM_PRIME_SONG.get());
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(SowEntities.ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ENDER_KNIGHT, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GRIM, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.TIDE_SINGER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.DEATH_SINGER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.AEGUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KALTARIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MENDORIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SENDARIS_MASTER, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FELDEN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KIYOSHI, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NIIKA, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ABBIGAIL, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ALEC, CommonPlayerLikeEntityRenderer::new);
    }

    public static void registerModelPredicates() {
        ItemPropertiesRegistry.registerGeneric(new Identifier(SongsOfWar.MOD_ID, CanActiveSwordItem.ACTIVE_KEY), (stack, world, entity, seed) -> stack.getNbt() != null && stack.getNbt().getBoolean(CanActiveSwordItem.ACTIVE_KEY) ? 1 : 0);
    }
}
