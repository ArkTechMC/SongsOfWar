package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowWeapons;
import com.iafenvoy.sow.render.glint.GlintManager;
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
    }

    public static void process() {
        GlintManager.BLUE.addPredicate(stack -> stack.isOf(SowWeapons.SCYTHE_IRON.get()));
    }
}
