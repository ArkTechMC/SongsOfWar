package com.iafenvoy.sow.entity.magnorite;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class IgneousEntity extends AbstractMagnoriteEntity {
    public IgneousEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/magnorite/igneous.png");
    }

    @Override
    public Optional<Identifier> getMarkerTextureId() {
        return Optional.of(new Identifier(SongsOfWar.MOD_ID, "textures/entity/magnorite/igneous_marker.png"));
    }
}
