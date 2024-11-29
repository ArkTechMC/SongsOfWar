package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.registry.SowBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class MobiliumSongCubeBlockEntity extends AbstractSongCubeBlockEntity {
    public MobiliumSongCubeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.MOBILIUM_SONG_TYPE.get(), pos, state);
    }

    @Override
    protected PowerCategory getCategory() {
        return PowerCategory.MOBILIUM;
    }
}
