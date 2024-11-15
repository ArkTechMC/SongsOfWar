package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.event.LivingEntityEvents;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.entity.power.ProteCloneEntity;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.power.type.DelaySongPower;
import com.iafenvoy.sow.power.type.IntervalSongPower;
import com.iafenvoy.sow.power.type.PersistSongPower;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowSounds;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public final class ProtisiumPowers {
    public static final PersistSongPower PROTEARMOR = new PersistSongPower("protearmor", PowerCategory.PROTISIUM)
            .setApplySound(SowSounds.PROTEARMOR)
            .setUnapplySound(SowSounds.PROTEARMOR_UNAPPLY)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.protisium.protearmorPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.protisium.protearmorSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.protisium.protearmorExhaustion.getValue())
            .onInit(self -> LivingEntityEvents.DAMAGE.register((entity, source, amount) -> {
                if (entity instanceof PlayerEntity player) {
                    SongPowerData data = SongPowerData.byPlayer(player);
                    if (data.powerEnabled(PowerCategory.PROTISIUM, self)) {
                        data.get(PowerCategory.PROTISIUM).disable();
                        return Math.max(amount - SowConfig.INSTANCE.protisium.protearmorMaxReduceDamage.getValue().floatValue(), 0);
                    }
                }
                return amount;
            }));
    public static final DelaySongPower PROTECLONE = new DelaySongPower("proteclone", PowerCategory.PROTISIUM)
            .setDelay(12)
            .setApplySound(SowSounds.PROTECLONE)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.protisium.proteclonePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.protisium.protecloneSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.protisium.protecloneExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                ProteCloneEntity proteClone = SowEntities.PROTE_CLONE.get().create(world);
                if (proteClone != null) {
                    proteClone.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
                    proteClone.setDisappearCd(SowConfig.INSTANCE.protisium.proteclonePrimaryCooldown.getValue());
                    world.spawnEntity(proteClone);
                }
            });
    public static final IntervalSongPower PROTEHEAL = new IntervalSongPower("proteheal", PowerCategory.PROTISIUM)
            .setInterval(10)
            .setTimes(10)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.protisium.protehealPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.protisium.protehealSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.protisium.protehealExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                if (player.getHealth() >= player.getMaxHealth()) {
                    holder.cancel();
                    return;
                }
                player.heal(1);
            });
    public static final PersistSongPower PROTEPOINT = new PersistSongPower("protepoint", PowerCategory.PROTISIUM)
            .setApplySound(SowSounds.PROTEPOINT)
            .setExhaustion(holder -> SowConfig.INSTANCE.protisium.protepointExhaustion.getValue())
            .onApply(holder -> {
                ItemStack stack = new ItemStack(SowItems.PROTEPOINT_SHIELD.get());
                holder.getPlayer().setStackInHand(Hand.OFF_HAND, stack);
            }).onTick(holder -> {
                if (!holder.getPlayer().getOffHandStack().isOf(SowItems.PROTEPOINT_SHIELD.get())) holder.cancel();
            }).onUnapply(holder -> {
                if (holder.getPlayer().getOffHandStack().isOf(SowItems.PROTEPOINT_SHIELD.get()))
                    holder.getPlayer().setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY.copy());
            });
    public static final PersistSongPower PROTESPHERE = new PersistSongPower("protesphere", PowerCategory.PROTISIUM)
            .setApplySound(SowSounds.PROTESPHERE)
            .setUnapplySound(SowSounds.PROTESPHERE_UNAPPLY)
            .setExhaustion(holder -> SowConfig.INSTANCE.protisium.protesphereExhaustion.getValue())
            .onApply(holder -> {
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_ARMOR);
                if (instance != null)
                    instance.addTemporaryModifier(new EntityAttributeModifier(Static.PROTESPHERE_UUID, "protesphere", 50, EntityAttributeModifier.Operation.ADDITION));
            })
            .onUnapply(holder -> {
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_ARMOR);
                if (instance != null) instance.removeModifier(Static.PROTESPHERE_UUID);
            });

    public static void init() {
    }
}
