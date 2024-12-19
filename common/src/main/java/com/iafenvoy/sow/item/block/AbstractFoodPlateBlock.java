package com.iafenvoy.sow.item.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public abstract class AbstractFoodPlateBlock<T extends Enum<T> & AbstractFoodPlateBlock.FoodType> extends HorizontalFacingBlock {
    protected static final IntProperty ITEM_COUNT = IntProperty.of("item_count", 0, 5);

    public AbstractFoodPlateBlock(Function<Settings, Settings> settings) {
        super(settings.apply(Settings.copy(Blocks.JUNGLE_WOOD)));
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH).with(ITEM_COUNT, 0).with(this.getFoodTypeProperty(), this.getDefaultFoodType()));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, ITEM_COUNT, this.getFoodTypeProperty());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack inHand = player.getStackInHand(hand);
        int i = state.get(ITEM_COUNT);
        EnumProperty<T> foodType = this.getFoodTypeProperty();
        T defaultType = this.getDefaultFoodType();
        FoodType type = state.get(foodType);
        if (inHand.isEmpty()) {
            if (type == defaultType || i == 0)
                return ActionResult.PASS;
            else {
                player.setStackInHand(hand, new ItemStack(type.getItem()));
                if (i > 1) world.setBlockState(pos, state.with(ITEM_COUNT, i - 1), 3);
                else world.setBlockState(pos, state.with(ITEM_COUNT, 0).with(foodType, defaultType), 3);
                return ActionResult.SUCCESS;
            }
        } else {
            T target = this.getFoodTypeFromItem(inHand.getItem());
            if (target != defaultType && (type == defaultType || type == target) && i < target.getMaxPlacement()) {
                world.setBlockState(pos, state.with(ITEM_COUNT, i + 1).with(foodType, target), 3);
                inHand.decrement(1);
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        }
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        dropStack(world, pos, new ItemStack(state.get(this.getFoodTypeProperty()).getItem(), state.get(ITEM_COUNT)));
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }

    protected abstract EnumProperty<T> getFoodTypeProperty();

    protected abstract T getDefaultFoodType();

    protected abstract T getFoodTypeFromItem(Item item);

    protected interface FoodType extends StringIdentifiable {
        Item getItem();

        int getMaxPlacement();
    }
}
