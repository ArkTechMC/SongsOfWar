package com.iafenvoy.sow.item;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.EnchantmentFragmentInfo;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnchantmentFragmentItem extends Item {
    private final EnchantmentFragmentInfo info;

    public EnchantmentFragmentItem(EnchantmentFragmentInfo info, Settings settings) {
        super(settings.maxCount(4).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
        this.info = info;
    }

    public EnchantmentFragmentInfo getInfo() {
        return this.info;
    }

    @Override
    public String getTranslationKey() {
        return "item." + SongsOfWar.MOD_ID + ".enchantment_fragment";
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        this.info.applyTooltip(this, tooltip);
    }
}
