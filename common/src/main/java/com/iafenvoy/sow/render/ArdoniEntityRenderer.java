package com.iafenvoy.sow.render;

import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.render.feature.ArdoniEyeHairFeatureRenderer;
import com.iafenvoy.sow.render.feature.ArdoniMarkerFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ArdoniEntityRenderer extends BipedEntityRenderer<AbstractArdoniEntity, BipedEntityModel<AbstractArdoniEntity>> {
    public ArdoniEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER)), 0.5F);
        this.addFeature(new ArdoniEyeHairFeatureRenderer(this));
        this.addFeature(new ArdoniMarkerFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(AbstractArdoniEntity entity) {
        return entity.getSkinTexture();
    }
}
