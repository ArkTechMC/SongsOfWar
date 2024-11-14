package com.iafenvoy.sow.particle;

import com.iafenvoy.neptune.util.function.consumer.Consumer3;
import com.iafenvoy.sow.mixin.WorldAccessor;
import com.iafenvoy.sow.registry.SowParticles;
import com.iafenvoy.sow.util.SowMath;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Uuids;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

import java.util.Locale;
import java.util.UUID;

public class LaserParticleBuilder extends ParticleType<LaserParticleBuilder> implements ParticleEffect {
    public static final Factory<LaserParticleBuilder> FACTORY = new Factory<>() {
        @Override
        public LaserParticleBuilder read(ParticleType<LaserParticleBuilder> type, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            double pitch = reader.readDouble();
            reader.expect(' ');
            double yaw = reader.readDouble();
            reader.expect(' ');
            double distance = reader.readDouble();
            reader.expect(' ');
            float energyScale = reader.readFloat();
            return new LaserParticleBuilder(null, Math.toRadians(pitch), Math.toRadians(yaw), distance, 0, energyScale);
        }

        @Override
        public LaserParticleBuilder read(ParticleType<LaserParticleBuilder> type, PacketByteBuf buf) {
            return new LaserParticleBuilder(buf.readBoolean() ? buf.readUuid() : null, buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readFloat());
        }
    };
    public static final Codec<LaserParticleBuilder> CODEC = RecordCodecBuilder.create(i -> i.group(
            Uuids.CODEC.optionalFieldOf("owner", null).forGetter(LaserParticleBuilder::getOwner),
            Codec.DOUBLE.fieldOf("pitch").forGetter(LaserParticleBuilder::getPitch),
            Codec.DOUBLE.fieldOf("yaw").forGetter(LaserParticleBuilder::getYaw),
            Codec.DOUBLE.fieldOf("distance").forGetter(LaserParticleBuilder::getDistance),
            Codec.DOUBLE.fieldOf("offset").forGetter(LaserParticleBuilder::getOffset),
            Codec.FLOAT.fieldOf("energyScale").forGetter(LaserParticleBuilder::getEnergyScale)
    ).apply(i, LaserParticleBuilder::new));
    @Nullable
    private final UUID owner;
    private double pitch, yaw;
    private final double distance, offset;
    private final float energyScale;

    public LaserParticleBuilder(@Nullable UUID owner, double pitch, double yaw, double distance, double offset, float energyScale) {
        super(true, FACTORY);
        this.owner = owner;
        this.pitch = pitch;
        this.yaw = yaw;
        this.distance = distance;
        this.offset = offset;
        this.energyScale = energyScale;
    }

    @NotNull
    @Override
    public ParticleType<?> getType() {
        return SowParticles.LASER.get();
    }

    @Override
    public void write(@NotNull PacketByteBuf buf) {
        if (this.owner != null) {
            buf.writeBoolean(true);
            buf.writeUuid(this.owner);
        } else buf.writeBoolean(false);
        buf.writeDouble(this.pitch);
        buf.writeDouble(this.yaw);
        buf.writeDouble(this.distance);
        buf.writeDouble(this.offset);
        buf.writeFloat(this.energyScale);
    }

    @NotNull
    @Override
    public String asString() {
        return String.format(Locale.ROOT, "%s p=%.2f y=%.2f d=%.2f s=%.2f", Registries.PARTICLE_TYPE.getId(this.getType()), this.pitch, this.yaw, this.distance, this.energyScale);
    }

    @Nullable
    public UUID getOwner() {
        return this.owner;
    }

    @Override
    public Codec<LaserParticleBuilder> getCodec() {
        return CODEC;
    }

    public Quaternionf getRotationQuaternion(World world, Consumer3<Double, Double, Double> positionUpdater) {
        if (this.owner != null && world != null) {
            Entity entity = ((WorldAccessor) world).getEntityLookup().get(this.owner);
            if (entity != null) {
                this.pitch = Math.toRadians(entity.getPitch() + 90);
                this.yaw = Math.toRadians(-entity.getHeadYaw());
                Vec3d rotation = SowMath.getRotationVectorUnit(entity.getPitch(), entity.getHeadYaw());
                Vec3d pos = entity.getPos().add(0, 1, 0).add(rotation.multiply(this.offset));
                positionUpdater.accept(pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return new Quaternionf().rotateX((float) this.pitch).rotateLocalY((float) this.yaw);
    }

    public double getPitch() {
        return this.pitch;
    }

    public double getYaw() {
        return this.yaw;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getOffset() {
        return this.offset;
    }

    public float getEnergyScale() {
        return this.energyScale;
    }
}