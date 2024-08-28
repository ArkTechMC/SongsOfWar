package com.iafenvoy.sow.entity;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import dev.architectury.networking.NetworkManager;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ArdoniEntity extends AbstractArdoniEntity {
    public static final Identifier UPDATE_DATA = new Identifier(SongsOfWar.MOD_ID, "update_marker_seed");
    private long markerSeed;
    private ArdoniType ardoniType;

    public ArdoniEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.markerSeed = System.nanoTime();
        this.ardoniType = ArdoniType.random();
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putLong("markerSeed", this.markerSeed);
        nbt.putString("ardoniType", this.ardoniType.id());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("markerSeed")) this.markerSeed = nbt.getLong("markerSeed");
        if (nbt.contains("ardoniType")) this.ardoniType = ArdoniType.byId(nbt.getString("ardoniType"));
    }

    public void setMarkerSeed(long markerSeed) {
        this.markerSeed = markerSeed;
    }

    public long getMarkerSeed() {
        return this.markerSeed;
    }

    public ArdoniType getArdoniType() {
        return this.ardoniType;
    }

    public void setArdoniType(String type) {
        this.setArdoniType(ArdoniType.byId(type));
    }

    public void setArdoniType(ArdoniType ardoniType) {
        this.ardoniType = ardoniType;
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        PacketByteBuf buf = PacketBufferUtils.create();
        buf.writeInt(this.getId());
        assert this.getWorld().getServer() != null;
        NetworkManager.sendToServer(UPDATE_DATA, buf);
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }
}
