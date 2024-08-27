package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.item.SongStoneItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static net.minecraft.item.ItemStack.MODIFIER_FORMAT;

public class SongStoneInfo {
    private static final UUID MODIFIER_UUID = UUID.fromString("72e1b659-d5b8-4472-91e2-085bba5ac696");
    private final GlintManager.GlintHolder glint;
    private final Map<EntityAttribute, Double> MODIFIERS = new HashMap<>();
    private final int levelCost;

    protected SongStoneInfo(GlintManager.GlintHolder glint, int levelCost) {
        this.glint = glint;
        this.levelCost = levelCost;
    }

    public static SongStoneInfo of(GlintManager.GlintHolder glint, int levelCost) {
        return new SongStoneInfo(glint, levelCost);
    }

    public SongStoneInfo dmg(double damageBonus) {
        return this.modify(EntityAttributes.GENERIC_ATTACK_DAMAGE, damageBonus);
    }

    public SongStoneInfo kb(double knockbackBonus) {
        return this.modify(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, knockbackBonus);
    }

    public SongStoneInfo spd(double speedBonus) {
        return this.modify(EntityAttributes.GENERIC_ATTACK_SPEED, speedBonus);
    }

    public SongStoneInfo luck(double luckBonus) {
        return this.modify(EntityAttributes.GENERIC_LUCK, luckBonus);
    }

    public SongStoneInfo modify(EntityAttribute attribute, double value) {
        this.MODIFIERS.put(attribute, value);
        return this;
    }

    public ItemStack apply(ItemStack stack) {
        this.glint.apply(stack, true);
        stack.getOrCreateNbt().putString("song_stone", this.getId());
        for (Map.Entry<EntityAttribute, Double> entry : this.MODIFIERS.entrySet())
            if (entry.getValue() != 0)
                stack.addAttributeModifier(entry.getKey(), new EntityAttributeModifier(MODIFIER_UUID, "song_stone", entry.getValue(), EntityAttributeModifier.Operation.ADDITION), EquipmentSlot.MAINHAND);
        if (stack.getName() instanceof MutableText mutableText)
            stack.setCustomName(mutableText.fillStyle(Style.EMPTY.withItalic(false)).formatted(this.glint.textColor()));//TODO: Bad code, should mixin renderer
        return stack;
    }

    public static ItemStack unapply(ItemStack stack) {
        GlintManager.removeGlint(stack);
        stack.getOrCreateNbt().getList("AttributeModifiers", NbtElement.COMPOUND_TYPE).removeIf(x -> x instanceof NbtCompound compound && compound.contains("UUID") && compound.getUuid("UUID").equals(MODIFIER_UUID));
        stack.removeCustomName();
        return stack;
    }

    private static String formatNumber(double number) {
        if (number > 0) return "+" + MODIFIER_FORMAT.format(number);
        return "-" + MODIFIER_FORMAT.format(-number);
    }

    public void applyTooltip(SongStoneItem item, List<Text> tooltips) {
        tooltips.add(Text.translatable(item.getTranslationKey() + "." + this.getId()).formatted(this.glint.textColor()));
        for (Map.Entry<EntityAttribute, Double> entry : this.MODIFIERS.entrySet())
            if (entry.getValue() != 0)
                tooltips.add(Text.literal(formatNumber(entry.getValue()) + " ").append(Text.translatable(entry.getKey().getTranslationKey())));
    }

    public int getLevelCost() {
        return this.levelCost;
    }

    public String getId() {
        return this.glint.id();
    }
}
