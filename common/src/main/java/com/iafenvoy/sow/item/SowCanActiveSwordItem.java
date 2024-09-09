package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.object.item.CanActiveSwordItem;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.item.ToolMaterial;

import java.util.function.Function;

public class SowCanActiveSwordItem extends CanActiveSwordItem implements SowWeapon {
    public SowCanActiveSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Function<Settings, Settings> settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.apply(new Settings().arch$tab(SowItemGroups.WEAPONS)));
    }
}
