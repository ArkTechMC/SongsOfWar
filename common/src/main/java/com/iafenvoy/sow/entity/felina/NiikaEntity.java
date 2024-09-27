package com.iafenvoy.sow.entity.felina;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class NiikaEntity extends AbstractFelinaEntity {
    public NiikaEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setStackInHand(Hand.MAIN_HAND, new ItemStack(SowWeapons.ZERU_LONG_SWORD_IRON.get()));
        this.setStackInHand(Hand.OFF_HAND, new ItemStack(SowWeapons.ZERU_LONG_SWORD_IRON_1.get()));
    }

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/felina/niika.png");
    }

    @Override
    public float getScale() {
        return 0.95f;
    }
}
