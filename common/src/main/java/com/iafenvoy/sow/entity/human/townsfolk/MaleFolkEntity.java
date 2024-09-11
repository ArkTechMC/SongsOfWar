package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class MaleFolkEntity extends AbstractTownsFolkEntity {
    public MaleFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "male";
    }

    @Override
    public int getVariantCount() {
        return 34;
    }
}
