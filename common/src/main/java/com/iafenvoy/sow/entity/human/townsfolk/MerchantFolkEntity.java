package com.iafenvoy.sow.entity.human.townsfolk;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class MerchantFolkEntity extends AbstractTownsFolkEntity {
    public MerchantFolkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public String job() {
        return "merchant";
    }

    @Override
    public int getVariantCount() {
        return 8;
    }
}
