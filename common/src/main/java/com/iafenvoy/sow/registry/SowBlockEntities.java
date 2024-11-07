package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.entity.AggressiumSongCubeBlockEntity;
import com.iafenvoy.sow.item.block.entity.MobiliumSongCubeBlockEntity;
import com.iafenvoy.sow.item.block.entity.ProtisiumSongCubeBlockEntity;
import com.iafenvoy.sow.item.block.entity.SupportiumSongCubeBlockEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public final class SowBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);
    //Block Entity
    public static final RegistrySupplier<BlockEntityType<AggressiumSongCubeBlockEntity>> AGGRESSIUM_SONG_TYPE = register("aggressium_song", () -> BlockEntityType.Builder.create(AggressiumSongCubeBlockEntity::new, SowBlocks.AGGRESSIUM_SONG.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<MobiliumSongCubeBlockEntity>> MOBILIUM_SONG_TYPE = register("mobilium_song", () -> BlockEntityType.Builder.create(MobiliumSongCubeBlockEntity::new, SowBlocks.MOBILIUM_SONG.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<ProtisiumSongCubeBlockEntity>> PROTISIUM_SONG_TYPE = register("protisium_song", () -> BlockEntityType.Builder.create(ProtisiumSongCubeBlockEntity::new, SowBlocks.PROTISIUM_SONG.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<SupportiumSongCubeBlockEntity>> SUPPORTIUM_SONG_TYPE = register("supportium_song", () -> BlockEntityType.Builder.create(SupportiumSongCubeBlockEntity::new, SowBlocks.SUPPORTIUM_SONG.get()).build(null));

    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(String id, Supplier<BlockEntityType<T>> block) {
        return REGISTRY.register(id, block);
    }
}
