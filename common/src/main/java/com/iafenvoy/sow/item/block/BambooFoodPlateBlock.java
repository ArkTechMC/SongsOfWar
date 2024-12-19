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

public class BambooFoodPlateBlock extends AbstractFoodPlateBlock<BambooFoodPlateBlock.BambooPlateFoodType> {
    protected static final EnumProperty<BambooPlateFoodType> FOOD_TYPE = EnumProperty.of("food_type", BambooPlateFoodType.class);

    public BambooFoodPlateBlock() {
        super(p -> p);
    }

    @Override
    protected EnumProperty<BambooPlateFoodType> getFoodTypeProperty() {
        return FOOD_TYPE;
    }

    @Override
    protected BambooPlateFoodType getDefaultFoodType() {
        return BambooPlateFoodType.NONE;
    }

    @Override
    protected BambooPlateFoodType getFoodTypeFromItem(Item item) {
        return Arrays.stream(BambooPlateFoodType.values()).filter(x -> x.getItem() == item).findFirst().orElse(BambooPlateFoodType.NONE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.09375, 0, 0.09375, 0.90625, 0.125, 0.90625);
    }

    protected enum BambooPlateFoodType implements FoodType {
        NONE("none", () -> Items.AIR, 0),
        PEAS_STEAMED_STUFFED_BUN("peas_steamed_stuffed_bun", SowDelight.PEAS_STEAMED_STUFFED_BUN, 5),
        PEAS_PASTRY("peas_pastry", SowDelight.PEAS_PASTRY, 4);

        private final String id;
        private final Supplier<Item> item;
        private final int maxPlacement;

        BambooPlateFoodType(String id, Supplier<Item> item, int maxPlacement) {
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
