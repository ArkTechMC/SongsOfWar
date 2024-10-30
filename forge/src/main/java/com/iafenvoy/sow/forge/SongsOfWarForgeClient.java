package com.iafenvoy.sow.forge;

import com.iafenvoy.jupiter.render.screen.ConfigSelectScreen;
import com.iafenvoy.sow.SongsOfWarClient;
import com.iafenvoy.sow.config.SowConfig;
import net.minecraft.text.Text;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SongsOfWarForgeClient {
    @SubscribeEvent
    public static void process(FMLClientSetupEvent event) {
        event.enqueueWork(SongsOfWarClient::process);
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((client, screen) -> new ConfigSelectScreen<>(Text.translatable("config.sow.title"), screen, SowConfig.INSTANCE, null)));
    }
}
