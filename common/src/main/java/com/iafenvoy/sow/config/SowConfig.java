package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.config.container.AutoInitConfigContainer;
import com.iafenvoy.jupiter.config.entry.*;
import com.iafenvoy.jupiter.interfaces.IConfigEntry;
import com.iafenvoy.jupiter.interfaces.IConfigEnumEntry;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.util.Identifier;

public class SowConfig extends AutoInitConfigContainer {
    public static final SowConfig INSTANCE = new SowConfig();
    public final CommonConfig common = new CommonConfig();
    public final AggressiumPowerConfig aggressium = new AggressiumPowerConfig();
    public final MobiliumPowerConfig mobilium = new MobiliumPowerConfig();
    public final ProtisiumPowerConfig protisium = new ProtisiumPowerConfig();
    public final SupporiumPowerConfig supportium = new SupporiumPowerConfig();

    public SowConfig() {
        super(new Identifier(SongsOfWar.MOD_ID, "sow_config"), "config.sow.server.title", "./config/sow/songs-of-war.json");
    }

    public static class CommonConfig extends AutoInitConfigCategoryBase {
        public final IConfigEntry<Boolean> enableBeaconTp = new BooleanEntry("config.sow.common.enableBeaconTp", true).json("enableBeaconTp");
        public final IConfigEntry<IConfigEnumEntry> anniversary = new EnumEntry("???", Anniversary.InvokeType.NORMAL).json("anniversary");

        public CommonConfig() {
            super("common", "config.sow.category.common");
        }
    }

    @SuppressWarnings("unused")
    public static class AggressiumPowerConfig extends AutoInitConfigCategoryBase {
        public final IConfigEntry<Double> aggrobeamExhaustion = new DoubleEntry("config.sow.power.aggrobeam.exhaustion", 4.0 / 10, 0, Integer.MAX_VALUE).json("aggrobeam.exhaustion");
        public final IConfigEntry<Double> aggrobeamDamage = new DoubleEntry("config.sow.power.aggrobeam.damage", 2, 0, Integer.MAX_VALUE).json("aggrobeam.damage");
        public final IConfigEntry<Double> aggrobeamMaxDistance = new DoubleEntry("config.sow.power.aggrobeam.maxDistance", 50, 0, Integer.MAX_VALUE).json("aggrobeam.maxDistance");
        public final SeparatorEntry s1 = new SeparatorEntry();
        public final IConfigEntry<Integer> aggroblastPrimaryCooldown = new IntegerEntry("config.sow.power.aggroblast.cooldown.primary", 20, 0, Integer.MAX_VALUE).json("aggroblast.cooldown.primary");
        public final IConfigEntry<Integer> aggroblastSecondaryCooldown = new IntegerEntry("config.sow.power.aggroblast.cooldown.secondary", 20, 0, Integer.MAX_VALUE).json("aggroblast.cooldown.secondary");
        public final IConfigEntry<Double> aggroblastExhaustion = new DoubleEntry("config.sow.power.aggroblast.exhaustion", 2, 0, Integer.MAX_VALUE).json("aggroblast.exhaustion");
        public final IConfigEntry<Double> aggroblastSpeed = new DoubleEntry("config.sow.power.aggroblast.speed", 1, 0, Integer.MAX_VALUE).json("aggroblast.speed");
        public final IConfigEntry<Double> aggroblastRange = new DoubleEntry("config.sow.power.aggroblast.range", 5, 0, Integer.MAX_VALUE).json("aggroblast.range");
        public final IConfigEntry<Double> aggroblastDamage = new DoubleEntry("config.sow.power.aggroblast.damage", 4, 0, Integer.MAX_VALUE).json("aggroblast.damage");
        public final SeparatorEntry s2 = new SeparatorEntry();
        public final IConfigEntry<Integer> aggrodetonatePrimaryCooldown = new IntegerEntry("config.sow.power.aggrodetonate.cooldown.primary", 30, 0, Integer.MAX_VALUE).json("aggrodetonate.cooldown.primary");
        public final IConfigEntry<Integer> aggrodetonateSecondaryCooldown = new IntegerEntry("config.sow.power.aggrodetonate.cooldown.secondary", 50, 0, Integer.MAX_VALUE).json("aggrodetonate.cooldown.secondary");
        public final IConfigEntry<Double> aggrodetonateExhaustion = new DoubleEntry("config.sow.power.aggrodetonate.exhaustion", 2, 0, Integer.MAX_VALUE).json("aggrodetonate.exhaustion");
        public final IConfigEntry<Double> aggrodetonatePower = new DoubleEntry("config.sow.power.aggrodetonate.power", 1, 0, Integer.MAX_VALUE).json("aggrodetonate.power");
        public final IConfigEntry<Double> aggrodetonateSpeed = new DoubleEntry("config.sow.power.aggrodetonate.speed", 2, 0, Integer.MAX_VALUE).json("aggrodetonate.speed");
        public final SeparatorEntry s3 = new SeparatorEntry();
        public final IConfigEntry<Integer> aggroquakePrimaryCooldown = new IntegerEntry("config.sow.power.aggroquake.cooldown.primary", 300, 0, Integer.MAX_VALUE).json("aggroquake.cooldown.primary");
        public final IConfigEntry<Integer> aggroquakeSecondaryCooldown = new IntegerEntry("config.sow.power.aggroquake.cooldown.secondary", 200, 0, Integer.MAX_VALUE).json("aggroquake.cooldown.secondary");
        public final IConfigEntry<Double> aggroquakeExhaustion = new DoubleEntry("config.sow.power.aggroquake.exhaustion", 4, 0, Integer.MAX_VALUE).json("aggroquake.exhaustion");
        public final IConfigEntry<Double> aggroquakeRange = new DoubleEntry("config.sow.power.aggroquake.range", 10, 0, Integer.MAX_VALUE).json("aggroquake.range");
        public final IConfigEntry<Double> aggroquakeDamage = new DoubleEntry("config.sow.power.aggroquake.damage", 5, 0, Integer.MAX_VALUE).json("aggroquake.damage");
        public final SeparatorEntry s4 = new SeparatorEntry();
        public final IConfigEntry<Integer> aggroshardPrimaryCooldown = new IntegerEntry("config.sow.power.aggroshard.cooldown.primary", 60, 0, Integer.MAX_VALUE).json("aggroshard.cooldown.primary");
        public final IConfigEntry<Integer> aggroshardSecondaryCooldown = new IntegerEntry("config.sow.power.aggroshard.cooldown.secondary", 100, 0, Integer.MAX_VALUE).json("aggroshard.cooldown.secondary");
        public final IConfigEntry<Double> aggroshardExhaustion = new DoubleEntry("config.sow.power.aggroshard.exhaustion", 5, 0, Integer.MAX_VALUE).json("aggroshard.exhaustion");
        public final IConfigEntry<Double> aggroshardDamage = new DoubleEntry("config.sow.power.aggroshard.damage", 1, 0, Integer.MAX_VALUE).json("aggroshard.damage");
        public final IConfigEntry<Double> aggroshardSpeed = new DoubleEntry("config.sow.power.aggroshard.speed", 1.5, 0, Integer.MAX_VALUE).json("aggroshard.speed");
        public final IConfigEntry<Integer> aggroshardCount = new IntegerEntry("config.sow.power.aggroshard.count", 20, 0, Integer.MAX_VALUE).json("aggroshard.count");
        public final SeparatorEntry s5 = new SeparatorEntry();
        public final IConfigEntry<Integer> aggroshockPrimaryCooldown = new IntegerEntry("config.sow.power.aggroshock.cooldown.primary", 300, 0, Integer.MAX_VALUE).json("aggroshock.cooldown.primary");
        public final IConfigEntry<Integer> aggroshockSecondaryCooldown = new IntegerEntry("config.sow.power.aggroshock.cooldown.secondary", 300, 0, Integer.MAX_VALUE).json("aggroshock.cooldown.secondary");
        public final IConfigEntry<Double> aggroshockExhaustion = new DoubleEntry("config.sow.power.aggroshock.exhaustion", 4, 0, Integer.MAX_VALUE).json("aggroshock.exhaustion");
        public final IConfigEntry<Integer> aggroshockDistance = new IntegerEntry("config.sow.power.aggroshock.distance", 8, 0, Integer.MAX_VALUE).json("aggroshock.distance");
        public final SeparatorEntry s6 = new SeparatorEntry();
        public final IConfigEntry<Integer> aggrospherePrimaryCooldown = new IntegerEntry("config.sow.power.aggrosphere.cooldown.primary", 10, 0, Integer.MAX_VALUE).json("aggrosphere.cooldown.primary");
        public final IConfigEntry<Integer> aggrosphereSecondaryCooldown = new IntegerEntry("config.sow.power.aggrosphere.cooldown.secondary", 10, 0, Integer.MAX_VALUE).json("aggrosphere.cooldown.secondary");
        public final IConfigEntry<Double> aggrosphereExhaustion = new DoubleEntry("config.sow.power.aggrosphere.exhaustion", 1, 0, Integer.MAX_VALUE).json("aggrosphere.exhaustion");
        public final IConfigEntry<Double> aggrosphereSpeed = new DoubleEntry("config.sow.power.aggrosphere.speed", 3, 0, Integer.MAX_VALUE).json("aggrosphere.speed");
        public final IConfigEntry<Double> aggrosphereDamage = new DoubleEntry("config.sow.power.aggrosphere.damage", 5, 0, Integer.MAX_VALUE).json("aggrosphere.damage");
        public final SeparatorEntry s7 = new SeparatorEntry();
        public final IConfigEntry<Double> aggrostormExhaustion = new DoubleEntry("config.sow.power.aggrostorm.exhaustion", 4, 0, Integer.MAX_VALUE).json("aggrostorm.exhaustion");
        public final IConfigEntry<Double> aggrostormStrength = new DoubleEntry("config.sow.power.aggrostorm.strength", 0.02, 0, Integer.MAX_VALUE).json("aggrostorm.strength");
        public final IConfigEntry<Double> aggrostormRange = new DoubleEntry("config.sow.power.aggrostorm.range", 15, 0, Integer.MAX_VALUE).json("aggrostorm.range");
        public final IConfigEntry<Double> aggrostormDamage = new DoubleEntry("config.sow.power.aggrostorm.damage", 1, 0, Integer.MAX_VALUE).json("aggrostorm.damage");

        public AggressiumPowerConfig() {
            super("aggressium", "config.sow.category.power.aggressium");
        }
    }

    @SuppressWarnings("unused")
    public static class MobiliumPowerConfig extends AutoInitConfigCategoryBase {
        public final IConfigEntry<Integer> mobilibouncePrimaryCooldown = new IntegerEntry("config.sow.power.mobilibounce.cooldown.primary", 50, 0, Integer.MAX_VALUE).json("mobilibounce.cooldown.primary");
        public final IConfigEntry<Integer> mobilibounceSecondaryCooldown = new IntegerEntry("config.sow.power.mobilibounce.cooldown.secondary", 50, 0, Integer.MAX_VALUE).json("mobilibounce.cooldown.secondary");
        public final IConfigEntry<Double> mobilibounceExhaustion = new DoubleEntry("config.sow.power.mobilibounce.exhaustion", 0.5, 0, Integer.MAX_VALUE).json("mobilibounce.exhaustion");
        public final IConfigEntry<Integer> mobilibounceExistTime = new IntegerEntry("config.sow.power.mobilibounce.exist_time", 5, 0, Integer.MAX_VALUE).json("mobilibounce.exist_time");
        public final SeparatorEntry s1 = new SeparatorEntry();
        public final IConfigEntry<Integer> mobiliburstPrimaryCooldown = new IntegerEntry("config.sow.power.mobiliburst.cooldown.primary", 40, 0, Integer.MAX_VALUE).json("mobiliburst.cooldown.primary");
        public final IConfigEntry<Integer> mobiliburstSecondaryCooldown = new IntegerEntry("config.sow.power.mobiliburst.cooldown.secondary", 80, 0, Integer.MAX_VALUE).json("mobiliburst.cooldown.secondary");
        public final IConfigEntry<Double> mobiliburstExhaustion = new DoubleEntry("config.sow.power.mobiliburst.exhaustion", 4, 0, Integer.MAX_VALUE).json("mobiliburst.exhaustion");
        public final IConfigEntry<Double> mobiliburstSpeed = new DoubleEntry("config.sow.power.mobiliburst.speed", 8, 0, 50).json("mobiliburst.speed");
        public final SeparatorEntry s2 = new SeparatorEntry();
        public final IConfigEntry<Integer> mobiliflashPrimaryCooldown = new IntegerEntry("config.sow.power.mobiliflash.cooldown.primary", 40, 0, Integer.MAX_VALUE).json("mobiliflash.cooldown.primary");
        public final IConfigEntry<Integer> mobiliflashSecondaryCooldown = new IntegerEntry("config.sow.power.mobiliflash.cooldown.secondary", 40, 0, Integer.MAX_VALUE).json("mobiliflash.cooldown.secondary");
        public final IConfigEntry<Double> mobiliflashExhaustion = new DoubleEntry("config.sow.power.mobiliflash.exhaustion", 2, 0, Integer.MAX_VALUE).json("mobiliflash.exhaustion");
        public final IConfigEntry<Double> mobiliflashSpeed = new DoubleEntry("config.sow.power.mobiliflash.speed", 8, 0, 50).json("mobiliflash.speed");
        public final SeparatorEntry s3 = new SeparatorEntry();
        public final IConfigEntry<Double> mobiliglideExhaustion = new DoubleEntry("config.sow.power.mobiliglide.exhaustion", 2.0 / 10, 0, Integer.MAX_VALUE).json("mobiliglide.exhaustion");
        public final SeparatorEntry s4 = new SeparatorEntry();
        public final IConfigEntry<Double> mobilileapExhaustion = new DoubleEntry("config.sow.power.mobilileap.exhaustion", 2.0 / 10, 0, Integer.MAX_VALUE).json("mobilileap.exhaustion");
        public final SeparatorEntry s5 = new SeparatorEntry();
        public final IConfigEntry<Double> mobiliwingsExhaustion = new DoubleEntry("config.sow.power.mobiliwings.exhaustion", 1.0 / 10, 0, Integer.MAX_VALUE).json("mobiliwings.exhaustion");

        public MobiliumPowerConfig() {
            super("mobilium", "config.sow.category.power.mobilium");
        }
    }

    @SuppressWarnings("unused")
    public static class ProtisiumPowerConfig extends AutoInitConfigCategoryBase {
        public final IConfigEntry<Integer> protearmorPrimaryCooldown = new IntegerEntry("config.sow.power.protearmor.cooldown.primary", 40, 0, Integer.MAX_VALUE).json("protearmor.cooldown.primary");
        public final IConfigEntry<Integer> protearmorSecondaryCooldown = new IntegerEntry("config.sow.power.protearmor.cooldown.secondary", 80, 0, Integer.MAX_VALUE).json("protearmor.cooldown.secondary");
        public final IConfigEntry<Double> protearmorExhaustion = new DoubleEntry("config.sow.power.protearmor.exhaustion", 2.0 / 10, 0, Integer.MAX_VALUE).json("protearmor.exhaustion");
        public final IConfigEntry<Double> protearmorMaxReduceDamage = new DoubleEntry("config.sow.power.protearmor.maxReduceDamage", 20, 0, Integer.MAX_VALUE).json("protearmor.maxReduceDamage");
        public final SeparatorEntry s1 = new SeparatorEntry();
        public final IConfigEntry<Integer> proteclonePrimaryCooldown = new IntegerEntry("config.sow.power.proteclone.cooldown.primary", 60, 0, Integer.MAX_VALUE).json("proteclone.cooldown.primary");
        public final IConfigEntry<Integer> protecloneSecondaryCooldown = new IntegerEntry("config.sow.power.proteclone.cooldown.secondary", 100, 0, Integer.MAX_VALUE).json("proteclone.cooldown.secondary");
        public final IConfigEntry<Double> protecloneExhaustion = new DoubleEntry("config.sow.power.proteclone.exhaustion", 4, 0, Integer.MAX_VALUE).json("proteclone.exhaustion");
        public final SeparatorEntry s2 = new SeparatorEntry();
        public final IConfigEntry<Integer> protehealPrimaryCooldown = new IntegerEntry("config.sow.power.proteheal.cooldown.primary", 100, 0, Integer.MAX_VALUE).json("proteheal.cooldown.primary");
        public final IConfigEntry<Integer> protehealSecondaryCooldown = new IntegerEntry("config.sow.power.proteheal.cooldown.secondary", 200, 0, Integer.MAX_VALUE).json("proteheal.cooldown.secondary");
        public final IConfigEntry<Double> protehealExhaustion = new DoubleEntry("config.sow.power.proteheal.exhaustion", 2, 0, Integer.MAX_VALUE).json("proteheal.exhaustion");
        public final SeparatorEntry s3 = new SeparatorEntry();
        public final IConfigEntry<Double> protepointExhaustion = new DoubleEntry("config.sow.power.protepoint.exhaustion", 1.0 / 10, 0, Integer.MAX_VALUE).json("protepoint.exhaustion");
        public final SeparatorEntry s4 = new SeparatorEntry();
        public final IConfigEntry<Double> protesphereExhaustion = new DoubleEntry("config.sow.power.protesphere.exhaustion", 2.0 / 10, 0, Integer.MAX_VALUE).json("protesphere.exhaustion");

        public ProtisiumPowerConfig() {
            super("protisium", "config.sow.category.power.protisium");
        }
    }

    @SuppressWarnings("unused")
    public static class SupporiumPowerConfig extends AutoInitConfigCategoryBase {
        public final IConfigEntry<Integer> supporekesisPrimaryCooldown = new IntegerEntry("config.sow.power.supporekesis.cooldown.primary", 50, 0, Integer.MAX_VALUE).json("supporekesis.cooldown.primary");
        public final IConfigEntry<Integer> supporekesisSecondaryCooldown = new IntegerEntry("config.sow.power.supporekesis.cooldown.secondary", 150, 0, Integer.MAX_VALUE).json("supporekesis.cooldown.secondary");
        public final IConfigEntry<Double> supporekesisExhaustion = new DoubleEntry("config.sow.power.supporekesis.exhaustion", 2, 0, Integer.MAX_VALUE).json("supporekesis.exhaustion");
        public final IConfigEntry<Double> supporekesisRange = new DoubleEntry("config.sow.power.supporekesis.range", 20, 0, 16 * 16).json("supporekesis.range");
        public final IConfigEntry<Boolean> supporekesisControlSelf = new BooleanEntry("config.sow.power.supporekesis.control_self", false).json("supporekesis.control_self");
        public final SeparatorEntry s1 = new SeparatorEntry();
        public final IConfigEntry<Integer> supporoformPrimaryCooldown = new IntegerEntry("config.sow.power.supporoform.cooldown.primary", 40, 0, Integer.MAX_VALUE).json("supporoform.cooldown.primary");
        public final IConfigEntry<Integer> supporoformSecondaryCooldown = new IntegerEntry("config.sow.power.supporoform.cooldown.secondary", 160, 0, Integer.MAX_VALUE).json("supporoform.cooldown.secondary");
        public final IConfigEntry<Double> supporoformExhaustion = new DoubleEntry("config.sow.power.supporoform.exhaustion", 4, 0, Integer.MAX_VALUE).json("supporoform.exhaustion");
        public final SeparatorEntry s2 = new SeparatorEntry();
        public final IConfigEntry<Integer> supporoliftPrimaryCooldown = new IntegerEntry("config.sow.power.supporolift.cooldown.primary", 100, 0, Integer.MAX_VALUE).json("supporolift.cooldown.primary");
        public final IConfigEntry<Integer> supporoliftSecondaryCooldown = new IntegerEntry("config.sow.power.supporolift.cooldown.secondary", 200, 0, Integer.MAX_VALUE).json("supporolift.cooldown.secondary");
        public final IConfigEntry<Double> supporoliftExhaustion = new DoubleEntry("config.sow.power.supporolift.exhaustion", 2, 0, Integer.MAX_VALUE).json("supporolift.exhaustion");
        public final IConfigEntry<Double> supporoliftRange = new DoubleEntry("config.sow.power.supporolift.range", 20, 0, 16 * 16).json("supporolift.range");
        public final SeparatorEntry s3 = new SeparatorEntry();
        public final IConfigEntry<Integer> supporospikePrimaryCooldown = new IntegerEntry("config.sow.power.supporospike.cooldown.primary", 50, 0, Integer.MAX_VALUE).json("supporospike.cooldown.primary");
        public final IConfigEntry<Integer> supporospikeSecondaryCooldown = new IntegerEntry("config.sow.power.supporospike.cooldown.secondary", 100, 0, Integer.MAX_VALUE).json("supporospike.cooldown.secondary");
        public final IConfigEntry<Double> supporospikeExhaustion = new DoubleEntry("config.sow.power.supporospike.exhaustion", 3, 0, Integer.MAX_VALUE).json("supporospike.exhaustion");
        public final IConfigEntry<Double> supporospikeRange = new DoubleEntry("config.sow.power.supporospike.range", 10, 0, 16 * 16).json("supporospike.range");

        public SupporiumPowerConfig() {
            super("supportium", "config.sow.category.power.supportium");
        }
    }
}
