package com.iafenvoy.sow;

import com.iafenvoy.sow.data.ArdoniName;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowWeapons;
import com.mojang.logging.LogUtils;
import dev.architectury.registry.ReloadListenerRegistry;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public class SongsOfWar {
    public static final String MOD_ID = "sow";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        SowItems.REGISTRY.register();
        SowWeapons.REGISTRY.register();
        SowItemGroups.REGISTRY.register();
        SowEntities.REGISTRY.register();
        SowEntities.init();
    }

    public static void process() {
        SowItems.init();
        ReloadListenerRegistry.register(ResourceType.SERVER_DATA, new ArdoniName(), new Identifier(MOD_ID, "ardoni_name"));
    }
}
