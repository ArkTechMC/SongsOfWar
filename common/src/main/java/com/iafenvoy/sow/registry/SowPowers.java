package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.event.LivingEntityEvents;
import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.object.EntityUtil;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.neptune.util.Timeout;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.entity.power.*;
import com.iafenvoy.sow.particle.LaserParticleBuilder;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.power.component.MobiliBurstComponent;
import com.iafenvoy.sow.power.component.MobiliWingsComponent;
import com.iafenvoy.sow.power.type.*;
import com.iafenvoy.sow.util.SowMath;
import com.iafenvoy.sow.world.WorldUtil;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Ownable;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@SuppressWarnings("unused")
public final class SowPowers {
    //Aggressium
    public static final DelaySongPower AGGROSPHERE = new DelaySongPower("aggrosphere", PowerCategory.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROSPHERE)
            .setDelay(6)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggrospherePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggrosphereSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggrosphereExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                AggroSphereEntity aggroSphere = SowEntities.AGGRO_SPHERE.get().create(world);
                if (aggroSphere != null) {
                    final Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                    aggroSphere.setVelocity(dir.multiply(SowConfig.INSTANCE.aggressium.aggrosphereSpeed.getValue()));
                    holder.processProjectile(aggroSphere);
                    world.spawnEntity(aggroSphere);
                }
            });
    public static final DelaySongPower AGGROQUAKE = new DelaySongPower("aggroquake", PowerCategory.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROQUAKE)
            .setDelay(8)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroquakePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroquakeSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggroquakeExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                double r = SowConfig.INSTANCE.aggressium.aggroquakeRange.getValue();
                Vec3d range = new Vec3d(r, r, r);
                List<LivingEntity> entities = holder.getWorld().getEntitiesByClass(LivingEntity.class, new Box(player.getPos().add(range), player.getPos().subtract(range)), x -> x != player);
                for (LivingEntity living : entities) {
                    Vec3d dir = SowMath.reverse(player.getPos().subtract(living.getPos()), r).multiply(-0.5);
                    living.damage(DamageUtil.build(living, SowDamageTypes.AGGROQUAKE), SowConfig.INSTANCE.aggressium.aggroquakeDamage.getValue().floatValue());
                    living.setVelocity(dir.add(0, 0.5, 0));
                    living.velocityModified = true;
                }
            });
    public static final InstantSongPower AGGROSHOCK = new InstantSongPower("aggroshock", PowerCategory.AGGRESSIUM).experimental()
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroshockPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroshockSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggroshockExhaustion.getValue())
            .onApply(holder -> {
                if (!(holder.getWorld() instanceof ServerWorld serverWorld)) return;
                PlayerEntity player = holder.getPlayer();
                final Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                Vec3d pos = player.getPos();
                for (int i = 0; i < SowConfig.INSTANCE.aggressium.aggroshockDistance.getValue(); i++) {
                    pos = pos.add(dir);
                    EntityUtil.lightening(serverWorld, pos.x, pos.y, pos.z, false);
                }
            });
    public static final PersistSongPower AGGROSTORM = new PersistSongPower("aggrostorm", PowerCategory.AGGRESSIUM).experimental()
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggrostormExhaustion.getValue())
            .onTick(holder -> {
                PlayerEntity player = holder.getPlayer();
                double r = SowConfig.INSTANCE.aggressium.aggrostormRange.getValue();
                Vec3d range = new Vec3d(r, r, r);
                List<LivingEntity> entities = holder.getWorld().getEntitiesByClass(LivingEntity.class, new Box(player.getPos().add(range), player.getPos().subtract(range)), x -> x != player);
                for (LivingEntity living : entities) {
                    Vec3d v = player.getPos().subtract(living.getPos());
                    Vec3d dir = SowMath.reverse(v, r).multiply(SowConfig.INSTANCE.aggressium.aggrostormStrength.getValue());
                    if (v.length() <= r / 2)
                        living.damage(DamageUtil.build(living, SowDamageTypes.AGGROSTORM), SowConfig.INSTANCE.aggressium.aggrostormDamage.getValue().floatValue() / 20);
                    living.setVelocity(dir);
                    living.velocityModified = true;
                }
            });
    public static final DelaySongPower AGGRODETONATE = new DelaySongPower("aggrodetonate", PowerCategory.AGGRESSIUM)
            .setApplySound(SowSounds.AGGRODETONATE)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggrodetonatePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggrodetonateSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggrodetonateExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                AggroDetonateEntity aggroDetonate = SowEntities.AGGRO_DETONATE.get().create(world);
                if (aggroDetonate != null) {
                    Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                    aggroDetonate.setVelocity(dir.multiply(SowConfig.INSTANCE.aggressium.aggrodetonateSpeed.getValue()));
                    holder.processProjectile(aggroDetonate);
                    world.spawnEntity(aggroDetonate);
                }
            });
    public static final DelaySongPower AGGROSHARD = new DelaySongPower("aggroshard", PowerCategory.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROSHARD)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroshardPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroshardSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggroshardExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                Random random = new Random();
                for (int i = 0; i < SowConfig.INSTANCE.aggressium.aggroshardCount.getValue(); i++) {
                    Timeout.create(random.nextInt(25), () -> {
                        AggroShardEntity aggroShard = SowEntities.AGGRO_SHARD.get().create(world);
                        if (aggroShard != null) {
                            Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                            final double MUL = 0.2, speed = SowConfig.INSTANCE.aggressium.aggroshardSpeed.getValue();
                            aggroShard.setVelocity(dir.multiply(speed).add(RandomHelper.nextDouble(-speed * MUL, speed * MUL), RandomHelper.nextDouble(-speed * MUL, speed * MUL), RandomHelper.nextDouble(-speed * MUL, speed * MUL)));
                            holder.processProjectile(aggroShard);
                            world.spawnEntity(aggroShard);
                        }
                    });
                }
            });
    public static final InstantSongPower AGGROBLAST = new InstantSongPower("aggroblast", PowerCategory.AGGRESSIUM)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroblastPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.aggressium.aggroblastSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggroblastExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                EntityHitResult result = WorldUtil.raycastNearest(player, SowConfig.INSTANCE.aggressium.aggroblastRange.getValue());
                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    double speed = SowConfig.INSTANCE.aggressium.aggroblastSpeed.getValue();
                    Vec3d dir = living.getPos().subtract(player.getPos()).multiply(speed);
                    living.setVelocity(dir.add(0, 0.3, 0));
                    living.velocityModified = true;
                    if (holder.getWorld() instanceof ServerWorld serverWorld) {
                        Vec3d d = SowMath.getRotationVector(player.getPitch(), player.getHeadYaw());
                        for (int i = 0; i < 30; i++)
                            serverWorld.spawnParticles(SowParticles.AGGROBLAST.get(), player.getX(), player.getY() + 1, player.getZ(), 0, d.x, d.y, d.z, speed);
                    }
                    living.damage(DamageUtil.build(player, SowDamageTypes.AGGROBLAST), SowConfig.INSTANCE.aggressium.aggroblastDamage.getValue().floatValue());
                } else holder.cancel();
            });
    public static final PersistSongPower AGGROBEAM = new PersistSongPower("aggrobeam", PowerCategory.AGGRESSIUM)
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggrobeamExhaustion.getValue())
            .onTick(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                double maxDistance = SowConfig.INSTANCE.aggressium.aggrobeamMaxDistance.getValue();
                Vec3d pos = player.getPos().add(0, 1, 0), end = pos.add(SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw()).multiply(maxDistance));
                BlockHitResult result = world.raycast(new RaycastContext(pos, end, RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, player));
                double d = result.getPos().subtract(pos).length();
                if (holder.getWorld() instanceof ServerWorld serverWorld)
                    serverWorld.spawnParticles(new LaserParticleBuilder(player.getUuid(), Vec3d.ZERO, result.getType() == HitResult.Type.BLOCK ? d : maxDistance, 0.1F), player.getX(), player.getY() + 1, player.getZ(), 0, 1, 0, 0, 1);
                List<EntityHitResult> results = WorldUtil.raycastAll(player, pos, end, new Box(pos, end), entity -> entity instanceof LivingEntity, d * d);
                DamageSource source = DamageUtil.build(player, SowDamageTypes.AGGROBEAM);
                for (EntityHitResult r : results)
                    r.getEntity().damage(source, SowConfig.INSTANCE.aggressium.aggrobeamDamage.getValue().floatValue());
            });
    //Mobilium
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
    public static final PersistSongPower MOBILILEAP = new PersistSongPower("mobilileap", PowerCategory.MOBILIUM)
            .setExhaustion(holder -> SowConfig.INSTANCE.mobilium.mobilileapExhaustion.getValue());
    //Protisium
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
    //Supportium
    public static final InstantSongPower SUPPOROLIFT = new InstantSongPower("supporolift", PowerCategory.SUPPORTIUM)
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
    public static final InstantSongPower SUPPOREKESIS = new InstantSongPower("supporekesis", PowerCategory.SUPPORTIUM)
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
                        controllable.setDisappearCd(10, true);
                }
            });

    public static void init() {
        for (AbstractSongPower<?> power : AbstractSongPower.POWERS) {
            power.init();
            CreativeTabRegistry.appendStack(SowItemGroups.POWER, power::getStack);
        }
    }
}
