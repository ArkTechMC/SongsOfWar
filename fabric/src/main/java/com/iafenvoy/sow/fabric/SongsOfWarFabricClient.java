package com.iafenvoy.sow.fabric;

import com.iafenvoy.sow.SongsOfWarClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SongsOfWarFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SongsOfWarClient.init();
        SongsOfWarClient.process();
    }
}
