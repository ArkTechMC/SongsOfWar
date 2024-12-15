package com.iafenvoy.sow.render.glint;

import com.iafenvoy.neptune.render.glint.GlintManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtElement;
import org.jetbrains.annotations.ApiStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

@Environment(EnvType.CLIENT)
public class GlintLayerManager {
    private static final Map<com.iafenvoy.neptune.render.glint.GlintManager.GlintHolder, RenderLayer> LAYERS = new HashMap<>();

    static {
        for (com.iafenvoy.neptune.render.glint.GlintManager.GlintHolder holder : com.iafenvoy.neptune.render.glint.GlintManager.HOLDERS) {
            if (holder.texture() == null) continue;
            RenderLayer layer = RenderLayer.of("glint_" + holder.id(),
                    VertexFormats.POSITION_TEXTURE,
                    VertexFormat.DrawMode.QUADS,
                    256,
                    RenderLayer.MultiPhaseParameters.builder().program(RenderPhase.DIRECT_GLINT_PROGRAM)
                            .texture(new RenderPhase.Texture(holder.texture(), true, false))
                            .writeMaskState(RenderPhase.COLOR_MASK)
                            .cull(RenderPhase.DISABLE_CULLING)
                            .depthTest(RenderPhase.EQUAL_DEPTH_TEST)
                            .transparency(RenderPhase.GLINT_TRANSPARENCY)
                            .texturing(RenderPhase.GLINT_TEXTURING)
                            .build(false));
            LAYERS.put(holder, layer);
        }
    }

    @ApiStatus.Internal
    public static void registerAll(SortedMap<RenderLayer, BufferBuilder> map) {
        for (Map.Entry<com.iafenvoy.neptune.render.glint.GlintManager.GlintHolder, RenderLayer> entry : LAYERS.entrySet())
            if (!map.containsKey(entry.getValue()))
                map.put(entry.getValue(), new BufferBuilder(entry.getValue().getExpectedBufferSize()));
    }

    public static boolean shouldAlwaysGlint(ItemStack stack) {
        return !stack.isEmpty() &&
                stack.getNbt() != null &&
                stack.getNbt().contains(com.iafenvoy.neptune.render.glint.GlintManager.GLINT_KEY, NbtElement.STRING_TYPE) &&
                com.iafenvoy.neptune.render.glint.GlintManager.BY_ID.containsKey(stack.getOrCreateNbt().getString(com.iafenvoy.neptune.render.glint.GlintManager.GLINT_KEY)) &&
                stack.getNbt().getBoolean(com.iafenvoy.neptune.render.glint.GlintManager.GLINT_ALWAYS_KEY);
    }

    public static RenderLayer process(RenderLayer origin, ItemStack stack) {
        if (!stack.isEmpty() && stack.getNbt() != null && stack.getNbt().contains(com.iafenvoy.neptune.render.glint.GlintManager.GLINT_KEY, NbtElement.STRING_TYPE)) {
            String id = stack.getOrCreateNbt().getString(com.iafenvoy.neptune.render.glint.GlintManager.GLINT_KEY);
            if (stack.getNbt().getBoolean(com.iafenvoy.neptune.render.glint.GlintManager.GLINT_ALWAYS_KEY))
                return LAYERS.getOrDefault(com.iafenvoy.neptune.render.glint.GlintManager.BY_ID.getOrDefault(id, GlintManager.DEFAULT), RenderLayer.getDirectGlint());
        }
        return origin;
    }
}
