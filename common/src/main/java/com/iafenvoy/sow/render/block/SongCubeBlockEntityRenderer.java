package com.iafenvoy.sow.render.block;

import com.iafenvoy.sow.item.block.entity.*;
import com.iafenvoy.sow.registry.SowBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public abstract class SongCubeBlockEntityRenderer<T extends AbstractSongCubeBlockEntity> implements BlockEntityRenderer<T> {
    protected final BlockEntityRendererFactory.Context ctx;

    protected SongCubeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5, 0.25, 0.5);
        this.ctx.getItemRenderer().renderItem(this.getStack(), ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        matrices.pop();
    }

    protected abstract ItemStack getStack();

    public static class AggressiumSongCubeBlockEntityRenderer extends SongCubeBlockEntityRenderer<AggressiumSongCubeBlockEntity> {
        public AggressiumSongCubeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
            super(ctx);
        }

        @Override
        protected ItemStack getStack() {
            return new ItemStack(SowBlocks.AGGRESSIUM_SONG.get());
        }
    }

    public static class MobiliumSongCubeBlockEntityRenderer extends SongCubeBlockEntityRenderer<MobiliumSongCubeBlockEntity> {
        public MobiliumSongCubeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
            super(ctx);
        }

        @Override
        protected ItemStack getStack() {
            return new ItemStack(SowBlocks.MOBILIUM_SONG.get());
        }
    }

    public static class ProtisiumSongCubeBlockEntityRenderer extends SongCubeBlockEntityRenderer<ProtisiumSongCubeBlockEntity> {
        public ProtisiumSongCubeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
            super(ctx);
        }

        @Override
        protected ItemStack getStack() {
            return new ItemStack(SowBlocks.PROTISIUM_SONG.get());
        }
    }

    public static class SupportiumSongCubeBlockEntityRenderer extends SongCubeBlockEntityRenderer<SupportiumSongCubeBlockEntity> {
        public SupportiumSongCubeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
            super(ctx);
        }

        @Override
        protected ItemStack getStack() {
            return new ItemStack(SowBlocks.SUPPORTIUM_SONG.get());
        }
    }
}
