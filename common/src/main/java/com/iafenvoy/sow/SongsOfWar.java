package com.iafenvoy.sow;

import com.iafenvoy.jupiter.ConfigManager;
import com.iafenvoy.jupiter.ServerConfigManager;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.data.ArdoniName;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.network.ServerNetworkHelper;
import com.iafenvoy.sow.registry.*;
import com.iafenvoy.sow.registry.power.SowPowers;
import com.mojang.logging.LogUtils;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.registry.ReloadListenerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.resource.ResourceType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public class SongsOfWar {
    public static final String MOD_ID = "sow";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ConfigManager.getInstance().registerConfigHandler(SowConfig.INSTANCE);
        ConfigManager.getInstance().registerServerConfig(SowConfig.INSTANCE, ServerConfigManager.PermissionChecker.IS_OPERATOR);

        SowBlocks.REGISTRY.register();
        SowBlocks.ITEM_REGISTRY.register();
        SowBlockEntities.REGISTRY.register();
        SowDelight.REGISTRY.register();
        SowEntities.REGISTRY.register();
        SowItemGroups.REGISTRY.register();
        SowItems.REGISTRY.register();
        SowParticles.REGISTRY.register();
        SowSpawnEggs.REGISTRY.register();
        SowSkulls.REGISTRY.register();
        SowSkulls.ITEM_REGISTRY.register();
        SowSounds.REGISTRY.register();
        SowWeapons.REGISTRY.register();
        SowCommands.init();
        SowEntities.init();
    }

    public static void process() {
        SowBanners.init();
        SowPowers.init();
        BlockEvent.BREAK.register((world, pos, state, player, xp) -> {
            if (state.isOf(Blocks.BEACON) && world instanceof ServerWorld serverWorld)
                BeaconData.getInstance(serverWorld).remove(pos);
            return EventResult.pass();
        });
        ReloadListenerRegistry.register(ResourceType.SERVER_DATA, new ArdoniName(), new Identifier(MOD_ID, "ardoni_name"));
        ServerNetworkHelper.init();
    }
}
