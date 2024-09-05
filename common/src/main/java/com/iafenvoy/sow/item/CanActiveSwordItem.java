package com.iafenvoy.sow.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Function;

public class CanActiveSwordItem extends SowSwordItem {
    public static final String ACTIVE_KEY = "active";

    public CanActiveSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Function<Settings, Settings> settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            ItemStack stack = user.getStackInHand(hand);
            stack.getOrCreateNbt().putBoolean(ACTIVE_KEY, !stack.getOrCreateNbt().getBoolean(ACTIVE_KEY));
            return TypedActionResult.success(stack);
        }
        return super.use(world, user, hand);
    }
}
