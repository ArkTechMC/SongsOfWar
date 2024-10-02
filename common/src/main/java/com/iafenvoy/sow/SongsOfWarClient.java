package com.iafenvoy.sow;

import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.registry.SowRenderers;
import com.iafenvoy.sow.screen.BeaconTeleportScreen;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class SongsOfWarClient {
    public static void init() {
        SowRenderers.registerEntityRenderers();
    }

    public static void process() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, Static.BEACON_TELEPORT, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            BeaconData data = BeaconData.readNbt(buf.readNbt());
            context.queue(() -> MinecraftClient.getInstance().setScreen(new BeaconTeleportScreen(data, pos, 0)));
        });
    }
}
