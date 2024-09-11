package com.iafenvoy.sow.data;

import com.iafenvoy.sow.registry.SowBanners;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.Nullable;

public enum KingdomType {
    Conchord("conchord", SowBanners.CONCHORD, SowBanners.CONCHORD_SIMPLE),
    CrownPeak("crown_peak", SowBanners.CROWN_PEAK, null),
    Cydonia("cydonia", SowBanners.CYDONIA, SowBanners.CYDONIA_SIMPLE),
    Etherea("etherea", null, null),
    Felden("felden", SowBanners.FELDEN, SowBanners.FELDEN_SIMPLE),
    General("general", null, null),
    Hydraphel("hydraphel", SowBanners.HYDRAPHEL, SowBanners.HYDRAPHEL_SIMPLE),
    Karthen("karthen", SowBanners.KARTHEN, SowBanners.KARTHEN_SIMPLE),
    Northwind("northwind", SowBanners.NORTHWIND, SowBanners.NORTHWIND_SIMPLE);
    private final String id;
    @Nullable
    private final ItemStack banner;
    @Nullable
    private final ItemStack bannerSmall;

    KingdomType(String id, @Nullable ItemStack banner, @Nullable ItemStack bannerSmall) {
        this.id = id;
        this.banner = banner;
        this.bannerSmall = bannerSmall;
    }

    public String getId() {
        return this.id;
    }

    public ItemStack getShield() {
        ItemStack stack = new ItemStack(Items.SHIELD);
        if (this.banner == null) return stack;
        NbtCompound compound = BlockItem.getBlockEntityNbt(this.banner);
        assert compound != null;
        BlockItem.setBlockEntityNbt(stack, BlockEntityType.BANNER, compound);
        return stack;
    }
}
