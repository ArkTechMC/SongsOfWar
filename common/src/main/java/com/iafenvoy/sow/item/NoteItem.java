package com.iafenvoy.sow.item;

import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class NoteItem extends Item {
    private static final Map<PowerCategory, Item> ITEMS = new HashMap<>();
    private final PowerCategory category;

    public NoteItem(PowerCategory category) {
        super(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
        this.category = category;
        ITEMS.put(this.category, this);
    }

    public PowerCategory getCategory() {
        return this.category;
    }

    public static Item getItem(PowerCategory category) {
        return ITEMS.getOrDefault(category, Items.AIR);
    }
}
