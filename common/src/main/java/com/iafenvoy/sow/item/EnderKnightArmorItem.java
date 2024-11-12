package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.object.item.ArmorMaterialUtil;
import com.iafenvoy.neptune.render.armor.IArmorTextureProvider;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class EnderKnightArmorItem extends ArmorItem implements IArmorTextureProvider {
    public EnderKnightArmorItem(Type type) {
        super(ArmorMaterialUtil.of("ender_knight", new int[]{13, 15, 16, 11}, 40, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.5F, () -> Items.OBSIDIAN), type, new Settings().fireproof().arch$tab(SowItemGroups.ITEMS));
    }

    @Override
    public Identifier getArmorTexture(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot, String s) {
        return new Identifier(SongsOfWar.MOD_ID, "textures/models/armor/ender_knight_layer_" + (equipmentSlot == EquipmentSlot.LEGS ? 2 : 1) + ".png");
    }
}
