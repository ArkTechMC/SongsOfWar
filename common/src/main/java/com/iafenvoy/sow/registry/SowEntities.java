package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.*;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.ArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.DeathSingerArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.TideSingerArdoniEntity;
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

    public static final RegistrySupplier<EntityType<ArdoniEntity>> ARDONI = build("ardoni", ArdoniEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<EnderKnightEntity>> ENDER_KNIGHT = build("ender_knight", EnderKnightEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);

    public static final RegistrySupplier<EntityType<TideSingerArdoniEntity>> TIDE_SINGER = build("tide_singer", TideSingerArdoniEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final RegistrySupplier<EntityType<DeathSingerArdoniEntity>> DEATH_SINGER = build("death_singer", DeathSingerArdoniEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);

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
        EntityAttributeRegistry.register(TIDE_SINGER, AbstractArdoniEntity::createAttributes);
        EntityAttributeRegistry.register(DEATH_SINGER, AbstractArdoniEntity::createAttributes);
    }
}
