package com.iafenvoy.sow.fabric;

import com.iafenvoy.sow.SongsOfWar;
import net.fabricmc.api.ModInitializer;

public class SongsOfWarFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SongsOfWar.init();
        SongsOfWar.process();
    }
}