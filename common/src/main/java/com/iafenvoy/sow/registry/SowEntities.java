package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.*;
import com.iafenvoy.sow.entity.ardoni.*;
import com.iafenvoy.sow.entity.felina.AbstractFelinaEntity;
import com.iafenvoy.sow.entity.felina.FeldenEntity;
import com.iafenvoy.sow.entity.felina.KiyoshiEntity;
import com.iafenvoy.sow.entity.felina.NiikaEntity;
import com.iafenvoy.sow.entity.human.*;
import com.iafenvoy.sow.entity.necromancer.NecrolordEntity;
import com.iafenvoy.sow.entity.necromancer.XariaEntity;
import com.iafenvoy.sow.entity.netheran.ChronosEntity;
import com.iafenvoy.sow.entity.netheran.PythusEntity;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public final class SowEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ENTITY_TYPE);

    //Misc
    public static final RegistrySupplier<EntityType<ArdoniEntity>> ARDONI = build("ardoni", ArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<EnderKnightEntity>> ENDER_KNIGHT = build("ender_knight", EnderKnightEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<GrimEntity>> GRIM = build("grim", GrimEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<IgneousEntity>> IGNEOUS = build("igneous", IgneousEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    //Ardoni
    public static final RegistrySupplier<EntityType<TideSingerArdoniEntity>> TIDE_SINGER = build("tide_singer", TideSingerArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<DeathSingerArdoniEntity>> DEATH_SINGER = build("death_singer", DeathSingerArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<AegusEntity>> AEGUS = build("aegus", AegusEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<KaltarisMasterEntity>> KALTARIS_MASTER = build("kaltaris_master", KaltarisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<MendorisMasterEntity>> MENDORIS_MASTER = build("mendoris_master", MendorisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<SendarisMasterEntity>> SENDARIS_MASTER = build("sendaris_master", SendarisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<HubrisEntity>> HUBRIS = build("hubris", HubrisEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<RiaEntity>> RIA = build("ria", RiaEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<ThalleousEntity>> THALLEOUS = build("thalleous", ThalleousEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<GalleousEntity>> GALLEOUS = build("galleous", GalleousEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<SennEntity>> SENN = build("senn", SennEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<ZuliusEntity>> ZULIUS = build("zulius", ZuliusEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<TygrenEntity>> TYGREN = build("tygren", TygrenEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<OsivianEntity>> OSIVIAN = build("osivian", OsivianEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<LucidiusEntity>> LUCIDIUS = build("lucidius", LucidiusEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<ZinaidaEntity>> ZINAIDA = build("zinaida", ZinaidaEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    //Felina
    public static final RegistrySupplier<EntityType<FeldenEntity>> FELDEN = build("felden", FeldenEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<KiyoshiEntity>> KIYOSHI = build("kiyoshi", KiyoshiEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<NiikaEntity>> NIIKA = build("niika", NiikaEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    //Human
    public static final RegistrySupplier<EntityType<AbbigailEntity>> ABBIGAIL = build("abbigail", AbbigailEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<AlecEntity>> ALEC = build("alec", AlecEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<BartenderEntity>> BARTENDER = build("bartender", BartenderEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<CivilianEntity>> CIVILIAN = build("civilian", CivilianEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<DarleneEntity>> DARLENE = build("darlene", DarleneEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<EddyEntity>> EDDY = build("eddy", EddyEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<HawkenEntity>> HAWKEN = build("hawken", HawkenEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<HorseRiderEntity>> HORSE_RIDER = build("horse_rider", HorseRiderEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<LucanEntity>> LUCAN = build("lucan", LucanEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<MarcusEntity>> MARCUS = build("marcus", MarcusEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<MarshallEntity>> MARSHALL = build("marchall", MarshallEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<MrfinchEntity>> MRFINCH = build("mrfinch", MrfinchEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<SullimanEntity>> SULLIMAN = build("sulliman", SullimanEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    //Necromancer
    public static final RegistrySupplier<EntityType<NecrolordEntity>> NECROLORD = build("necrolord", NecrolordEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<XariaEntity>> XARIA = build("xaria", XariaEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    //Netheran
    public static final RegistrySupplier<EntityType<ChronosEntity>> CHRONOS = build("chronos", ChronosEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<PythusEntity>> PYTHUS = build("pythus", PythusEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);

    private static <T extends Entity> RegistrySupplier<EntityType<T>> build(String name, EntityType.EntityFactory<T> constructor, SpawnGroup category, int trackingRange, int updateInterval, boolean fireImmune, float sizeX, float sizeY) {
        return register(name, () -> {
            EntityType.Builder<T> builder = EntityType.Builder.create(constructor, category).maxTrackingRange(trackingRange).trackingTickInterval(updateInterval).setDimensions(sizeX, sizeY);
            if (fireImmune) builder.makeFireImmune();
            return builder.build(name);
        });
    }

    private static <T extends Entity> RegistrySupplier<EntityType<T>> register(String name, Supplier<EntityType<T>> type) {
        return REGISTRY.register(name, type);
    }

    public static void init() {
        EntityAttributeRegistry.register(ARDONI, AbstractArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(ENDER_KNIGHT, EnderKnightEntity::createAttributes);
        EntityAttributeRegistry.register(GRIM, GrimEntity::createAttributes);
        EntityAttributeRegistry.register(IGNEOUS, IgneousEntity::createAttributes);

        EntityAttributeRegistry.register(TIDE_SINGER, AbstractArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(DEATH_SINGER, AbstractArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(AEGUS, AegusEntity::createAttributes);
        EntityAttributeRegistry.register(KALTARIS_MASTER, KaltarisMasterEntity::createAttributes);
        EntityAttributeRegistry.register(MENDORIS_MASTER, MendorisMasterEntity::createAttributes);
        EntityAttributeRegistry.register(SENDARIS_MASTER, SendarisMasterEntity::createAttributes);
        EntityAttributeRegistry.register(HUBRIS, HubrisEntity::createAttributes);
        EntityAttributeRegistry.register(RIA, RiaEntity::createAttributes);
        EntityAttributeRegistry.register(THALLEOUS, ThalleousEntity::createAttributes);
        EntityAttributeRegistry.register(GALLEOUS, GalleousEntity::createAttributes);
        EntityAttributeRegistry.register(SENN, SennEntity::createAttributes);
        EntityAttributeRegistry.register(ZULIUS, ZuliusEntity::createAttributes);
        EntityAttributeRegistry.register(TYGREN, TygrenEntity::createAttributes);
        EntityAttributeRegistry.register(OSIVIAN, OsivianEntity::createAttributes);
        EntityAttributeRegistry.register(LUCIDIUS, LucidiusEntity::createAttributes);
        EntityAttributeRegistry.register(ZINAIDA, ZinaidaEntity::createAttributes);

        EntityAttributeRegistry.register(FELDEN, AbstractFelinaEntity::createAttributes);
        EntityAttributeRegistry.register(KIYOSHI, AbstractFelinaEntity::createAttributes);
        EntityAttributeRegistry.register(NIIKA, AbstractFelinaEntity::createAttributes);

        EntityAttributeRegistry.register(ABBIGAIL, AbbigailEntity::createAttributes);
        EntityAttributeRegistry.register(ALEC, AlecEntity::createAttributes);
        EntityAttributeRegistry.register(BARTENDER, BartenderEntity::createAttributes);
        EntityAttributeRegistry.register(CIVILIAN, CivilianEntity::createAttributes);
        EntityAttributeRegistry.register(DARLENE, DarleneEntity::createAttributes);
        EntityAttributeRegistry.register(EDDY, EddyEntity::createAttributes);
        EntityAttributeRegistry.register(HAWKEN, HawkenEntity::createAttributes);
        EntityAttributeRegistry.register(HORSE_RIDER, HorseRiderEntity::createAttributes);
        EntityAttributeRegistry.register(LUCAN, LucanEntity::createAttributes);
        EntityAttributeRegistry.register(MARCUS, MarcusEntity::createAttributes);
        EntityAttributeRegistry.register(MARSHALL, MarshallEntity::createAttributes);
        EntityAttributeRegistry.register(MRFINCH, MrfinchEntity::createAttributes);
        EntityAttributeRegistry.register(SULLIMAN, SullimanEntity::createAttributes);

        EntityAttributeRegistry.register(NECROLORD, NecrolordEntity::createAttributes);
        EntityAttributeRegistry.register(XARIA, XariaEntity::createAttributes);

        EntityAttributeRegistry.register(CHRONOS, ChronosEntity::createAttributes);
        EntityAttributeRegistry.register(PYTHUS, PythusEntity::createAttributes);
    }
}
