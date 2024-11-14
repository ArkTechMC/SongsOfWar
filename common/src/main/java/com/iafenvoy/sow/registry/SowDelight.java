package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.PeasCanItem;
import com.iafenvoy.sow.item.PeasDelightItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

public class SowDelight {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Item> PEAS_CAN = REGISTRY.register("peas_can", () -> new PeasCanItem());
    public static final RegistrySupplier<Item> PEAS_BURGER = REGISTRY.register("peas_burger", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(4).saturationModifier(1).build())));
    public static final RegistrySupplier<Item> PEAS_CAKE = REGISTRY.register("peas_cake", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).build())));
    public static final RegistrySupplier<Item> PEAS_FLOUR_CAKE = REGISTRY.register("peas_flour_cake", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build())));
    public static final RegistrySupplier<Item> PEAS_ICE_BAR = REGISTRY.register("peas_ice_bar", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(3).saturationModifier(0.33f).build())));
    public static final RegistrySupplier<Item> PEAS_ICE_CREAM = REGISTRY.register("peas_ice_cream", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(4).saturationModifier(1).build())));
    public static final RegistrySupplier<Item> PEAS_MILK_TEA = REGISTRY.register("peas_milk_tea", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8f).build())));
    public static final RegistrySupplier<Item> PEAS_PIE = REGISTRY.register("peas_pie", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(6).saturationModifier(0.33f).build())));
    public static final RegistrySupplier<Item> PEAS_STEAMED_STUFFED_BUN = REGISTRY.register("peas_steamed_stuffed_bun", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build())));
    public static final RegistrySupplier<Item> PEAS_STRING = REGISTRY.register("peas_string", () -> new PeasDelightItem(p -> p.food(new FoodComponent.Builder().hunger(2).saturationModifier(0.75f).snack().build())));
}
