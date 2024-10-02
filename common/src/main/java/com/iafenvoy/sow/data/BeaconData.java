package com.iafenvoy.sow.data;

import com.iafenvoy.sow.SongsOfWar;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BeaconData extends PersistentState {
    private static final String ID = "beaconData";
    private static final Codec<List<SingleBeaconData>> CODEC = RecordCodecBuilder.<SingleBeaconData>create(i1 -> i1.group(
            BlockPos.CODEC.fieldOf("pos").forGetter(SingleBeaconData::pos),
            Codecs.TEXT.fieldOf("name").forGetter(SingleBeaconData::name)
    ).apply(i1, SingleBeaconData::new)).listOf();
    private final List<SingleBeaconData> beaconPos;

    private BeaconData() {
        this.beaconPos = new ArrayList<>();
    }

    private BeaconData(NbtCompound compound) {
        this.beaconPos = new ArrayList<>(CODEC.parse(NbtOps.INSTANCE, compound.get(ID)).getOrThrow(true, SongsOfWar.LOGGER::error));
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.put(ID, CODEC.encodeStart(NbtOps.INSTANCE, this.beaconPos).getOrThrow(true, SongsOfWar.LOGGER::error));
        return nbt;
    }

    public List<SingleBeaconData> getBeaconPos() {
        return this.beaconPos;
    }

    public Optional<SingleBeaconData> get(BlockPos pos) {
        return this.beaconPos.stream().filter(x -> x.pos.equals(pos)).findFirst();
    }

    public void add(BlockPos pos, Text name) {
        this.remove(pos);
        this.beaconPos.add(new SingleBeaconData(pos, name));
        this.markDirty();
    }

    public void remove(BlockPos pos) {
        this.beaconPos.removeIf(x -> x.pos.equals(pos));
        this.markDirty();
    }

    public static BeaconData readNbt(NbtCompound nbt) {
        return new BeaconData(nbt);
    }

    public static BeaconData getInstance(ServerWorld world) {
        BeaconData data = world.getPersistentStateManager().getOrCreate(BeaconData::readNbt, BeaconData::new, ID);
        int cnt = data.beaconPos.size();
        data.beaconPos.removeIf(x -> !world.getBlockState(x.pos).isOf(Blocks.BEACON));
        int delta = cnt - data.beaconPos.size();
        if (delta > 0) SongsOfWar.LOGGER.warn("Remove {} wrong teleport beacon data.", delta);
        return data;
    }

    public record SingleBeaconData(BlockPos pos, Text name) {
    }
}
