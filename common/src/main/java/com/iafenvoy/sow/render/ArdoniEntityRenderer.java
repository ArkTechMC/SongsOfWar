package com.iafenvoy.sow.render;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import com.iafenvoy.sow.render.feature.ArdoniEyeHairFeatureRenderer;
import com.iafenvoy.sow.render.feature.ArdoniMarkerFeatureRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class ArdoniEntityRenderer extends BipedEntityRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    public ArdoniEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER)), 0.5F);
        this.addFeature(new ArdoniEyeHairFeatureRenderer(this));
        this.addFeature(new ArdoniMarkerFeatureRenderer(this));
    }

    @Override
    public void render(AbstractArdoniEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(1.1f, 1.1f, 1.1f);
        double darkness = 1;
        if (mobEntity instanceof ArdoniEntity ardoni)
            if (ardoni.getArdoniType().dark())
                darkness = RandomHelper.nextDouble(new Random(ardoni.getMarkerSeed()), 0.65, 0.75);
            else
                darkness = RandomHelper.nextDouble(new Random(ardoni.getMarkerSeed()), 0.9, 1);
        RenderSystem.setShaderColor((float) darkness, (float) darkness, (float) darkness, 1);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        matrixStack.pop();
    }

    @Override
    public Identifier getTexture(AbstractArdoniEntity entity) {
        return entity.getSkinTexture();
    }
}
