package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.registry.SowItems;

public class SongsOfWar {
    public static final String MOD_ID = "sow";

    public static void init() {
        SowBlocks.REGISTRY.register();
        SowItems.REGISTRY.register();
        SowItemGroups.REGISTRY.register();
    }

    public static void process() {
    }
}
