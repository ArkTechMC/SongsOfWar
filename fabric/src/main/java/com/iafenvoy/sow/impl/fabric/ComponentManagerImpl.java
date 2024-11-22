package com.iafenvoy.sow.impl.fabric;

import com.iafenvoy.sow.fabric.component.SongChunkComponent;
import com.iafenvoy.sow.fabric.component.SongPowerComponent;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.NotNull;

public class ComponentManagerImpl {
    public static SongPowerData getSongPowerData(@NotNull PlayerEntity player) {
        return SongPowerComponent.SONG_POWER_COMPONENT.get(player).getData();
    }

    public static SongChunkData getSongChunkData(@NotNull WorldChunk chunk) {
        return SongChunkComponent.SONG_CHUNK_COMPONENT.get(chunk).getData();
    }
}
