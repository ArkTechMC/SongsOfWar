package com.iafenvoy.sow.item;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.SongStoneInfo;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SongStoneItem extends Item {
    private final SongStoneInfo info;

    public SongStoneItem(SongStoneInfo info, Settings settings) {
        super(settings.maxCount(4).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
        this.info = info;
    }

    public SongStoneInfo getInfo() {
        return this.info;
    }

    @Override
    public String getTranslationKey() {
        return "item." + SongsOfWar.MOD_ID + ".song_stone";
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        this.info.applyTooltip(this, tooltip);
    }
}
