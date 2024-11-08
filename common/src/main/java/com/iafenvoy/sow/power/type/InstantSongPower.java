package com.iafenvoy.sow.power.type;

import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerDataHolder;

public final class InstantSongPower extends AbstractSongPower<InstantSongPower> {
    public InstantSongPower(String id, PowerCategory category) {
        super(id, category);
    }

    @Override
    protected boolean applyInternal(SongPowerDataHolder holder) {
        this.apply.accept(holder);
        if (holder.isCancelled()) return false;
        holder.cooldown();
        playSound(holder, this.applySound);
        return true;
    }

    @Override
    protected PowerType getType() {
        return PowerType.INSTANT;
    }

    @Override
    protected InstantSongPower get() {
        return this;
    }
}
