package com.iafenvoy.sow.network;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.entity.ArdoniEntity;
import dev.architectury.networking.NetworkManager;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class ServerNetworkHelper {
    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, ArdoniEntity.UPDATE_DATA, (buf, context) -> {
            final int id = buf.readInt();
            assert context.getPlayer().getServer() != null;
            context.getPlayer().getServer().execute(() -> {
                if (context.getPlayer().getWorld().getEntityById(id) instanceof ArdoniEntity ardoni) {
                    PacketByteBuf byteBuf = PacketBufferUtils.create();
                    byteBuf.writeInt(ardoni.getId()).writeLong(ardoni.getMarkerSeed());
                    byteBuf.writeString(ardoni.getArdoniType().id());
                    assert ardoni.getWorld().getServer() != null;
                    NetworkManager.sendToPlayer((ServerPlayerEntity) context.getPlayer(), ArdoniEntity.UPDATE_DATA, byteBuf);
                }
            });
        });
    }
}
