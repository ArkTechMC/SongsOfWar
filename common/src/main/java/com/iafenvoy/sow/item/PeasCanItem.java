package com.iafenvoy.sow.item;

import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PeasCanItem extends Item {
    public PeasCanItem() {
        super(new Item.Settings().arch$tab(SowItemGroups.ITEMS).food(new FoodComponent.Builder().alwaysEdible().hunger(4).snack().build()));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.sow.peas_can.tooltip"));
    }
}
