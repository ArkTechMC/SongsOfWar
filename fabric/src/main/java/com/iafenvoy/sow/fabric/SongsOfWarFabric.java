package com.iafenvoy.sow.fabric;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.power.SongPowerData;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class SongsOfWarFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SongsOfWar.init();
        SongsOfWar.process();
        ServerLifecycleEvents.SERVER_STOPPING.register(SongPowerData::stop);
    }
}