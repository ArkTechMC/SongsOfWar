package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.data.BeaconData;
import dev.architectury.networking.NetworkManager;
import net.minecraft.block.BeaconBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(BeaconBlock.class)
public class BeaconBlockMixin {
    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void handleUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (!(world instanceof ServerWorld serverWorld) || !(player instanceof ServerPlayerEntity serverPlayer))
            return;
        if (world.getBlockEntity(pos) instanceof BeaconBlockEntity) {
            BeaconData beaconData = BeaconData.getInstance(serverWorld);
            Optional<BeaconData.SingleBeaconData> optional = beaconData.get(pos);
            if (optional.isPresent()) {
                PacketByteBuf buf = PacketBufferUtils.create();
                buf.writeBlockPos(pos);
                buf.writeNbt(beaconData.writeNbt(new NbtCompound()));
                NetworkManager.sendToPlayer(serverPlayer, Static.BEACON_TELEPORT, buf);
                cir.setReturnValue(ActionResult.CONSUME);
            }
        }
    }

    @Inject(method = "onPlaced", at = @At("HEAD"))
    private void handlePlace(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, CallbackInfo ci) {
        if (itemStack.hasCustomName())
            if (world instanceof ServerWorld serverWorld)
                BeaconData.getInstance(serverWorld).add(pos, itemStack.getName());
    }
}
