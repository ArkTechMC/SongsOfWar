package com.iafenvoy.sow.compat.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;

@EmiEntrypoint
public class SowRecipePlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        SongStoneRecipeHelper.register(registry);
        SongRecipeHelper.register(registry);
    }
}
