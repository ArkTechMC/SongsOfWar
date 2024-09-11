package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class FemaleFolkEntity extends AbstractTownsFolkEntity {
    public FemaleFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "female";
    }

    @Override
    public int getVariantCount() {
        return 36;
    }
}
