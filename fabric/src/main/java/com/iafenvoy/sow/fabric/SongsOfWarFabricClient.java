package com.iafenvoy.sow.fabric;

import com.iafenvoy.sow.SongsOfWarClient;
import net.fabricmc.api.ClientModInitializer;

public class SongsOfWarFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SongsOfWarClient.init();
        SongsOfWarClient.process();
    }
}
