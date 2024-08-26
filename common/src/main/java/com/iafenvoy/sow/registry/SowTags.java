package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class SowTags {
    public static final TagKey<Item> SONG_STONE=create("song_stone");
    public static final TagKey<Item> SOW_WEAPON=create("sow_weapon");
    public static final TagKey<Item> SOW_REVERSE_WEAPON=create("sow_reverse_weapon");

    private static TagKey<Item> create(String id){
        return TagKey.of(RegistryKeys.ITEM,new Identifier(SongsOfWar.MOD_ID,id));
    }
}
