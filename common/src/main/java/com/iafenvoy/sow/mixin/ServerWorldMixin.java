package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.level.ServerWorldProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
    @Shadow
    @Final
    private ServerWorldProperties worldProperties;

    @Inject(method = "tickChunk", at = @At("RETURN"))
    private void onMidnight(WorldChunk chunk, int randomTickSpeed, CallbackInfo ci) {
        if (!SowConfig.INSTANCE.common.songChunkRegen.getValue() || this.worldProperties.getTimeOfDay() % 24000 != 18000)
            return;
        SongChunkData.byChunk(chunk).increaseRemainNotes();
    }
}
