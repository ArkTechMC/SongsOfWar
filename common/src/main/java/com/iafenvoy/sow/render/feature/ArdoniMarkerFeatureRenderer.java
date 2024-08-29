package com.iafenvoy.sow.render.feature;

import com.iafenvoy.sow.entity.ArdoniEntity;
import com.iafenvoy.sow.render.ArdoniEntityRenderer;
import com.iafenvoy.sow.render.ArdoniMarkerGenerator;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ArdoniMarkerFeatureRenderer extends FeatureRenderer<ArdoniEntity, BipedEntityModel<ArdoniEntity>> {
    public ArdoniMarkerFeatureRenderer(FeatureRendererContext<ArdoniEntity, BipedEntityModel<ArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ArdoniMarkerGenerator generator = ArdoniMarkerGenerator.getOrCreate(entity.getMarkerSeed());
        BipedEntityModel<ArdoniEntity> model = this.getContextModel();
        float[] color = ArdoniEntityRenderer.resolveColor(entity);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(generator.generate())), light, OverlayTexture.DEFAULT_UV, color[0], color[1], color[2], 1);
    }
}
