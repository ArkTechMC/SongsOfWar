package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public final class SowBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK);

    public static final RegistrySupplier<Block> WALLS_OF_TIME = register("walls_of_time", () -> new Block(AbstractBlock.Settings.create()));

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> crop) {
        RegistrySupplier<T> s = REGISTRY.register(id, crop);
        SowItems.REGISTRY.register(id, () -> new AliasedBlockItem(s.get(), new Item.Settings().arch$tab(SowItemGroups.ITEMS)));
        return s;
    }
}
