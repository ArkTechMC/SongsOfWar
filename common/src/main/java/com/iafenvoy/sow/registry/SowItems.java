package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.*;
import com.iafenvoy.sow.item.impl.ProtepointShieldItem;
import com.iafenvoy.sow.power.PowerCategory;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

@SuppressWarnings("unused")
public final class SowItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_RED = REGISTRY.register("enchantment_fragment_red", () -> new EnchantmentFragmentItem(GlintManager.RED));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_YELLOW = REGISTRY.register("enchantment_fragment_yellow", () -> new EnchantmentFragmentItem(GlintManager.YELLOW));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_BLUE = REGISTRY.register("enchantment_fragment_blue", () -> new EnchantmentFragmentItem(GlintManager.BLUE));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_ORANGE = REGISTRY.register("enchantment_fragment_orange", () -> new EnchantmentFragmentItem(GlintManager.ORANGE));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_GREEN = REGISTRY.register("enchantment_fragment_green", () -> new EnchantmentFragmentItem(GlintManager.GREEN));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_PURPLE = REGISTRY.register("enchantment_fragment_purple", () -> new EnchantmentFragmentItem(GlintManager.PURPLE));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_WHITE = REGISTRY.register("enchantment_fragment_white", () -> new EnchantmentFragmentItem(GlintManager.WHITE));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_PINK = REGISTRY.register("enchantment_fragment_pink", () -> new EnchantmentFragmentItem(GlintManager.PINK));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_AQUA = REGISTRY.register("enchantment_fragment_aqua", () -> new EnchantmentFragmentItem(GlintManager.AQUA));

    public static final RegistrySupplier<Item> WITHER_STAFF = REGISTRY.register("wither_staff", () -> new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS)));

    public static final RegistrySupplier<Item> ENDER_KNIGHT_HELMET = REGISTRY.register("ender_knight_helmet", () -> new EnderKnightArmorItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_CHESTPLATE = REGISTRY.register("ender_knight_chestplate", () -> new EnderKnightArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_LEGGINGS = REGISTRY.register("ender_knight_leggings", () -> new EnderKnightArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_BOOTS = REGISTRY.register("ender_knight_boots", () -> new EnderKnightArmorItem(ArmorItem.Type.BOOTS));

    public static final RegistrySupplier<Item> SONG_STONE = REGISTRY.register("song_stone", SongStoneItem::new);
    public static final RegistrySupplier<Item> AGGRESSIUM_SONG_STONE = REGISTRY.register("aggressium_song_stone", () -> new AdjustedSongStoneItem(PowerCategory.AGGRESSIUM));
    public static final RegistrySupplier<Item> MOBILIUM_SONG_STONE = REGISTRY.register("mobilium_song_stone", () -> new AdjustedSongStoneItem(PowerCategory.MOBILIUM));
    public static final RegistrySupplier<Item> PROTISIUM_SONG_STONE = REGISTRY.register("protisium_song_stone", () -> new AdjustedSongStoneItem(PowerCategory.PROTISIUM));
    public static final RegistrySupplier<Item> SUPPORTIUM_SONG_STONE = REGISTRY.register("supportium_song_stone", () -> new AdjustedSongStoneItem(PowerCategory.SUPPORTIUM));
    public static final RegistrySupplier<Item> RED_NOTE = REGISTRY.register("red_note", () -> new NoteItem(PowerCategory.AGGRESSIUM));
    public static final RegistrySupplier<Item> YELLOW_NOTE = REGISTRY.register("yellow_note", () -> new NoteItem(PowerCategory.MOBILIUM));
    public static final RegistrySupplier<Item> BLUE_NOTE = REGISTRY.register("blue_note", () -> new NoteItem(PowerCategory.PROTISIUM));
    public static final RegistrySupplier<Item> GREEN_NOTE = REGISTRY.register("green_note", () -> new NoteItem(PowerCategory.SUPPORTIUM));

    public static final RegistrySupplier<ShrineDebugItem> SHRINE_DEBUG = REGISTRY.register("shrine_debug", ShrineDebugItem::new);
    //Fake Items, should not use in game without song power.
    public static final RegistrySupplier<Item> PROTEPOINT_SHIELD = REGISTRY.register("protepoint_shield", ProtepointShieldItem::create);
}
