package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class OldFolkEntity extends AbstractTownsFolkEntity {
    public OldFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "old";
    }

    @Override
    public int getVariantCount() {
        return 3;
    }
}
