package com.iafenvoy.sow.render.feature;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.ArdoniEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ArdoniEyeHairFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    private static final Identifier EYE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye.png");
    private static final Identifier HAIR = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair.png");
    private static final Identifier HAIR_MARKER = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_marker.png");
    private static final Identifier HAIR_SHORT = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_short.png");
    private static final Identifier HAIR_SHORT_MARKER = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_short_marker.png");

    public ArdoniEyeHairFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<AbstractArdoniEntity> model = this.getContextModel();
        Color4i color = entity.getColor();
        boolean child = entity instanceof ArdoniEntity ardoni && ardoni.isChild();
        Identifier hair = child ? HAIR_SHORT : HAIR, hairMarker = child ? HAIR_SHORT_MARKER : HAIR_MARKER;
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(EYE)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        if (entity instanceof ArdoniEntity) {
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(hair)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(hairMarker)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        }
    }
}
