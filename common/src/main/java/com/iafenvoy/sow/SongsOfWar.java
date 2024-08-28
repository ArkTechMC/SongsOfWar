package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.*;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class SongsOfWar {
    public static final String MOD_ID = "sow";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        SowBlocks.REGISTRY.register();
        SowItems.REGISTRY.register();
        SowWeapons.REGISTRY.register();
        SowItemGroups.REGISTRY.register();
        SowEntities.REGISTRY.register();
        SowEntities.init();
    }

    public static void process() {
        SowItems.init();
    }
}
