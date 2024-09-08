package com.iafenvoy.sow.entity.felina;

import com.iafenvoy.neptune.object.entity.MonsterEntityBase;
import com.iafenvoy.neptune.render.EntityTextureProvider;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class FeldenEntity extends MonsterEntityBase implements EntityTextureProvider {
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(FeldenEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public FeldenEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, EntityGroup.DEFAULT);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.getNavigation().getNodeMaker().setCanOpenDoors(true);
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false) {
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return this.mob.getWidth() * this.mob.getWidth() + entity.getWidth();
            }
        });
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.65));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.goalSelector.add(4, new LongDoorInteractGoal(this, false));
        this.goalSelector.add(5, new LongDoorInteractGoal(this, true));
        this.goalSelector.add(6, new BreakDoorGoal(this, e -> true));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.goalSelector.add(8, new SwimGoal(this));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, 1);
    }

    public int getVariant() {
        return this.dataTracker.get(VARIANT);
    }

    public void setVariant(int type) {
        this.dataTracker.set(VARIANT, type);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("variant", this.getVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("variant")) this.setVariant(nbt.getInt("variant"));
        else this.setVariant(RandomHelper.nextInt(1, 3));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 10.0);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0);
        return builder;
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/felina/felden_" + this.getVariant() + ".png");
    }
}
