package com.iafenvoy.sow.world;

import com.iafenvoy.sow.power.PowerCategory;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.StructureWorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SongChunkManager {
    public static boolean hasSongChunk(StructureWorldAccess serverWorld, PowerCategory category, ChunkPos pos, int radius) {
        return ChunkPos.stream(pos, radius).reduce(false, (p, c) -> p || SongChunkManager.isSongChunk(serverWorld, category, c), (a, b) -> a || b);
    }

    public static boolean isSongChunk(StructureWorldAccess serverWorld, PowerCategory category, ChunkPos pos) {
        return new Random(serverWorld.getSeed() + category.getRandomOffset() + pos.x * 0x5AC0DBL + pos.z * 0x5F24FL).nextInt(256) == 0;
    }

    @Nullable
    public static PowerCategory find(StructureWorldAccess serverWorld, ChunkPos pos) {
        for (PowerCategory category : PowerCategory.values())
            if (isSongChunk(serverWorld, category, pos))
                return category;
        return null;
    }
}
