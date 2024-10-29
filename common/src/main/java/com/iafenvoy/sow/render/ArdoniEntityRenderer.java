package com.iafenvoy.sow.render;

import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.util.Flatable;
import com.iafenvoy.sow.render.feature.ArdoniEyeFeatureRenderer;
import com.iafenvoy.sow.render.feature.ArdoniHairFeatureRenderer;
import com.iafenvoy.sow.render.feature.ArdoniMarkerFeatureRenderer;
import com.iafenvoy.sow.render.feature.ArdoniSkinFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ArdoniEntityRenderer extends BipedEntityRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    public ArdoniEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER)), 0.5F);
        this.addFeature(new ArdoniSkinFeatureRenderer(this));
        this.addFeature(new ArdoniEyeFeatureRenderer(this));
        this.addFeature(new ArdoniHairFeatureRenderer(this));
        this.addFeature(new ArdoniMarkerFeatureRenderer(this));
    }

    @Override
    public void render(AbstractArdoniEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(1.1f, 1.1f, 1.1f);
        if (mobEntity instanceof Flatable flatable && flatable.isFlat())
            matrixStack.scale(1, 0.001f, 1);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.pop();
    }

    @Override
    public Identifier getTexture(AbstractArdoniEntity entity) {
        return entity.getSkinTexture();
    }
}
