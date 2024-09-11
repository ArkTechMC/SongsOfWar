package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class PoorFolkEntity extends AbstractTownsFolkEntity {
    public PoorFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "poor";
    }

    @Override
    public int getVariantCount() {
        return 8;
    }
}
