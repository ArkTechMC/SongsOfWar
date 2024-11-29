package com.iafenvoy.sow;

import com.iafenvoy.sow.compat.LitematicaHelper;
import com.iafenvoy.sow.registry.SowKeybindings;
import com.iafenvoy.sow.registry.SowRenderers;
import com.iafenvoy.sow.render.util.ArdoniMarkerReloader;
import com.iafenvoy.sow.world.sound.ClientSongCubeSoundManager;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.registry.ReloadListenerRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

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
        SowRenderers.registerModelPredicate();
        Static.songCubeSoundManager = ClientSongCubeSoundManager.INSTANCE;
        ClientTickEvent.CLIENT_POST.register(client -> Static.songCubeSoundManager.tick());
        ReloadListenerRegistry.register(ResourceType.CLIENT_RESOURCES, new ArdoniMarkerReloader(), new Identifier(SongsOfWar.MOD_ID, "ardoni_marker"));
        LitematicaHelper.extractFile();
    }
}
