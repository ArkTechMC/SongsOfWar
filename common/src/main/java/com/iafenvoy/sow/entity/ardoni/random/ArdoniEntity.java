package com.iafenvoy.sow.entity.ardoni.random;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniName;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class ArdoniEntity extends AbstractArdoniEntity {
    private static final TrackedData<Long> MARKER_SEED = DataTracker.registerData(ArdoniEntity.class, TrackedDataHandlerRegistry.LONG);
    private static final TrackedData<String> ARDONI_TYPE = DataTracker.registerData(ArdoniEntity.class, TrackedDataHandlerRegistry.STRING);
    private static final TrackedData<Boolean> CHILD = DataTracker.registerData(ArdoniEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public ArdoniEntity(EntityType<? extends ArdoniEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Optional<Identifier> getMarkerTexture() {
        return Optional.empty();
    }

    @Override
    public Color4i getColor() {
        //TODO: Remap failure
//        if (this.hasCustomName() && this.getName().getString().equals("jeb_"))
//            return Color4i.fromHSV((this.age + this.getId()) / 100.0f, 1, 1);
        return this.getArdoniType().color();
    }

    @Override
    public Identifier getSkinTexture() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_base.png");
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MARKER_SEED, 0L);
        this.dataTracker.startTracking(ARDONI_TYPE, "");
        this.dataTracker.startTracking(CHILD, false);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putLong("markerSeed", this.getMarkerSeed());
        nbt.putString("ardoniType", this.getArdoniTypeString());
        nbt.putBoolean("child", this.isChild());
    }

    public void setDefaultData() {
        this.setMarkerSeed(System.nanoTime());
        this.setChild(this.random.nextInt(5) == 0);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setDefaultData();
        if (nbt.contains("markerSeed")) this.setMarkerSeed(nbt.getLong("markerSeed"));
        if (nbt.contains("child")) this.setChild(nbt.getBoolean("child"));
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        EntityData data = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        this.setDefaultData();
        this.setCustomName(Text.literal(String.format("%s %s", ArdoniName.randomName(), this.getArdoniType().getFormattedName())));
        return data;
    }

    public void setMarkerSeed(long markerSeed) {
        this.dataTracker.set(MARKER_SEED, markerSeed);
    }

    public long getMarkerSeed() {
        return this.dataTracker.get(MARKER_SEED);
    }

    public String getArdoniTypeString() {
        return this.dataTracker.get(ARDONI_TYPE);
    }

    public boolean isChild() {
        return this.dataTracker.get(CHILD);
    }

    public void setChild(boolean child) {
        this.dataTracker.set(CHILD, child);
    }
}
