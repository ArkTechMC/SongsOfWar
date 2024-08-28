package com.iafenvoy.sow.render.feature;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.entity.ArdoniEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ArdoniEyeHairFeatureRenderer extends FeatureRenderer<ArdoniEntity, BipedEntityModel<ArdoniEntity>> {
    private static final Identifier EYE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni_eye.png");
    private static final Identifier HAIR_SHORT = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni_hair_short.png");
    private static final Identifier HAIR_SHORT_MARKER = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni_hair_short_marker.png");

    public ArdoniEyeHairFeatureRenderer(FeatureRendererContext<ArdoniEntity, BipedEntityModel<ArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<ArdoniEntity> model = this.getContextModel();
        ArdoniType type = entity.getArdoniType();
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(EYE)), light, OverlayTexture.DEFAULT_UV, type.r(), type.g(), type.b(), 1);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(HAIR_SHORT)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(HAIR_SHORT_MARKER)), light, OverlayTexture.DEFAULT_UV, type.r(), type.g(), type.b(), 1);
    }
}
