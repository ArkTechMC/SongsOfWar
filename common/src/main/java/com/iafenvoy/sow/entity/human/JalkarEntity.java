package com.iafenvoy.sow.entity.human;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowWeapons;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class JalkarEntity extends AbstractHumanEntity {
    public static final Identifier TEXTURE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/human/jalkar.png");

    public JalkarEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setStackInHand(Hand.MAIN_HAND,new ItemStack(SowWeapons.SWORD_IRON.get()));
    }

    @Override
    public Identifier getTextureId() {
        return TEXTURE;
    }
}
