package com.iafenvoy.sow.particle;

import com.iafenvoy.sow.registry.SowParticles;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.command.argument.BlockArgumentParser;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;

import java.util.Locale;

public class BlockDisplayParticleBuilder extends ParticleType<BlockDisplayParticleBuilder> implements ParticleEffect {
    public static final Factory<BlockDisplayParticleBuilder> FACTORY = new Factory<>() {
        @Override
        public BlockDisplayParticleBuilder read(ParticleType<BlockDisplayParticleBuilder> type, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            BlockState blockState = BlockArgumentParser.block(Registries.BLOCK.getReadOnlyWrapper(), reader, false).blockState();
            reader.expect(' ');
            boolean absolute = reader.readBoolean();
            reader.expect(' ');
            double rotationX = reader.readDouble();
            reader.expect(' ');
            double rotationY = reader.readDouble();
            reader.expect(' ');
            double rotationZ = reader.readDouble();
            reader.expect(' ');
            float scale = reader.readFloat();
            reader.expect(' ');
            int duration = reader.readInt();
            return new BlockDisplayParticleBuilder(blockState, absolute, new Vec3d(Math.toRadians(rotationX), Math.toRadians(rotationY), Math.toRadians(rotationZ)), scale, duration);
        }

        @Override
        public BlockDisplayParticleBuilder read(ParticleType<BlockDisplayParticleBuilder> type, PacketByteBuf buf) {
            return new BlockDisplayParticleBuilder(buf.readRegistryValue(Block.STATE_IDS), buf.readBoolean(), new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble()), buf.readFloat(), buf.readInt());
        }
    };
    public static final Codec<BlockDisplayParticleBuilder> CODEC = RecordCodecBuilder.create(i -> i.group(
            BlockState.CODEC.fieldOf("blockState").forGetter(BlockDisplayParticleBuilder::getBlockState),
            Codec.BOOL.fieldOf("absolute").forGetter(BlockDisplayParticleBuilder::isAbsolute),
            Vec3d.CODEC.fieldOf("rotation").forGetter(BlockDisplayParticleBuilder::getRotation),
            Codec.FLOAT.fieldOf("scale").forGetter(BlockDisplayParticleBuilder::getScale),
            Codec.INT.fieldOf("duration").forGetter(BlockDisplayParticleBuilder::getDuration)
    ).apply(i, BlockDisplayParticleBuilder::new));
    private final BlockState blockState;
    private final boolean absolute;
    private final Vec3d rotation;
    private final float scale;
    private final int duration;

    public BlockDisplayParticleBuilder(BlockState blockState, boolean absolute, Vec3d rotation, float scale, int duration) {
        super(true, FACTORY);
        this.blockState = blockState;
        this.absolute = absolute;
        this.rotation = rotation;
        this.scale = scale;
        this.duration = duration;
    }

    @Override
    public ParticleType<?> getType() {
        return SowParticles.BLOCK_DISPLAY.get();
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeRegistryValue(Block.STATE_IDS, this.blockState);
        buf.writeBoolean(this.absolute);
        buf.writeDouble(this.rotation.x);
        buf.writeDouble(this.rotation.y);
        buf.writeDouble(this.rotation.z);
        buf.writeFloat(this.scale);
        buf.writeInt(this.duration);
    }

    @Override
    public String asString() {
        return String.format(Locale.ROOT, "%s b=%s r=%s d=%d", Registries.PARTICLE_TYPE.getId(this.getType()), this.blockState.toString(), this.getRotation().toString(), this.duration);
    }

    @Override
    public Codec<BlockDisplayParticleBuilder> getCodec() {
        return CODEC;
    }

    public Quaternionf getRotationQuaternion() {
        if (this.absolute)
            return new Quaternionf().rotateX((float) this.rotation.x).rotationY((float) this.rotation.y).rotationZ((float) this.rotation.z);
        return new Quaternionf().rotateX((float) this.rotation.x).rotateLocalY((float) this.rotation.y).rotateLocalZ((float) this.rotation.z);
    }

    public BlockState getBlockState() {
        return this.blockState;
    }

    public boolean isAbsolute() {
        return this.absolute;
    }

    public Vec3d getRotation() {
        return this.rotation;
    }

    public float getScale() {
        return this.scale;
    }

    public int getDuration() {
        return this.duration;
    }
}
