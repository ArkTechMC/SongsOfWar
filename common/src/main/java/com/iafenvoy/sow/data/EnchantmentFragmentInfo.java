package com.iafenvoy.sow.data;

import com.google.common.collect.Multimap;
import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.item.EnchantmentFragmentItem;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.List;
import java.util.UUID;

public class EnchantmentFragmentInfo {
    private static final UUID MODIFIER_UUID = UUID.fromString("72e1b659-d5b8-4472-91e2-085bba5ac696");
    private final GlintManager.GlintHolder glint;
    private final Object2DoubleMap<EntityAttribute> modifiers = new Object2DoubleOpenHashMap<>();
    private final int levelCost;

    protected EnchantmentFragmentInfo(GlintManager.GlintHolder glint, int levelCost) {
        this.glint = glint;
        this.levelCost = levelCost;
    }

    public static EnchantmentFragmentInfo of(GlintManager.GlintHolder glint, int levelCost) {
        return new EnchantmentFragmentInfo(glint, levelCost);
    }

    private static EntityAttributeModifier buildByUuid(EntityAttribute attribute, Multimap<EntityAttribute, EntityAttributeModifier> map, double additional) {
        UUID uuid = map.get(attribute).stream().findFirst().map(EntityAttributeModifier::getId).orElse(MODIFIER_UUID);
        return new EntityAttributeModifier(uuid, "enchantment_fragment", map.get(attribute).stream().filter(x -> x.getId().equals(uuid)).reduce(additional, (p, c) -> p + c.getValue(), Double::sum), EntityAttributeModifier.Operation.ADDITION);
    }

    public static ItemStack unapply(ItemStack stack) {
        GlintManager.removeGlint(stack);
        stack.getOrCreateNbt().remove("Enchantments");
        stack.getOrCreateNbt().remove("AttributeModifiers");
        stack.getOrCreateNbt().remove("enchantment_fragment");
        stack.removeCustomName();
        return stack;
    }

    private static String formatNumber(double number) {
        if (number > 0) return "+" + ItemStack.MODIFIER_FORMAT.format(number);
        return "-" + ItemStack.MODIFIER_FORMAT.format(-number);
    }

    public EnchantmentFragmentInfo dmg(double damageBonus) {
        return this.modify(EntityAttributes.GENERIC_ATTACK_DAMAGE, damageBonus);
    }

    public EnchantmentFragmentInfo kb(double knockbackBonus) {
        return this.modify(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, knockbackBonus);
    }

    public EnchantmentFragmentInfo spd(double speedBonus) {
        return this.modify(EntityAttributes.GENERIC_ATTACK_SPEED, speedBonus);
    }

    public EnchantmentFragmentInfo luck(double luckBonus) {
        return this.modify(EntityAttributes.GENERIC_LUCK, luckBonus);
    }

    public EnchantmentFragmentInfo modify(EntityAttribute attribute, double value) {
        this.modifiers.put(attribute, value);
        return this;
    }

    public ItemStack apply(ItemStack stack) {
        this.glint.apply(stack, true);
        stack.addEnchantment(Enchantments.UNBREAKING, 1);
        stack.getOrCreateNbt().putString("enchantment_fragment", this.getId());
        Multimap<EntityAttribute, EntityAttributeModifier> attributes = stack.getItem().getAttributeModifiers(EquipmentSlot.MAINHAND);
        this.buildByAttribute(stack, EntityAttributes.GENERIC_ATTACK_DAMAGE, attributes);
        this.buildByAttribute(stack, EntityAttributes.GENERIC_ATTACK_SPEED, attributes);
        for (Object2DoubleMap.Entry<EntityAttribute> entry : this.modifiers.object2DoubleEntrySet()) {
            EntityAttribute attribute = entry.getKey();
            if (attribute == EntityAttributes.GENERIC_ATTACK_DAMAGE || attribute == EntityAttributes.GENERIC_ATTACK_SPEED)
                continue;
            stack.addAttributeModifier(attribute, new EntityAttributeModifier(MODIFIER_UUID, "enchantment_fragment", entry.getDoubleValue(), EntityAttributeModifier.Operation.ADDITION), EquipmentSlot.MAINHAND);
        }
        if (stack.getName() instanceof MutableText mutableText)
            stack.setCustomName(mutableText.fillStyle(Style.EMPTY.withItalic(false)).formatted(this.glint.textColor()));//TODO: Bad code, should mixin renderer
        return stack;
    }

    private void buildByAttribute(ItemStack stack, EntityAttribute attribute, Multimap<EntityAttribute, EntityAttributeModifier> map) {
        if (map.containsKey(attribute) || this.modifiers.containsKey(attribute))
            stack.addAttributeModifier(attribute, buildByUuid(attribute, map, this.modifiers.getOrDefault(attribute, 0)), EquipmentSlot.MAINHAND);
    }

    public void applyTooltip(EnchantmentFragmentItem item, List<Text> tooltips) {
        tooltips.add(Text.translatable(item.getTranslationKey() + "." + this.getId()).formatted(this.glint.textColor()));
        for (Object2DoubleMap.Entry<EntityAttribute> entry : this.modifiers.object2DoubleEntrySet())
            if (entry.getDoubleValue() != 0)
                tooltips.add(Text.literal(formatNumber(entry.getDoubleValue()) + " ").append(Text.translatable(entry.getKey().getTranslationKey())));
    }

    public int getLevelCost() {
        return this.levelCost;
    }

    public String getId() {
        return this.glint.id();
    }
}
