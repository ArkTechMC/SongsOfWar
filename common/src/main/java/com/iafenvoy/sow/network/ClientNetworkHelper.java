package com.iafenvoy.sow.network;

import com.iafenvoy.sow.entity.ArdoniEntity;
import dev.architectury.networking.NetworkManager;
import net.minecraft.client.MinecraftClient;

public class ClientNetworkHelper {
    public static void init(){
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, ArdoniEntity.UPDATE_DATA, (buf, context) -> {
            final int id = buf.readInt();
            final long seed = buf.readLong();
            final String type = buf.readString();
            final MinecraftClient client = MinecraftClient.getInstance();
            assert client.world != null;
            client.execute(() -> {
                if (client.world.getEntityById(id) instanceof ArdoniEntity ardoni) {
                    ardoni.setMarkerSeed(seed);
                    ardoni.setArdoniType(type);
                }
            });
        });
    }
}
