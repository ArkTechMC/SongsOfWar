package com.iafenvoy.sow.forge;

import com.iafenvoy.jupiter.render.screen.ConfigSelectScreen;
import com.iafenvoy.sow.SongsOfWarClient;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.screen.PowerHudRenderer;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SongsOfWarForgeClient {
    @SubscribeEvent
    public static void process(FMLClientSetupEvent event) {
        event.enqueueWork(SongsOfWarClient::process);
        ItemPropertiesRegistry.register(SowItems.PROTEPOINT_SHIELD.get(), new Identifier("blocking"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() ? 1 : 0);
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((client, screen) -> new ConfigSelectScreen<>(Text.translatable("config.sow.title"), screen, SowConfig.INSTANCE, null)));
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void renderPowerHud(RenderGuiEvent.Post event) {
            PowerHudRenderer.render(MinecraftClient.getInstance(), event.getGuiGraphics());
        }
    }
}
