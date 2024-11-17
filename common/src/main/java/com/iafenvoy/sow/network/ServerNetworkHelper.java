package com.iafenvoy.sow.network;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.item.block.entity.AbstractSongCubeBlockEntity;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.power.component.MobiliWingsComponent;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import dev.architectury.networking.NetworkManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class ServerNetworkHelper {
    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Static.BEACON_TELEPORT, (buf, context) -> {
            BlockPos prev = buf.readBlockPos(), now = buf.readBlockPos();
            PlayerEntity player = context.getPlayer();
            if (player.getBlockPos().getSquaredDistance(prev) > 10 * 10) {
                SongsOfWar.LOGGER.warn("Player {} request to teleport but too far!", player.getEntityName());
                return;
            }
            context.queue(() -> {
                BlockPos newPos = player.getBlockPos().subtract(prev).add(now);
                player.requestTeleport(newPos.getX(), newPos.getY(), newPos.getZ());
            });
        });
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Static.POWER_KEYBINDING_SYNC, (buf, context) -> {
            PlayerEntity player = context.getPlayer();
            PowerCategory type = buf.readEnumConstant(PowerCategory.class);
            SongPowerData data = SongPowerData.byPlayer(player);
            if (!player.isSpectator() && data.isEnabled())
                context.queue(() -> data.get(type).keyPress());
        });
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Static.JUMP_PRESS, (buf, context) -> {
            PlayerEntity player = context.getPlayer();
            SongPowerData data = SongPowerData.byPlayer(player);
            if (data.powerEnabled(PowerCategory.MOBILIUM, MobiliumPowers.MOBILIWINGS))
                context.queue(() -> {
                    if (SongPowerData.byPlayer(player).getComponent(MobiliWingsComponent.ID) instanceof MobiliWingsComponent component)
                        component.speedUp();
                });
        });
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Static.SONG_CUBE_DATA_SYNC, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            PlayerEntity player = context.getPlayer();
            context.queue(() -> {
                if (player instanceof ServerPlayerEntity serverPlayer && serverPlayer.getEntityWorld().getBlockEntity(pos) instanceof AbstractSongCubeBlockEntity blockEntity)
                    NetworkManager.sendToPlayer(serverPlayer, Static.SONG_CUBE_DATA_SYNC, PacketBufferUtils.create().writeBlockPos(pos).writeString(blockEntity.getPower().getId()));
            });
        });
    }
}
