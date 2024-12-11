package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.item.EnchantmentFragmentItem;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GrindstoneScreenHandler.class)
public abstract class GrindstoneScreenHandlerMixin extends ScreenHandler {
    @Shadow
    @Final
    Inventory input;

    @Shadow
    @Final
    private Inventory result;

    protected GrindstoneScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Inject(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/GrindstoneScreenHandler;sendContentUpdates()V"))
    private void addSongStoneRecipe(CallbackInfo ci) {
        ItemStack weapon = this.input.getStack(0);
        if ((weapon.getItem() instanceof SwordItem || weapon.getItem() instanceof AxeItem) && weapon.getNbt() != null && weapon.getNbt().contains(GlintManager.GLINT_KEY))
            this.result.setStack(0, EnchantmentFragmentItem.removeFromStack(weapon.copy()));
    }
}
