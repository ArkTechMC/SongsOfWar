package com.iafenvoy.sow.render.feature;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.zombie.AbstractZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ZombieEyeFeatureRenderer extends FeatureRenderer<AbstractZombieEntity, ZombieEntityModel<AbstractZombieEntity>> {
    private static final Identifier TEXTURE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/zombie/eye.png");

    public ZombieEyeFeatureRenderer(FeatureRendererContext<AbstractZombieEntity, ZombieEntityModel<AbstractZombieEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractZombieEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ZombieEntityModel<AbstractZombieEntity> model = this.getContextModel();
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE));
        model.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }
}
