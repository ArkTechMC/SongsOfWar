package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class SowItemGroups {
    public static final DeferredRegister<ItemGroup> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final RegistrySupplier<ItemGroup> ITEMS= REGISTRY.register("items",()->CreativeTabRegistry.create(Text.translatable("itemGroup."+SongsOfWar.MOD_ID+".items"),()->new ItemStack(SowBlocks.AGGRESSIUM_CUBE.get())));
}
