package com.iafenvoy.sow.entity.ardoni.random;

import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class SendarisArdoniEntity extends ArdoniEntity {
    public SendarisArdoniEntity(EntityType<? extends ArdoniEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.SENDARIS;
    }
}
