package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.object.EntityUtil;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.neptune.util.Timeout;
import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.entity.power.AggroDetonateEntity;
import com.iafenvoy.sow.entity.power.AggroShardEntity;
import com.iafenvoy.sow.entity.power.AggroSphereEntity;
import com.iafenvoy.sow.particle.LaserParticleBuilder;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.type.DelaySongPower;
import com.iafenvoy.sow.power.type.InstantSongPower;
import com.iafenvoy.sow.power.type.PersistSongPower;
import com.iafenvoy.sow.registry.SowDamageTypes;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowParticles;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.SowMath;
import com.iafenvoy.sow.world.WorldUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public final class AggressiumPowers {
    public static final PersistSongPower AGGROBEAM = new PersistSongPower("aggrobeam", PowerCategory.AGGRESSIUM).experimental()
            .setApplySound(SowSounds.AGGROBEAM)
            .setExhaustion(holder -> SowConfig.INSTANCE.aggressium.aggrobeamExhaustion.getValue())
            .onTick(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                double maxDistance = SowConfig.INSTANCE.aggressium.aggrobeamMaxDistance.getValue();
                Vec3d rotation = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                Vec3d pos = player.getPos().add(0, 1, 0), end = pos.add(rotation.multiply(maxDistance));
                BlockHitResult result = world.raycast(new RaycastContext(pos, end, RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, player));
                double d = result.getPos().subtract(pos).length();
                if (holder.getWorld() instanceof ServerWorld serverWorld) {
                    final double OFFSET = 1;
                    Vec3d p = pos.add(rotation.multiply(OFFSET));
                    serverWorld.spawnParticles(new LaserParticleBuilder(player.getUuid(), 0, 0, result.getType() == HitResult.Type.BLOCK ? d : maxDistance, OFFSET, 0.1F), p.getX(), p.getY(), p.getZ(), 0, 1, 0, 0, 1);
                }
                List<EntityHitResult> results = WorldUtil.raycastAll(player, pos, end, new Box(pos, end), entity -> entity instanceof LivingEntity, d * d);
                DamageSource source = DamageUtil.build(player, SowDamageTypes.AGGROBEAM);
                for (EntityHitResult r : results)
                    r.getEntity().damage(source, holder.processDamage(SowConfig.INSTANCE.aggressium.aggrobeamDamage.getValue().floatValue()));
            });
    public static final DelaySongPower AGGROBLAST = new DelaySongPower("aggroblast", PowerCategory.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROBLAST)
            .setDelay(8)
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
                    living.damage(DamageUtil.build(player, SowDamageTypes.AGGROBLAST), holder.processDamage(SowConfig.INSTANCE.aggressium.aggroblastDamage.getValue().floatValue()));
                } else holder.cancel();
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
                    living.damage(DamageUtil.build(living, SowDamageTypes.AGGROQUAKE), holder.processDamage(SowConfig.INSTANCE.aggressium.aggroquakeDamage.getValue().floatValue()));
                    living.setVelocity(dir.add(0, 0.5, 0));
                    living.velocityModified = true;
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
    public static final PersistSongPower AGGROSTORM = new PersistSongPower("aggrostorm", PowerCategory.AGGRESSIUM).experimental()
            .setApplySound(SowSounds.AGGROSTORM)
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
                        living.damage(DamageUtil.build(living, SowDamageTypes.AGGROSTORM), holder.processDamage(SowConfig.INSTANCE.aggressium.aggrostormDamage.getValue().floatValue() / 20));
                    living.setVelocity(dir);
                    living.velocityModified = true;
                }
            });

    public static void init() {
    }
}
