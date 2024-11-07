package com.iafenvoy.sow.world.sound;

import com.iafenvoy.sow.power.PowerCategory;
import net.minecraft.util.math.BlockPos;

public interface SongCubeSoundManager {
    boolean nearEnough(BlockPos pos);

    void startPlaying(BlockPos pos, PowerCategory category);

    void stopPlaying(BlockPos pos);

    void destroy(BlockPos pos);
}
