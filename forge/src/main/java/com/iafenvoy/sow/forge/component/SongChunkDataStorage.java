package com.iafenvoy.sow.forge.component;

import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.nbt.NbtCompound;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

@AutoRegisterCapability
public class SongChunkDataStorage implements INBTSerializable<NbtCompound> {
    private final SongChunkData chunkData = new SongChunkData();

    @Override
    public NbtCompound serializeNBT() {
        return this.chunkData.encode();
    }

    @Override
    public void deserializeNBT(NbtCompound compound) {
        this.chunkData.decode(compound);
    }

    public SongChunkData getData() {
        return this.chunkData;
    }
}
