package com.iafenvoy.sow.impl.forge;

import com.iafenvoy.sow.forge.component.SongChunkDataProvider;
import com.iafenvoy.sow.forge.component.SongChunkDataStorage;
import com.iafenvoy.sow.forge.component.SongPowerDataProvider;
import com.iafenvoy.sow.forge.component.SongPowerDataStorage;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.NotNull;

public class ComponentManagerImpl {
    public static SongPowerData getSongPowerData(@NotNull PlayerEntity player) {
        return player.getCapability(SongPowerDataProvider.CAPABILITY).resolve().map(SongPowerDataStorage::getData).orElse(new SongPowerData(player));
    }

    public static SongChunkData getSongChunkData(@NotNull WorldChunk chunk) {
        return chunk.getCapability(SongChunkDataProvider.CAPABILITY).resolve().map(SongChunkDataStorage::getData).orElse(new SongChunkData());
    }
}
