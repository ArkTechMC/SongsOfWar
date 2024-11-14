package com.iafenvoy.sow.render.particle;

import com.iafenvoy.sow.particle.BlockDisplayParticleBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class BlockDisplayParticle extends SpriteBillboardParticle {
    private final BlockDisplayParticleBuilder data;

    private BlockDisplayParticle(BlockDisplayParticleBuilder data, ClientWorld world, double x, double y, double z, double vx, double vy, double vz, SpriteProvider spriteSet) {
        super(world, x, y, z);
        this.data = data;
        this.setMaxAge(data.getDuration());
        this.setSprite(MinecraftClient.getInstance().getBlockRenderManager().getModels().getModelParticleSprite(data.getBlockState()));
        this.scale = data.getScale() / 2;
        this.collidesWithWorld = false;
    }

    @Override
    public void buildGeometry(VertexConsumer vertexBuilder, Camera renderInfo, float partialTicks) {
        Vec3d view = renderInfo.getPos();
        float newX = (float) (this.x - view.x);
        float newY = (float) (this.y - view.y);
        float newZ = (float) (this.z - view.z);
        float uMin = this.getMinU();
        float uMax = this.getMaxU();
        float vMin = this.getMinV();
        float vMax = this.getMaxV();
        Quaternionf quaternion = this.data.getRotationQuaternion();
        this.drawComponent(vertexBuilder, this.getResultVector(quaternion, newX, newY, newZ), uMin, uMax, vMin, vMax);
    }

    private Vector3f[] getResultVector(Quaternionf quaternion, float newX, float newY, float newZ) {
        Vector3f[] resultVector = {
                new Vector3f(-this.scale, -this.scale, -this.scale),
                new Vector3f(-this.scale, this.scale, -this.scale),
                new Vector3f(this.scale, this.scale, -this.scale),
                new Vector3f(this.scale, -this.scale, -this.scale),
                new Vector3f(-this.scale, -this.scale, this.scale),
                new Vector3f(-this.scale, this.scale, this.scale),
                new Vector3f(this.scale, this.scale, this.scale),
                new Vector3f(this.scale, -this.scale, this.scale)
        };
        for (Vector3f vec : resultVector) {
            quaternion.transform(vec);
            vec.add(newX, newY, newZ);
        }
        return resultVector;
    }

    private void drawComponent(VertexConsumer vertexBuilder, Vector3f[] vectors, float uMin, float uMax, float vMin, float vMax) {
        this.addVertexes(vertexBuilder, vectors, 0, 1, 2, 3, uMin, uMax, vMin, vMax);
        this.addVertexes(vertexBuilder, vectors, 5, 4, 7, 6, uMin, uMax, vMin, vMax);
        this.addVertexes(vertexBuilder, vectors, 6, 7, 3, 2, uMin, uMax, vMin, vMax);
        this.addVertexes(vertexBuilder, vectors, 4, 5, 1, 0, uMin, uMax, vMin, vMax);
        this.addVertexes(vertexBuilder, vectors, 3, 7, 4, 0, uMin, uMax, vMin, vMax);
        this.addVertexes(vertexBuilder, vectors, 6, 2, 1, 5, uMin, uMax, vMin, vMax);
    }

    private void addVertexes(VertexConsumer vertexBuilder, Vector3f[] vectors, int v1, int v2, int v3, int v4, float uMin, float uMax, float vMin, float vMax) {
        this.addVertex(vertexBuilder, vectors[v1], uMax, vMax);
        this.addVertex(vertexBuilder, vectors[v2], uMax, vMin);
        this.addVertex(vertexBuilder, vectors[v3], uMin, vMin);
        this.addVertex(vertexBuilder, vectors[v4], uMin, vMax);
    }

    private void addVertex(VertexConsumer vertexBuilder, Vector3f pos, float u, float v) {
        int brightness = this.getBrightness(0);
        vertexBuilder.vertex(pos.x(), pos.y(), pos.z()).texture(u, v).color(this.red, this.green, this.blue, this.alpha).light(brightness, brightness).next();
    }

    @Override
    public int getBrightness(float partialTick) {
        BlockPos pos = new BlockPos((int) this.x, (int) this.y, (int) this.z);
        return this.world.getLightLevel(LightType.SKY, pos) << 4;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.TERRAIN_SHEET;
    }

    public static ParticleFactory<BlockDisplayParticleBuilder> create(SpriteProvider sprite) {
        return (parameters, world, x, y, z, vx, vy, vz) -> new BlockDisplayParticle(parameters, world, x, y, z, vx, vy, vz, sprite);
    }
}
