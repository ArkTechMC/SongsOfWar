package com.iafenvoy.sow.impl.forge;

import com.iafenvoy.sow.forge.component.SongChunkDataProvider;
import com.iafenvoy.sow.forge.component.SongChunkDataStorage;
import com.iafenvoy.sow.forge.component.SongPowerDataProvider;
import com.iafenvoy.sow.forge.component.SongPowerDataStorage;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.chunk.WorldChunk;

public class ComponentManagerImpl {
    public static SongPowerData getSongPowerData(PlayerEntity player) {
        return player.getCapability(SongPowerDataProvider.CAPABILITY).resolve().map(SongPowerDataStorage::getData).orElse(new SongPowerData(player));
    }

    public static SongChunkData getSongChunkData(WorldChunk chunk) {
        return chunk.getCapability(SongChunkDataProvider.CAPABILITY).resolve().map(SongChunkDataStorage::getData).orElse(new SongChunkData());
    }
}
