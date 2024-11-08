package com.iafenvoy.sow.render.entity.feature;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import com.iafenvoy.sow.render.entity.util.ArdoniMarkerGenerator;
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

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class ArdoniMarkerFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    public ArdoniMarkerFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        Optional<Identifier> marker = entity.getMarkerTexture();
        BipedEntityModel<AbstractArdoniEntity> model = this.getContextModel();
        if (marker.isPresent())
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(marker.get())), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        else if (entity instanceof ArdoniEntity ardoni) {
            ArdoniMarkerGenerator generator = ArdoniMarkerGenerator.getOrCreate(ardoni.getMarkerSeed());
            Color4i color = entity.getColor();
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(generator.generate())), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        }
    }
}
