package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.registry.SowDelight;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class FoodPlateBlock extends HorizontalFacingBlock {
    protected static final IntProperty ITEM_COUNT = IntProperty.of("item_count", 0, 4);
    protected static final EnumProperty<FoodType> FOOD_TYPE = EnumProperty.of("food_type", FoodType.class);

    public FoodPlateBlock(Function<Settings, Settings> settings) {
        super(settings.apply(Settings.copy(Blocks.JUNGLE_WOOD)));
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH).with(ITEM_COUNT, 0).with(FOOD_TYPE, FoodType.NONE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, ITEM_COUNT, FOOD_TYPE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack inHand = player.getStackInHand(hand);
        int i = state.get(ITEM_COUNT);
        FoodType type = state.get(FOOD_TYPE);
        if (inHand.isEmpty()) {
            if (state.get(FOOD_TYPE) == FoodType.NONE || i == 0)
                return ActionResult.PASS;
            else {
                player.setStackInHand(hand, new ItemStack(type.getItem()));
                if (i > 1) world.setBlockState(pos, state.with(ITEM_COUNT, i - 1), 3);
                else world.setBlockState(pos, state.with(ITEM_COUNT, 0).with(FOOD_TYPE, FoodType.NONE), 3);
                return ActionResult.SUCCESS;
            }
        } else {
            FoodType target = FoodType.resolveType(inHand.getItem());
            if (target != FoodType.NONE && (type == FoodType.NONE || type == target) && i < target.maxPlacement) {
                world.setBlockState(pos, state.with(ITEM_COUNT, i + 1).with(FOOD_TYPE, target), 3);
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
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0, 0, 0, 1, 0.125, 1);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        dropStack(world, pos, new ItemStack(state.get(FOOD_TYPE).getItem(), state.get(ITEM_COUNT)));
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }

    protected enum FoodType implements StringIdentifiable {
        NONE("none", () -> Items.AIR, 0),
        PEAS_STRING("peas_string", SowDelight.PEAS_STRING, 3),
        PEAS_FLOUR_CAKE("peas_flour_cake", SowDelight.PEAS_FLOUR_CAKE, 4);

        private final String id;
        private final Supplier<Item> item;
        private final int maxPlacement;

        FoodType(String id, Supplier<Item> item, int maxPlacement) {
            this.id = id;
            this.item = item;
            this.maxPlacement = maxPlacement;
        }

        @Override
        public String asString() {
            return this.id;
        }

        public Item getItem() {
            return this.item.get();
        }

        public int getMaxPlacement() {
            return this.maxPlacement;
        }

        public boolean match(Item item) {
            return item == this.getItem();
        }

        public static FoodType resolveType(Item item) {
            return Arrays.stream(values()).filter(x -> x.getItem() == item).findFirst().orElse(NONE);
        }
    }
}
