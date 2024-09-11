package com.iafenvoy.sow.entity.human.guard;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class NorthwindGuardEntity extends AbstractGuardEntity{
    public NorthwindGuardEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.Northwind;
    }

    @Override
    public int getVariantCount() {
        return 5;
    }
}
