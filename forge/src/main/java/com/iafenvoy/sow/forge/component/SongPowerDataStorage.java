package com.iafenvoy.sow.forge.component;

import com.iafenvoy.neptune.forge.component.ITickableCapability;
import com.iafenvoy.sow.power.SongPowerData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public class SongPowerDataStorage implements ITickableCapability {
    private final SongPowerData playerData;

    public SongPowerDataStorage(PlayerEntity player) {
        this.playerData = new SongPowerData(player);
    }

    @Override
    public NbtCompound serializeNBT() {
        return this.playerData.encode();
    }

    @Override
    public void deserializeNBT(NbtCompound compound) {
        this.playerData.decode(compound);
    }

    public SongPowerData getData() {
        return this.playerData;
    }

    @Override
    public void tick() {
        this.playerData.tick();
    }

    @Override
    public boolean isDirty() {
        return this.playerData.isDirty();
    }
}
