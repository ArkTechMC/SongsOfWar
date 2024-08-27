package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.item.SongStoneItem;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.item.ItemStack.MODIFIER_FORMAT;

public class SongStoneInfo {
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

    public SongStoneInfo modify(EntityAttribute attribute, double value) {
        this.MODIFIERS.put(attribute, value);
        return this;
    }

    public ItemStack apply(ItemStack stack) {
        this.glint.apply(stack, true);
        stack.getOrCreateNbt().putString("song_stone", this.getId());
        for (Map.Entry<EntityAttribute, Double> entry : this.MODIFIERS.entrySet())
            if (entry.getValue() != 0)
                stack.addAttributeModifier(entry.getKey(), new EntityAttributeModifier("song_stone", entry.getValue(), EntityAttributeModifier.Operation.ADDITION), null);
        if (stack.getName() instanceof MutableText mutableText)
            stack.setCustomName(mutableText.fillStyle(Style.EMPTY.withItalic(false)).formatted(this.glint.textColor()));//TODO: Bad code, should mixin renderer
        //TODO: Config
        stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);
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
