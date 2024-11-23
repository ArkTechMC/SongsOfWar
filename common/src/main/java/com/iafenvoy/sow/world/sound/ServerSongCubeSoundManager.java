package com.iafenvoy.sow.world.sound;

import com.iafenvoy.sow.power.PowerCategory;
import net.minecraft.util.math.BlockPos;

public enum ServerSongCubeSoundManager implements SongCubeSoundManager {
    INSTANCE;

    @Override
    public void startPlaying(BlockPos pos, PowerCategory category) {
    }

    @Override
    public void destroy(BlockPos pos) {
    }

    @Override
    public void tick() {
    }
}
