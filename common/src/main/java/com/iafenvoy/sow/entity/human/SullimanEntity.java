package com.iafenvoy.sow.entity.human;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class SullimanEntity extends AbstractHumanEntity {
    public static final Identifier TEXTURE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/human/sulliman.png");

    public SullimanEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getTextureId() {
        return TEXTURE;
    }
}
