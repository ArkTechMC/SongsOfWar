package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class ScholarFolkEntity extends AbstractTownsFolkEntity {
    public ScholarFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "scholar";
    }

    @Override
    public int getVariantCount() {
        return 11;
    }
}
