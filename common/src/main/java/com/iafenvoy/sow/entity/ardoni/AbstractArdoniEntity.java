package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.object.entity.MonsterEntityBase;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public abstract class AbstractArdoniEntity extends MonsterEntityBase {
    public AbstractArdoniEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, EntityGroup.DEFAULT);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_ARMOR, 10.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.getNavigation().getNodeMaker().setCanOpenDoors(true);
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1, false) {
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return this.mob.getWidth() * this.mob.getWidth() + entity.getWidth();
            }
        });
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.5));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.goalSelector.add(4, new LongDoorInteractGoal(this, false));
        this.goalSelector.add(5, new LongDoorInteractGoal(this, true));
        this.goalSelector.add(6, new BreakDoorGoal(this, e -> true));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.goalSelector.add(8, new SwimGoal(this));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource.isOf(DamageTypes.DRAGON_BREATH) || damageSource.isOf(DamageTypes.MAGIC))
            return true;
        return super.isInvulnerableTo(damageSource);
    }

    public abstract Identifier getSkinTexture();

    public abstract Optional<Identifier> getMarkerTexture();

    public abstract Color4i getColor();

    public abstract ArdoniType getArdoniType();

    public boolean isFemale() {
        return false;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }
}
