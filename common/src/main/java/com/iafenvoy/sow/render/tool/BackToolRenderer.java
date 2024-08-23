package com.iafenvoy.sow.render.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public class BackToolRenderer extends HeldItemFeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public BackToolRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> context, HeldItemRenderer heldItemRenderer) {
        super(context, heldItemRenderer);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider provider, int i, AbstractClientPlayerEntity entity, float f, float g, float h, float j, float k, float l) {
//        if (entity != null) {
//            if (entity.getName().asString().equals(ClientUtil.getRenderPlayer())) {
//                if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ELYTRA)
//                    return;
//                if (ToolInfo.leftBackTool.shouldRender())
//                    renderItem(ToolInfo.leftBackTool, matrices, provider, i, entity);
//                if (ToolInfo.rightBackTool.shouldRender())
//                    renderItem(ToolInfo.rightBackTool, matrices, provider, i, entity);
//            }
//        }
    }

    private void renderItem(ItemStack stack, MatrixStack matrices, VertexConsumerProvider provider, int i, AbstractClientPlayerEntity entity) {
//        matrices.push();
//        ModelPart modelPart = this.getContextModel().body;
//        modelPart.rotate(matrices);
//        ItemStack backSlotItem = ClientUtil.GetItemFromName(info.getItem(), info.isEnchanted());
//        matrices.translate(info.getOffsetX(), info.getOffsetY(), info.getOffsetZ() + 0.22D);
//        matrices.scale(info.getSize(), info.getSize(), info.getSize());
//        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(info.getRotateZ()));
//        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(info.getRotateX()));
//        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(info.getRotateY()));
//        MinecraftClient.getInstance().getHeldItemRenderer().renderItem(entity, backSlotItem, ModelTransformation.Mode.GROUND, false, matrices, provider, i);
//        matrices.pop();
    }
}