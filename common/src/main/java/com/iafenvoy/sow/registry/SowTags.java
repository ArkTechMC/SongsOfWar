package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class SowTags {
    public static final TagKey<Block> STONE_BRICKS = block("stone_bricks");
    public static final TagKey<Block> STONE_BRICK_STAIRS = block("stone_brick_stairs");

    private static TagKey<Block> block(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(SongsOfWar.MOD_ID, id));
    }
}
