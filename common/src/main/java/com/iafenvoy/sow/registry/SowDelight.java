package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.PeasCanItem;
import com.iafenvoy.sow.item.PeasDelightItem;
import com.iafenvoy.sow.item.block.FoodBlockWithPiece;
import com.iafenvoy.sow.item.block.FoodPlateBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

@SuppressWarnings("unused")
public final class SowDelight {
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK);

    public static final RegistrySupplier<Item> PEAS_CAN = ITEM_REGISTRY.register("peas_can", PeasCanItem::new);

    public static final RegistrySupplier<Block> FOOD_PLATE = BLOCK_REGISTRY.register("food_plate", () -> new FoodPlateBlock(p -> p));
    public static final RegistrySupplier<Item> FOOD_PLATE_ITEM = ITEM_REGISTRY.register("food_plate", () -> new BlockItem(FOOD_PLATE.get(), new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));
    public static final RegistrySupplier<Item> PEAS_STRING = ITEM_REGISTRY.register("peas_string", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).snack().build())));
    public static final RegistrySupplier<Item> PEAS_FLOUR_CAKE = ITEM_REGISTRY.register("peas_flour_cake", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build())));

    public static final RegistrySupplier<Item> PEAS_BURGER = ITEM_REGISTRY.register("peas_burger", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(4).saturationModifier(1).build())));
    public static final RegistrySupplier<Item> PEAS_CAKE = ITEM_REGISTRY.register("peas_cake", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).build())));
    public static final RegistrySupplier<Item> PEAS_ICE_BAR = ITEM_REGISTRY.register("peas_ice_bar", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(3).saturationModifier(0.33f).build())));
    public static final RegistrySupplier<Item> PEAS_ICE_CREAM = ITEM_REGISTRY.register("peas_ice_cream", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(4).saturationModifier(1).build())));
    public static final RegistrySupplier<Item> PEAS_MILK_TEA = ITEM_REGISTRY.register("peas_milk_tea", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8f).build())));
    public static final RegistrySupplier<Item> PEAS_PIE = ITEM_REGISTRY.register("peas_pie", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(6).saturationModifier(0.33f).build())));
    public static final RegistrySupplier<Block> PEAS_STEAMED_STUFFED_BUN_BLOCK = BLOCK_REGISTRY.register("peas_steamed_stuffed_bun", () -> new FoodBlockWithPiece(p -> p, 4, new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build()));
    public static final RegistrySupplier<Item> PEAS_STEAMED_STUFFED_BUN = ITEM_REGISTRY.register("peas_steamed_stuffed_bun", () -> new BlockItem(PEAS_STEAMED_STUFFED_BUN_BLOCK.get(), new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));
}
