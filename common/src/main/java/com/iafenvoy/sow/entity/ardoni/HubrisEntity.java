package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class HubrisEntity extends AbstractArdoniEntity {
    public HubrisEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getSkinTexture() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/hubris.png");
    }

    @Override
    public Optional<Identifier> getMarkerTexture() {
        return Optional.of(new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/hubris_marker.png"));
    }

    @Override
    public Color4i getColor() {
        return new Color4i(255, 255, 0, 255);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.NESTORIS;
    }
}
