package com.iafenvoy.sow.impl;

import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.world.song.SongChunkData;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;

public class ComponentManager {
    @ExpectPlatform
    public static SongPowerData getSongPowerData(PlayerEntity player) {
        throw new AssertionError("This method should be replaced by Architectury");
    }

    @ExpectPlatform
    public static SongChunkData getSongChunkData(WorldChunk chunk){
        throw new AssertionError("This method should be replaced by Architectury");
    }
}
