package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import com.iafenvoy.sow.registry.SowTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ArdoniGraveBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    public ArdoniGraveBlock() {
        super(Settings.copy(Blocks.STONE).luminance(state -> state.get(ACTIVATED) ? 15 : 0).emissiveLighting((state, world, pos) -> state.get(ACTIVATED)));
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH).with(ACTIVATED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, ACTIVATED);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ArdoniGraveBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).isIn(SowTags.MASTER_STAFF)) {
            boolean activated = state.get(ACTIVATED);
            world.setBlockState(pos, state.with(ACTIVATED, !activated));
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> VoxelShapes.cuboid(0.25, 0, 0.75, 0.75, 0.75, 0.875);
            case SOUTH -> VoxelShapes.cuboid(0.25, 0, 0.125, 0.75, 0.75, 0.25);
            case WEST -> VoxelShapes.cuboid(0.75, 0, 0.25, 0.875, 0.75, 0.75);
            case EAST -> VoxelShapes.cuboid(0.125, 0, 0.25, 0.25, 0.75, 0.75);
            case DOWN, UP -> VoxelShapes.empty();
        };
    }
}
