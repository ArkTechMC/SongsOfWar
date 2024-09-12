package com.iafenvoy.sow.entity.netharan;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class ChronosEntity extends AbstractNetheranEntity {
    public ChronosEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/netharan/chronos.png");
    }

    @Override
    public Optional<Identifier> getMarkerTextureId() {
        return Optional.of(new Identifier(SongsOfWar.MOD_ID, "textures/entity/netharan/chronos_marker.png"));
    }
}
