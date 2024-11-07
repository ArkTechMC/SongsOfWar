package com.iafenvoy.sow.render;

import com.iafenvoy.sow.entity.power.AggroSphereEntity;
import com.iafenvoy.sow.render.model.SphereModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AggroSphereRenderer extends EntityRenderer<AggroSphereEntity> {
    private final SphereModel<AggroSphereEntity> sphereModel;

    public AggroSphereRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.sphereModel = new SphereModel<>(SphereModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(AggroSphereEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.translate(0, -0.5, 0);
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(this.getTexture(entity)));
        this.sphereModel.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 1, 0, 0, 0.3f);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(AggroSphereEntity entity) {
        return RenderConstants.WHITE_TEXTURE;
    }
}
