package com.iafenvoy.sow.entity.necromancer;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class XariaEntity extends AbstractNecromancerEntity {
    public XariaEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/necromancer/xaria.png");
    }
}
