package com.iafenvoy.sow.particle;

import com.iafenvoy.neptune.util.function.consumer.Consumer3;
import com.iafenvoy.sow.mixin.WorldAccessor;
import com.iafenvoy.sow.registry.SowParticles;
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

public final class LaserParticleBuilder extends ParticleType<LaserParticleBuilder> implements ParticleEffect {
    public static final Factory<LaserParticleBuilder> FACTORY = new Factory<>() {
        @Override
        public LaserParticleBuilder read(ParticleType<LaserParticleBuilder> type, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            double rotationX = reader.readDouble();
            reader.expect(' ');
            double rotationY = reader.readDouble();
            reader.expect(' ');
            double rotationZ = reader.readDouble();
            reader.expect(' ');
            double distance = reader.readDouble();
            reader.expect(' ');
            float energyScale = reader.readFloat();
            return new LaserParticleBuilder(null, new Vec3d(rotationX, rotationY, rotationZ), distance, energyScale);
        }

        @Override
        public LaserParticleBuilder read(ParticleType<LaserParticleBuilder> type, PacketByteBuf buf) {
            return new LaserParticleBuilder(buf.readBoolean() ? buf.readUuid() : null, new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble()), buf.readDouble(), buf.readFloat());
        }
    };
    public static final Codec<LaserParticleBuilder> CODEC = RecordCodecBuilder.create(val -> val.group(
            Uuids.CODEC.optionalFieldOf("owner", null).forGetter(LaserParticleBuilder::getOwner),
            Vec3d.CODEC.fieldOf("rotation").forGetter(LaserParticleBuilder::getRotation),
            Codec.DOUBLE.fieldOf("distance").forGetter(LaserParticleBuilder::getDistance),
            Codec.FLOAT.fieldOf("energyScale").forGetter(LaserParticleBuilder::getEnergyScale)
    ).apply(val, LaserParticleBuilder::new));
    @Nullable
    private final UUID owner;
    private Vec3d rotation;
    private final double distance;
    private final float energyScale;

    public LaserParticleBuilder(@Nullable UUID owner, Vec3d rotation, double distance, float energyScale) {
        super(true, FACTORY);
        this.owner = owner;
        this.rotation = rotation;
        this.distance = distance;
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
        buf.writeDouble(this.distance);
        buf.writeFloat(this.energyScale);
    }

    @NotNull
    @Override
    public String asString() {
        return String.format(Locale.ROOT, "%s r=%s d=%.2f s=%.2f", Registries.PARTICLE_TYPE.getId(this.getType()), this.getRotation(), this.distance, this.energyScale);
    }

    @Nullable
    public UUID getOwner() {
        return this.owner;
    }

    public Vec3d getRotation() {
        return this.rotation;
    }

    public float getEnergyScale() {
        return this.energyScale;
    }

    public double getDistance() {
        return this.distance;
    }

    public Quaternionf getRotationQuaternion(World world, Consumer3<Double, Double, Double> positionUpdater) {
        if (this.owner != null && world != null) {
            Entity entity = ((WorldAccessor) world).getEntityLookup().get(this.owner);
            if (entity != null) {
                Vec3d pos = entity.getPos();
                this.rotation = new Vec3d(Math.toRadians(entity.getPitch() + 90), Math.toRadians(-entity.getHeadYaw()), 0);
                positionUpdater.accept(pos.getX(), pos.getY() + 1, pos.getZ());
            }
        }
        return new Quaternionf().rotateX((float) this.rotation.x).rotateLocalY((float) this.rotation.y);
    }

    @Override
    public Codec<LaserParticleBuilder> getCodec() {
        return CODEC;
    }
}