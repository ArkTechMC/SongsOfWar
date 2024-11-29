package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.MobiliumSongCubeBlockEntity;
import com.iafenvoy.sow.power.PowerCategory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class MobiliumSongCubeBlock extends AbstractSongCubeBlock {
    public MobiliumSongCubeBlock() {
        super(PowerCategory.MOBILIUM);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MobiliumSongCubeBlockEntity(pos, state);
    }
}
