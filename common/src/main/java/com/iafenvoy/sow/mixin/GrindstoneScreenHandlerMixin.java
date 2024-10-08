package com.iafenvoy.sow.mixin;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

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

    //TODO: Item copy
//    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
//    private void addSongStoneRecipe(CallbackInfo ci) {
//        ItemStack weapon = this.input.getStack(0);
//        if ((weapon.getItem() instanceof SwordItem || weapon.getItem() instanceof AxeItem) && weapon.getNbt() != null && weapon.getNbt().contains(GlintManager.GLINT_KEY)) {
//            this.result.setStack(0, EnchantmentFragmentInfo.unapply(weapon.copy()));
//            this.sendContentUpdates();
//            ci.cancel();
//        }
//    }
}
