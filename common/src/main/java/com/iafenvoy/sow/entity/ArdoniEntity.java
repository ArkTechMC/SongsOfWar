package com.iafenvoy.sow.entity;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.SongsOfWar;
import dev.architectury.networking.NetworkManager;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

public class ArdoniEntity extends AbstractArdoniEntity {
    public static final Identifier UPDATE_MARKER_SEED = new Identifier(SongsOfWar.MOD_ID, "update_marker_seed");
    private long markerSeed;

    public ArdoniEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.markerSeed = System.nanoTime();
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        EntityData data = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        PacketByteBuf buf = PacketBufferUtils.create();
        buf.writeInt(this.getId()).writeLong(this.markerSeed);
        NetworkManager.sendToPlayers(world.getServer().getOverworld().getPlayers(), UPDATE_MARKER_SEED, buf);
        return data;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putLong("markerSeed", this.markerSeed);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.markerSeed = nbt.getLong("markerSeed");
    }

    @ApiStatus.Internal
    public void setMarkerSeed(long markerSeed) {
        this.markerSeed = markerSeed;
    }

    public long getMarkerSeed() {
        return this.markerSeed;
    }
}
