package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.render.glint.GlintManager;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.data.SongStoneInfo;
import com.iafenvoy.sow.item.SongStoneItem;
import com.iafenvoy.sow.item.SowSpawnEggItem;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

@SuppressWarnings("unused")
public final class SowItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Item> SONG_STONE_RED = REGISTRY.register("song_stone_red", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.RED, 1).dmg(5), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_YELLOW = REGISTRY.register("song_stone_yellow", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.YELLOW, 1).kb(5), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_BLUE = REGISTRY.register("song_stone_blue", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.BLUE, 1).spd(5), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_ORANGE = REGISTRY.register("song_stone_orange", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.ORANGE, 1).dmg(3).kb(2), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_GREEN = REGISTRY.register("song_stone_green", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.GREEN, 1).luck(5), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_PURPLE = REGISTRY.register("song_stone_purple", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.PURPLE, 1).dmg(2).spd(2), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_WHITE = REGISTRY.register("song_stone_white", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.WHITE, 1).dmg(2).kb(1).spd(1).luck(1), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_PINK = REGISTRY.register("song_stone_pink", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.PINK, 1).spd(2).luck(3), new Item.Settings()));
    public static final RegistrySupplier<Item> SONG_STONE_AQUA = REGISTRY.register("song_stone_aqua", () -> new SongStoneItem(SongStoneInfo.of(GlintManager.AQUA, 1).kb(2).luck(3), new Item.Settings()));

    public static final RegistrySupplier<Item> WITHER_STAFF = REGISTRY.register("wither_staff", () -> new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS)));
    //Spawn Egg
    //Misc
    public static final RegistrySupplier<Item> NONE_TYPE_ARDONI_SPAWN_EGG = REGISTRY.register("none_type_ardoni_spawn_egg", () ->ArdoniType.NONE.createSpawnEgg(SowEntities.NONE_TYPE_ARDONI));
    public static final RegistrySupplier<Item> VOLTARIS_ARDONI_SPAWN_EGG = REGISTRY.register("voltaris_ardoni_spawn_egg", () -> ArdoniType.VOLTARIS.createSpawnEgg(SowEntities.VOLTARIS_ARDONI));
    public static final RegistrySupplier<Item> SENDARIS_ARDONI_SPAWN_EGG = REGISTRY.register("sendaris_ardoni_spawn_egg", () -> ArdoniType.SENDARIS.createSpawnEgg(SowEntities.SENDARIS_ARDONI));
    public static final RegistrySupplier<Item> NESTORIS_ARDONI_SPAWN_EGG = REGISTRY.register("nestoris_ardoni_spawn_egg",  () ->ArdoniType.NESTORIS.createSpawnEgg(SowEntities.NESTORIS_ARDONI));
    public static final RegistrySupplier<Item> KALTARIS_ARDONI_SPAWN_EGG = REGISTRY.register("kaltaris_ardoni_spawn_egg",  () ->ArdoniType.KALTARIS.createSpawnEgg(SowEntities.KALTARIS_ARDONI));
    public static final RegistrySupplier<Item> MENDORIS_ARDONI_SPAWN_EGG = REGISTRY.register("mendoris_ardoni_spawn_egg",  () ->ArdoniType.MENDORIS.createSpawnEgg(SowEntities.MENDORIS_ARDONI));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_SPAWN_EGG = REGISTRY.register("ender_knight_spawn_egg", SowSpawnEggItem.create(SowEntities.ENDER_KNIGHT, 0xFF000000, 0xFF800080));
    public static final RegistrySupplier<Item> GRIM_SPAWN_EGG = REGISTRY.register("grim_spawn_egg", SowSpawnEggItem.create(SowEntities.GRIM, 0xFF444444, 0xFF00FFFF));
    //Ardoni
    public static final RegistrySupplier<Item> TIDE_SINGER_SPAWN_EGG = REGISTRY.register("tide_singer_spawn_egg", SowSpawnEggItem.create(SowEntities.TIDE_SINGER, 0xFF888888, 0xFFFFFF00));
    public static final RegistrySupplier<Item> DEATH_SINGER_SPAWN_EGG = REGISTRY.register("death_singer_spawn_egg", SowSpawnEggItem.create(SowEntities.DEATH_SINGER, 0xFF444444, 0xFFFF0000));
    public static final RegistrySupplier<Item> AEGUS_SPAWN_EGG = REGISTRY.register("aegus_spawn_egg", SowSpawnEggItem.create(SowEntities.AEGUS, 0xFF888888, 0xFFFFFF00));
    public static final RegistrySupplier<Item> KALTARIS_MASTER_SPAWN_EGG = REGISTRY.register("kaltaris_master_spawn_egg", SowSpawnEggItem.create(SowEntities.KALTARIS_MASTER, 0xFF888888, 0xFF00FF00));
    public static final RegistrySupplier<Item> MENDORIS_MASTER_SPAWN_EGG = REGISTRY.register("mendoris_master_spawn_egg", SowSpawnEggItem.create(SowEntities.MENDORIS_MASTER, 0xFF888888, 0xFF800080));
    public static final RegistrySupplier<Item> SENDARIS_MASTER_SPAWN_EGG = REGISTRY.register("sendaris_master_spawn_egg", SowSpawnEggItem.create(SowEntities.SENDARIS_MASTER, 0xFF888888, 0xFF00FFFF));
    public static final RegistrySupplier<Item> HUBRIS_SPAWN_EGG = REGISTRY.register("hubris_spawn_egg", SowSpawnEggItem.create(SowEntities.HUBRIS, 0xFF888888, 0xFFFFFF00));
    public static final RegistrySupplier<Item> RIA_SPAWN_EGG = REGISTRY.register("ria_spawn_egg", SowSpawnEggItem.create(SowEntities.RIA, 0xFFAAAAAA, 0xFF00FFFF));
    public static final RegistrySupplier<Item> THALLEOUS_SPAWN_EGG = REGISTRY.register("thalleous_spawn_egg", SowSpawnEggItem.create(SowEntities.THALLEOUS, 0xFF888888, 0xFF007FFF));
    public static final RegistrySupplier<Item> GALLEOUS_SPAWN_EGG = REGISTRY.register("galleous_spawn_egg", SowSpawnEggItem.create(SowEntities.GALLEOUS, 0xFF888888, 0xFF007FFF));
    public static final RegistrySupplier<Item> SENN_SPAWN_EGG = REGISTRY.register("senn_spawn_egg", SowSpawnEggItem.create(SowEntities.SENN, 0xFF888888, 0xFFFFFFFF));
    public static final RegistrySupplier<Item> ZULIUS_SPAWN_EGG = REGISTRY.register("zulius_spawn_egg", SowSpawnEggItem.create(SowEntities.ZULIUS, 0xFF888888, 0xFF00FF00));
    public static final RegistrySupplier<Item> TYGREN_SPAWN_EGG = REGISTRY.register("tygren_spawn_egg", SowSpawnEggItem.create(SowEntities.TYGREN, 0xFF888888, 0xFFFF0000));
    public static final RegistrySupplier<Item> OSIVIAN_SPAWN_EGG = REGISTRY.register("osivian_spawn_egg", SowSpawnEggItem.create(SowEntities.OSIVIAN, 0xFF888888, 0xFF0000FF));
    public static final RegistrySupplier<Item> LUCIDIUS_SPAWN_EGG = REGISTRY.register("lucidius_spawn_egg", SowSpawnEggItem.create(SowEntities.LUCIDIUS, 0xFF666666, 0xFFFF0000));
    public static final RegistrySupplier<Item> ZINAIDA_SPAWN_EGG = REGISTRY.register("zinaida_spawn_egg", SowSpawnEggItem.create(SowEntities.ZINAIDA, 0xFF666666, 0xFFFF0000));
    //Felina
    public static final RegistrySupplier<Item> FELDEN_SPAWN_EGG = REGISTRY.register("felden_spawn_egg", SowSpawnEggItem.create(SowEntities.FELDEN, 0xFF444444, 0xFFf9d4c9));
    public static final RegistrySupplier<Item> KIYOSHI_SPAWN_EGG = REGISTRY.register("kiyoshi_spawn_egg", SowSpawnEggItem.create(SowEntities.KIYOSHI, 0xFF006400, 0xFFf9d4c9));
    public static final RegistrySupplier<Item> NIIKA_SPAWN_EGG = REGISTRY.register("niika_spawn_egg", SowSpawnEggItem.create(SowEntities.NIIKA, 0xFF444444, 0xFFa52a2a));
    //Human
    public static final RegistrySupplier<Item> ABBIGAIL_SPAWN_EGG = REGISTRY.register("abbigail_spawn_egg", SowSpawnEggItem.create(SowEntities.ABBIGAIL, 0xFFa52a2a, 0xFF301934));
    public static final RegistrySupplier<Item> ALEC_SPAWN_EGG = REGISTRY.register("alec_spawn_egg", SowSpawnEggItem.create(SowEntities.ALEC, 0xFF444444, 0xFFf9d4c9));
    public static final RegistrySupplier<Item> BARTENDER_SPAWN_EGG = REGISTRY.register("bartender_spawn_egg", SowSpawnEggItem.create(SowEntities.BARTENDER, 0xFF05243e, 0xFF575008));
    public static final RegistrySupplier<Item> CIVILIAN_SPAWN_EGG = REGISTRY.register("civilian_spawn_egg", SowSpawnEggItem.create(SowEntities.CIVILIAN, 0xFF345758, 0xFFd9d4b2));
    public static final RegistrySupplier<Item> DARLENE_SPAWN_EGG = REGISTRY.register("darlene_spawn_egg", SowSpawnEggItem.create(SowEntities.DARLENE, 0xFF3f2b20, 0xFFe0b476));
    public static final RegistrySupplier<Item> EDDY_SPAWN_EGG = REGISTRY.register("eddy_spawn_egg", SowSpawnEggItem.create(SowEntities.EDDY, 0xFF28231c, 0xFFf2cba8));
    public static final RegistrySupplier<Item> HAWKEN_SPAWN_EGG = REGISTRY.register("hawken_spawn_egg", SowSpawnEggItem.create(SowEntities.HAWKEN, 0xFF53464f, 0xFF3f332b));
    public static final RegistrySupplier<Item> HORSE_RIDER_SPAWN_EGG = REGISTRY.register("horse_rider_spawn_egg", SowSpawnEggItem.create(SowEntities.HORSE_RIDER, 0xFF152c43, 0xFFb7928c));
    public static final RegistrySupplier<Item> LUCAN_SPAWN_EGG = REGISTRY.register("lucan_spawn_egg", SowSpawnEggItem.create(SowEntities.LUCAN, 0xFF5e4941, 0xFFf0bf85));
    public static final RegistrySupplier<Item> MARCUS_SPAWN_EGG = REGISTRY.register("marcus_spawn_egg", SowSpawnEggItem.create(SowEntities.MARCUS, 0xFF5e4941, 0xFF2c1308));
    public static final RegistrySupplier<Item> MARSHALL_SPAWN_EGG = REGISTRY.register("marshall_spawn_egg", SowSpawnEggItem.create(SowEntities.MARSHALL, 0xFF53171f, 0xFFc88e71));
    public static final RegistrySupplier<Item> MRFINCH_SPAWN_EGG = REGISTRY.register("mrfinch_spawn_egg", SowSpawnEggItem.create(SowEntities.MRFINCH, 0xFF8f652c, 0xFFFFFFFF));
    public static final RegistrySupplier<Item> SULLIMAN_SPAWN_EGG = REGISTRY.register("sulliman_spawn_egg", SowSpawnEggItem.create(SowEntities.SULLIMAN, 0xFF480c09, 0xFF210e08));
    //Magnorite
    public static final RegistrySupplier<Item> IGNEOUS_SPAWN_EGG = REGISTRY.register("igneous_spawn_egg", SowSpawnEggItem.create(SowEntities.IGNEOUS, 0xFF444444, 0xFFFF0000));
    public static final RegistrySupplier<Item> MAGNORITE_SPAWN_EGG = REGISTRY.register("magnorite_spawn_egg", SowSpawnEggItem.create(SowEntities.MAGNORITE, 0xFF444444, 0xFFFF0000));
    //Necromancer
    public static final RegistrySupplier<Item> NECROMANCER_SPAWN_EGG = REGISTRY.register("necromancer_spawn_egg", SowSpawnEggItem.create(SowEntities.NECROMANCER, 0xFF222222, 0xFFBBBBBB));
    public static final RegistrySupplier<Item> NECROLORD_SPAWN_EGG = REGISTRY.register("necrolord_spawn_egg", SowSpawnEggItem.create(SowEntities.NECROLORD, 0xFF222222, 0xFFBBBBBB));
    public static final RegistrySupplier<Item> XARIA_SPAWN_EGG = REGISTRY.register("xaria_spawn_egg", SowSpawnEggItem.create(SowEntities.XARIA, 0xFF222222, 0xFFBBBBBB));
    //Netheran
    public static final RegistrySupplier<Item> NETHARAN_SPAWN_EGG = REGISTRY.register("netharan_spawn_egg", SowSpawnEggItem.create(SowEntities.NETHARAN, 0xFF222222, 0xFFFF0000));
    public static final RegistrySupplier<Item> CHRONOS_SPAWN_EGG = REGISTRY.register("chronos_spawn_egg", SowSpawnEggItem.create(SowEntities.CHRONOS, 0xFF222222, 0xFFFF0000));
    public static final RegistrySupplier<Item> PYTHUS_SPAWN_EGG = REGISTRY.register("pythus_spawn_egg", SowSpawnEggItem.create(SowEntities.PYTHUS, 0xFF222222, 0xFFd6350f));
    //Zombie
    public static final RegistrySupplier<Item> HUSK_SPAWN_EGG = REGISTRY.register("husk_spawn_egg", SowSpawnEggItem.create(SowEntities.HUSK, 7958625, 15125652));
    public static final RegistrySupplier<Item> STRAY_SPAWN_EGG = REGISTRY.register("stray_spawn_egg", SowSpawnEggItem.create(SowEntities.STRAY, 6387319, 14543594));
    public static final RegistrySupplier<Item> ZOMBIE_SPAWN_EGG = REGISTRY.register("zombie_spawn_egg", SowSpawnEggItem.create(SowEntities.ZOMBIE, 44975, 7969893));
    //Guard
    public static final RegistrySupplier<Item> CONCHORD_GUARD_SPAWN_EGG = REGISTRY.register("conchord_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.CONCHORD_GUARD, 0xff4a2e1d, 0xff575757));
    public static final RegistrySupplier<Item> CROWN_GUARD_PEAK_SPAWN_EGG = REGISTRY.register("crown_peak_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.CROWN_PEAK_GUARD, 0xffd9d8d9, 0xff30210e));
    public static final RegistrySupplier<Item> CYDONIA_GUARD_SPAWN_EGG = REGISTRY.register("cydonia_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.CYDONIA_GUARD, 0xffab6117, 0xff403a34));
    public static final RegistrySupplier<Item> ETHEREA_GUARD_SPAWN_EGG = REGISTRY.register("etherea_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.ETHEREA_GUARD, 0xff2b3d8d, 0xff342a21));
    public static final RegistrySupplier<Item> FELDEN_GUARD_SPAWN_EGG = REGISTRY.register("felden_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.FELDEN_GUARD, 0xff3e372f, 0xff914f2f));
    public static final RegistrySupplier<Item> GENERAL_GUARD_SPAWN_EGG = REGISTRY.register("general_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.GENERAL_GUARD, 0xffbcc5cc, 0xff121212));
    public static final RegistrySupplier<Item> HYDRAPHEL_GUARD_SPAWN_EGG = REGISTRY.register("hydraphel_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.HYDRAPHEL_GUARD, 0xffebedf1, 0xff823a04));
    public static final RegistrySupplier<Item> KARTHEN_GUARD_SPAWN_EGG = REGISTRY.register("karthen_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.KARTHEN_GUARD, 0xff2a2a2a, 0xff4a3f31));
    public static final RegistrySupplier<Item> NORTHWIND_GUARD_SPAWN_EGG = REGISTRY.register("northwind_guard_spawn_egg", SowSpawnEggItem.create(SowEntities.NORTHWIND_GUARD, 0xff09417f, 0xffeec79a));
    //Soldier
    public static final RegistrySupplier<Item> CONCHORD_SOLDIER_SPAWN_EGG = REGISTRY.register("conchord_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.CONCHORD_SOLDIER, 0xff4a2e1d, 0xff575757));
    public static final RegistrySupplier<Item> CROWN_SOLDIER_PEAK_SPAWN_EGG = REGISTRY.register("crown_peak_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.CROWN_PEAK_SOLDIER, 0xffd9d8d9, 0xff30210e));
    public static final RegistrySupplier<Item> CYDONIA_SOLDIER_SPAWN_EGG = REGISTRY.register("cydonia_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.CYDONIA_SOLDIER, 0xffab6117, 0xff403a34));
    public static final RegistrySupplier<Item> ETHEREA_SOLDIER_SPAWN_EGG = REGISTRY.register("etherea_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.ETHEREA_SOLDIER, 0xff2b3d8d, 0xff342a21));
    public static final RegistrySupplier<Item> FELDEN_SOLDIER_SPAWN_EGG = REGISTRY.register("felden_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.FELDEN_SOLDIER, 0xff3e372f, 0xff914f2f));
    public static final RegistrySupplier<Item> HYDRAPHEL_SOLDIER_SPAWN_EGG = REGISTRY.register("hydraphel_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.HYDRAPHEL_SOLDIER, 0xffebedf1, 0xff823a04));
    public static final RegistrySupplier<Item> NORTHWIND_SOLDIER_SPAWN_EGG = REGISTRY.register("northwind_soldier_spawn_egg", SowSpawnEggItem.create(SowEntities.NORTHWIND_SOLDIER, 0xff09417f, 0xffeec79a));
    //Townsfolk
    public static final RegistrySupplier<Item> ADVENTURER_FOLK_SPAWN_EGG = REGISTRY.register("adventurer_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.ADVENTURER_FOLK, 0xff326b88, 0xff8b5a3b));
    public static final RegistrySupplier<Item> BLACKSMITH_FOLK_SPAWN_EGG = REGISTRY.register("blacksmith_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.BLACKSMITH_FOLK, 0xff4c4441, 0xff3e2305));
    public static final RegistrySupplier<Item> CHEF_FOLK_SPAWN_EGG = REGISTRY.register("chef_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.CHEF_FOLK, 0xff384200, 0xff1a1a1a));
    public static final RegistrySupplier<Item> FARMER_FOLK_SPAWN_EGG = REGISTRY.register("farmer_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.FARMER_FOLK, 0xff543e3b, 0xffca9668));
    public static final RegistrySupplier<Item> FEMALE_FOLK_SPAWN_EGG = REGISTRY.register("female_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.FEMALE_FOLK, 0xfffec38f, 0xff66462e));
    public static final RegistrySupplier<Item> FISHER_FOLK_SPAWN_EGG = REGISTRY.register("fisher_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.FISHER_FOLK, 0xff1f1c16, 0xff6f5b38));
    public static final RegistrySupplier<Item> LEATHER_WORKER_FOLK_SPAWN_EGG = REGISTRY.register("leather_worker_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.LEATHER_WORKER_FOLK, 0xff021c02, 0xff543013));
    public static final RegistrySupplier<Item> MALE_FOLK_SPAWN_EGG = REGISTRY.register("male_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.MALE_FOLK, 0xff5e4139, 0xff251d15));
    public static final RegistrySupplier<Item> MERCHANT_FOLK_SPAWN_EGG = REGISTRY.register("merchant_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.MERCHANT_FOLK, 0xff1d1d1d, 0xff3e2d25));
    public static final RegistrySupplier<Item> MINER_FOLK_SPAWN_EGG = REGISTRY.register("miner_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.MINER_FOLK, 0xff624430, 0xffe59a65));
    public static final RegistrySupplier<Item> OLD_FOLK_SPAWN_EGG = REGISTRY.register("old_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.OLD_FOLK, 0xff7c6247, 0xfffdc997));
    public static final RegistrySupplier<Item> POOL_FOLK_SPAWN_EGG = REGISTRY.register("poor_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.POOR_FOLK, 0xff9f8e6e, 0xff53483d));
    public static final RegistrySupplier<Item> SAILOR_FOLK_SPAWN_EGG = REGISTRY.register("sailor_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.SAILOR_FOLK, 0xff314670, 0xff212121));
    public static final RegistrySupplier<Item> SCHOLAR_FOLK_SPAWN_EGG = REGISTRY.register("scholar_folk_spawn_egg", SowSpawnEggItem.create(SowEntities.SCHOLAR_FOLK, 0xff2f0c00, 0xff626262));

    public static void init() {
        CreativeTabRegistry.appendStack(SowItemGroups.ITEMS,
                SowBanners.CONCHORD,
                SowBanners.CONCHORD_SIMPLE,
                SowBanners.CROWN_PEAK,
                SowBanners.CYDONIA,
                SowBanners.CYDONIA_SIMPLE,
                SowBanners.FELDEN,
                SowBanners.FELDEN_SIMPLE,
                SowBanners.HYDRAPHEL,
                SowBanners.HYDRAPHEL_SIMPLE,
                SowBanners.KARTHEN,
                SowBanners.KARTHEN_SIMPLE,
                SowBanners.NORTHWIND,
                SowBanners.NORTHWIND_SIMPLE);
    }
}
