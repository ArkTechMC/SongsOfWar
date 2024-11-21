package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.TemporaryTransparentBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class TemporaryTransparentBlock extends GlassBlock implements BlockEntityProvider {
    public TemporaryTransparentBlock(Function<Settings, Settings> settings) {
        super(settings.apply(Settings.copy(Blocks.GLASS)));
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TemporaryTransparentBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> TemporaryTransparentBlockEntity.tick(world1, pos, state1, (TemporaryTransparentBlockEntity) blockEntity);
    }

    public static void place(World world, BlockPos pos, BlockState state, int tick) {
        BlockState s = world.getBlockState(pos);
        world.setBlockState(pos, state, 2, 0);
        if (world.getBlockEntity(pos) instanceof TemporaryTransparentBlockEntity blockEntity) {
            blockEntity.setTick(tick);
            blockEntity.setState(s);
        }
    }
}
