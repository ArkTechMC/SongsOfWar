package com.iafenvoy.sow.impl.forge;

import com.iafenvoy.sow.forge.component.SongPowerDataProvider;
import com.iafenvoy.sow.forge.component.SongPowerDataStorage;
import com.iafenvoy.sow.power.SongPowerData;
import net.minecraft.entity.player.PlayerEntity;

public class ComponentManagerImpl {
    public static SongPowerData getSongPowerData(PlayerEntity player) {
        return player.getCapability(SongPowerDataProvider.CAPABILITY).resolve().map(SongPowerDataStorage::getData).orElse(null);
    }
}
