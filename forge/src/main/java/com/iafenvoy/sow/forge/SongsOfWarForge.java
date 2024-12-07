package com.iafenvoy.sow.forge;

import com.iafenvoy.neptune.forge.component.CapabilitySyncHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.SongsOfWarClient;
import com.iafenvoy.sow.forge.component.SongChunkDataProvider;
import com.iafenvoy.sow.forge.component.SongPowerDataProvider;
import com.iafenvoy.sow.power.SongPowerData;
import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.architectury.utils.Env;
import net.minecraft.util.Identifier;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SongsOfWar.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SongsOfWarForge {
    public SongsOfWarForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(SongsOfWar.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SongsOfWar.init();
        CapabilitySyncHelper.register(new Identifier(SongsOfWar.MOD_ID, "song_power"), SongPowerDataProvider.CAPABILITY, SongPowerDataProvider::new);
        if (Platform.getEnvironment() == Env.CLIENT)
            SongsOfWarClient.init();
    }

    @SubscribeEvent
    public static void process(FMLCommonSetupEvent event) {
        event.enqueueWork(SongsOfWar::process);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onServerStop(ServerStoppingEvent event) {
            SongPowerData.stop(event.getServer());
        }

        @SubscribeEvent
        public static void attachChunkData(AttachCapabilitiesEvent<WorldChunk> event) {
            event.addCapability(new Identifier(SongsOfWar.MOD_ID, "song_chunk_data"), new SongChunkDataProvider());
        }
    }
}