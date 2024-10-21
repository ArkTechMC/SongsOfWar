package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.CommonPlayerLikeEntityRenderer;
import com.iafenvoy.neptune.render.CommonPlayerLikeWithMarkerEntityRenderer;
import com.iafenvoy.neptune.render.SkullRenderRegistry;
import com.iafenvoy.sow.entity.GrimEntity;
import com.iafenvoy.sow.entity.ardoni.*;
import com.iafenvoy.sow.entity.felina.*;
import com.iafenvoy.sow.entity.human.*;
import com.iafenvoy.sow.entity.magnorite.IgneousEntity;
import com.iafenvoy.sow.entity.necromancer.NecrolordEntity;
import com.iafenvoy.sow.entity.necromancer.XariaEntity;
import com.iafenvoy.sow.entity.netharan.ChronosEntity;
import com.iafenvoy.sow.entity.netharan.PythusEntity;
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

    public static void registerSkull() {
        SkullRenderRegistry.register(SowSkulls.SkullType.ABBIGAIL, AbbigailEntity.TEXTURE, SowSkulls.ABBIGAIL_HEAD.get(), SowSkulls.ABBIGAIL_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.AEGUS, AegusEntity.TEXTURE, SowSkulls.AEGUS_HEAD.get(), SowSkulls.AEGUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.ALEC, AlecEntity.TEXTURE, SowSkulls.ALEC_HEAD.get(), SowSkulls.ALEC_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.ALLISTER, AllisterEntity.TEXTURE, SowSkulls.ALLISTER_HEAD.get(), SowSkulls.ALLISTER_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.AURELIUS, AureliusEntity.TEXTURE, SowSkulls.AURELIUS_HEAD.get(), SowSkulls.AURELIUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.CHRONOS, ChronosEntity.TEXTURE, SowSkulls.CHRONOS_HEAD.get(), SowSkulls.CHRONOS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.DARLENE, DarleneEntity.TEXTURE, SowSkulls.DARLENE_HEAD.get(), SowSkulls.DARLENE_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.DEATH_SINGER, DeathSingerEntity.TEXTURE, SowSkulls.DEATH_SINGER_HEAD.get(), SowSkulls.DEATH_SINGER_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.DENNY, DennyEntity.TEXTURE, SowSkulls.DENNY_HEAD.get(), SowSkulls.DENNY_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.EDDY, EddyEntity.TEXTURE, SowSkulls.EDDY_HEAD.get(), SowSkulls.EDDY_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.GALLEOUS, GalleousEntity.TEXTURE, SowSkulls.GALLEOUS_HEAD.get(), SowSkulls.GALLEOUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.GRIM, GrimEntity.TEXTURE, SowSkulls.GRIM_HEAD.get(), SowSkulls.GRIM_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.HADION, HadionEntity.TEXTURE, SowSkulls.HADION_HEAD.get(), SowSkulls.HADION_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.HAWKEN, HawkenEntity.TEXTURE, SowSkulls.HAWKEN_HEAD.get(), SowSkulls.HAWKEN_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.HUBRIS, HubrisEntity.TEXTURE, SowSkulls.HUBRIS_HEAD.get(), SowSkulls.HUBRIS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.IGNEOUS, IgneousEntity.TEXTURE, SowSkulls.IGNEOUS_HEAD.get(), SowSkulls.IGNEOUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.JALKAR, JalkarEntity.TEXTURE, SowSkulls.JALKAR_HEAD.get(), SowSkulls.JALKAR_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.KIYOSHI, KiyoshiEntity.TEXTURE, SowSkulls.KIYOSHI_HEAD.get(), SowSkulls.KIYOSHI_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.LUCAN, LucanEntity.TEXTURE, SowSkulls.LUCAN_HEAD.get(), SowSkulls.LUCAN_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.LUCIDIUS, LucidiusEntity.TEXTURE, SowSkulls.LUCIDIUS_HEAD.get(), SowSkulls.LUCIDIUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.MARCUS, MarcusEntity.TEXTURE, SowSkulls.MARCUS_HEAD.get(), SowSkulls.MARCUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.MARSHALL, MarshallEntity.TEXTURE, SowSkulls.MARSHALL_HEAD.get(), SowSkulls.MARSHALL_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.MASANI, MasaniEntity.TEXTURE, SowSkulls.MASANI_HEAD.get(), SowSkulls.MASANI_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.MRFINCH, MrfinchEntity.TEXTURE, SowSkulls.MRFINCH_HEAD.get(), SowSkulls.MRFINCH_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.NECROLORD, NecrolordEntity.TEXTURE, SowSkulls.NECROLORD_HEAD.get(), SowSkulls.NECROLORD_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.NIIKA, NiikaEntity.TEXTURE, SowSkulls.NIIKA_HEAD.get(), SowSkulls.NIIKA_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.NITSUKE, NitsukeEntity.TEXTURE, SowSkulls.NITSUKE_HEAD.get(), SowSkulls.NITSUKE_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.OSIVIAN, OsivianEntity.TEXTURE, SowSkulls.OSIVIAN_HEAD.get(), SowSkulls.OSIVIAN_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.PYTHUS, PythusEntity.TEXTURE, SowSkulls.PYTHUS_HEAD.get(), SowSkulls.PYTHUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.RIA, RiaEntity.TEXTURE, SowSkulls.RIA_HEAD.get(), SowSkulls.RIA_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.SAXON, SaxonEntity.TEXTURE, SowSkulls.SAXON_HEAD.get(), SowSkulls.SAXON_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.SENN, SennEntity.TEXTURE, SowSkulls.SENN_HEAD.get(), SowSkulls.SENN_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.SULLIMAN, SullimanEntity.TEXTURE, SowSkulls.SULLIMAN_HEAD.get(), SowSkulls.SULLIMAN_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.THALLEOUS, ThalleousEntity.TEXTURE, SowSkulls.THALLEOUS_HEAD.get(), SowSkulls.THALLEOUS_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.TIDE_SINGER, TideSingerEntity.TEXTURE, SowSkulls.TIDE_SINGER_HEAD.get(), SowSkulls.TIDE_SINGER_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.TREVOR, TrevorEntity.TEXTURE, SowSkulls.TREVOR_HEAD.get(), SowSkulls.TREVOR_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.TYGREN, TygrenEntity.TEXTURE, SowSkulls.TYGREN_HEAD.get(), SowSkulls.TYGREN_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.VAL, ValEntity.TEXTURE, SowSkulls.VAL_HEAD.get(), SowSkulls.VAL_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.XARIA, XariaEntity.TEXTURE, SowSkulls.XARIA_HEAD.get(), SowSkulls.XARIA_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.YUJUKI, YujukiEntity.TEXTURE, SowSkulls.YUJUKI_HEAD.get(), SowSkulls.YUJUKI_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.ZINAIDA, ZinaidaEntity.TEXTURE, SowSkulls.ZINAIDA_HEAD.get(), SowSkulls.ZINAIDA_WALL_HEAD.get());
        SkullRenderRegistry.register(SowSkulls.SkullType.ZULIUS, ZuliusEntity.TEXTURE, SowSkulls.ZULIUS_HEAD.get(), SowSkulls.ZULIUS_WALL_HEAD.get());
    }
}
