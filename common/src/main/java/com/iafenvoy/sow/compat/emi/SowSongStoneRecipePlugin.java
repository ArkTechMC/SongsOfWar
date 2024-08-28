package com.iafenvoy.sow.compat.emi;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.SongStoneItem;
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
public class SowSongStoneRecipePlugin implements EmiPlugin {
    private static final List<Item> allWeapons = Registries.ITEM.stream().filter(x -> x instanceof SwordItem || x instanceof AxeItem).toList();
    private static final List<SongStoneItem> allStones = Registries.ITEM.stream().filter(x -> x instanceof SongStoneItem).map(x -> (SongStoneItem) x).toList();

    @Override
    public void register(EmiRegistry registry) {
        for (SongStoneItem songStone : allStones) {
            registry.addRecipe(new SowAnvilRecipe(songStone));
            registry.addRecipe(new SowGrindstoneRecipe(songStone));
        }
    }

    private static class SowAnvilRecipe implements EmiRecipe {
        private final Identifier id;
        private final SongStoneItem songStone;
        private final int unique = EmiUtil.RANDOM.nextInt();
        private Item lastWeapon = Items.AIR;

        private SowAnvilRecipe(SongStoneItem songStone) {
            this.id = new Identifier(SongsOfWar.MOD_ID, "sow_anvil_" + songStone.getInfo().getId());
            this.songStone = songStone;
        }

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
            return List.of(EmiIngredient.of(allWeapons.stream().map(Ingredient::ofItems).map(EmiIngredient::of).toList()), EmiIngredient.of(Ingredient.ofItems(this.songStone)));
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
            widgets.addSlot(EmiIngredient.of(Ingredient.ofItems(this.songStone)), 49, 0);
            widgets.addGeneratedSlot(r -> EmiIngredient.of(Ingredient.ofStacks(this.songStone.getInfo().apply(new ItemStack(this.lastWeapon)))), this.unique, 107, 0).recipeContext(this);
        }
    }

    private static class SowGrindstoneRecipe implements EmiRecipe {
        private static final Identifier BACKGROUND = new Identifier("minecraft", "textures/gui/container/grindstone.png");
        private final int unique = EmiUtil.RANDOM.nextInt();
        private final SongStoneItem songStone;
        private final Identifier id;
        private Item lastWeapon = Items.AIR;

        public SowGrindstoneRecipe(SongStoneItem songStone) {
            this.songStone = songStone;
            this.id = new Identifier(SongsOfWar.MOD_ID, "sow_grindstone_" + songStone.getInfo().getId());
        }

        @Override
        public EmiRecipeCategory getCategory() {
            return VanillaEmiRecipeCategories.GRINDING;
        }

        @Override
        public Identifier getId() {
            return this.id;
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of();
        }

        @Override
        public List<EmiStack> getOutputs() {
            return List.of();
        }

        @Override
        public boolean supportsRecipeTree() {
            return false;
        }

        @Override
        public int getDisplayWidth() {
            return 116;
        }

        @Override
        public int getDisplayHeight() {
            return 56;
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addTexture(BACKGROUND, 0, 0, 116, 56, 30, 15);
            widgets.addGeneratedSlot(r -> EmiIngredient.of(Ingredient.ofStacks(this.songStone.getInfo().apply(new ItemStack(this.lastWeapon = RandomHelper.randomOne(r, allWeapons))))), this.unique, 18, 3).drawBack(false);
            widgets.addGeneratedSlot(r -> EmiIngredient.of(Ingredient.ofStacks(new ItemStack(this.lastWeapon))), this.unique, 98, 18).drawBack(false).recipeContext(this);
        }
    }
}
