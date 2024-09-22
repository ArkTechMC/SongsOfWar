package com.iafenvoy.sow.entity.human.guard;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.neptune.util.function.MemorizeSupplier;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.KingdomType;
import com.iafenvoy.sow.entity.human.AbstractHumanEntity;
import com.iafenvoy.sow.registry.SowTags;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractGuardEntity extends AbstractHumanEntity {
    protected static final MemorizeSupplier<List<Item>> GUARD_WEAPONS = new MemorizeSupplier<>(() -> Registries.ITEM.stream().filter(x -> new ItemStack(x).isIn(SowTags.GUARD_WEAPONS)).toList());
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(AbstractGuardEntity.class, TrackedDataHandlerRegistry.INTEGER);

    protected AbstractGuardEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setStackInHand(Hand.MAIN_HAND, new ItemStack(RandomHelper.randomOne(GUARD_WEAPONS.get())));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, 1);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("variant", this.getVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("variant")) this.setVariant(nbt.getInt("variant"));
        else this.setVariant(RandomHelper.nextInt(1, this.getVariantCount()));
    }

    public int getVariant() {
        return this.dataTracker.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.dataTracker.set(VARIANT, variant);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        EntityData data = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        this.setVariant(RandomHelper.nextInt(1, this.getVariantCount()));
        return data;
    }

    public abstract KingdomType getKingdom();

    public abstract int getVariantCount();

    @Override
    public Identifier getTextureId() {
        return new Identifier(SongsOfWar.MOD_ID, "textures/entity/human/guard/" + this.getKingdom().getId() + "/guard_" + this.getVariant() + ".png");
    }
}
