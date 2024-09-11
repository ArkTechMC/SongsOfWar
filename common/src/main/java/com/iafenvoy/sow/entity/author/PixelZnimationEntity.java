package com.iafenvoy.sow.entity.author;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class PixelZnimationEntity extends AbstractAuthorEntity {
    public PixelZnimationEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setCustomName(Text.literal("PixelZnimation"));
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/author/pixel_znimation.png");
    }
}
