package com.iafenvoy.sow.item;

import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.world.SongChunkManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class SongStoneItem extends Item {
    public static final String POWER_KEY = "song_power";

    public SongStoneItem() {
        super(new Settings().rarity(Rarity.UNCOMMON).maxCount(1).arch$tab(SowItemGroups.ITEMS));
    }

    @SuppressWarnings("all")
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (world instanceof ServerWorld serverWorld) {
            if (!(entity instanceof PlayerEntity player) || !SongPowerData.byPlayer(player).isEnabled())
                stack.getOrCreateNbt().remove(POWER_KEY);
            else {
                PowerCategory category = SongChunkManager.find(serverWorld, entity.getChunkPos());
                NbtCompound compound = stack.getOrCreateNbt();
                if (category != null) compound.putString(POWER_KEY, category.getId());
                else compound.remove(POWER_KEY);
            }
        }
    }
}
