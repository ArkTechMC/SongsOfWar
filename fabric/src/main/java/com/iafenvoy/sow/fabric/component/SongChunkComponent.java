package com.iafenvoy.sow.fabric.component;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.world.song.SongChunkData;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.chunk.Chunk;
import org.jetbrains.annotations.NotNull;

public class SongChunkComponent implements ComponentV3 {
    public static final ComponentKey<SongChunkComponent> SONG_CHUNK_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(SongsOfWar.MOD_ID, "song_chunk_data"), SongChunkComponent.class);

    private final Chunk chunk;
    private final SongChunkData data;

    public SongChunkComponent(Chunk chunk) {
        this.chunk = chunk;
        this.data = new SongChunkData();
    }

    public Chunk getChunk() {
        return this.chunk;
    }

    public SongChunkData getData() {
        return this.data;
    }

    @Override
    public void readFromNbt(@NotNull NbtCompound tag) {
        this.data.decode(tag);
    }

    @Override
    public void writeToNbt(@NotNull NbtCompound tag) {
        this.data.encode(tag);
    }
}
