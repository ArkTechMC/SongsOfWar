package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.CommonPlayerLikeEntityRenderer;
import com.iafenvoy.neptune.render.CommonPlayerLikeWithMarkerEntityRenderer;
import com.iafenvoy.sow.render.ArdoniEntityRenderer;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class SowRenderers {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(SowEntities.NONE_TYPE_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.VOLTARIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SENDARIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MENDORIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NESTORIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KALTARIS_ARDONI, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ENDER_KNIGHT, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GRIM, CommonPlayerLikeEntityRenderer::new);

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
        EntityRendererRegistry.register(SowEntities.AURELIUS, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HADION, ArdoniEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.VAL, ArdoniEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.FELDEN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KIYOSHI, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NIIKA, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MASANI, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NITSUKE, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.YUJUKI, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.ABBIGAIL, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ALEC, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.BARTENDER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CIVILIAN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.DARLENE, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.EDDY, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HAWKEN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HORSE_RIDER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.LUCAN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MARCUS, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MARSHALL, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MRFINCH, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SULLIMAN, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ALLISTER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.DENNY, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.JALKAR, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SAXON, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.TREVOR, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.IGNEOUS, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MAGNORITE, CommonPlayerLikeWithMarkerEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.NECROMANCER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NECROLORD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.XARIA, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.NETHARAN, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CHRONOS, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.PYTHUS, CommonPlayerLikeWithMarkerEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.HUSK, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.STRAY, CommonPlayerLikeWithMarkerEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ZOMBIE, CommonPlayerLikeWithMarkerEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.CONCHORD_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CROWN_PEAK_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CYDONIA_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ETHEREA_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FELDEN_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.GENERAL_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HYDRAPHEL_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.KARTHEN_GUARD, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NORTHWIND_GUARD, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.CONCHORD_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CROWN_PEAK_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CYDONIA_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.ETHEREA_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FELDEN_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.HYDRAPHEL_SOLDIER, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.NORTHWIND_SOLDIER, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.ADVENTURER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.BLACKSMITH_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.CHEF_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FARMER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FEMALE_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.FISHER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.LEATHER_WORKER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MALE_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MERCHANT_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.MINER_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.OLD_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.POOR_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SAILOR_FOLK, CommonPlayerLikeEntityRenderer::new);
        EntityRendererRegistry.register(SowEntities.SCHOLAR_FOLK, CommonPlayerLikeEntityRenderer::new);

        EntityRendererRegistry.register(SowEntities.PIXEL_ZNIMATION, CommonPlayerLikeEntityRenderer::new);
    }
}
