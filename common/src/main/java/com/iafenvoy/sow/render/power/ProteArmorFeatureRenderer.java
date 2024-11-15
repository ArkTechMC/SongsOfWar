package com.iafenvoy.sow.render.power;

import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.registry.power.ProtisiumPowers;
import com.iafenvoy.sow.render.RenderConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

@Environment(EnvType.CLIENT)
public class ProteArmorFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>, A extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {
    private final A model;

    public ProteArmorFeatureRenderer(FeatureRendererContext<T, M> context, A model) {
        super(context);
        this.model = model;
        this.model.hat.visible = false;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (SongPowerData.byPlayer(entity).powerEnabled(PowerCategory.PROTISIUM, ProtisiumPowers.PROTEARMOR)) {
            matrices.push();
            this.getContextModel().copyBipedStateTo(this.model);
            VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(RenderConstants.WHITE_TEXTURE));
            this.model.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 0, 0.5f, 1, 0.1f);
            matrices.pop();
        }
    }
}
