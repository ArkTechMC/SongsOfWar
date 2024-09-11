package com.iafenvoy.sow.entity.ardoni.random;

import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class NestorisArdoniEntity extends ArdoniEntity {
    public NestorisArdoniEntity(EntityType<? extends ArdoniEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.NESTORIS;
    }
}
