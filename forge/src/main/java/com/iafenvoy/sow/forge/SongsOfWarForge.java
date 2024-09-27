package com.iafenvoy.sow.forge;

import com.iafenvoy.jupiter.screen.ConfigSelectScreen;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.SongsOfWarClient;
import com.iafenvoy.sow.config.SowConfig;
import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.architectury.utils.Env;
import net.minecraft.text.Text;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SongsOfWar.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SongsOfWarForge {
    public SongsOfWarForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(SongsOfWar.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SongsOfWar.init();
        if (Platform.getEnvironment() == Env.CLIENT)
            SongsOfWarClient.init();
    }

    @SubscribeEvent
    public static void process(FMLCommonSetupEvent event) {
        SongsOfWar.process();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void process(FMLClientSetupEvent event) {
            event.enqueueWork(SongsOfWarClient::process);
            ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((client, screen) -> new ConfigSelectScreen<>(Text.translatable("config.sow.title"), screen, SowConfig.INSTANCE, null)));
        }
    }
}