package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.SongStoneInfo;
import com.iafenvoy.sow.item.SongStoneItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

@SuppressWarnings("unused")
public final class SowItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Item> SONG_STONE_RED = REGISTRY.register("song_stone_red", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.RED, 1).dmg(10), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_YELLOW = REGISTRY.register("song_stone_yellow", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.YELLOW, 1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_BLUE = REGISTRY.register("song_stone_blue", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.BLUE, 1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_ORANGE = REGISTRY.register("song_stone_orange", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.ORANGE, 1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_GREEN = REGISTRY.register("song_stone_green", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.GREEN, 1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_PURPLE = REGISTRY.register("song_stone_purple", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.PURPLE, 1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_WHITE = REGISTRY.register("song_stone_white", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.WHITE, 1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_PINK = REGISTRY.register("song_stone_pink", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.PINK, 1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_AQUA = REGISTRY.register("song_stone_aqua", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.AQUA, 1), new Item.Settings()));

    public static final RegistrySupplier<Item> WITHER_STAFF = REGISTRY.register("wither_staff", () -> new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS)));
}
