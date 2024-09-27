package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.PeasBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public final class SowBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK);

    public static final RegistrySupplier<PeasBlock> PEAS = registerCrop("peas", PeasBlock::new);

    private static <T extends CropBlock> RegistrySupplier<T> registerCrop(String id, Supplier<T> crop) {
        RegistrySupplier<T> s = REGISTRY.register(id, crop);
        SowItems.REGISTRY.register(id, () -> new AliasedBlockItem(s.get(), new Item.Settings().arch$tab(SowItemGroups.ITEMS)));
        return s;
    }
}
