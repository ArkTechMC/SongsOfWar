package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public final class SowParticles {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.PARTICLE_TYPE);

    public static final RegistrySupplier<DefaultParticleType> SONG_EFFECT = register("song_effect", () -> new DefaultParticleType(false) {
    });

    private static RegistrySupplier<DefaultParticleType> register(String id, Supplier<DefaultParticleType> type) {
        return REGISTRY.register(id, type);
    }
}
