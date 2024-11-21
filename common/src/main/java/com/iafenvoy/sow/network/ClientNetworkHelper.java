package com.iafenvoy.sow.network;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.item.block.entity.AbstractSongCubeBlockEntity;
import com.iafenvoy.sow.power.type.AbstractSongPower;
import com.iafenvoy.sow.power.type.DummySongPower;
import com.iafenvoy.sow.screen.BeaconTeleportScreen;
import dev.architectury.networking.NetworkManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class ClientNetworkHelper {
    private static final Set<BlockPos> REQUESTING = new HashSet<>();

    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, Static.BEACON_TELEPORT, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            BeaconData data = BeaconData.readNbt(buf.readNbt());
            context.queue(() -> MinecraftClient.getInstance().setScreen(new BeaconTeleportScreen(data, pos, 0)));
        });
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, Static.SONG_CUBE_DATA_SYNC, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            AbstractSongPower<?> power = AbstractSongPower.BY_ID.getOrDefault(buf.readString(), DummySongPower.EMPTY);
            if (power.isEmpty()) return;//Do not sync empty one again
            REQUESTING.remove(pos);
            World world = context.getPlayer().getEntityWorld();
            context.queue(() -> {
                if (world != null && world.getBlockEntity(pos) instanceof AbstractSongCubeBlockEntity blockEntity)
                    blockEntity.setPower(power);
            });
        });
    }

    public static void request(BlockPos pos) {
        if (REQUESTING.contains(pos)) return;
        REQUESTING.add(pos);
        NetworkManager.sendToServer(Static.SONG_CUBE_DATA_SYNC, PacketBufferUtils.create().writeBlockPos(pos));
    }
}