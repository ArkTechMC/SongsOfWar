package com.iafenvoy.sow.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.server.world.ServerWorld;

public class RecipeUtils {
    public static ItemStack findSmeltResult(ServerWorld serverWorld, ItemStack source, PlayerEntity player) {
        ItemStack stack = findResult(serverWorld, RecipeType.SMELTING, source, player);
        if (!stack.isEmpty()) return stack;
        stack = findResult(serverWorld, RecipeType.BLASTING, source, player);
        if (!stack.isEmpty()) return stack;
        stack = findResult(serverWorld, RecipeType.SMOKING, source, player);
        if (!stack.isEmpty()) return stack;
        return ItemStack.EMPTY;
    }

    public static <T extends AbstractCookingRecipe> ItemStack findResult(ServerWorld serverWorld, RecipeType<T> type, ItemStack source, PlayerEntity player) {
        for (T recipe : serverWorld.getRecipeManager().listAllOfType(type))
            if (recipe.getIngredients().size() == 1 && recipe.getIngredients().get(0).test(source) && player.totalExperience >= recipe.getCookTime() * source.getCount() / 20) {
                player.addExperience(-recipe.getCookTime() * source.getCount() / 20);
                ItemStack result = recipe.getOutput(serverWorld.getRegistryManager());
                result.setCount(result.getCount() * source.getCount());
                return result;
            }
        return ItemStack.EMPTY;
    }
}
