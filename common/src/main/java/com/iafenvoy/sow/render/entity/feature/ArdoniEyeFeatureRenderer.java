package com.iafenvoy.sow.render.entity.feature;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
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
public class ArdoniEyeFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    private static final Identifier EYE_MALE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_male.png");
    private static final Identifier EYE_FEMALE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_female.png");
    private static final Identifier PUPIL_MALE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_male.png");
    private static final Identifier PUPIL_FEMALE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_female.png");

    public ArdoniEyeFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<AbstractArdoniEntity> model = this.getContextModel();
        Color4i color = entity.getColor();
        Identifier pupil = entity.isFemale() ? PUPIL_FEMALE : PUPIL_MALE;
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(pupil)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        if (entity instanceof ArdoniEntity ardoni) {
            Identifier eye = entity.isFemale() ? EYE_FEMALE : EYE_MALE;
            double darkness = ArdoniSkinFeatureRenderer.getDarkness(ardoni);
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(eye)), light, OverlayTexture.DEFAULT_UV, (float) darkness, (float) darkness, (float) darkness, 1);
        }
    }
}
