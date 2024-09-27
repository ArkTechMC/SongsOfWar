package com.iafenvoy.sow.entity.human.guard;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class CrownPeakGuardEntity extends AbstractGuardEntity {
    public CrownPeakGuardEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.CrownPeak;
    }

    @Override
    public int getVariantCount() {
        return 15;
    }
}
