package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.type.AbstractSongPower;
import com.iafenvoy.sow.power.type.DummySongPower;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractSongCubeBlockEntity extends BlockEntity {
    private AbstractSongPower<?> power = DummySongPower.EMPTY;

    public AbstractSongCubeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.power = AbstractSongPower.BY_ID.getOrDefault(nbt.getString("songPower"), DummySongPower.EMPTY);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.power != null) nbt.putString("songPower", this.power.getId());
    }

    public void setPower(AbstractSongPower<?> power) {
        this.power = power;
    }

    public AbstractSongPower<?> getPower() {
        return this.power;
    }

    @Override
    public void markRemoved() {
        super.markRemoved();
        Static.songCubeSoundManager.destroy(this.pos);
    }

    protected abstract PowerCategory getCategory();

    public static void tick(World world, BlockPos pos, BlockState state, AbstractSongCubeBlockEntity blockEntity) {
        Static.songCubeSoundManager.startPlaying(pos, blockEntity.getCategory());
    }
}
