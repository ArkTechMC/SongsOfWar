package com.iafenvoy.sow.entity.human.guard;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class FeldenGuardEntity extends AbstractGuardEntity {
    public FeldenGuardEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.Felden;
    }

    @Override
    public int getVariantCount() {
        return 10;
    }

    @Override
    public float getScale() {
        return 1.05f;
    }
}
