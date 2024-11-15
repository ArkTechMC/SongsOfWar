package com.iafenvoy.sow.render.power;

import com.iafenvoy.sow.entity.power.SupporoSpikeEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AffineTransformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class SupporoSpikeRenderer extends EntityRenderer<SupporoSpikeEntity> {
    private final BlockRenderManager blockRenderManager;

    public SupporoSpikeRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.blockRenderManager = ctx.getBlockRenderManager();
    }

    @Override
    public void render(SupporoSpikeEntity entity, float f, float g, MatrixStack matrices, VertexConsumerProvider vertexConsumerProvider, int i) {
        this.shadowRadius = 0;
        this.shadowOpacity = 1;
        super.render(entity, f, g, matrices, vertexConsumerProvider, i);
        matrices.push();
        matrices.translate(-0.5, 0, -0.5);
        matrices.multiply(entity.getRotationQuaternion());
        DisplayEntity.AbstractInterpolator<AffineTransformation> interpolator = DisplayEntity.AbstractInterpolator.constant(getTransformation(entity));
        AffineTransformation affineTransformation = interpolator.interpolate(1);
        matrices.multiplyPositionMatrix(affineTransformation.getMatrix());
        matrices.peek().getNormalMatrix().rotate(affineTransformation.getLeftRotation()).rotate(affineTransformation.getRightRotation());
        this.blockRenderManager.renderBlockAsEntity(entity.getBlockState(), matrices, vertexConsumerProvider, i, OverlayTexture.DEFAULT_UV);
        matrices.pop();
    }

    private static AffineTransformation getTransformation(SupporoSpikeEntity entity) {
        Vector3f vector3f = new Vector3f();
        Quaternionf quaternionf = new Quaternionf();
        Vector3f vector3f2 = new Vector3f(entity.getScale());
        Quaternionf quaternionf2 = new Quaternionf();
        return new AffineTransformation(vector3f, quaternionf, vector3f2, quaternionf2);
    }

    @Override
    public Identifier getTexture(SupporoSpikeEntity displayEntity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
