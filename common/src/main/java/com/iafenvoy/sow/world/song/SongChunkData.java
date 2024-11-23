package com.iafenvoy.sow.world.song;

import com.iafenvoy.sow.impl.ComponentManager;
import com.iafenvoy.sow.util.Serializable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.chunk.WorldChunk;

public class SongChunkData implements Serializable {
    private boolean fulfilled = false;
    private int maxNotes;
    private int remainNotes;

    @Override
    public void encode(NbtCompound nbt) {
        nbt.putBoolean("fulfilled", this.isFulfilled());
        nbt.putInt("max_notes", this.getMaxNotes());
        nbt.putInt("remain_notes", this.getRemainNotes());
    }

    @Override
    public void decode(NbtCompound nbt) {
        this.setFulfilled(nbt.getBoolean("fulfilled"));
        this.setMaxNotes(nbt.getInt("max_notes"));
        this.setRemainNotes(nbt.getInt("remain_notes"));
    }

    private int getMaxNotes() {
        return this.maxNotes;
    }

    private void setMaxNotes(int maxNotes) {
        this.maxNotes = maxNotes;
    }

    public int getRemainNotes() {
        return this.remainNotes;
    }

    private void setRemainNotes(int remainNotes) {
        this.remainNotes = remainNotes;
    }

    public boolean isFulfilled() {
        return this.fulfilled;
    }

    private void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public void initialize(int remainNotes) {
        if (this.isFulfilled()) return;
        this.setFulfilled(true);
        this.setMaxNotes(remainNotes);
        this.setRemainNotes(remainNotes);
    }

    public boolean decreaseRemainNotes() {
        if (!this.isFulfilled()) return false;
        if (this.remainNotes <= 0) return false;
        this.remainNotes--;
        return true;
    }

    public void increaseRemainNotes() {
        if (!this.isFulfilled()) return;
        if (this.remainNotes >= this.maxNotes) return;
        this.remainNotes++;
    }

    public boolean isEmpty() {
        return this.fulfilled && this.remainNotes <= 0;
    }

    public static SongChunkData byChunk(WorldChunk chunk) {
        if (chunk == null) return new SongChunkData();
        return ComponentManager.getSongChunkData(chunk);
    }
}
