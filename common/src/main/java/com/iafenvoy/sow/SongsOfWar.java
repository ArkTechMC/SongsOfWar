package com.iafenvoy.sow;

import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowWeapons;
import com.iafenvoy.sow.render.glint.GlintManager;
import com.mojang.logging.LogUtils;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import org.slf4j.Logger;

public class SongsOfWar {
    public static final String MOD_ID = "sow";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        SowBlocks.REGISTRY.register();
        SowItems.REGISTRY.register();
        SowWeapons.REGISTRY.register();
        SowItemGroups.REGISTRY.register();
    }

    public static void process() {
        CreativeTabRegistry.appendBuiltinStack(Registries.ITEM_GROUP.get(ItemGroups.COMBAT), () -> GlintManager.BLUE.apply(new ItemStack(SowWeapons.SCYTHE_IRON.get())));
        GlintManager.alwaysRender();
    }
}
