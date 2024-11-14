package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.EnchantmentFragmentInfo;
import com.iafenvoy.sow.item.EnchantmentFragmentItem;
import com.iafenvoy.sow.item.EnderKnightArmorItem;
import com.iafenvoy.sow.item.ShrineDebugItem;
import com.iafenvoy.sow.item.impl.ProtepointShieldItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

@SuppressWarnings("unused")
public final class SowItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_RED = REGISTRY.register("enchantment_fragment_red", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.RED, 1).dmg(3)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_YELLOW = REGISTRY.register("enchantment_fragment_yellow", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.YELLOW, 1).kb(3)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_BLUE = REGISTRY.register("enchantment_fragment_blue", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.BLUE, 1).spd(3)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_ORANGE = REGISTRY.register("enchantment_fragment_orange", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.ORANGE, 1).dmg(2).kb(1)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_GREEN = REGISTRY.register("enchantment_fragment_green", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.GREEN, 1).luck(3)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_PURPLE = REGISTRY.register("enchantment_fragment_purple", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.PURPLE, 1).dmg(2).spd(1)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_WHITE = REGISTRY.register("enchantment_fragment_white", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.WHITE, 1).dmg(1).kb(1).spd(1)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_PINK = REGISTRY.register("enchantment_fragment_pink", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.PINK, 1).spd(1).luck(2)));
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_AQUA = REGISTRY.register("enchantment_fragment_aqua", () -> new EnchantmentFragmentItem(EnchantmentFragmentInfo.of(GlintManager.AQUA, 1).kb(1).luck(2)));

    public static final RegistrySupplier<Item> WITHER_STAFF = REGISTRY.register("wither_staff", () -> new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS)));

    public static final RegistrySupplier<Item> ENDER_KNIGHT_HELMET = REGISTRY.register("ender_knight_helmet", () -> new EnderKnightArmorItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_CHESTPLATE = REGISTRY.register("ender_knight_chestplate", () -> new EnderKnightArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_LEGGINGS = REGISTRY.register("ender_knight_leggings", () -> new EnderKnightArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_BOOTS = REGISTRY.register("ender_knight_boots", () -> new EnderKnightArmorItem(ArmorItem.Type.BOOTS));

    public static final RegistrySupplier<ShrineDebugItem> SHRINE_DEBUG = REGISTRY.register("shrine_debug", ShrineDebugItem::new);
    //Fake Items, should not use in game without song power.
    public static final RegistrySupplier<Item> PROTEPOINT_SHIELD = REGISTRY.register("protepoint_shield", ProtepointShieldItem::create);
}
