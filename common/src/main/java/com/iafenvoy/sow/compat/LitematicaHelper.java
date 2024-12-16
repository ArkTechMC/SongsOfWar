package com.iafenvoy.sow.compat;

import com.iafenvoy.sow.SongsOfWar;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class LitematicaHelper {
    private static final String EXTRACT_PATH = "./schematics/songs-of-war/";
    private static final List<String> FILES = List.of("shrine.litematic");

    public static void extractFile() {
        if(!new File(EXTRACT_PATH).mkdirs())
            SongsOfWar.LOGGER.error("Failed to create folder {}.", EXTRACT_PATH);
        for (String file : FILES) {
            try {
                write2File(LitematicaHelper.class.getResourceAsStream("/litematica/" + file), EXTRACT_PATH + file);
            } catch (Exception e) {
                SongsOfWar.LOGGER.error("Failed to extract litematica file {}.", file, e);
            }
        }
    }

    public static void write2File(InputStream is, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
             BufferedInputStream bis = new BufferedInputStream(is)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) bos.write(buffer, 0, bytesRead);
            bos.flush();
        }
    }
}
