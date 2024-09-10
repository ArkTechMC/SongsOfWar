package com.iafenvoy.sow.render;

import com.iafenvoy.sow.entity.zombie.AbstractZombieEntity;
import com.iafenvoy.sow.render.feature.ZombieEyeFeatureRenderer;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

public class SowZombieEntityRenderer extends BipedEntityRenderer<AbstractZombieEntity, ZombieEntityModel<AbstractZombieEntity>> {
    public SowZombieEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ZombieEntityModel<>(ctx.getPart(EntityModelLayers.ZOMBIE)), 0.5f);
        this.addFeature(new ZombieEyeFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(AbstractZombieEntity entity) {
        return entity.getTexture();
    }
}
