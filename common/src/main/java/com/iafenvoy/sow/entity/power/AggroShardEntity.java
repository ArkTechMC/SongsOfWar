package com.iafenvoy.sow.entity.power;

import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.registry.SowDamageTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class AggroShardEntity extends SopProjectileEntity {
    public AggroShardEntity(EntityType<? extends SopProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getEntityWorld().getClosestEntity(LivingEntity.class, TargetPredicate.DEFAULT, null, this.getX(), this.getY(), this.getZ(), new Box(this.getPos().add(1, 1, 1), this.getPos().subtract(1, 1, 1)));
        if (target != null) {
            target.damage(DamageUtil.build(this.ownerOrSelf(), SowDamageTypes.AGGROSHARD), SowConfig.INSTANCE.aggressium.aggroshardDamage.getValue().floatValue());
            this.remove(RemovalReason.DISCARDED);
        } else if (!this.getEntityWorld().getBlockState(this.getBlockPos()).isAir() && this.getDisappearCd() < 0)
            this.setDisappearCd(20, false);
        else if (this.isOnGround() || this.inGround)
            this.remove(RemovalReason.DISCARDED);
    }
}
