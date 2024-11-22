package com.iafenvoy.sow.item;

import com.iafenvoy.sow.item.block.AbstractSongCubeBlock;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class SongCubeItem extends BlockItem {
    private final AbstractSongCubeBlock block;

    public SongCubeItem(AbstractSongCubeBlock block) {
        super(block, new Item.Settings().rarity(Rarity.EPIC).maxCount(1).arch$tab(SowItemGroups.POWER));
        this.block = block;
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        this.block.getCategory().randomOne().appendNbt(stack);
    }
}
