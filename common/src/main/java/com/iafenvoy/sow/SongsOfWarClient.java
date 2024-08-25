package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowWeapons;
import com.iafenvoy.sow.render.glint.GlintLayerManager;
import com.iafenvoy.sow.render.glint.GlintManager;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;

public class SongsOfWarClient {
    public static void init() {
    }

    public static void process() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), SowBlocks.AGGRESSIUM_CUBE.get(), SowBlocks.MOBILIUM_CUBE.get(), SowBlocks.PROTISIUM_CUBE.get(), SowBlocks.SUPPORIUM_CUBE.get());
    }
}
