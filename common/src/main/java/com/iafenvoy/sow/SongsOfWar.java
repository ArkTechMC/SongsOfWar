package com.iafenvoy.sow;

import com.iafenvoy.jupiter.ConfigManager;
import com.iafenvoy.jupiter.ServerConfigManager;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.data.ArdoniName;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.registry.*;
import com.iafenvoy.sow.world.sound.ServerSongCubeEntityDataHelper;
import com.mojang.logging.LogUtils;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.networking.NetworkManager;
import dev.architectury.registry.ReloadListenerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.resource.ResourceType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;

public class SongsOfWar {
    public static final String MOD_ID = "sow";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ConfigManager.getInstance().registerConfigHandler(SowConfig.INSTANCE);
        ConfigManager.getInstance().registerServerConfig(SowConfig.INSTANCE, ServerConfigManager.PermissionChecker.IS_OPERATOR);

        SowSkulls.init();
        SowBlocks.REGISTRY.register();
        SowBlockEntities.REGISTRY.register();
        SowEntities.REGISTRY.register();
        SowItems.REGISTRY.register();
        SowItemGroups.REGISTRY.register();
        SowParticles.REGISTRY.register();
        SowSounds.REGISTRY.register();
        SowWeapons.REGISTRY.register();
        SowCommands.init();
        SowEntities.init();
    }

    public static void process() {
        SowBanners.init();
        SowItems.init();
        SowBlocks.init();
        SowPowers.init();
        BlockEvent.BREAK.register((world, pos, state, player, xp) -> {
            if (state.isOf(Blocks.BEACON) && world instanceof ServerWorld serverWorld)
                BeaconData.getInstance(serverWorld).remove(pos);
            return EventResult.pass();
        });
        ServerSongCubeEntityDataHelper.init();
        ReloadListenerRegistry.register(ResourceType.SERVER_DATA, new ArdoniName(), new Identifier(MOD_ID, "ardoni_name"));
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Static.BEACON_TELEPORT, (buf, context) -> {
            BlockPos prev = buf.readBlockPos(), now = buf.readBlockPos();
            PlayerEntity player = context.getPlayer();
            if (player.getBlockPos().getSquaredDistance(prev) > 10 * 10) {
                LOGGER.warn("Player {} request to teleport but too far!", player.getEntityName());
                return;
            }
            context.queue(() -> {
                BlockPos newPos = player.getBlockPos().subtract(prev).add(now);
                player.requestTeleport(newPos.getX(), newPos.getY(), newPos.getZ());
            });
        });
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Static.KEYBINDING_SYNC, (buf, context) -> {
            PlayerEntity player = context.getPlayer();
            PowerCategory type = buf.readEnumConstant(PowerCategory.class);
            SongPowerData data = SongPowerData.byPlayer(player);
            if (!player.isSpectator() && data.isEnabled())
                context.queue(() -> data.get(type).keyPress());
        });
    }
}
