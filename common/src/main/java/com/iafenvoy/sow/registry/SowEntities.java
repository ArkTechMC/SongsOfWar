package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.util.EntityBuildHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.GrimEntity;
import com.iafenvoy.sow.entity.ardoni.*;
import com.iafenvoy.sow.entity.ardoni.random.*;
import com.iafenvoy.sow.entity.author.PixelZnimationEntity;
import com.iafenvoy.sow.entity.felina.*;
import com.iafenvoy.sow.entity.human.*;
import com.iafenvoy.sow.entity.human.guard.*;
import com.iafenvoy.sow.entity.human.soldier.*;
import com.iafenvoy.sow.entity.human.townsfolk.*;
import com.iafenvoy.sow.entity.magnorite.IgneousEntity;
import com.iafenvoy.sow.entity.magnorite.MagnoriteEntity;
import com.iafenvoy.sow.entity.necromancer.NecrolordEntity;
import com.iafenvoy.sow.entity.necromancer.NecromancerEntity;
import com.iafenvoy.sow.entity.necromancer.XariaEntity;
import com.iafenvoy.sow.entity.netharan.ChronosEntity;
import com.iafenvoy.sow.entity.netharan.NetharanEntity;
import com.iafenvoy.sow.entity.netharan.PythusEntity;
import com.iafenvoy.sow.entity.zombie.SowHuskEntity;
import com.iafenvoy.sow.entity.zombie.SowStrayEntity;
import com.iafenvoy.sow.entity.zombie.SowZombieEntity;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKeys;

public final class SowEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ENTITY_TYPE);

    //Misc
    public static final RegistrySupplier<EntityType<NoneTypeArdoniEntity>> NONE_TYPE_ARDONI = build("none_type_ardoni", NoneTypeArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<KaltarisArdoniEntity>> KALTARIS_ARDONI = build("kaltaris_ardoni", KaltarisArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<MendorisArdoniEntity>> MENDORIS_ARDONI = build("mendoris_ardoni", MendorisArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<NestorisArdoniEntity>> NESTORIS_ARDONI = build("nestoris_ardoni", NestorisArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<SendarisArdoniEntity>> SENDARIS_ARDONI = build("sendaris_ardoni", SendarisArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<VoltarisArdoniEntity>> VOLTARIS_ARDONI = build("voltaris_ardoni", VoltarisArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<GrimEntity>> GRIM = build("grim", GrimEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Ardoni
    public static final RegistrySupplier<EntityType<TideSingerEntity>> TIDE_SINGER = build("tide_singer", TideSingerEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<DeathSingerEntity>> DEATH_SINGER = build("death_singer", DeathSingerEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<AegusEntity>> AEGUS = build("aegus", AegusEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<KaltarisMasterEntity>> KALTARIS_MASTER = build("kaltaris_master", KaltarisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<MendorisMasterEntity>> MENDORIS_MASTER = build("mendoris_master", MendorisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<SendarisMasterEntity>> SENDARIS_MASTER = build("sendaris_master", SendarisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<HubrisEntity>> HUBRIS = build("hubris", HubrisEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<RiaEntity>> RIA = build("ria", RiaEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<ThalleousEntity>> THALLEOUS = build("thalleous", ThalleousEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<GalleousEntity>> GALLEOUS = build("galleous", GalleousEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<SennEntity>> SENN = build("senn", SennEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<ZuliusEntity>> ZULIUS = build("zulius", ZuliusEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<TygrenEntity>> TYGREN = build("tygren", TygrenEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<OsivianEntity>> OSIVIAN = build("osivian", OsivianEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<LucidiusEntity>> LUCIDIUS = build("lucidius", LucidiusEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<ZinaidaEntity>> ZINAIDA = build("zinaida", ZinaidaEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<AureliusEntity>> AURELIUS = build("aurelius", AureliusEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<HadionEntity>> HADION = build("hadion", HadionEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    public static final RegistrySupplier<EntityType<ValEntity>> VAL = build("val", ValEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.1f));
    //Felina
    public static final RegistrySupplier<EntityType<FeldenEntity>> FELDEN = build("felden", FeldenEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final RegistrySupplier<EntityType<KiyoshiEntity>> KIYOSHI = build("kiyoshi", KiyoshiEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final RegistrySupplier<EntityType<NiikaEntity>> NIIKA = build("niika", NiikaEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    public static final RegistrySupplier<EntityType<MasaniEntity>> MASANI = build("masani", MasaniEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    public static final RegistrySupplier<EntityType<NitsukeEntity>> NITSUKE = build("nitsuke", NitsukeEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    public static final RegistrySupplier<EntityType<YujukiEntity>> YUJUKI = build("yujuki", YujukiEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(0.95f));
    //Human
    public static final RegistrySupplier<EntityType<AbbigailEntity>> ABBIGAIL = build("abbigail", AbbigailEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<AlecEntity>> ALEC = build("alec", AlecEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<BartenderEntity>> BARTENDER = build("bartender", BartenderEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<CivilianEntity>> CIVILIAN = build("civilian", CivilianEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<DarleneEntity>> DARLENE = build("darlene", DarleneEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<EddyEntity>> EDDY = build("eddy", EddyEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<HawkenEntity>> HAWKEN = build("hawken", HawkenEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<HorseRiderEntity>> HORSE_RIDER = build("horse_rider", HorseRiderEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<LucanEntity>> LUCAN = build("lucan", LucanEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<MarcusEntity>> MARCUS = build("marcus", MarcusEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<MarshallEntity>> MARSHALL = build("marchall", MarshallEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<MrfinchEntity>> MRFINCH = build("mrfinch", MrfinchEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<SullimanEntity>> SULLIMAN = build("sulliman", SullimanEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<AllisterEntity>> ALLISTER = build("allister", AllisterEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<DennyEntity>> DENNY = build("denny", DennyEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<JalkarEntity>> JALKAR = build("jalkar", JalkarEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<SaxonEntity>> SAXON = build("saxon", SaxonEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<TrevorEntity>> TREVOR = build("trevor", TrevorEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Magnorite
    public static final RegistrySupplier<EntityType<IgneousEntity>> IGNEOUS = build("igneous", IgneousEntity::new, SpawnGroup.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.2f));
    public static final RegistrySupplier<EntityType<MagnoriteEntity>> MAGNORITE = build("magnorite", MagnoriteEntity::new, SpawnGroup.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.2f));
    //Necromancer
    public static final RegistrySupplier<EntityType<NecromancerEntity>> NECROMANCER = build("necromancer", NecromancerEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<NecrolordEntity>> NECROLORD = build("necrolord", NecrolordEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<XariaEntity>> XARIA = build("xaria", XariaEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Netheran
    public static final RegistrySupplier<EntityType<NetharanEntity>> NETHARAN = build("netharan", NetharanEntity::new, SpawnGroup.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.15f));
    public static final RegistrySupplier<EntityType<ChronosEntity>> CHRONOS = build("chronos", ChronosEntity::new, SpawnGroup.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.15f));
    public static final RegistrySupplier<EntityType<PythusEntity>> PYTHUS = build("pythus", PythusEntity::new, SpawnGroup.CREATURE, 64, 3, true, EntityBuildHelper.PLAYER.scale(1.15f));
    //Zombie
    public static final RegistrySupplier<EntityType<SowHuskEntity>> HUSK = build("husk", SowHuskEntity::new, SpawnGroup.MONSTER, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<SowStrayEntity>> STRAY = build("stray", SowStrayEntity::new, SpawnGroup.MONSTER, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<SowZombieEntity>> ZOMBIE = build("zombie", SowZombieEntity::new, SpawnGroup.MONSTER, 64, 3, false, EntityBuildHelper.PLAYER);
    //Guard
    public static final RegistrySupplier<EntityType<ConchordGuardEntity>> CONCHORD_GUARD = build("conchord_guard", ConchordGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<CrownPeakGuardEntity>> CROWN_PEAK_GUARD = build("crown_peak_guard", CrownPeakGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<CydoniaGuardEntity>> CYDONIA_GUARD = build("cydonia_guard", CydoniaGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<EthereaGuardEntity>> ETHEREA_GUARD = build("etherea_guard", EthereaGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<FeldenGuardEntity>> FELDEN_GUARD = build("felden_guard", FeldenGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final RegistrySupplier<EntityType<GeneralGuardEntity>> GENERAL_GUARD = build("general_guard", GeneralGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<HydraphelGuardEntity>> HYDRAPHEL_GUARD = build("hydraphel_guard", HydraphelGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<KarthenGuardEntity>> KARTHEN_GUARD = build("karthen_guard", KarthenGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<NorthwindGuardEntity>> NORTHWIND_GUARD = build("northwind_guard", NorthwindGuardEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Soldier
    public static final RegistrySupplier<EntityType<ConchordSoldierEntity>> CONCHORD_SOLDIER = build("conchord_soldier", ConchordSoldierEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<CrownPeakSoldierEntity>> CROWN_PEAK_SOLDIER = build("crown_peak_soldier", CrownPeakSoldierEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<CydoniaSoldierEntity>> CYDONIA_SOLDIER = build("cydonia_soldier", CydoniaSoldierEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<EthereaSoldierEntity>> ETHEREA_SOLDIER = build("etherea_soldier", EthereaSoldierEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<FeldenSoldierEntity>> FELDEN_SOLDIER = build("felden_soldier", FeldenSoldierEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER.scale(1.05f));
    public static final RegistrySupplier<EntityType<HydraphelSoldierEntity>> HYDRAPHEL_SOLDIER = build("hydraphel_soldier", HydraphelSoldierEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<NorthwindSoldierEntity>> NORTHWIND_SOLDIER = build("northwind_soldier", NorthwindSoldierEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Townsfolk
    public static final RegistrySupplier<EntityType<AdventurerFolkEntity>> ADVENTURER_FOLK = build("adventurer_folk", AdventurerFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<BlacksmithFolkEntity>> BLACKSMITH_FOLK = build("blacksmith_folk", BlacksmithFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<ChefFolkEntity>> CHEF_FOLK = build("chef_folk", ChefFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<FarmerFolkEntity>> FARMER_FOLK = build("farmer_folk", FarmerFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<FemaleFolkEntity>> FEMALE_FOLK = build("female_folk", FemaleFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<FisherFolkEntity>> FISHER_FOLK = build("fisher_folk", FisherFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<LeatherWorkerFolkEntity>> LEATHER_WORKER_FOLK = build("leather_worker_folk", LeatherWorkerFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<MaleFolkEntity>> MALE_FOLK = build("male_folk", MaleFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<MerchantFolkEntity>> MERCHANT_FOLK = build("merchant_folk", MerchantFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<MinerFolkEntity>> MINER_FOLK = build("miner_folk", MinerFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<OldFolkEntity>> OLD_FOLK = build("old_folk", OldFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<PoorFolkEntity>> POOR_FOLK = build("poor_folk", PoorFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<SailorFolkEntity>> SAILOR_FOLK = build("sailor_folk", SailorFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    public static final RegistrySupplier<EntityType<ScholarFolkEntity>> SCHOLAR_FOLK = build("scholar_folk", ScholarFolkEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);
    //Author
    public static final RegistrySupplier<EntityType<PixelZnimationEntity>> PIXEL_ZNIMATION = build("pixel_znimation", PixelZnimationEntity::new, SpawnGroup.CREATURE, 64, 3, false, EntityBuildHelper.PLAYER);

    private static <T extends Entity> RegistrySupplier<EntityType<T>> build(String name, EntityType.EntityFactory<T> constructor, SpawnGroup category, int trackingRange, int updateInterval, boolean fireImmune, EntityBuildHelper.Dimension dimension) {
        return REGISTRY.register(name, EntityBuildHelper.build(name, constructor, category, trackingRange, updateInterval, fireImmune, dimension));
    }

    public static void init() {
        EntityAttributeRegistry.register(NONE_TYPE_ARDONI, NoneTypeArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(KALTARIS_ARDONI, KaltarisArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(MENDORIS_ARDONI, MendorisArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(NESTORIS_ARDONI, NestorisArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(SENDARIS_ARDONI, SendarisArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(VOLTARIS_ARDONI, VoltarisArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(GRIM, GrimEntity::createAttributes);

        EntityAttributeRegistry.register(TIDE_SINGER, TideSingerEntity::createAttributes);
        EntityAttributeRegistry.register(DEATH_SINGER, DeathSingerEntity::createAttributes);
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
        EntityAttributeRegistry.register(AURELIUS, AureliusEntity::createAttributes);
        EntityAttributeRegistry.register(HADION, HadionEntity::createAttributes);
        EntityAttributeRegistry.register(VAL, ValEntity::createAttributes);

        EntityAttributeRegistry.register(FELDEN, FeldenEntity::createAttributes);
        EntityAttributeRegistry.register(KIYOSHI, KiyoshiEntity::createAttributes);
        EntityAttributeRegistry.register(NIIKA, NiikaEntity::createAttributes);
        EntityAttributeRegistry.register(MASANI, MasaniEntity::createAttributes);
        EntityAttributeRegistry.register(NITSUKE, NitsukeEntity::createAttributes);
        EntityAttributeRegistry.register(YUJUKI, YujukiEntity::createAttributes);

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
        EntityAttributeRegistry.register(ALLISTER, AllisterEntity::createAttributes);
        EntityAttributeRegistry.register(DENNY, DennyEntity::createAttributes);
        EntityAttributeRegistry.register(JALKAR, JalkarEntity::createAttributes);
        EntityAttributeRegistry.register(SAXON, SaxonEntity::createAttributes);
        EntityAttributeRegistry.register(TREVOR, TrevorEntity::createAttributes);

        EntityAttributeRegistry.register(IGNEOUS, IgneousEntity::createAttributes);
        EntityAttributeRegistry.register(MAGNORITE, MagnoriteEntity::createAttributes);

        EntityAttributeRegistry.register(NECROMANCER, NecrolordEntity::createAttributes);
        EntityAttributeRegistry.register(NECROLORD, NecrolordEntity::createAttributes);
        EntityAttributeRegistry.register(XARIA, XariaEntity::createAttributes);

        EntityAttributeRegistry.register(NETHARAN, NetharanEntity::createAttributes);
        EntityAttributeRegistry.register(CHRONOS, ChronosEntity::createAttributes);
        EntityAttributeRegistry.register(PYTHUS, PythusEntity::createAttributes);

        EntityAttributeRegistry.register(HUSK, SowHuskEntity::createZombieAttributes);
        EntityAttributeRegistry.register(STRAY, SowStrayEntity::createZombieAttributes);
        EntityAttributeRegistry.register(ZOMBIE, SowZombieEntity::createZombieAttributes);

        EntityAttributeRegistry.register(CONCHORD_GUARD, ConchordGuardEntity::createAttributes);
        EntityAttributeRegistry.register(CROWN_PEAK_GUARD, CrownPeakGuardEntity::createAttributes);
        EntityAttributeRegistry.register(CYDONIA_GUARD, CydoniaGuardEntity::createAttributes);
        EntityAttributeRegistry.register(ETHEREA_GUARD, EthereaGuardEntity::createAttributes);
        EntityAttributeRegistry.register(FELDEN_GUARD, FeldenGuardEntity::createAttributes);
        EntityAttributeRegistry.register(GENERAL_GUARD, GeneralGuardEntity::createAttributes);
        EntityAttributeRegistry.register(HYDRAPHEL_GUARD, HydraphelGuardEntity::createAttributes);
        EntityAttributeRegistry.register(KARTHEN_GUARD, KarthenGuardEntity::createAttributes);
        EntityAttributeRegistry.register(NORTHWIND_GUARD, NorthwindGuardEntity::createAttributes);

        EntityAttributeRegistry.register(CONCHORD_SOLDIER, ConchordSoldierEntity::createAttributes);
        EntityAttributeRegistry.register(CROWN_PEAK_SOLDIER, CrownPeakSoldierEntity::createAttributes);
        EntityAttributeRegistry.register(CYDONIA_SOLDIER, CydoniaSoldierEntity::createAttributes);
        EntityAttributeRegistry.register(ETHEREA_SOLDIER, EthereaSoldierEntity::createAttributes);
        EntityAttributeRegistry.register(FELDEN_SOLDIER, FeldenSoldierEntity::createAttributes);
        EntityAttributeRegistry.register(HYDRAPHEL_SOLDIER, HydraphelSoldierEntity::createAttributes);
        EntityAttributeRegistry.register(NORTHWIND_SOLDIER, NorthwindSoldierEntity::createAttributes);

        EntityAttributeRegistry.register(ADVENTURER_FOLK, AdventurerFolkEntity::createAttributes);
        EntityAttributeRegistry.register(BLACKSMITH_FOLK, BlacksmithFolkEntity::createAttributes);
        EntityAttributeRegistry.register(CHEF_FOLK, ChefFolkEntity::createAttributes);
        EntityAttributeRegistry.register(FARMER_FOLK, FarmerFolkEntity::createAttributes);
        EntityAttributeRegistry.register(FEMALE_FOLK, FemaleFolkEntity::createAttributes);
        EntityAttributeRegistry.register(FISHER_FOLK, FisherFolkEntity::createAttributes);
        EntityAttributeRegistry.register(LEATHER_WORKER_FOLK, LeatherWorkerFolkEntity::createAttributes);
        EntityAttributeRegistry.register(MALE_FOLK, MaleFolkEntity::createAttributes);
        EntityAttributeRegistry.register(MERCHANT_FOLK, MerchantFolkEntity::createAttributes);
        EntityAttributeRegistry.register(MINER_FOLK, MinerFolkEntity::createAttributes);
        EntityAttributeRegistry.register(OLD_FOLK, OldFolkEntity::createAttributes);
        EntityAttributeRegistry.register(POOR_FOLK, PoorFolkEntity::createAttributes);
        EntityAttributeRegistry.register(SAILOR_FOLK, SailorFolkEntity::createAttributes);
        EntityAttributeRegistry.register(SCHOLAR_FOLK, ScholarFolkEntity::createAttributes);

        EntityAttributeRegistry.register(PIXEL_ZNIMATION, PixelZnimationEntity::createAttributes);
    }
}
