package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.entity.power.SupporekesisControllable;
import com.iafenvoy.sow.entity.power.SupporoSpikeEntity;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.type.DelaySongPower;
import com.iafenvoy.sow.power.type.InstantSongPower;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.RecipeUtils;
import com.iafenvoy.sow.world.WorldUtil;
import it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Ownable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public final class SupportiumPowers {
    public static final DelaySongPower SUPPOREKESIS = new DelaySongPower("supporekesis", PowerCategory.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOREKESIS)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporekesisPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporekesisSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.supportium.supporekesisExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                double r = SowConfig.INSTANCE.supportium.supporekesisRange.getValue();
                List<Entity> controllables = world.getEntitiesByClass(Entity.class, new Box(player.getX() - r, player.getY() - r, player.getZ() - r, player.getX() + r, player.getY() + r, player.getZ() + r), c -> c instanceof SupporekesisControllable);
                for (Entity c : controllables) {
                    if (c instanceof Ownable ownable && ownable.getOwner() != null && Objects.equals(ownable.getOwner().getUuid(), player.getUuid()) && !SowConfig.INSTANCE.supportium.supporekesisControlSelf.getValue())
                        continue;
                    if (c instanceof SupporekesisControllable controllable)
                        controllable.setDisappearCd(70, true);
                }
            });
    public static final DelaySongPower SUPPOROFORM = new DelaySongPower("supporoform", PowerCategory.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOROFORM)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoformPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoformSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.supportium.supporoformExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                if (!(world instanceof ServerWorld serverWorld)) return;
                final int MAX_CNT = 41;
                for (int i = 0; i < MAX_CNT; i++) {
                    ItemStack stack = player.getInventory().getStack(i);
                    if (stack.isEmpty()) continue;
                    ItemStack stack1 = ItemStack.EMPTY;
                    if (stack.isOf(Items.OBSIDIAN))
                        stack1 = switch (stack.getCount()) {
                            case 5 -> new ItemStack(SowItems.ENDER_KNIGHT_HELMET.get());
                            case 8 -> new ItemStack(SowItems.ENDER_KNIGHT_CHESTPLATE.get());
                            case 7 -> new ItemStack(SowItems.ENDER_KNIGHT_LEGGINGS.get());
                            case 4 -> new ItemStack(SowItems.ENDER_KNIGHT_BOOTS.get());
                            default -> ItemStack.EMPTY;
                        };
                    if (stack1.isEmpty()) stack1 = RecipeUtils.findSmeltResult(serverWorld, stack).copy();
                    if (!stack1.isEmpty()) player.getInventory().setStack(i, stack1);
                }
            });
    public static final InstantSongPower SUPPOROLIFT = new InstantSongPower("supporolift", PowerCategory.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOROLIFT)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoliftPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoliftSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.supportium.supporoliftExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                EntityHitResult result = WorldUtil.raycastNearest(player, SowConfig.INSTANCE.supportium.supporoliftRange.getValue());
                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    Vec3d dir = player.getPos().subtract(living.getPos()).multiply(0.2);
                    living.setVelocity(dir.add(0, 0.3, 0));
                    living.velocityModified = true;
                } else holder.cancel();
            });
    public static final InstantSongPower SUPPOROSPIKE = new InstantSongPower("supporospike", PowerCategory.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOROSPIKE)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporospikePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporospikeSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.supportium.supporospikeExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                EntityHitResult result = WorldUtil.raycastNearest(player, SowConfig.INSTANCE.supportium.supporospikeRange.getValue());
                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    Vec3d[] vecs = new Vec3d[]{
                            new Vec3d(-0.5, -0.5, -0.5),
                            new Vec3d(0.5, -0.5, -0.5),
                            new Vec3d(-0.5, -0.5, 0.5),
                            new Vec3d(0.5, -0.5, 0.5),
                            new Vec3d(0, 0.5, 0)
                    };
                    Double2FloatFunction RANDOM = r -> (float) RandomHelper.nextDouble(-r, r);
                    BlockState state = world.getBlockState(living.getBlockPos().down());
                    for (Vec3d vec : vecs) {
                        SupporoSpikeEntity spike = SowEntities.SUPPORO_SPIKE.get().create(world);
                        if (spike != null) {
                            spike.setBlockState(state);
                            spike.setPosition(living.getPos().add(vec));
                            spike.setScale(1.2F);
                            spike.setDuration(50);
                            spike.setRotation(new Vector3f(RANDOM.get(Math.PI / 4), RANDOM.get(Math.PI / 16), RANDOM.get(Math.PI / 16)));
                            world.spawnEntity(spike);
                        }
                    }
                    living.setVelocity(new Vec3d(0, 1.5, 0));
                    living.velocityModified = true;
                } else holder.cancel();
            });

    public static void init() {
    }
}
