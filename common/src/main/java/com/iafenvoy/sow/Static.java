package com.iafenvoy.sow;

import com.iafenvoy.sow.world.sound.ServerSongCubeSoundManager;
import com.iafenvoy.sow.world.sound.SongCubeSoundManager;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class Static {
    public static final Identifier BEACON_TELEPORT = new Identifier(SongsOfWar.MOD_ID, "beacon_teleport");
    public static final Identifier POWER_KEYBINDING_SYNC = new Identifier(SongsOfWar.MOD_ID, "keybinding_sync");
    public static final Identifier JUMP_PRESS = new Identifier(SongsOfWar.MOD_ID, "jump_press");
    public static final UUID PROTESPHERE_UUID = UUID.fromString("babda2da-13e9-4096-baba-933bb695e319");
    public static final UUID MOBILIGLIDE_UUID = UUID.fromString("3db28b1d-3fec-4a31-9f50-6c04f30e33f1");
    public static SongCubeSoundManager songCubeSoundManager = ServerSongCubeSoundManager.INSTANCE;
}
