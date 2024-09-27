package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArdoniName implements SynchronousResourceReloader {
    private static final List<String> NAMES = new ArrayList<>();

    public static String randomName() throws UnsupportedOperationException {
        try {
            return RandomHelper.randomOne(NAMES);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Cannot random an ardoni name.", e);
        }
    }

    @Override
    public void reload(ResourceManager manager) {
        NAMES.clear();
//        String language = MinecraftClient.getInstance().options.language.toLowerCase(Locale.ROOT);
        Identifier file = new Identifier(SongsOfWar.MOD_ID, "ardoni_name/en_us.txt");
        for (Resource resource : manager.getAllResources(file))
            try {
                BufferedReader reader = resource.getReader();
                String s;
                while ((s = reader.readLine()) != null) NAMES.add(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        SongsOfWar.LOGGER.info("Successfully loaded {} ardoni name(s),", NAMES.size());
    }
}
