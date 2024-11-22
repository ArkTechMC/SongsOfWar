package com.iafenvoy.sow.impl.fabric;

import com.iafenvoy.sow.fabric.component.SongChunkComponent;
import com.iafenvoy.sow.fabric.component.SongPowerComponent;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.chunk.WorldChunk;

public class ComponentManagerImpl {
    public static SongPowerData getSongPowerData(PlayerEntity player) {
        return SongPowerComponent.SONG_POWER_COMPONENT.get(player).getData();
    }

    public static SongChunkData getSongChunkData(WorldChunk chunk) {
        return SongChunkComponent.SONG_CHUNK_COMPONENT.get(chunk).getData();
    }
}
