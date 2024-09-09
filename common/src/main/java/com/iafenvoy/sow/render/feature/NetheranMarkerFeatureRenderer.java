package com.iafenvoy.sow.render.feature;

import com.iafenvoy.sow.entity.netheran.AbstractNetheranEntity;
import com.iafenvoy.sow.render.NetheranEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class NetheranMarkerFeatureRenderer extends FeatureRenderer<AbstractNetheranEntity, PlayerEntityModel<AbstractNetheranEntity>> {
    public NetheranMarkerFeatureRenderer(FeatureRendererContext<AbstractNetheranEntity, PlayerEntityModel<AbstractNetheranEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractNetheranEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        Optional<Identifier> marker = entity.getMarkerTexture();
        BipedEntityModel<AbstractNetheranEntity> model = this.getContextModel();
        marker.ifPresent(id -> model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(id)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1));
    }
}
