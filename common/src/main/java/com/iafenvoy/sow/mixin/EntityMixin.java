package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.registry.SowPowers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Shadow
    public float fallDistance;

    @Inject(method = "getJumpVelocityMultiplier", at = @At("RETURN"), cancellable = true)
    private void modifyJumpHeight(CallbackInfoReturnable<Float> cir) {
        Entity self = (Entity) (Object) this;
        if (self instanceof PlayerEntity player && SongPowerData.byPlayer(player).powerEnabled(PowerCategory.MOBILIUM, SowPowers.MOBILILEAP)) {
            this.fallDistance = 0;
            cir.setReturnValue(cir.getReturnValue() * 5);
        }
    }
}
