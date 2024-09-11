package com.iafenvoy.sow.entity.ardoni.random;

import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class NoneTypeArdoniEntity extends ArdoniEntity {
    public NoneTypeArdoniEntity(EntityType<? extends ArdoniEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.NONE;
    }
}
