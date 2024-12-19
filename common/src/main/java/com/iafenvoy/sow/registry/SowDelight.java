package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.PeasCanItem;
import com.iafenvoy.sow.item.PeasDelightItem;
import com.iafenvoy.sow.item.block.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.shape.VoxelShapes;

@SuppressWarnings("unused")
public final class SowDelight {
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK);

    public static final RegistrySupplier<Item> PEAS_CAN = ITEM_REGISTRY.register("peas_can", PeasCanItem::new);

    public static final RegistrySupplier<Block> WOODEN_FOOD_PLATE = BLOCK_REGISTRY.register("wooden_food_plate", WoodenFoodPlateBlock::new);
    public static final RegistrySupplier<Item> WOODEN_FOOD_PLATE_ITEM = ITEM_REGISTRY.register("wooden_food_plate", () -> new BlockItem(WOODEN_FOOD_PLATE.get(), new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));
    public static final RegistrySupplier<Item> PEAS_STRING = ITEM_REGISTRY.register("peas_string", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).snack().build())));
    public static final RegistrySupplier<Item> PEAS_FLOUR_CAKE = ITEM_REGISTRY.register("peas_flour_cake", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build())));
    public static final RegistrySupplier<Item> PEAS_STEWIE = ITEM_REGISTRY.register("peas_stewie", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(1).saturationModifier(0.33f).build())));

    public static final RegistrySupplier<Block> PEAS_PIE = BLOCK_REGISTRY.register("peas_pie", PeasPieBlock::new);
    public static final RegistrySupplier<Item> PEAS_PIE_ITEM = ITEM_REGISTRY.register("peas_pie", () -> new BlockItem(PEAS_PIE.get(), new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));

    public static final RegistrySupplier<Block> PEAS_PIZZA = BLOCK_REGISTRY.register("peas_pizza", PeasPizzaBlock::new);
    public static final RegistrySupplier<Item> PEAS_PIZZA_ITEM = ITEM_REGISTRY.register("peas_pizza", () -> new BlockItem(PEAS_PIZZA.get(), new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));

    public static final RegistrySupplier<Block> PEAS_BURGER = BLOCK_REGISTRY.register("peas_burger", () -> new SimplePickableFoodBlock(AbstractBlock.Settings.copy(Blocks.CAKE), VoxelShapes.cuboid(0, 0, 0, 1, 0.875, 1)));
    public static final RegistrySupplier<Item> PEAS_BURGER_ITEM = ITEM_REGISTRY.register("peas_burger", () -> new BlockItem(PEAS_BURGER.get(), new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1).build()).arch$tab(SowItemGroups.PEAS_DELIGHT)));

    public static final RegistrySupplier<Block> PEAS_CAKE = BLOCK_REGISTRY.register("peas_cake", () -> new SimplePickableFoodBlock(AbstractBlock.Settings.copy(Blocks.CAKE),VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.125, 0.875)));
    public static final RegistrySupplier<Item> PEAS_CAKE_ITEM = ITEM_REGISTRY.register("peas_cake", () -> new BlockItem(PEAS_CAKE.get(), new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).build()).arch$tab(SowItemGroups.PEAS_DELIGHT)));

    public static final RegistrySupplier<Block> BAMBOO_FOOD_PLATE = BLOCK_REGISTRY.register("bamboo_food_plate", BambooFoodPlateBlock::new);
    public static final RegistrySupplier<Item> BAMBOO_FOOD_PLATE_ITEM = ITEM_REGISTRY.register("bamboo_food_plate", () -> new BlockItem(BAMBOO_FOOD_PLATE.get(), new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));
    public static final RegistrySupplier<Item> PEAS_STEAMED_STUFFED_BUN = ITEM_REGISTRY.register("peas_steamed_stuffed_bun", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build())));
    public static final RegistrySupplier<Item> PEAS_PASTRY = ITEM_REGISTRY.register("peas_pastry", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(4).saturationModifier(0.33f).build())));

    public static final RegistrySupplier<Item> PEAS_ICE_BAR = ITEM_REGISTRY.register("peas_ice_bar", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(3).saturationModifier(0.33f).build())));
    public static final RegistrySupplier<Item> PEAS_ICE_CREAM = ITEM_REGISTRY.register("peas_ice_cream", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(4).saturationModifier(1).build())));
    public static final RegistrySupplier<Item> PEAS_MILK_TEA = ITEM_REGISTRY.register("peas_milk_tea", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8f).build())));
}
