package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowRenderers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SongsOfWarClient {
    public static void init() {
        SowRenderers.registerEntityRenderers();
    }

    public static void process() {
        SowRenderers.registerBlockRenderers();
        SowRenderers.registerModelPredicates();
    }
}
