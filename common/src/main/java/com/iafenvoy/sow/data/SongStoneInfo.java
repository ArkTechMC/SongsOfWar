package com.iafenvoy.sow.data;

import com.iafenvoy.sow.render.glint.GlintManager;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

public class SongStoneInfo {
    private final GlintManager.GlintHolder glint;
    private final double damageBonus;
    private final double speedBonus;
    private final double knockbackBonus;
    private final int levelCost;

    protected SongStoneInfo(Builder builder) {
        this.glint = builder.glint;
        this.damageBonus = builder.damageBonus;
        this.speedBonus = builder.speedBonus;
        this.knockbackBonus = builder.knockbackBonus;
        this.levelCost = builder.levelCost;
    }

    public void apply(ItemStack stack) {
        this.glint.apply(stack, true);
        if (this.damageBonus != 0)
            stack.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier("song_stone", this.damageBonus, EntityAttributeModifier.Operation.ADDITION), null);
        if (this.speedBonus != 0)
            stack.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier("song_stone", this.speedBonus, EntityAttributeModifier.Operation.ADDITION), null);
        if (this.knockbackBonus != 0)
            stack.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, new EntityAttributeModifier("song_stone", this.knockbackBonus, EntityAttributeModifier.Operation.ADDITION), null);
    }

    public int getLevelCost() {
        return this.levelCost;
    }

    public static class Builder {
        private GlintManager.GlintHolder glint;
        private double damageBonus = 0;
        private double speedBonus = 0;
        private double knockbackBonus = 0;
        private int levelCost = 0;

        public Builder(GlintManager.GlintHolder glint) {
            this.glint = glint;
        }

        public void glint(GlintManager.GlintHolder glint) {
            this.glint = glint;
        }

        public void dmg(double damageBonus) {
            this.damageBonus = damageBonus;
        }

        public void kb(double knockbackBonus) {
            this.knockbackBonus = knockbackBonus;
        }

        public void spd(double speedBonus) {
            this.speedBonus = speedBonus;
        }

        public void cost(int levelCost) {
            this.levelCost = levelCost;
        }

        public SongStoneInfo build() {
            return new SongStoneInfo(this);
        }
    }
}
