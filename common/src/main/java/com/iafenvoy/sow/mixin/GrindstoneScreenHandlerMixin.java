package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.data.EnchantmentFragmentInfo;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.screen.GrindstoneScreenHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GrindstoneScreenHandler.class)
public class GrindstoneScreenHandlerMixin {
    @Shadow
    @Final
    Inventory input;

    @Shadow
    @Final
    private Inventory result;

    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
    private void addSongStoneRecipe(CallbackInfo ci) {
        ItemStack weapon = this.input.getStack(0);
        if ((weapon.getItem() instanceof SwordItem || weapon.getItem() instanceof AxeItem) && weapon.getNbt() != null && weapon.getNbt().contains(GlintManager.GLINT_KEY)) {
            this.result.setStack(0, EnchantmentFragmentInfo.unapply(weapon.copy()));
            ci.cancel();
        }
    }
}
