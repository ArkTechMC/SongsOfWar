package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.AbstractSongCubeBlockEntity;
import com.iafenvoy.sow.item.block.entity.AggressiumSongCubeBlockEntity;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.registry.SowBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AggressiumSongCubeBlock extends AbstractSongCubeBlock {
    public AggressiumSongCubeBlock() {
        super(PowerCategory.AGGRESSIUM);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AggressiumSongCubeBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, SowBlockEntities.AGGRESSIUM_SONG_TYPE.get(), AbstractSongCubeBlockEntity::tick);
    }
}
