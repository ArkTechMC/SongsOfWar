package com.iafenvoy.sow.compat.emi;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.SongStoneItem;
import com.iafenvoy.sow.registry.SowItems;
import dev.emi.emi.EmiUtil;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;

@EmiEntrypoint
public class SowAnvilRecipePlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addRecipe(new SowAnvilRecipe());
    }

    public static class SowAnvilRecipe implements EmiRecipe {
        private static final List<Item> allWeapons = Registries.ITEM.stream().filter(x -> x instanceof SwordItem || x instanceof AxeItem).toList();
        private static final List<SongStoneItem> allStones = Registries.ITEM.stream().filter(x -> x instanceof SongStoneItem).map(x -> (SongStoneItem) x).toList();
        private final Identifier id = new Identifier(SongsOfWar.MOD_ID, "sow_anvil");
        private final int unique = EmiUtil.RANDOM.nextInt();
        private Item lastWeapon = Items.AIR;
        private SongStoneItem lastIngredient = (SongStoneItem) SowItems.SONG_STONE_RED.get();

        @Override
        public EmiRecipeCategory getCategory() {
            return VanillaEmiRecipeCategories.ANVIL_REPAIRING;
        }

        @Override
        public Identifier getId() {
            return this.id;
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of(EmiIngredient.of(allWeapons.stream().map(Ingredient::ofItems).map(EmiIngredient::of).toList()), EmiIngredient.of(allStones.stream().map(Ingredient::ofItems).map(EmiIngredient::of).toList()));
        }

        @Override
        public List<EmiStack> getOutputs() {
            return List.of(EmiStack.of(Items.AIR));
        }

        @Override
        public boolean supportsRecipeTree() {
            return false;
        }

        @Override
        public int getDisplayWidth() {
            return 125;
        }

        @Override
        public int getDisplayHeight() {
            return 18;
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addTexture(EmiTexture.PLUS, 27, 3);
            widgets.addTexture(EmiTexture.EMPTY_ARROW, 75, 1);
            widgets.addGeneratedSlot(r -> EmiIngredient.of(Ingredient.ofItems(this.lastWeapon = RandomHelper.randomOne(r, allWeapons))), this.unique, 0, 0);
            widgets.addGeneratedSlot(r -> EmiIngredient.of(Ingredient.ofItems(this.lastIngredient = RandomHelper.randomOne(r, allStones))), this.unique, 49, 0);
            widgets.addGeneratedSlot(r -> EmiIngredient.of(Ingredient.ofStacks(this.lastIngredient.getInfo().apply(new ItemStack(this.lastWeapon)))), this.unique, 107, 0).recipeContext(this);
        }
    }
}
