package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class SowDamageTypes {
    public static final RegistryKey<DamageType> AGGRODETONATE = of("aggrodetonate");
    public static final RegistryKey<DamageType> AGGROQUAKE = of("aggroquake");
    public static final RegistryKey<DamageType> AGGROSPHERE = of("aggrosphere");
    public static final RegistryKey<DamageType> AGGROSTORM = of("aggrostorm");
    public static final RegistryKey<DamageType> AGGROSHARD = of("aggroshard");
    public static final RegistryKey<DamageType> AGGROBLAST = of("aggroblast");
    public static final RegistryKey<DamageType> AGGROBEAM = of("aggrobeam");

    private static RegistryKey<DamageType> of(String id) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(SongsOfWar.MOD_ID, id));
    }
}
