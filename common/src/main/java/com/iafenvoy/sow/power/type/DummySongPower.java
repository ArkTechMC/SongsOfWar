package com.iafenvoy.sow.power.type;

import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerDataHolder;

public non-sealed abstract class DummySongPower extends AbstractSongPower<DummySongPower> {
    public static final DummySongPower EMPTY = new DummySongPower("", null) {
        @Override
        protected boolean applyInternal(SongPowerDataHolder holder) {
            return true;
        }
    };

    public DummySongPower(String id, PowerCategory category) {
        super(id, category);
    }

    @Override
    protected PowerType getType() {
        return PowerType.DUMMY;
    }

    @Override
    protected DummySongPower get() {
        return this;
    }
}
