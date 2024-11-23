package com.iafenvoy.sow.world.sound;

import com.iafenvoy.sow.power.PowerCategory;
import net.minecraft.util.math.BlockPos;

public interface SongCubeSoundManager {
    void startPlaying(BlockPos pos, PowerCategory category);

    void destroy(BlockPos pos);

    void tick();
}
