package com.iafenvoy.sow.entity.netheran;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class PythusEntity extends AbstractNetheranEntity {
    public PythusEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/netheran/pythus.png");
    }

    @Override
    public Optional<Identifier> getMarkerTextureId() {
        return Optional.of(new Identifier(SongsOfWar.MOD_ID, "textures/entity/netheran/pythus_marker.png"));
    }
}
