package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.MobilibouncePlatformBlockItem;
import com.iafenvoy.sow.item.block.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

import java.util.function.Function;
import java.util.function.Supplier;

public final class SowBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK);
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<PeasBlock> PEAS = register("peas", PeasBlock::new, block -> new BlockItem(block, new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));
    public static final RegistrySupplier<Block> WALLS_OF_TIME = register("walls_of_time", () -> new Block(AbstractBlock.Settings.create()));
    //Block
    public static final RegistrySupplier<AggressiumSongCubeBlock> AGGRESSIUM_SONG = register("aggressium_song", AggressiumSongCubeBlock::new, block -> new BlockItem(block, new Item.Settings().rarity(Rarity.EPIC).maxCount(1).arch$tab(SowItemGroups.POWER)));
    public static final RegistrySupplier<MobiliumSongCubeBlock> MOBILIUM_SONG = register("mobilium_song", MobiliumSongCubeBlock::new, block -> new BlockItem(block, new Item.Settings().rarity(Rarity.EPIC).maxCount(1).arch$tab(SowItemGroups.POWER)));
    public static final RegistrySupplier<ProtisiumSongCubeBlock> PROTISIUM_SONG = register("protisium_song", ProtisiumSongCubeBlock::new, block -> new BlockItem(block, new Item.Settings().rarity(Rarity.EPIC).maxCount(1).arch$tab(SowItemGroups.POWER)));
    public static final RegistrySupplier<SupportiumSongCubeBlock> SUPPORTIUM_SONG = register("supportium_song", SupportiumSongCubeBlock::new, block -> new BlockItem(block, new Item.Settings().rarity(Rarity.EPIC).maxCount(1).arch$tab(SowItemGroups.POWER)));
    //Fake Blocks, should not use in game without song power.
    public static final RegistrySupplier<GlassBlock> MOBILIBOUNCE_PLATFORM = register("mobilibounce_platform", () -> new GlassBlock(AbstractBlock.Settings.copy(Blocks.BEDROCK).dropsNothing().nonOpaque().emissiveLighting((state, world, pos) -> true).luminance(state -> 15).jumpVelocityMultiplier(3)), MobilibouncePlatformBlockItem::new);

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> crop) {
        RegistrySupplier<T> s = REGISTRY.register(id, crop);
        ITEM_REGISTRY.register(id, () -> new AliasedBlockItem(s.get(), new Item.Settings().arch$tab(SowItemGroups.ITEMS)));
        return s;
    }

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> block, Function<Block, Item> itemBuilder) {
        RegistrySupplier<T> r = REGISTRY.register(id, block);
        ITEM_REGISTRY.register(id, () -> itemBuilder.apply(r.get()));
        return r;
    }
}
