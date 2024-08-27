package com.iafenvoy.sow.item;

import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

import java.util.function.Function;

public class SowAxeItem extends AxeItem implements SowWeapon {
    public SowAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Function<Settings, Settings> settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.apply(new Settings().arch$tab(SowItemGroups.WEAPONS)));
    }
}
