package com.iafenvoy.sow.render.util;

import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;

public class ArdoniMarkerReloader implements SynchronousResourceReloader {
    @Override
    public void reload(ResourceManager manager) {
        ArdoniMarkerGenerator.resetAll();
    }
}
