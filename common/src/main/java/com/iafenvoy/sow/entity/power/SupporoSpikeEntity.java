package com.iafenvoy.sow.entity.power;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class SupporoSpikeEntity extends Entity {
    private static final TrackedData<BlockState> BLOCK_STATE = DataTracker.registerData(SupporoSpikeEntity.class, TrackedDataHandlerRegistry.BLOCK_STATE);
    private static final TrackedData<Boolean> ABSOLUTE_ROTATION = DataTracker.registerData(SupporoSpikeEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Vector3f> ROTATION = DataTracker.registerData(SupporoSpikeEntity.class, TrackedDataHandlerRegistry.VECTOR3F);
    private static final TrackedData<Float> SCALE = DataTracker.registerData(SupporoSpikeEntity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> DURATION = DataTracker.registerData(SupporoSpikeEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public SupporoSpikeEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(BLOCK_STATE, Blocks.AIR.getDefaultState());
        this.dataTracker.startTracking(ABSOLUTE_ROTATION, false);
        this.dataTracker.startTracking(ROTATION, new Vector3f(0, 0, 0));
        this.dataTracker.startTracking(SCALE, 1F);
        this.dataTracker.startTracking(DURATION, 20);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setBlockState(NbtHelper.toBlockState(this.getWorld().createCommandRegistryWrapper(RegistryKeys.BLOCK), nbt.getCompound("block_state")));
        this.setAbsoluteRotation(nbt.getBoolean("absolute_rotation"));
        this.setRotation(new Vector3f(nbt.getFloat("rotation_x"), nbt.getFloat("rotation_y"), nbt.getFloat("rotation_z")));
        this.setScale(nbt.getFloat("scale"));
        this.setDuration(nbt.getInt("duration"));
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.put("block_state", NbtHelper.fromBlockState(this.getBlockState()));
        nbt.putBoolean("absolute_rotation", this.isAbsoluteRotation());
        Vector3f rotation = this.getRotation();
        nbt.putFloat("rotation_x", rotation.x);
        nbt.putFloat("rotation_y", rotation.y);
        nbt.putFloat("rotation_z", rotation.z);
        nbt.putFloat("scale", this.getScale());
        nbt.putInt("duration", this.getDuration());
    }

    @Override
    protected Box calculateBoundingBox() {
        return super.calculateBoundingBox();
    }

    @Override
    public void tick() {
        super.tick();
        int d = this.getDuration();
        if (d <= 0) this.remove(RemovalReason.DISCARDED);
        this.setDuration(d - 1);
    }

    public Quaternionf getRotationQuaternion() {
        Vector3f rotation = this.getRotation();
        if (this.isAbsoluteRotation())
            return new Quaternionf().rotateX(rotation.x).rotationY(rotation.y).rotationZ(rotation.z);
        return new Quaternionf().rotateX(rotation.x).rotateLocalY(rotation.y).rotateLocalZ(rotation.z);
    }

    public BlockState getBlockState() {
        return this.dataTracker.get(BLOCK_STATE);
    }

    public void setBlockState(BlockState state) {
        this.dataTracker.set(BLOCK_STATE, state);
    }

    public boolean isAbsoluteRotation() {
        return this.dataTracker.get(ABSOLUTE_ROTATION);
    }

    public void setAbsoluteRotation(boolean absoluteRotation) {
        this.dataTracker.set(ABSOLUTE_ROTATION, absoluteRotation);
    }

    public Vector3f getRotation() {
        return this.dataTracker.get(ROTATION);
    }

    public void setRotation(Vector3f rotation) {
        this.dataTracker.set(ROTATION, rotation);
    }

    public float getScale() {
        return this.dataTracker.get(SCALE);
    }

    public void setScale(float scale) {
        this.dataTracker.set(SCALE, scale);
    }

    public int getDuration() {
        return this.dataTracker.get(DURATION);
    }

    public void setDuration(int duration) {
        this.dataTracker.set(DURATION, duration);
    }
}
