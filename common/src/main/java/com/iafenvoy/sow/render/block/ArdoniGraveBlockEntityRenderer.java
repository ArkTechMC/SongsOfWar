package com.iafenvoy.sow.render.block;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import com.iafenvoy.sow.render.RenderConstants;
import com.iafenvoy.sow.render.util.ArdoniMarkerGenerator;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class ArdoniGraveBlockEntityRenderer implements BlockEntityRenderer<ArdoniGraveBlockEntity> {
    public ArdoniGraveBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(ArdoniGraveBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        ModelPart part = getTexturedModelData().createModel();
        long seed = entity.getSeed();
        Identifier texture = ArdoniMarkerGenerator.getOrCreate(seed).getForGrave();
        matrices.translate(0.5, 1.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getRotationDegree()));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));
        part.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(RenderConstants.STONE_TEXTURE)), light, overlay);
        Color4i color = entity.activated() ? entity.getArdoniType().getColor(seed) : new Color4i(0x20, 0x20, 0x20, 0xFF);
        part.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(texture)), light, overlay, color.getR(), color.getG(), color.getB(), color.getA());
        matrices.pop();
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("bone", ModelPartBuilder.create().uv(18, 18).cuboid(-12.0F, -12.0F, 12.0F, 8.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
}
