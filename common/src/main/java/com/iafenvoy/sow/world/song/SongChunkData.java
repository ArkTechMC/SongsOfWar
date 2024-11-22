package com.iafenvoy.sow.world.song;

import com.iafenvoy.sow.impl.ComponentManager;
import com.iafenvoy.sow.util.Serializable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.chunk.WorldChunk;

public class SongChunkData implements Serializable {
    private boolean fulfilled = false;
    private int remainNotes;

    @Override
    public void encode(NbtCompound nbt) {
        nbt.putBoolean("fulfilled", this.isFulfilled());
        nbt.putInt("remain_notes", this.getRemainNotes());
    }

    @Override
    public void decode(NbtCompound nbt) {
        this.setFulfilled(nbt.getBoolean("fulfilled"));
        this.setRemainNotes(nbt.getInt("remain_notes"));
    }

    public int getRemainNotes() {
        return this.remainNotes;
    }

    public void setRemainNotes(int remainNotes) {
        this.remainNotes = remainNotes;
    }

    public boolean isFulfilled() {
        return this.fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public boolean reduceRemainNotes() {
        if (this.remainNotes <= 0) return false;
        this.remainNotes--;
        return true;
    }

    public boolean isEmpty() {
        return this.fulfilled && this.remainNotes <= 0;
    }

    public static SongChunkData byChunk(WorldChunk chunk) {
        return ComponentManager.getSongChunkData(chunk);
    }
}
