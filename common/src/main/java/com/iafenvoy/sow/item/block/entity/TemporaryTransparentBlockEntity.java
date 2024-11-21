package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TemporaryTransparentBlockEntity extends BlockEntity {
    private BlockState state;
    private int tick = -1;

    public TemporaryTransparentBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.TEMPORARY.get(), pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.setState(BlockState.CODEC.parse(NbtOps.INSTANCE, nbt.get("state")).resultOrPartial(SongsOfWar.LOGGER::debug).orElse(Blocks.AIR.getDefaultState()));
        this.setTick(nbt.getInt("tick"));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("state", BlockState.CODEC.encodeStart(NbtOps.INSTANCE, this.getState()).resultOrPartial(SongsOfWar.LOGGER::debug).orElse(new NbtCompound()));
        nbt.putInt("tick", this.tick);
    }

    public BlockState getState() {
        return this.state;
    }

    public void setState(BlockState state) {
        this.state = state;
    }

    public int getTick() {
        return this.tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public static void tick(World world, BlockPos pos, BlockState state, TemporaryTransparentBlockEntity blockEntity) {
        int tick = blockEntity.getTick();
        if (tick == 0) {
            BlockState s = blockEntity.getState();
            if (s != null) world.setBlockState(pos, s, 2, 0);
        } else if (tick > 0) blockEntity.setTick(tick - 1);
    }
}
