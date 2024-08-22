package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.render.glint.GlintManager;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.SortedMap;

@Mixin(BufferBuilderStorage.class)
public class BufferBuilderStorageMixin {
    @Shadow
    @Final
    private SortedMap<RenderLayer, BufferBuilder> entityBuilders;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void registerGlints(CallbackInfo ci) {
        GlintManager.registerAll(this.entityBuilders);
    }
}
