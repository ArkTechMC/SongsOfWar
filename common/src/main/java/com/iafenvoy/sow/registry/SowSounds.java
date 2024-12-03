package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public final class SowSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.SOUND_EVENT);

    public static final RegistrySupplier<SoundEvent> AGGRESSIUM = register("aggressium");
    public static final RegistrySupplier<SoundEvent> MOBILIUM = register("mobilium");
    public static final RegistrySupplier<SoundEvent> PROTISIUM = register("protisium");
    public static final RegistrySupplier<SoundEvent> SUPPORTIUM = register("supportium");

    public static final RegistrySupplier<SoundEvent> AGGROBEAM = register("aggrobeam");
    public static final RegistrySupplier<SoundEvent> AGGROBLAST = register("aggroblast");
    public static final RegistrySupplier<SoundEvent> AGGRODETONATE = register("aggrodetonate");
    public static final RegistrySupplier<SoundEvent> AGGROQUAKE = register("aggroquake");
    public static final RegistrySupplier<SoundEvent> AGGROSPHERE = register("aggrosphere");
    public static final RegistrySupplier<SoundEvent> AGGROSHARD = register("aggroshard");
    public static final RegistrySupplier<SoundEvent> AGGROSTORM = register("aggrostorm");
    public static final RegistrySupplier<SoundEvent> MOBILIBOUNCE = register("mobilibounce");
    public static final RegistrySupplier<SoundEvent> MOBILIBURST = register("mobiliburst");
    public static final RegistrySupplier<SoundEvent> MOBILIFLASH = register("mobiliflash");
    public static final RegistrySupplier<SoundEvent> MOBILIGLIDE = register("mobiliglide");
    public static final RegistrySupplier<SoundEvent> MOBILILEAP = register("mobilileap");
    public static final RegistrySupplier<SoundEvent> MOBILIWINGS = register("mobiliwings");
    public static final RegistrySupplier<SoundEvent> PROTEARMOR = register("protearmor");
    public static final RegistrySupplier<SoundEvent> PROTEARMOR_UNAPPLY = register("protearmor_unapply");
    public static final RegistrySupplier<SoundEvent> PROTEBARRIER = register("protebarrier");
    public static final RegistrySupplier<SoundEvent> PROTECLONE = register("proteclone");
    public static final RegistrySupplier<SoundEvent> PROTEHEAL = register("proteheal");
    public static final RegistrySupplier<SoundEvent> PROTEPOINT = register("protepoint");
    public static final RegistrySupplier<SoundEvent> PROTESPHERE = register("protesphere");
    public static final RegistrySupplier<SoundEvent> PROTESPHERE_UNAPPLY = register("protesphere_unapply");
    public static final RegistrySupplier<SoundEvent> SUPPOREKESIS = register("supporekesis");
    public static final RegistrySupplier<SoundEvent> SUPPOROFORM = register("supporoform");
    public static final RegistrySupplier<SoundEvent> SUPPOROLIFT = register("supporolift");
    public static final RegistrySupplier<SoundEvent> SUPPOROSPIKE = register("supporospike");

    private static RegistrySupplier<SoundEvent> register(String id) {
        return REGISTRY.register(id, () -> SoundEvent.of(Identifier.of(SongsOfWar.MOD_ID, id)));
    }
}
