package com.iafenvoy.sow.util;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.server.world.ServerWorld;

public class RecipeUtils {
    public static ItemStack findSmeltResult(ServerWorld serverWorld, ItemStack source) {
        ItemStack stack = findResult(serverWorld, RecipeType.SMELTING, source);
        if (!stack.isEmpty()) return stack;
        stack = findResult(serverWorld, RecipeType.BLASTING, source);
        if (!stack.isEmpty()) return stack;
        stack = findResult(serverWorld, RecipeType.SMOKING, source);
        if (!stack.isEmpty()) return stack;
        return ItemStack.EMPTY;
    }

    public static <T extends AbstractCookingRecipe> ItemStack findResult(ServerWorld serverWorld, RecipeType<T> type, ItemStack source) {
        for (T recipe : serverWorld.getRecipeManager().listAllOfType(type))
            if (recipe.getIngredients().size() == 1 && recipe.getIngredients().get(0).test(source)) {
                ItemStack result = recipe.getOutput(serverWorld.getRegistryManager());
                result.setCount(result.getCount() * source.getCount());
                return result;
            }
        return ItemStack.EMPTY;
    }
}
