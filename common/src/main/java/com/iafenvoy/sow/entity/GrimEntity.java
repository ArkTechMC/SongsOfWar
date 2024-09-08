package com.iafenvoy.sow.entity;

import com.iafenvoy.neptune.object.entity.MonsterEntityBase;
import com.iafenvoy.neptune.render.EntityTextureProvider;
import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class GrimEntity extends MonsterEntityBase implements EntityTextureProvider {
    public GrimEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, EntityGroup.DEFAULT);
        this.setStackInHand(Hand.MAIN_HAND, GlintManager.BLUE.apply(new ItemStack(SowWeapons.SCYTHE_IRON.get()), true));
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
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.5));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.goalSelector.add(4, new LongDoorInteractGoal(this, false));
        this.goalSelector.add(5, new LongDoorInteractGoal(this, true));
        this.goalSelector.add(6, new BreakDoorGoal(this, e -> true));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.goalSelector.add(8, new SwimGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 10.0);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0);
        return builder;
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/grim.png");
    }
}
