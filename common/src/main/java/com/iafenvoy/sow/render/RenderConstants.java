package com.iafenvoy.sow.render;

import com.iafenvoy.sow.SongsOfWar;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RenderConstants {
    public static final Identifier WHITE_TEXTURE = new Identifier(SongsOfWar.MOD_ID, "textures/white.png");
}
