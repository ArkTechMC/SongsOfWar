package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class SailorFolkEntity extends AbstractTownsFolkEntity {
    public SailorFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "sailor";
    }

    @Override
    public int getVariantCount() {
        return 2;
    }
}
