package com.iafenvoy.sow.entity.power;

import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.registry.SowDamageTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.explosion.ExplosionBehavior;

public class AggroDetonateEntity extends SopProjectileEntity {
    public AggroDetonateEntity(EntityType<? extends SopProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getEntityWorld().getClosestEntity(LivingEntity.class, TargetPredicate.DEFAULT, null, this.getX(), this.getY(), this.getZ(), new Box(this.getPos().add(1, 1, 1), this.getPos().subtract(1, 1, 1)));
        if (target != null) this.explode();
        else if (this.isOnGround() || this.inGround || !this.getEntityWorld().getBlockState(this.getBlockPos()).isAir())
            this.explode();
    }

    public void explode() {
        this.getEntityWorld().createExplosion(this, DamageUtil.build(this.ownerOrSelf(), SowDamageTypes.AGGRODETONATE), new ExplosionBehavior(), this.getPos(), SowConfig.INSTANCE.aggressium.aggrodetonatePower.getValue().floatValue(), false, World.ExplosionSourceType.MOB);
        this.remove(RemovalReason.DISCARDED);
    }
}
