package com.iafenvoy.sow.entity.human.soldier;

import com.iafenvoy.sow.data.KingdomType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class HydraphelSoldierEntity extends AbstractSoldierEntity {
    public HydraphelSoldierEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public KingdomType getKingdom() {
        return KingdomType.Hydraphel;
    }

    @Override
    public int getVariantCount() {
        return 3;
    }
}
