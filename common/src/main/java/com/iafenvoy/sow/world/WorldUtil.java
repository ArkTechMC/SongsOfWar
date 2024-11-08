package com.iafenvoy.sow.world;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class WorldUtil {
    @Nullable
    public static EntityHitResult raycastEntity(LivingEntity entity, double maxDistance) {
        Vec3d p1 = entity.getEyePos(), p2 = p1.add(entity.getRotationVec(1).multiply(maxDistance)), r = new Vec3d(maxDistance, maxDistance, maxDistance);
        return ProjectileUtil.raycast(entity, p1, p2, new Box(entity.getPos().add(r), entity.getPos().subtract(r)), e -> e instanceof LivingEntity, maxDistance * maxDistance);
    }
}
