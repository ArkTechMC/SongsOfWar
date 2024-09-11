package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.object.BannerUtil;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Pair;

public final class SowBanners {
    public static final ItemStack CONCHORD = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".conchord", Items.GREEN_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.BROWN),
            new Pair<>(BannerPatterns.TRIANGLE_BOTTOM, DyeColor.BROWN),
            new Pair<>(BannerPatterns.CROSS, DyeColor.WHITE)
    );
    public static final ItemStack CONCHORD_SIMPLE = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".conchord_simple", Items.BROWN_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.WHITE),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.GREEN)
    );
    public static final ItemStack CROWN_PEAK = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".crown_peak", Items.GRAY_BANNER,
            new Pair<>(BannerPatterns.BRICKS, DyeColor.LIGHT_GRAY),
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.PURPLE),
            new Pair<>(BannerPatterns.BORDER, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRAIGHT_CROSS, DyeColor.WHITE),
            new Pair<>(BannerPatterns.RHOMBUS, DyeColor.GRAY),
            new Pair<>(BannerPatterns.CIRCLE, DyeColor.WHITE)
    );
    public static final ItemStack CYDONIA= BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".cydonia", Items.WHITE_BANNER,
            new Pair<>(BannerPatterns.HALF_HORIZONTAL, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRIPE_MIDDLE, DyeColor.ORANGE),
            new Pair<>(BannerPatterns.RHOMBUS, DyeColor.ORANGE)
    );
    public static final ItemStack CYDONIA_SIMPLE = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".cydonia_simple", Items.WHITE_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.ORANGE)
    );
    public static final ItemStack FELDEN = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".felden", Items.BLACK_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.GREEN),
            new Pair<>(BannerPatterns.STRIPE_CENTER, DyeColor.GREEN),
            new Pair<>(BannerPatterns.FLOWER, DyeColor.LIME),
            new Pair<>(BannerPatterns.RHOMBUS, DyeColor.BLACK),
            new Pair<>(BannerPatterns.CIRCLE, DyeColor.LIME)
    );
    public static final ItemStack FELDEN_SIMPLE = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".felden_simple", Items.GREEN_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.LIME),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.BLACK)
    );
    public static final ItemStack HYDRAPHEL = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".hydraphel", Items.GRAY_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.CROSS, DyeColor.WHITE),
            new Pair<>(BannerPatterns.TRIANGLE_BOTTOM, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.FLOWER, DyeColor.WHITE),
            new Pair<>(BannerPatterns.RHOMBUS, DyeColor.WHITE),
            new Pair<>(BannerPatterns.CIRCLE, DyeColor.GRAY)
    );
    public static final ItemStack HYDRAPHEL_SIMPLE = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".hydraphel_simple", Items.LIGHT_BLUE_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.WHITE),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.GRAY)
    );
    public static final ItemStack KARTHEN = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".karthen", Items.RED_BANNER,
            new Pair<>(BannerPatterns.TRIANGLE_TOP, DyeColor.BLACK),
            new Pair<>(BannerPatterns.TRIANGLE_BOTTOM, DyeColor.BLACK),
            new Pair<>(BannerPatterns.TRIANGLES_TOP, DyeColor.GRAY),
            new Pair<>(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.GRAY),
            new Pair<>(BannerPatterns.CURLY_BORDER, DyeColor.BLACK),
            new Pair<>(BannerPatterns.RHOMBUS, DyeColor.GRAY)
    );
    public static final ItemStack KARTHEN_SIMPLE = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".karthen_simple", Items.RED_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.GRAY),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.BLACK)
    );
    public static final ItemStack NORTHWIND = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".northwind", Items.BLUE_BANNER,
            new Pair<>(BannerPatterns.GRADIENT, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.TRIANGLES_TOP, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.WHITE),
            new Pair<>(BannerPatterns.FLOWER, DyeColor.WHITE)
    );
    public static final ItemStack NORTHWIND_SIMPLE = BannerUtil.create("banner." + SongsOfWar.MOD_ID + ".northwind_simple", Items.WHITE_BANNER,
            new Pair<>(BannerPatterns.STRIPE_TOP, DyeColor.LIGHT_BLUE),
            new Pair<>(BannerPatterns.STRIPE_BOTTOM, DyeColor.BLUE)
    );
}
