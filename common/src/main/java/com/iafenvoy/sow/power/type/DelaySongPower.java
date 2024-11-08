package com.iafenvoy.sow.power.type;

import com.iafenvoy.neptune.util.Timeout;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerDataHolder;

public final class DelaySongPower extends AbstractSongPower<DelaySongPower> {
    private int delay = 0;

    public DelaySongPower(String id, PowerCategory category) {
        super(id, category);
    }

    public DelaySongPower setDelay(int delay) {
        this.delay = delay;
        return this;
    }

    @Override
    public int getPrimaryCooldown(SongPowerDataHolder data) {
        return super.getPrimaryCooldown(data) + this.delay;
    }

    @Override
    protected boolean applyInternal(SongPowerDataHolder holder) {
        playSound(holder, this.applySound);
        holder.cooldown();
        Timeout.create(this.delay, () -> this.apply.accept(holder));
        return true;
    }

    @Override
    protected PowerType getType() {
        return PowerType.DELAY;
    }

    @Override
    protected DelaySongPower get() {
        return this;
    }
}
