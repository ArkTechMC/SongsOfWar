package com.iafenvoy.sow.entity.power;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class ProteCloneEntity extends MobEntity {
    private static final TrackedData<Integer> DISAPPEAR_CD = DataTracker.registerData(ProteCloneEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public ProteCloneEntity(EntityType<? extends MobEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DISAPPEAR_CD, -1);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setDisappearCd(nbt.getInt("disappear_cd"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("disappear_cd", this.getDisappearCd());
    }

    public int getDisappearCd() {
        return this.dataTracker.get(DISAPPEAR_CD);
    }

    public void setDisappearCd(int cd) {
        this.dataTracker.set(DISAPPEAR_CD, cd);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) return;
        int cd = this.getDisappearCd();
        if (cd == 0) this.remove(RemovalReason.DISCARDED);
        else if (cd > 0) this.setDisappearCd(cd - 1);
    }

    @Override
    public boolean canHit() {
        return true;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        this.remove(RemovalReason.KILLED);
        return true;
    }
}
