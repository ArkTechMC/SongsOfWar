package com.iafenvoy.sow.render.feature;

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
public class ArdoniHairFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    private static final Identifier FEMALE_EXTRA_HAIR = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_female_extra.png");

    public ArdoniHairFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<AbstractArdoniEntity> model = this.getContextModel();
        Color4i color = entity.getColor();
        if (!(entity instanceof ArdoniEntity ardoni)) return;
        int age = ardoni.getAge();
        Identifier hair = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + ".png");
        Identifier hairMarker = new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + "_marker.png");
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(hair)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(hairMarker)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        if (ardoni.isFemale())
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(FEMALE_EXTRA_HAIR)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
    }
}
