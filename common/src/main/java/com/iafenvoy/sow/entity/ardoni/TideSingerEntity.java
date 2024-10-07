package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Optional;

public class TideSingerEntity extends AbstractArdoniEntity {
    public static final Identifier TEXTURE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/tide_singer.png");
    public static final Identifier TEXTURE_MARKER = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/tide_singer_marker.png");

    public TideSingerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setStackInHand(Hand.MAIN_HAND, GlintManager.YELLOW.apply(new ItemStack(SowWeapons.STAFF_TIDE_SINGER.get()), true));
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
        return new Color4i(255, 255, 0, 255);
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.NESTORIS;
    }
}
