package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class LucidiusEntity extends AbstractArdoniEntity {
    public static final Identifier TEXTURE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/lucidius.png");
    public static final Identifier TEXTURE_MARKER = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/lucidius_marker.png");

    public LucidiusEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Identifier getSkinTexture() {
        return TEXTURE;
    }

    @Override
    public Optional<Identifier> getMarkerTexture() {
        return Optional.of(TEXTURE_MARKER);
    }

    @Override
    public Color4i getColor() {
        return new Color4i(209, 94, 95, 255);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.VOLTARIS;
    }
}
