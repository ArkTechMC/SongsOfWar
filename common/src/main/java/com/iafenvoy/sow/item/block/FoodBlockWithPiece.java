package com.iafenvoy.sow.item.block;

import com.mojang.datafixers.util.Pair;
import dev.architectury.platform.Platform;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class FoodBlockWithPiece extends Block {
    public static final IntProperty BITES = Properties.BITES;
    private final int maxBite;
    private final FoodComponent food;

    public FoodBlockWithPiece(Function<Settings, Settings> settings, int maxBite, FoodComponent food) {
        super(settings.apply(Settings.copy(Blocks.CAKE)));
        this.maxBite = maxBite;
        this.food = food;
        this.setDefaultState(this.getStateManager().getDefaultState().with(BITES, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(BITES);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.canConsume(this.food.isAlwaysEdible()))
            return ActionResult.PASS;
        else {
            player.getHungerManager().add(this.food.getHunger(), this.food.getSaturationModifier());
            for (Pair<StatusEffectInstance, Float> pair : this.food.getStatusEffects())
                if (player.getRandom().nextDouble() < pair.getSecond())
                    player.addStatusEffect(pair.getFirst());
            int i = state.get(BITES);
            world.emitGameEvent(player, GameEvent.EAT, pos);
            if (i < this.maxBite)
                world.setBlockState(pos, state.with(BITES, i + 1), 3);
            else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
            return ActionResult.SUCCESS;
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        if (!Platform.isModLoaded("farmersdelight"))
            tooltip.add(Text.translatable("item.sow.tooltip.require.delight"));
    }
}
