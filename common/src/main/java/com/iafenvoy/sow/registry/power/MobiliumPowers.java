package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.util.Timeout;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.power.component.MobiliBurstComponent;
import com.iafenvoy.sow.power.component.MobiliWingsComponent;
import com.iafenvoy.sow.power.type.DelaySongPower;
import com.iafenvoy.sow.power.type.InstantSongPower;
import com.iafenvoy.sow.power.type.PersistSongPower;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.block.BlockState;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class MobiliumPowers {
    public static final InstantSongPower MOBILIBOUNCE = new InstantSongPower("mobilibounce", PowerCategory.MOBILIUM).experimental()
            .setApplySound(SowSounds.MOBILIBOUNCE)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.mobilium.mobilibouncePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.mobilium.mobilibounceSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.mobilium.mobilibounceExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                BlockPos below = player.getBlockPos().down();
                BlockState state = world.getBlockState(below);
                if (state.isSolidBlock(world, below) || player.isOnGround()) holder.cancel();
                world.setBlockState(below, SowBlocks.MOBILIBOUNCE_PLATFORM.get().getDefaultState(), 2, 0);
                player.setVelocity(0, 0, 0);
                player.velocityModified = true;
                Timeout.create(20 * SowConfig.INSTANCE.mobilium.mobilibounceExistTime.getValue(), () -> world.setBlockState(below, state, 2, 0));
            });
    public static final InstantSongPower MOBILIBURST = new InstantSongPower("mobiliburst", PowerCategory.MOBILIUM)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.mobilium.mobiliburstPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.mobilium.mobiliburstSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.mobilium.mobiliburstExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                final Vec3d dir = SowMath.getRotationVectorUnit(MathHelper.clamp(player.getPitch(), -15, 15), player.getHeadYaw());
                player.setVelocity(dir.multiply(SowConfig.INSTANCE.mobilium.mobiliburstSpeed.getValue()));
                player.velocityModified = true;
                MobiliBurstComponent component = new MobiliBurstComponent(player);
                component.setActivate(true);
                component.setMaxTick(SowConfig.INSTANCE.mobilium.mobiliburstPrimaryCooldown.getValue() + 20);
                SongPowerData.byPlayer(player).addComponent(MobiliBurstComponent.ID, component);
            });
    public static final DelaySongPower MOBILIFLASH = new DelaySongPower("mobiliflash", PowerCategory.MOBILIUM)
            .setApplySound(SowSounds.MOBILIFLASH)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.mobilium.mobiliflashPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.mobilium.mobiliflashSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.mobilium.mobiliflashExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                final Vec3d dir = SowMath.getRotationVectorUnit(MathHelper.clamp(player.getPitch(), -15, 15), player.getHeadYaw());
                player.setVelocity(dir.multiply(SowConfig.INSTANCE.mobilium.mobiliflashSpeed.getValue()));
                player.velocityModified = true;
            });
    public static final PersistSongPower MOBILIGLIDE = new PersistSongPower("mobiliglide", PowerCategory.MOBILIUM)
            .setExhaustion(holder -> SowConfig.INSTANCE.mobilium.mobiliglideExhaustion.getValue())
            .onApply(holder -> {//GRAVITY attribute not available before 1.20.5
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (instance != null)
                    instance.addTemporaryModifier(new EntityAttributeModifier(Static.MOBILIGLIDE_UUID, "mobiliglide", 1, EntityAttributeModifier.Operation.ADDITION));
            })
            .onTick(holder -> {
                if (holder.getPlayer().isOnGround() || holder.getPlayer().getAbilities().flying) holder.cancel();
            })
            .onUnapply(holder -> {
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (instance != null) instance.removeModifier(Static.MOBILIGLIDE_UUID);
            });
    public static final PersistSongPower MOBILILEAP = new PersistSongPower("mobilileap", PowerCategory.MOBILIUM)
            .setExhaustion(holder -> SowConfig.INSTANCE.mobilium.mobilileapExhaustion.getValue());
    public static final PersistSongPower MOBILIWINGS = new PersistSongPower("mobiliwings", PowerCategory.MOBILIUM)
            .setApplySound(() -> SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA)
            .setExhaustion(holder -> SowConfig.INSTANCE.mobilium.mobiliwingsExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                player.startFallFlying();
                SongPowerData.byPlayer(player).addComponent(MobiliWingsComponent.ID, new MobiliWingsComponent(player));
            })
            .onTick(holder -> {
                PlayerEntity player = holder.getPlayer();
                if (player.isOnGround() || player.getAbilities().flying) holder.cancel();
            })
            .onUnapply(holder -> SongPowerData.byPlayer(holder.getPlayer()).removeComponent(MobiliWingsComponent.ID));

    public static void init() {
    }
}
