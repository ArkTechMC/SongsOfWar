package com.iafenvoy.sow;

import com.iafenvoy.sow.compat.LitematicaHelper;
import com.iafenvoy.sow.network.ClientNetworkHelper;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowKeybindings;
import com.iafenvoy.sow.registry.SowRenderers;
import com.iafenvoy.sow.render.entity.util.ArdoniMarkerReloader;
import com.iafenvoy.sow.world.sound.ClientSongCubeSoundManager;
import dev.architectury.registry.ReloadListenerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
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
        Static.songCubeSoundManager = new ClientSongCubeSoundManager();
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.PEAS.get());
        ReloadListenerRegistry.register(ResourceType.CLIENT_RESOURCES, new ArdoniMarkerReloader(), new Identifier(SongsOfWar.MOD_ID, "ardoni_marker"));
        ClientNetworkHelper.init();
        LitematicaHelper.extractFile();
    }
}
