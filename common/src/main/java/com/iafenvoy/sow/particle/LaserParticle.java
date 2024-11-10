package com.iafenvoy.sow.particle;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class LaserParticle extends SpriteBillboardParticle {
    private static final float RADIAN_45 = (float) Math.toRadians(45);
    private static final float RADIAN_90 = (float) Math.toRadians(90);
    private final LaserParticleBuilder data;

    private LaserParticle(LaserParticleBuilder data, ClientWorld world, double x, double y, double z, double vx, double vy, double vz, SpriteProvider spriteSet) {
        super(world, x, y, z);
        this.data = data;
        this.setMaxAge(5);
        this.setColor((float) vx, (float) vy, (float) vz);
        this.setSprite(spriteSet);
        this.alpha = 0.11F;
        this.scale = data.getEnergyScale();
    }

    @Override
    public void buildGeometry(VertexConsumer vertexBuilder, Camera renderInfo, float partialTicks) {
        Vec3d view = renderInfo.getPos();
        float newX = (float) (MathHelper.lerp(partialTicks, this.prevPosX, this.x) - view.x);
        float newY = (float) (MathHelper.lerp(partialTicks, this.prevPosY, this.y) - view.y);
        float newZ = (float) (MathHelper.lerp(partialTicks, this.prevPosZ, this.z) - view.z);
        float uMin = this.getMinU();
        float uMax = this.getMaxU();
        float vMin = this.getMinV();
        float vMax = this.getMaxV();
        Quaternionf quaternion = this.data.getRotationQuaternion(MinecraftClient.getInstance().world, (x, y, z) -> {
            this.x = x;
            this.y = y;
            this.z = z;
        });
        quaternion.mul(RotationAxis.POSITIVE_Y.rotation(RADIAN_45));
        this.drawComponent(vertexBuilder, this.getResultVector(quaternion, newX, newY, newZ), uMin, uMax, vMin, vMax);
        Quaternionf quaternion2 = new Quaternionf(quaternion);
        quaternion2.mul(RotationAxis.POSITIVE_Y.rotation(RADIAN_90));
        this.drawComponent(vertexBuilder, this.getResultVector(quaternion2, newX, newY, newZ), uMin, uMax, vMin, vMax);
    }

    private Vector3f[] getResultVector(Quaternionf quaternion, float newX, float newY, float newZ) {
        Vector3f[] resultVector = {
                new Vector3f(-this.scale, (float) -this.data.getOffset(), 0),
                new Vector3f(-this.scale, (float) (this.data.getDistance() - this.data.getOffset()), 0),
                new Vector3f(this.scale, (float) (this.data.getDistance() - this.data.getOffset()), 0),
                new Vector3f(this.scale, (float) -this.data.getOffset(), 0)
        };
        for (Vector3f vec : resultVector) {
            quaternion.transform(vec);
            vec.add(newX, newY, newZ);
        }
        return resultVector;
    }

    private void drawComponent(VertexConsumer vertexBuilder, Vector3f[] resultVector, float uMin, float uMax, float vMin, float vMax) {
        this.addVertex(vertexBuilder, resultVector[0], uMax, vMax);
        this.addVertex(vertexBuilder, resultVector[1], uMax, vMin);
        this.addVertex(vertexBuilder, resultVector[2], uMin, vMin);
        this.addVertex(vertexBuilder, resultVector[3], uMin, vMax);
        //Draw back faces
        this.addVertex(vertexBuilder, resultVector[1], uMax, vMin);
        this.addVertex(vertexBuilder, resultVector[0], uMax, vMax);
        this.addVertex(vertexBuilder, resultVector[3], uMin, vMax);
        this.addVertex(vertexBuilder, resultVector[2], uMin, vMin);
    }

    private void addVertex(VertexConsumer vertexBuilder, Vector3f pos, float u, float v) {
        vertexBuilder.vertex(pos.x(), pos.y(), pos.z()).texture(u, v).color(this.red, this.green, this.blue, this.alpha).light(240, 240).next();
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static ParticleFactory<LaserParticleBuilder> create(SpriteProvider sprite) {
        return (parameters, world, x, y, z, vx, vy, vz) -> new LaserParticle(parameters, world, x, y, z, vx, vy, vz, sprite);
    }
}
