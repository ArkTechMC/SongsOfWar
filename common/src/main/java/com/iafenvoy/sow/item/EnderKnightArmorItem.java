package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.render.armor.IArmorTextureProvider;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class EnderKnightArmorItem extends ArmorItem implements IArmorTextureProvider {
    public EnderKnightArmorItem(Type type) {
        super(ArmorMaterials.NETHERITE, type, new Settings().fireproof().arch$tab(SowItemGroups.ITEMS));
    }

    @Override
    public Identifier getArmorTexture(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot, String s) {
        return new Identifier(SongsOfWar.MOD_ID, "textures/models/armor/ender_knight_layer_" + (equipmentSlot == EquipmentSlot.LEGS ? 2 : 1) + ".png");
    }
}
