package com.iafenvoy.sow.item;

import com.iafenvoy.sow.registry.SowItemGroups;
import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;

import java.util.function.Supplier;

public class SowSpawnEggItem extends ArchitecturySpawnEggItem {
    public SowSpawnEggItem(RegistrySupplier<? extends EntityType<? extends MobEntity>> entityType, int backgroundColor, int highlightColor) {
        super(entityType, backgroundColor, highlightColor, new Settings().arch$tab(SowItemGroups.MOBS));
    }

    public static Supplier<SowSpawnEggItem> create(final RegistrySupplier<? extends EntityType<? extends MobEntity>> entityType, final int backgroundColor, final int highlightColor) {
        return () -> new SowSpawnEggItem(entityType, backgroundColor, highlightColor);
    }
}
