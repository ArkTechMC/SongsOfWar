package com.iafenvoy.sow;

import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.registry.SowKeybindings;
import com.iafenvoy.sow.registry.SowRenderers;
import com.iafenvoy.sow.render.entity.util.ArdoniMarkerReloader;
import com.iafenvoy.sow.screen.BeaconTeleportScreen;
import com.iafenvoy.sow.world.sound.ClientSongCubeEntityDataHelper;
import com.iafenvoy.sow.world.sound.ClientSongCubeSoundManager;
import dev.architectury.networking.NetworkManager;
import dev.architectury.registry.ReloadListenerRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class SongsOfWarClient {
    public static void init() {
        SowKeybindings.init();
        SowRenderers.registerEntityRenderers();
        SowRenderers.registerParticleRenderer();
    }

    public static void process() {
        SowRenderers.registerSkull();
        SowRenderers.registerBlockEntityRenderer();
        SowRenderers.registerRenderType();
        ClientSongCubeEntityDataHelper.init();
        Static.songCubeSoundManager = new ClientSongCubeSoundManager();
        ReloadListenerRegistry.register(ResourceType.CLIENT_RESOURCES, new ArdoniMarkerReloader(), new Identifier(SongsOfWar.MOD_ID, "ardoni_marker"));
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, Static.BEACON_TELEPORT, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            BeaconData data = BeaconData.readNbt(buf.readNbt());
            context.queue(() -> MinecraftClient.getInstance().setScreen(new BeaconTeleportScreen(data, pos, 0)));
        });
    }
}
