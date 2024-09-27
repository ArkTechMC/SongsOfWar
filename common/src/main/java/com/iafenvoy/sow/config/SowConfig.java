package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.config.AutoInitConfigContainer;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.util.Identifier;

public class SowConfig extends AutoInitConfigContainer {
    public static final SowConfig INSTANCE = new SowConfig();

    public SowConfig() {
        super(new Identifier(SongsOfWar.MOD_ID, "sow_config"), "config.sow.server.title", "./config/sow/songs-of-war.json");
    }
}
