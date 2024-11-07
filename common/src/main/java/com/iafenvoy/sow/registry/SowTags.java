package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class SowTags {
    public static final TagKey<Block> STONE_BRICKS = of(RegistryKeys.BLOCK, "stone_bricks");
    public static final TagKey<Block> STONE_BRICK_STAIRS = of(RegistryKeys.BLOCK, "stone_brick_stairs");

    private static <T> TagKey<T> of(RegistryKey<Registry<T>> type, String id) {
        return TagKey.of(type, new Identifier(SongsOfWar.MOD_ID, id));
    }
}
