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
    public static final RegistrySupplier<Item> NONE_ARDONI_SPAWN_EGG = REGISTRY.register("none_ardoni_spawn_egg", ArdoniType.NONE::createSpawnEgg);
    public static final RegistrySupplier<Item> VOLTARIS_ARDONI_SPAWN_EGG = REGISTRY.register("voltaris_ardoni_spawn_egg", ArdoniType.VOLTARIS::createSpawnEgg);
    public static final RegistrySupplier<Item> SENDARIS_ARDONI_SPAWN_EGG = REGISTRY.register("sendaris_ardoni_spawn_egg", ArdoniType.SENDARIS::createSpawnEgg);
    public static final RegistrySupplier<Item> NESTORIS_ARDONI_SPAWN_EGG = REGISTRY.register("nestoris_ardoni_spawn_egg", ArdoniType.NESTORIS::createSpawnEgg);
    public static final RegistrySupplier<Item> KALTARIS_ARDONI_SPAWN_EGG = REGISTRY.register("kaltaris_ardoni_spawn_egg", ArdoniType.KALTARIS::createSpawnEgg);
    public static final RegistrySupplier<Item> MENDORIS_ARDONI_SPAWN_EGG = REGISTRY.register("mendoris_ardoni_spawn_egg", ArdoniType.MENDORIS::createSpawnEgg);
    public static final RegistrySupplier<Item> ENDER_KNIGHT_SPAWN_EGG = REGISTRY.register("ender_knight_spawn_egg", SowSpawnEggItem.create(SowEntities.ENDER_KNIGHT, 0xFF000000, 0xFF800080));
    public static final RegistrySupplier<Item> GRIM_SPAWN_EGG = REGISTRY.register("grim_spawn_egg", SowSpawnEggItem.create(SowEntities.GRIM, 0xFF444444, 0xFF00FFFF));
    public static final RegistrySupplier<Item> IGNEOUS_SPAWN_EGG = REGISTRY.register("igneous_spawn_egg", SowSpawnEggItem.create(SowEntities.IGNEOUS, 0xFF444444, 0xFFFF0000));
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
    public static final RegistrySupplier<Item> BIGGERTON_BARTENDER_SPAWN_EGG = REGISTRY.register("biggerton_bartender_spawn_egg", SowSpawnEggItem.create(SowEntities.BIGGERTON_BARTENDER, 0xFF05243e, 0xFF575008));
    public static final RegistrySupplier<Item> BIGGERTON_CIVILIAN_SPAWN_EGG = REGISTRY.register("biggerton_civilian_spawn_egg", SowSpawnEggItem.create(SowEntities.BIGGERTON_CIVILIAN, 0xFF345758, 0xFFd9d4b2));
    public static final RegistrySupplier<Item> DARLENE_SPAWN_EGG = REGISTRY.register("darlene_spawn_egg", SowSpawnEggItem.create(SowEntities.DARLENE, 0xFF3f2b20, 0xFFe0b476));
    public static final RegistrySupplier<Item> EDDY_SPAWN_EGG = REGISTRY.register("eddy_spawn_egg", SowSpawnEggItem.create(SowEntities.EDDY, 0xFF28231c, 0xFFf2cba8));
    public static final RegistrySupplier<Item> HAWKEN_SPAWN_EGG = REGISTRY.register("hawken_spawn_egg", SowSpawnEggItem.create(SowEntities.HAWKEN, 0xFF53464f, 0xFF3f332b));
    //Netheran
    public static final RegistrySupplier<Item> CHRONOS_SPAWN_EGG = REGISTRY.register("chronos_spawn_egg", SowSpawnEggItem.create(SowEntities.CHRONOS, 0xFF222222, 0xFFFF0000));
    public static final RegistrySupplier<Item> PYTHUS_SPAWN_EGG = REGISTRY.register("pythus_spawn_egg", SowSpawnEggItem.create(SowEntities.PYTHUS, 0xFF222222, 0xFFd6350f));

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
                SowBanners.K_ARTHEN,
                SowBanners.K_ARTHEN_SIMPLE,
                SowBanners.NORTHWIND,
                SowBanners.NORTHWIND_SIMPLE);
    }
}
