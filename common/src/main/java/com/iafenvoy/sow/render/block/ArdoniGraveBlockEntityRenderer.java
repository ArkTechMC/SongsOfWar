package com.iafenvoy.sow.render.block;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import com.iafenvoy.sow.render.RenderConstants;
import com.iafenvoy.sow.render.util.ArdoniMarkerGenerator;
import com.mojang.blaze3d.platform.TextureUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ArdoniGraveBlockEntityRenderer implements BlockEntityRenderer<ArdoniGraveBlockEntity> {
    private static final List<Identifier> REGISTERED = new LinkedList<>();

    @Override
    public void render(ArdoniGraveBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        ModelPart part = getTexturedModelData().createModel();
        long seed = entity.getSeed();
        Identifier texture = entity.isFixed() ? getTexture(entity.getTexturePath()) : ArdoniMarkerGenerator.getOrCreate(seed).getForGrave();
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

    public static Identifier getTexture(Identifier base) {
        ArdoniGraveTexture texture = new ArdoniGraveTexture(base);
        if (!REGISTERED.contains(base)) {
            REGISTERED.add(base);
            MinecraftClient.getInstance().getTextureManager().registerTexture(texture.getId(), texture);
        }
        return texture.getId();
    }

    public static void reset() {
        REGISTERED.clear();
    }

    private static class ArdoniGraveTexture extends ResourceTexture {
        public ArdoniGraveTexture(Identifier location) {
            super(location);
        }

        @Override
        public void load(ResourceManager manager) throws IOException {
            TextureData textureData = this.loadTextureData(manager);
            textureData.checkException();
            NativeImage nativeImage = textureData.getImage();
            NativeImage image = new NativeImage(nativeImage.getWidth(), nativeImage.getHeight(), true);
            fill(nativeImage, image);
            this.upload(image, false, false);
        }

        private void upload(NativeImage image, boolean blur, boolean clamp) {
            TextureUtil.prepareImage(this.getGlId(), 0, image.getWidth(), image.getHeight());
            image.upload(0, 0, 0, 0, 0, image.getWidth(), image.getHeight(), blur, clamp, false, true);
        }

        private static void fill(NativeImage origin, NativeImage target) {
            for (int i = 20; i < 28; i++)
                for (int j = 20; j < 32; j++)
                    target.setColor(i, j, origin.getColor(i, j));
        }

        public Identifier getId() {
            return this.location.withSuffixedPath("_grave");
        }
    }
}
