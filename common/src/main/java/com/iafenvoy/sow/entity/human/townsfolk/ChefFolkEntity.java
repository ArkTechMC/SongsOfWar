package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class ChefFolkEntity extends AbstractTownsFolkEntity {
    public ChefFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "chef";
    }

    @Override
    public int getVariantCount() {
        return 1;
    }
}
