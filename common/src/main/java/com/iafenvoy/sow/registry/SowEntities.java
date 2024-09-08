package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.*;
import com.iafenvoy.sow.entity.ardoni.*;
import com.iafenvoy.sow.entity.felina.FeldenEntity;
import com.iafenvoy.sow.entity.felina.KiyoshiEntity;
import com.iafenvoy.sow.entity.felina.NiikaEntity;
import com.iafenvoy.sow.entity.human.AbbigailEntity;
import com.iafenvoy.sow.entity.human.AlecEntity;
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
    //Ardoni
    public static final RegistrySupplier<EntityType<TideSingerArdoniEntity>> TIDE_SINGER = build("tide_singer", TideSingerArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<DeathSingerArdoniEntity>> DEATH_SINGER = build("death_singer", DeathSingerArdoniEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<AegusEntity>> AEGUS = build("aegus", AegusEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<KaltarisMasterEntity>> KALTARIS_MASTER = build("kaltaris_master", KaltarisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<MendorisMasterEntity>> MENDORIS_MASTER = build("mendoris_master", MendorisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<SendarisMasterEntity>> SENDARIS_MASTER = build("sendaris_master", SendarisMasterEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    //Felina
    public static final RegistrySupplier<EntityType<FeldenEntity>> FELDEN = build("felden", FeldenEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<KiyoshiEntity>> KIYOSHI = build("kiyoshi", KiyoshiEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<NiikaEntity>> NIIKA = build("niika", NiikaEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    //Human
    public static final RegistrySupplier<EntityType<AbbigailEntity>> ABBIGAIL = build("abbigail", AbbigailEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<AlecEntity>> ALEC = build("alec", AlecEntity::new, SpawnGroup.CREATURE, 64, 3, false, 0.6F, 1.8F);

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
        EntityAttributeRegistry.register(TIDE_SINGER, AbstractArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(DEATH_SINGER, AbstractArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(AEGUS, AegusEntity::createAttributes);
        EntityAttributeRegistry.register(KALTARIS_MASTER, KaltarisMasterEntity::createAttributes);
        EntityAttributeRegistry.register(MENDORIS_MASTER, MendorisMasterEntity::createAttributes);
        EntityAttributeRegistry.register(SENDARIS_MASTER, SendarisMasterEntity::createAttributes);
        EntityAttributeRegistry.register(FELDEN, FeldenEntity::createAttributes);
        EntityAttributeRegistry.register(KIYOSHI, KiyoshiEntity::createAttributes);
        EntityAttributeRegistry.register(NIIKA, NiikaEntity::createAttributes);
        EntityAttributeRegistry.register(ABBIGAIL, AbbigailEntity::createAttributes);
        EntityAttributeRegistry.register(ALEC, AlecEntity::createAttributes);
    }
}
