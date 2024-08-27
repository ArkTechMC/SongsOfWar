package com.iafenvoy.sow.item;

import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class SowAxeItem extends AxeItem implements SowWeapon {
    public SowAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Function<Settings, Settings> settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.apply(new Settings().arch$tab(SowItemGroups.ITEMS)));
    }
}
