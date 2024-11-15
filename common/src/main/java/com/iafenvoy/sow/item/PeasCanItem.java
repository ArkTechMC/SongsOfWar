package com.iafenvoy.sow.item;

import com.iafenvoy.sow.entity.ardoni.ThalleousEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PeasCanItem extends PeasDelightItem {
    public PeasCanItem() {
        super(p -> p.food(new FoodComponent.Builder().alwaysEdible().hunger(4).saturationModifier(0.5f).snack().build()));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.sow.peas_can.tooltip"));
    }


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof ThalleousEntity thalleous) {
            thalleous.equipStack(EquipmentSlot.HEAD, stack.copyWithCount(1));
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
