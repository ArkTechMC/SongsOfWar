package com.iafenvoy.sow.render;

import com.iafenvoy.sow.entity.netheran.AbstractNetheranEntity;
import com.iafenvoy.sow.render.feature.NetheranMarkerFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class NetheranEntityRenderer extends BipedEntityRenderer<AbstractNetheranEntity, PlayerEntityModel<AbstractNetheranEntity>> {
    public NetheranEntityRenderer(EntityRendererFactory.Context ctx) {
        this(ctx, false);
    }

    public NetheranEntityRenderer(EntityRendererFactory.Context ctx, boolean slim) {
        super(ctx, new PlayerEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER), slim), 0.5F);
        this.addFeature(new NetheranMarkerFeatureRenderer(this));
        this.getModel().setVisible(true);
    }

    @Override
    public Identifier getTexture(AbstractNetheranEntity entity) {
        return entity.getSkinTexture();
    }
}
