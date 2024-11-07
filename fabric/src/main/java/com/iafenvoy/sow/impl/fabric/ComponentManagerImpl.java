package com.iafenvoy.sow.impl.fabric;

import com.iafenvoy.sow.fabric.component.SongPowerComponent;
import com.iafenvoy.sow.power.SongPowerData;
import net.minecraft.entity.player.PlayerEntity;

public class ComponentManagerImpl {
    public static SongPowerData getSongPowerData(PlayerEntity player) {
        return SongPowerComponent.SONG_POWER_COMPONENT.get(player).getData();
    }
}
