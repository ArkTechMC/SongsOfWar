package com.iafenvoy.sow.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TemporaryBlockItem extends BlockItem {
    public TemporaryBlockItem(Block block) {
        super(block, new Settings());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!stack.isOf(this)) return;
        stack.setCount(0);
    }
}
