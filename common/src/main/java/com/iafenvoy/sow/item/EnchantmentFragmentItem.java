package com.iafenvoy.sow.item;

import com.google.common.collect.Multimap;
import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class EnchantmentFragmentItem extends Item {
    private static final UUID MODIFIER_UUID = UUID.fromString("72e1b659-d5b8-4472-91e2-085bba5ac696");
    private final GlintManager.GlintHolder glint;

    public EnchantmentFragmentItem(GlintManager.GlintHolder glint) {
        super(new Settings().maxCount(4).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
        this.glint = glint;
    }

    public GlintManager.GlintHolder getGlint() {
        return this.glint;
    }

    @Override
    public String getTranslationKey() {
        return "item." + SongsOfWar.MOD_ID + ".enchantment_fragment";
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(this.getTranslationKey() + "." + this.glint.id()).formatted(this.glint.textColor()));
        tooltip.add(Text.literal(formatNumber(3) + " ").append(Text.translatable(EntityAttributes.GENERIC_ATTACK_DAMAGE.getTranslationKey())));
        tooltip.add(Text.literal(formatNumber(0.5) + " ").append(Text.translatable(EntityAttributes.GENERIC_ATTACK_SPEED.getTranslationKey())));
    }

    public ItemStack applyToStack(ItemStack stack) {
        this.glint.apply(stack, true);
        stack.addEnchantment(Enchantments.UNBREAKING, 1);
        Multimap<EntityAttribute, EntityAttributeModifier> attributes = stack.getItem().getAttributeModifiers(EquipmentSlot.MAINHAND);
        stack.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, buildByUuid(EntityAttributes.GENERIC_ATTACK_DAMAGE, attributes, 3), EquipmentSlot.MAINHAND);
        stack.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, buildByUuid(EntityAttributes.GENERIC_ATTACK_SPEED, attributes, 0.5), EquipmentSlot.MAINHAND);
        if (stack.getName() instanceof MutableText mutableText)
            stack.setCustomName(mutableText.fillStyle(Style.EMPTY.withItalic(false)).formatted(this.glint.textColor()));//TODO: Bad code, should mixin renderer
        return stack;
    }

    private static EntityAttributeModifier buildByUuid(EntityAttribute attribute, Multimap<EntityAttribute, EntityAttributeModifier> map, double additional) {
        UUID uuid = map.get(attribute).stream().findFirst().map(EntityAttributeModifier::getId).orElse(MODIFIER_UUID);
        return new EntityAttributeModifier(uuid, "Enchantment fragment", map.get(attribute).stream().filter(x -> x.getId().equals(uuid)).reduce(additional, (p, c) -> p + c.getValue(), Double::sum), EntityAttributeModifier.Operation.ADDITION);
    }

    private static String formatNumber(double number) {
        if (number > 0) return "+" + ItemStack.MODIFIER_FORMAT.format(number);
        return "-" + ItemStack.MODIFIER_FORMAT.format(-number);
    }
}
