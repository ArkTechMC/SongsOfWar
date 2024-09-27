package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.registry.SowBlocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;

public class PeasBlock extends CropBlock {
    public PeasBlock() {
        super(Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return SowBlocks.PEAS.get();
    }
}
