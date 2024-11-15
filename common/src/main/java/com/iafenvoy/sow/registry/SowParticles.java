package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.particle.BlockDisplayParticleBuilder;
import com.iafenvoy.sow.particle.LaserParticleBuilder;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Blocks;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Vec3d;

import java.util.function.Supplier;

public final class SowParticles {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.PARTICLE_TYPE);

    public static final RegistrySupplier<DefaultParticleType> SONG_EFFECT = register("song_effect", () -> new DefaultParticleType(false) {
    });
    public static final RegistrySupplier<DefaultParticleType> AGGROBLAST = register("aggroblast", () -> new DefaultParticleType(false) {
    });
    public static final RegistrySupplier<LaserParticleBuilder> LASER = register("laser", () -> new LaserParticleBuilder(null, 0, 0, 1, 0, 1));
    public static final RegistrySupplier<BlockDisplayParticleBuilder> BLOCK_DISPLAY = register("block_display", () -> new BlockDisplayParticleBuilder(Blocks.AIR.getDefaultState(), true, Vec3d.ZERO, 1, 20));

    private static <T extends ParticleType<?>> RegistrySupplier<T> register(String id, Supplier<T> type) {
        return REGISTRY.register(id, type);
    }
}
