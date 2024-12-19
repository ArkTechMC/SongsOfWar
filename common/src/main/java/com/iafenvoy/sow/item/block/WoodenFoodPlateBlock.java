package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.registry.SowDelight;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Arrays;
import java.util.function.Supplier;

public class WoodenFoodPlateBlock extends AbstractFoodPlateBlock<WoodenFoodPlateBlock.WoodenPlateFoodType> {
    protected static final EnumProperty<WoodenPlateFoodType> FOOD_TYPE = EnumProperty.of("food_type", WoodenPlateFoodType.class);

    public WoodenFoodPlateBlock() {
        super(p -> p);
    }

    @Override
    protected EnumProperty<WoodenPlateFoodType> getFoodTypeProperty() {
        return FOOD_TYPE;
    }

    @Override
    protected WoodenPlateFoodType getDefaultFoodType() {
        return WoodenPlateFoodType.NONE;
    }

    @Override
    protected WoodenPlateFoodType getFoodTypeFromItem(Item item) {
        return Arrays.stream(WoodenPlateFoodType.values()).filter(x -> x.getItem() == item).findFirst().orElse(WoodenPlateFoodType.NONE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0, 0, 0, 1, 0.125, 1);
    }

    protected enum WoodenPlateFoodType implements FoodType {
        NONE("none", () -> Items.AIR, 0),
        PEAS_STRING("peas_string", SowDelight.PEAS_STRING, 3),
        PEAS_FLOUR_CAKE("peas_flour_cake", SowDelight.PEAS_FLOUR_CAKE, 4),
        PEAS_STEWIE("peas_stewie", SowDelight.PEAS_STEWIE, 4);

        private final String id;
        private final Supplier<Item> item;
        private final int maxPlacement;

        WoodenPlateFoodType(String id, Supplier<Item> item, int maxPlacement) {
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

        @Override
        public int getMaxPlacement() {
            return this.maxPlacement;
        }
    }
}
