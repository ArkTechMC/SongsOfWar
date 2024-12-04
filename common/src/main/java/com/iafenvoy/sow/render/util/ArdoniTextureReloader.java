package com.iafenvoy.sow.render.util;

import com.iafenvoy.sow.render.block.ArdoniGraveBlockEntityRenderer;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;

public class ArdoniTextureReloader implements SynchronousResourceReloader {
    @Override
    public void reload(ResourceManager manager) {
        ArdoniMarkerGenerator.resetAll();
        ArdoniGraveBlockEntityRenderer.reset();
    }
}
