package com.iafenvoy.sow.render.glint;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.client.render.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

import java.util.*;

public class GlintManager {
    public static final String GLINT_KEY = "glint";
    public static final List<GlintHolder> HOLDERS = new ArrayList<>();
    public static final Map<String, GlintHolder> BY_ID = new HashMap<>();
    private static boolean ALWAYS_RENDER = false;

    public static final GlintHolder DEFAULT = new GlintHolder("default", RenderLayer.getDirectGlint());
    public static final GlintHolder RED = new GlintHolder("red", new Identifier(SongsOfWar.MOD_ID, "textures/misc/glint_item_red.png"));
    public static final GlintHolder YELLOW = new GlintHolder("yellow", new Identifier(SongsOfWar.MOD_ID, "textures/misc/glint_item_yellow.png"));
    public static final GlintHolder BLUE = new GlintHolder("blue", new Identifier(SongsOfWar.MOD_ID, "textures/misc/glint_item_blue.png"));
    public static final GlintHolder ORANGE = new GlintHolder("orange", new Identifier(SongsOfWar.MOD_ID, "textures/misc/glint_item_orange.png"));
    public static final GlintHolder GREEN = new GlintHolder("green", new Identifier(SongsOfWar.MOD_ID, "textures/misc/glint_item_green.png"));
    public static final GlintHolder WHITE = new GlintHolder("white", new Identifier(SongsOfWar.MOD_ID, "textures/misc/glint_item_white.png"));

    public static VertexConsumer getDirectItemGlintConsumer(VertexConsumerProvider provider, RenderLayer layer, boolean glint, String id) {
        if (ALWAYS_RENDER || glint)
            return VertexConsumers.union(provider.getBuffer(BY_ID.getOrDefault(id, DEFAULT).layer), provider.getBuffer(layer));
        else return provider.getBuffer(layer);
    }

    public static void removeGlint(ItemStack stack){
        stack.getOrCreateNbt().remove(GLINT_KEY);
    }

    @ApiStatus.Internal
    public static void registerAll(SortedMap<RenderLayer, BufferBuilder> map) {
        for (GlintHolder holder : HOLDERS)
            map.put(holder.layer, new BufferBuilder(holder.layer.getExpectedBufferSize()));
    }

    public static void alwaysRender() {
        ALWAYS_RENDER = true;
    }

    public static void renderOnGlintOnly() {
        ALWAYS_RENDER = false;
    }

    public record GlintHolder(String id, RenderLayer layer) {
        public GlintHolder(String id, RenderLayer layer) {
            this.id = id;
            this.layer = layer;
            HOLDERS.add(this);
            BY_ID.put(this.id, this);
        }

        public GlintHolder(String id, Identifier texture) {
            this(id, RenderLayer.of("glint_" + id,
                    VertexFormats.POSITION_TEXTURE,
                    VertexFormat.DrawMode.QUADS,
                    256,
                    RenderLayer.MultiPhaseParameters.builder().program(RenderPhase.DIRECT_GLINT_PROGRAM)
                            .texture(new RenderPhase.Texture(texture, true, false))
                            .cull(RenderPhase.DISABLE_CULLING)
                            .depthTest(RenderPhase.EQUAL_DEPTH_TEST)
                            .transparency(RenderPhase.GLINT_TRANSPARENCY)
                            .texturing(RenderPhase.GLINT_TEXTURING)
                            .build(false)));
        }

        public ItemStack apply(ItemStack stack) {
            stack.getOrCreateNbt().putString(GLINT_KEY, this.id);
            return stack;
        }
    }
}
