package com.iafenvoy.sow.render.tool;

import com.iafenvoy.neptune.render.armor.IArmorRenderHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class BackToolRenderer extends HeldItemFeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    private final HeldItemRenderer heldItemRenderer;

    public BackToolRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> context, HeldItemRenderer heldItemRenderer) {
        super(context, heldItemRenderer);
        this.heldItemRenderer = heldItemRenderer;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider provider, int i, AbstractClientPlayerEntity entity, float f, float g, float h, float j, float k, float l) {
        Map<BackBeltToolManager.Place, ItemStack> stacks = BackBeltToolManager.getAllEquipped(entity);

        if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ELYTRA)
            return;
        if (stacks.containsKey(BackBeltToolManager.Place.BACK_LEFT))
            this.renderItem(stacks.get(BackBeltToolManager.Place.BACK_LEFT), matrices, provider, i, entity, true);
        if (stacks.containsKey(BackBeltToolManager.Place.BACK_RIGHT))
            this.renderItem(stacks.get(BackBeltToolManager.Place.BACK_RIGHT), matrices, provider, i, entity, false);
    }

    private void renderItem(ItemStack stack, MatrixStack matrices, VertexConsumerProvider provider, int i, AbstractClientPlayerEntity entity, boolean left) {
        matrices.push();
        IArmorRenderHelper.translateToChest(matrices, this.getContextModel(), entity);
        if(!entity.getEquippedStack(EquipmentSlot.CHEST).isEmpty())
            matrices.translate(0, 0, 0.05);
        if(left) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90));
            matrices.translate(-0.1, 0.1, 0.05);
        }
        matrices.translate(0, -0.3, 0.32);
        matrices.scale(1.5f, 1.5f, 1.5f);
        BackBeltToolManager.BackHolder holder = BackBeltToolManager.getBack(stack.getItem());
        if (holder != null) holder.transformer().accept(matrices, left);
        this.heldItemRenderer.renderItem(entity, stack, ModelTransformationMode.GROUND, false, matrices, provider, i);
        matrices.pop();
    }
}