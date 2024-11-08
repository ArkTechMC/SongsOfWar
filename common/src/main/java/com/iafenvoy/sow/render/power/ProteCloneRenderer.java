package com.iafenvoy.sow.render.power;

import com.iafenvoy.sow.entity.power.ProteCloneEntity;
import com.iafenvoy.sow.render.RenderConstants;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ProteCloneRenderer extends BipedEntityRenderer<ProteCloneEntity, BipedEntityModel<ProteCloneEntity>> {
    public ProteCloneRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER), RenderLayer::getEntityTranslucentEmissive), 0);
    }

    @Override
    public void render(ProteCloneEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.scale(1.85F, -1.85F, 1.85F);
        matrices.translate(0, -1.5, 0);
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(this.getTexture(entity)));
        this.model.head.xScale = this.model.head.yScale = this.model.head.zScale = 0.7F;
        this.model.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 0, 0.5f, 1, 0.3f);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(ProteCloneEntity entity) {
        return RenderConstants.WHITE_TEXTURE;
    }
}
