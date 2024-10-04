package com.iafenvoy.sow.render.feature;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class ArdoniSkinFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    public ArdoniSkinFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        double darkness = 1;
        if (entity instanceof ArdoniEntity ardoni)
            if (ardoni.getArdoniType().dark())
                darkness = RandomHelper.nextDouble(new Random(ardoni.getMarkerSeed()), 0.45, 0.65);
            else
                darkness = RandomHelper.nextDouble(new Random(ardoni.getMarkerSeed()), 0.8, 1);
        BipedEntityModel<AbstractArdoniEntity> model = this.getContextModel();
        model.render(matrices, vertexConsumers.getBuffer(model.getLayer(entity.getSkinTexture())), light, LivingEntityRenderer.getOverlay(entity, 0), (float) darkness, (float) darkness, (float) darkness, 1);
    }
}
