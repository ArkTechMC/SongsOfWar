package com.iafenvoy.sow.entity.ardoni.random;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniName;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class ArdoniEntity extends AbstractArdoniEntity {
    protected static final TrackedData<Long> MARKER_SEED = DataTracker.registerData(ArdoniEntity.class, TrackedDataHandlerRegistry.LONG);
    protected static final TrackedData<Integer> AGE = DataTracker.registerData(ArdoniEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Boolean> FEMALE = DataTracker.registerData(ArdoniEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public ArdoniEntity(EntityType<? extends ArdoniEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Optional<Identifier> getMarkerTexture() {
        return Optional.empty();
    }

    @Override
    public Color4i getColor() {
        if (this.hasCustomName() && this.getName().getString().equals("jeb_"))
            return Color4i.fromHSV((this.age + this.getId()) / 100.0f, 1, 1);
        return this.getArdoniType().getColor(this.getMarkerSeed());
    }

    @Override
    public Identifier getSkinTexture() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_base.png");
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MARKER_SEED, 0L);
        this.dataTracker.startTracking(AGE, 1);
        this.dataTracker.startTracking(FEMALE, false);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putLong("markerSeed", this.getMarkerSeed());
        nbt.putInt("age", this.getAge());
        nbt.putBoolean("female", this.isFemale());
    }

    public void setDefaultData() {
        this.setMarkerSeed(System.nanoTime());
        this.setAge(RandomHelper.nextInt(1, 5));
        this.setGender(RandomHelper.nextInt(0, 5) == 0);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setDefaultData();
        if (nbt.contains("markerSeed")) this.setMarkerSeed(nbt.getLong("markerSeed"));
        if (nbt.contains("age")) this.setAge(nbt.getInt("age"));
        if (nbt.contains("female")) this.setGender(nbt.getBoolean("female"));
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        EntityData data = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        this.setDefaultData();
        if (this.getArdoniType() == ArdoniType.NONE) this.setCustomName(Text.literal(ArdoniName.randomName()));
        else
            this.setCustomName(Text.literal(String.format("%s %s", ArdoniName.randomName(), this.getArdoniType().getFormattedName())));
        return data;
    }

    public long getMarkerSeed() {
        return this.dataTracker.get(MARKER_SEED);
    }

    public void setMarkerSeed(long markerSeed) {
        this.dataTracker.set(MARKER_SEED, markerSeed);
    }

    public int getAge() {
        return this.dataTracker.get(AGE);
    }

    public void setAge(int age) {
        this.dataTracker.set(AGE, age);
    }

    @Override
    public boolean isFemale() {
        return this.dataTracker.get(FEMALE);
    }

    public void setGender(boolean female) {
        this.dataTracker.set(FEMALE, female);
    }

    @Override
    public ItemStack toGrave() {
        return ArdoniGraveBlockEntity.buildGrave(this.getMarkerSeed(), this.getArdoniType());
    }
}
