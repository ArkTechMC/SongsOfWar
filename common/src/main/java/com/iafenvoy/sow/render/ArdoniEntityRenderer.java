package com.iafenvoy.sow.render;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ArdoniEntity;
import com.iafenvoy.sow.render.feature.ArdoniEyeHairFeatureRenderer;
import com.iafenvoy.sow.render.feature.ArdoniMarkerFeatureRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.awt.*;

public class ArdoniEntityRenderer extends BipedEntityRenderer<ArdoniEntity, BipedEntityModel<ArdoniEntity>> {
    public ArdoniEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER)), 0.5F);
        this.addFeature(new ArdoniEyeHairFeatureRenderer(this));
        this.addFeature(new ArdoniMarkerFeatureRenderer(this));
    }

    @Override
    public void render(ArdoniEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ArdoniEntity entity) {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_base.png");
    }

    public static float[] resolveColor(ArdoniEntity entity) {
        if (entity.hasCustomName() && entity.getName().getString().equals("jeb_")) {
            Color c = Color.getHSBColor((entity.age + entity.getId()) / 100.0f, 1, 1);
            return new float[]{c.getRed() / 255.0f, c.getGreen() / 255.0f, c.getBlue() / 255.0f};
        }
        return entity.getArdoniType().toColorArray();
    }
}
