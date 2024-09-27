package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.item.SowSpawnEggItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;

import java.util.*;

public record ArdoniType(String id, boolean dark, Color4i primaryColor, List<Color4i> altColors) {
    private static final Map<String, ArdoniType> BY_ID = new HashMap<>();
    public static final ArdoniType NONE;
    public static final ArdoniType VOLTARIS;
    public static final ArdoniType SENDARIS;
    public static final ArdoniType NESTORIS;
    public static final ArdoniType KALTARIS;
    public static final ArdoniType MENDORIS;

    public ArdoniType(String id, boolean dark, Color4i primaryColor, Color4i... altColors) {
        this(id, dark, primaryColor, List.of(altColors));
        BY_ID.put(id, this);
    }

    public Color4i getColor(long seed) {
        Random random = new Random(seed);
        if (this.altColors.isEmpty() || random.nextInt(3) > 0) return this.primaryColor;
        return RandomHelper.randomOne(random, this.altColors);
    }

    public static ArdoniType byId(String id) {
        return BY_ID.getOrDefault(id, NONE);
    }

    public static ArdoniType random() {
        return RandomHelper.randomOne(new ArrayList<>(BY_ID.values()));
    }

    public SowSpawnEggItem createSpawnEgg(RegistrySupplier<? extends EntityType<? extends MobEntity>> type) {
        return new SowSpawnEggItem(type, 0xFF888888, this.primaryColor.getIntValue());
    }

    public String getFormattedName() {
        if (this.id.isEmpty()) return "";
        return this.id.substring(0, 1).toUpperCase(Locale.ROOT) + this.id.substring(1);
    }

    static {
        NONE = new ArdoniType("none", false, new Color4i(255, 255, 255, 255));
        VOLTARIS = new ArdoniType("voltaris", true, new Color4i(255, 0, 0, 255));
        SENDARIS = new ArdoniType("sendaris", false, new Color4i(0, 0, 255, 255), new Color4i(0, 255, 255, 255));
        NESTORIS = new ArdoniType("nestoris", false, new Color4i(255, 255, 0, 255), new Color4i(240, 155, 89, 255));
        KALTARIS = new ArdoniType("kaltaris", false, new Color4i(0, 255, 0, 255));
        MENDORIS = new ArdoniType("mendoris", false, new Color4i(160, 32, 240, 255), new Color4i(234, 63, 247, 255));
    }
}
