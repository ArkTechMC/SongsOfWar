package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.neptune.network.ClientNetworkHelper;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.item.block.ArdoniGraveBlock;
import com.iafenvoy.sow.registry.SowBlockEntities;
import com.iafenvoy.sow.registry.SowBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class ArdoniGraveBlockEntity extends BlockEntity {
    private long seed;
    private boolean fixed;
    private ArdoniType ardoniType = ArdoniType.NONE;
    private boolean fulfulled = false;

    public ArdoniGraveBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.ARDONI_GRAVE.get(), pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.setSeed(nbt.getLong("seed"));
        this.setFixed(nbt.getBoolean("fixed"));
        this.setArdoniType(ArdoniType.byId(nbt.getString("type")));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("seed", this.getSeed());
        nbt.putBoolean("fixed", this.isFixed());
        nbt.putString("type", this.getArdoniType().id());
        this.fulfulled = true;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public long getSeed() {
        return this.seed;
    }

    public void setArdoniType(ArdoniType ardoniType) {
        this.ardoniType = ardoniType;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public ArdoniType getArdoniType() {
        return this.ardoniType;
    }

    public boolean activated() {
        return this.getCachedState().get(ArdoniGraveBlock.ACTIVATED);
    }

    @Environment(EnvType.CLIENT)
    public float getRotationDegree() {
        if (!this.fulfulled) ClientNetworkHelper.requestBlockEntityData(this.pos);
        return -this.getCachedState().get(ArdoniGraveBlock.FACING).asRotation() + 180;
    }

    public static ItemStack buildGrave(long seed, boolean fixed, ArdoniType type) {
        NbtCompound nbt = new NbtCompound();
        nbt.putLong("seed", seed);
        nbt.putBoolean("fixed", fixed);
        nbt.putString("type", type.id());
        ItemStack stack = new ItemStack(SowBlocks.ARDONI_GRAVE.get());
        stack.setSubNbt("BlockEntityTag", nbt);
        return stack;
    }
}
