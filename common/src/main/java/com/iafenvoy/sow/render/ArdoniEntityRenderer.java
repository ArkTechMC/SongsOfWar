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
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/ardoni_base.png");
    }
}
