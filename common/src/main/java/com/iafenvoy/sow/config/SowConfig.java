package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.config.AutoInitConfigContainer;
import com.iafenvoy.jupiter.malilib.config.options.ConfigBoolean;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.util.Identifier;

public class SowConfig extends AutoInitConfigContainer {
    public static final SowConfig INSTANCE = new SowConfig();
    public final CommonConfig common = new CommonConfig();

    public SowConfig() {
        super(new Identifier(SongsOfWar.MOD_ID, "sow_config"), "config.sow.server.title", "./config/sow/songs-of-war.json");
    }

    public static class CommonConfig extends AutoInitConfigCategoryBase {
        public final ConfigBoolean enableBeaconTp = new ConfigBoolean("config.sow.common.enableBeaconTp", true);

        public CommonConfig() {
            super("common", "config.sow.category.common");
        }
    }
}
