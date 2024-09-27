package com.iafenvoy.sow.fabric;

import com.iafenvoy.jupiter.screen.ConfigSelectScreen;
import com.iafenvoy.sow.config.SowConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.minecraft.text.Text;

public class ModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> new ConfigSelectScreen<>(Text.translatable("config.sow.title"), parent, SowConfig.INSTANCE, null);
    }
}
