package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.item.NoteItem;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.world.song.SongChunkManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.NoteBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @Inject(method = "playNote", at = @At("RETURN"))
    private void dropNote(@Nullable Entity entity, BlockState state, World world, BlockPos pos, CallbackInfo ci) {
        if (entity == null) return;
        if (!(world instanceof ServerWorld serverWorld) || !(entity instanceof PlayerEntity player)) return;
        if (!SongPowerData.byPlayer(player).isEnabled()) return;
        ChunkPos chunkPos = new ChunkPos(pos);
        PowerCategory category = SongChunkManager.find(serverWorld, chunkPos);
        if (category == null) return;
        BlockPos above = pos.up();
        if (serverWorld.getBlockState(above).isSolidBlock(serverWorld, above)) return;
        if (serverWorld.getRandom().nextInt(50) == 0 && SongChunkManager.reduce(serverWorld, chunkPos)) {
            Vec3d vec3d = above.toCenterPos();
            ItemEntity item = new ItemEntity(serverWorld, vec3d.x, vec3d.y, vec3d.z, new ItemStack(NoteItem.getItem(category)));
            world.spawnEntity(item);
        }
    }
}
