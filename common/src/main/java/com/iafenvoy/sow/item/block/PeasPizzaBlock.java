package com.iafenvoy.sow.item.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.List;

public class PeasPizzaBlock extends FoodBlockWithPiece {
    private static final List<VoxelShape> SHAPES = List.of(
            VoxelShapes.cuboid(0.5, 0, 0, 1, 0.125, 0.5),
            VoxelShapes.cuboid(0.5, 0, 0.5, 1, 0.125, 1),
            VoxelShapes.cuboid(0, 0, 0, 0.5, 0.125, 0.5),
            VoxelShapes.cuboid(0, 0, 0.5, 0.5, 0.125, 1)
    );

    public PeasPizzaBlock() {
        super(p -> p, 3, new FoodComponent.Builder().hunger(6).saturationModifier(0.33f).build());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();
        for (int i = 3 - state.get(BITES); i >= 0; i--)
            shape = VoxelShapes.union(shape, SHAPES.get(i));
        return shape;
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.cuboid(0, 0, 0, 0, 0, 0);
    }
}
