package com.iafenvoy.sow.item;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.SongStoneInfo;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.item.Item;

public class SongStoneItem extends Item {
    private final SongStoneInfo info;

    public SongStoneItem(SongStoneInfo.Builder info, Settings settings) {
        super(settings.maxCount(4).arch$tab(SowItemGroups.ITEMS));
        this.info = info.build();
    }

    public SongStoneInfo getInfo() {
        return this.info;
    }

    @Override
    public String getTranslationKey() {
        return "item." + SongsOfWar.MOD_ID + ".song_stone";
    }
}
