package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class SowTags {
    public static final TagKey<Item> SOLDIER_WEAPONS = TagKey.of(RegistryKeys.ITEM, new Identifier(SongsOfWar.MOD_ID, "soldier_weapons"));
    public static final TagKey<Item> GUARD_WEAPONS = TagKey.of(RegistryKeys.ITEM, new Identifier(SongsOfWar.MOD_ID, "guard_weapons"));

    public static void init() {
    }
}
