package com.iafenvoy.sow;

import com.iafenvoy.sow.entity.ArdoniEntity;
import com.iafenvoy.sow.registry.SowRenderers;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public class SongsOfWarClient {
    public static void init() {
        SowRenderers.registerEntityRenderers();
    }

    public static void process() {
        SowRenderers.registerBlockRenderers();
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, ArdoniEntity.UPDATE_MARKER_SEED, (buf, context) -> {
            final int id = buf.readInt();
            final long seed = buf.readLong();
            final MinecraftClient client = MinecraftClient.getInstance();
            assert client.world != null;
            client.execute(() -> {
                if (client.world.getEntityById(id) instanceof ArdoniEntity ardoni)
                    ardoni.setMarkerSeed(seed);
            });
        });
    }
}
