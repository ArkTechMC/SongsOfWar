package com.iafenvoy.sow.render.feature;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ArdoniEntity;
import com.iafenvoy.sow.render.ArdoniEntityRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ArdoniEyeHairFeatureRenderer extends FeatureRenderer<ArdoniEntity, BipedEntityModel<ArdoniEntity>> {
    private static final Identifier EYE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye.png");
    private static final Identifier HAIR = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair.png");
    private static final Identifier HAIR_MARKER = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_marker.png");
    private static final Identifier HAIR_SHORT = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_short.png");
    private static final Identifier HAIR_SHORT_MARKER = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_short_marker.png");

    public ArdoniEyeHairFeatureRenderer(FeatureRendererContext<ArdoniEntity, BipedEntityModel<ArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<ArdoniEntity> model = this.getContextModel();
        float[] color = ArdoniEntityRenderer.resolveColor(entity);
        Identifier hair = entity.isChild() ? HAIR_SHORT : HAIR, hairMarker = entity.isChild() ? HAIR_SHORT_MARKER : HAIR_MARKER;
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(EYE)), light, OverlayTexture.DEFAULT_UV, color[0], color[1], color[2], 1);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(hair)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(hairMarker)), light, OverlayTexture.DEFAULT_UV, color[0], color[1], color[2], 1);
    }
}
