package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class LeatherWorkerFolkEntity extends AbstractTownsFolkEntity {
    public LeatherWorkerFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "leather_worker";
    }

    @Override
    public int getVariantCount() {
        return 1;
    }
}
