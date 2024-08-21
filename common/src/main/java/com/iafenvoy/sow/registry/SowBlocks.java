package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

import java.util.function.Supplier;

public final class SowBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK);

    //Song Cubes
    public static final RegistrySupplier<Block> AGGRESSIUM_CUBE = registerSongCube("aggressium_cube", () -> new SongCubeBlock(SongCubeBlock.CubeType.AGGRESSIUM));
    public static final RegistrySupplier<Block> MOBILIUM_CUBE = registerSongCube("mobilium_cube", () -> new SongCubeBlock(SongCubeBlock.CubeType.MOBILIUM));
    public static final RegistrySupplier<Block> PROTISIUM_CUBE = registerSongCube("protisium_cube", () -> new SongCubeBlock(SongCubeBlock.CubeType.PROTISIUM));
    public static final RegistrySupplier<Block> SUPPORIUM_CUBE = registerSongCube("supporium_cube", () -> new SongCubeBlock(SongCubeBlock.CubeType.SUPPORIUM));

    private static <T extends Block> RegistrySupplier<T> registerSongCube(String id, Supplier<T> block) {
        RegistrySupplier<T> r = REGISTRY.register(id, block);
        SowItems.REGISTRY.register(id, () -> new BlockItem(r.get(), new Item.Settings().fireproof().maxCount(1).rarity(Rarity.EPIC).arch$tab(SowItemGroups.ITEMS)));
        return r;
    }
}
