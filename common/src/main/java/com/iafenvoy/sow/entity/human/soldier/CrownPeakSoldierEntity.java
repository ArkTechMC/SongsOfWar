package com.iafenvoy.sow.entity.human.soldier;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class CrownPeakSoldierEntity extends AbstractSoldierEntity {
    public CrownPeakSoldierEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.CrownPeak;
    }

    @Override
    public int getVariantCount() {
        return 10;
    }
}
