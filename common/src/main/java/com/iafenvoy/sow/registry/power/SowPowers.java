package com.iafenvoy.sow.registry.power;

import com.iafenvoy.sow.power.type.*;
import com.iafenvoy.sow.registry.SowItemGroups;
import dev.architectury.registry.CreativeTabRegistry;

public final class SowPowers {
    public static void init() {
        AggressiumPowers.init();
        MobiliumPowers.init();
        ProtisiumPowers.init();
        SupportiumPowers.init();
        for (AbstractSongPower<?> power : AbstractSongPower.POWERS) {
            power.init();
            CreativeTabRegistry.appendStack(SowItemGroups.POWER, power::getStack);
        }
    }
}
