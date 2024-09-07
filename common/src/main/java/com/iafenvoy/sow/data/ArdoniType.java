package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.entity.ardoni.ArdoniEntity;
import com.iafenvoy.sow.item.ArdoniSpawnEggItem;
import com.iafenvoy.sow.registry.SowEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public record ArdoniType(String id, Color4i color, boolean dark) {
    private static final Map<String, ArdoniType> BY_ID = new HashMap<>();

    public static final ArdoniType NONE = new ArdoniType("none", 255, 255, 255, false);
    public static final ArdoniType VOLTARIS = new ArdoniType("voltaris", 255, 0, 0, true);
    public static final ArdoniType SENDARIS = new ArdoniType("sendaris", 0, 0, 255, false);
    public static final ArdoniType NESTORIS = new ArdoniType("nestoris", 255, 255, 0, false);
    public static final ArdoniType KALTARIS = new ArdoniType("kaltaris", 0, 255, 0, false);
    public static final ArdoniType MENDORIS = new ArdoniType("mendoris", 160, 32, 240, false);

    public ArdoniType(String id, int r, int g, int b, boolean dark) {
        this(id, new Color4i(r, g, b, 255), dark);
        BY_ID.put(id, this);
    }

    public ArdoniEntity create(EntityType<? extends ArdoniEntity> entityType, World world) {
        ArdoniEntity ardoni = new ArdoniEntity(entityType, world);
        ardoni.setArdoniType(this);
        return ardoni;
    }

    public ArdoniSpawnEggItem createSpawnEgg() {
        return new ArdoniSpawnEggItem(SowEntities.ARDONI, this);
    }

    public static ArdoniType byId(String id) {
        return BY_ID.getOrDefault(id, NONE);
    }

    public static ArdoniType random() {
        return RandomHelper.randomOne(new ArrayList<>(BY_ID.values()));
    }
}
