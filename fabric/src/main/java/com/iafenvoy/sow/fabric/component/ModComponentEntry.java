package com.iafenvoy.sow.fabric.component;

import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;

public class ModComponentEntry implements EntityComponentInitializer, ChunkComponentInitializer {
    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(SongPowerComponent.SONG_POWER_COMPONENT, SongPowerComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }

    @Override
    public void registerChunkComponentFactories(ChunkComponentFactoryRegistry registry) {
        registry.register(SongChunkComponent.SONG_CHUNK_COMPONENT, SongChunkComponent::new);
    }
}
