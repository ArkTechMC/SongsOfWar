package com.iafenvoy.sow.entity.human;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.felina.NiikaEntity;
import com.iafenvoy.sow.entity.necromancer.AbstractNecromancerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class LucanEntity extends AbstractHumanEntity {
    private static final TrackedData<Integer> STATE = DataTracker.registerData(LucanEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final Identifier TEXTURE = new Identifier(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan.png");

    public LucanEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(STATE, 0);
    }

    public int getState() {
        return this.dataTracker.get(STATE);
    }

    public void setState(int state) {
        this.dataTracker.set(STATE, state);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getEntityWorld().getEntitiesByClass(AbstractNecromancerEntity.class, new Box(this.getPos().add(20, 10, 20), this.getPos().subtract(20, 10, 20)), LivingEntity::isAlive).isEmpty()) {
            if (!this.getEntityWorld().getEntitiesByClass(NiikaEntity.class, new Box(this.getPos().add(10, 5, 10), this.getPos().subtract(20, 5, 20)), LivingEntity::isAlive).isEmpty())
                this.setState(2);
            else this.setState(1);
        } else this.setState(0);
    }

    @Override
    public Identifier getTextureId() {
        if (this.getState() == 0) {
            if (this.getHealth() <= this.getMaxHealth() / 2)
                return new Identifier(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan_bandaged.png");
            return TEXTURE;
        } else if (this.getState() == 1)
            return new Identifier(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan_necro.png");
        else if (this.getState() == 2)
            return new Identifier(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan_necro_hoodless.png");
        return TEXTURE;
    }
}
