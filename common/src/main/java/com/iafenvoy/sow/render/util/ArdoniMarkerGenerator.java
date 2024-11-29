package com.iafenvoy.sow.render.util;

import com.iafenvoy.neptune.render.SimpleTexture;
import com.iafenvoy.sow.SongsOfWar;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.util.Identifier;

import java.util.*;

@Environment(EnvType.CLIENT)
public class ArdoniMarkerGenerator {
    private static final Map<Long, ArdoniMarkerGenerator> GENERATOR = new HashMap<>();
    private static final int BODY_OFFSET_X = 0, BODY_OFFSET_Y = 20;
    private static final int LEGS_OFFSET_X = 16, LEGS_OFFSET_Y = 52;
    private final ArdoniLikeBooleanMapGenerator body;
    private final ArdoniLikeBooleanMapGenerator legs;
    private final Random random;
    private final Identifier skinId, graveId;
    private boolean present = false;

    private ArdoniMarkerGenerator(long seed) {
        this.random = new Random(seed);
        this.body = new ArdoniLikeBooleanMapGenerator(56, 12, this.random.nextLong());
        this.legs = new ArdoniLikeBooleanMapGenerator(32, 12, this.random.nextLong());
        this.skinId = new Identifier(SongsOfWar.MOD_ID, "ardoni_skin_marker_" + seed);
        this.graveId = new Identifier(SongsOfWar.MOD_ID, "ardoni_grave_marker_" + seed);
    }

    public static ArdoniMarkerGenerator getOrCreate(long seed) {
        if (!GENERATOR.containsKey(seed)) GENERATOR.put(seed, new ArdoniMarkerGenerator(seed));
        return GENERATOR.get(seed);
    }

    public static void resetAll() {
        GENERATOR.values().forEach(ArdoniMarkerGenerator::reset);
    }

    private static int generateColor(Random random) {
        int r = random.nextInt(0xC0, 0x100);
        return 0xFF << 24 | r << 16 | r << 8 | r;
    }

    private static void fill(Random random, NativeImage skin, NativeImage grave, int offsetX, int offsetY, boolean[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++) {
                int x = offsetX + i, y = offsetY + j;
                int color = map[i][j] ? generateColor(random) : 0;
                skin.setColor(x, y, color);
                grave.setColor(x, y, 20 <= x && x <= 27 && 20 <= y && y <= 31 ? color : 0);
            }
    }

    private static void upload(NativeImage texture, Identifier id) {
        SimpleTexture skinTexture = new SimpleTexture(texture);
        skinTexture.upload(false, false);
        MinecraftClient.getInstance().getTextureManager().registerTexture(id, skinTexture);
    }

    private void generate() {
        this.present = true;
        NativeImage skin = new NativeImage(64, 64, true);
        NativeImage grave = new NativeImage(64, 64, true);
        fill(this.random, skin, grave, BODY_OFFSET_X, BODY_OFFSET_Y, this.body.generate());
        fill(this.random, skin, grave, LEGS_OFFSET_X, LEGS_OFFSET_Y, this.legs.generate());
        upload(skin, this.skinId);
        upload(grave, this.graveId);
    }

    public Identifier getForSkin() {
        if (!this.present) this.generate();
        return this.skinId;
    }

    public Identifier getForGrave() {
        if (!this.present) this.generate();
        return this.graveId;
    }

    public void reset() {
        this.present = false;
    }

    public static class ArdoniLikeBooleanMapGenerator {
        private static final List<Integer> INDEX = List.of(0, 1, 2, 3, 4, 5, 6, 7);
        private static final int[] DIR_X = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        private static final int[] DIR_Y = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

        private final int width, height, flag;
        private final Random random;

        public ArdoniLikeBooleanMapGenerator(int width, int height, long seed) {
            this.width = width;
            this.height = height;
            this.flag = (int) Math.pow(width * height, 0.5);
            this.random = new Random(seed);
        }

        public boolean[][] generate() {
            boolean[][] data = new boolean[this.width][this.height];
            int count = this.random.nextInt(this.flag / 2, this.flag);
            Queue<PointHolder> queue = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                int x = this.random.nextInt(this.width), y = this.random.nextInt(this.height);
                int size = this.random.nextInt(this.flag, this.width * this.height), dir = -1;
                queue.offer(new PointHolder(x, y, size, dir));
            }
            while (!queue.isEmpty()) {
                PointHolder o = queue.poll();
                if (o.size <= 0 || !DirMapChecker.allow.check(this, data, o.x, o.y, o.dir))
                    continue;
                data[o.x][o.y] = true;
                for (Integer i : DirMapFinder.allowMap.check(this, data, o.x, o.y))
                    if (this.random.nextBoolean())
                        queue.offer(new PointHolder(o.x + DIR_X[i], o.y + DIR_Y[i], this.random.nextInt((int) Math.floor((double) o.size * 2 / 3), o.size), (i + 4) % 8));
            }
            return data;
        }

        @FunctionalInterface
        public interface Callback {
            boolean call(int x, int y);
        }

        @FunctionalInterface
        public interface MapChecker {
            MapChecker checkOrTrue = (gen, x, y, fn) -> x < 0 || y < 0 || x >= gen.width || y >= gen.height || fn.call(x, y);
            MapChecker checkOrFalse = (gen, x, y, fn) -> x >= 0 && y >= 0 && x < gen.width && y < gen.height && fn.call(x, y);

            boolean check(ArdoniLikeBooleanMapGenerator gen, int x, int y, Callback fn);
        }

        @FunctionalInterface
        public interface DirMapChecker {
            DirMapChecker allow = (gen, map, x, y, igDir) -> !map[x][y] && INDEX.stream().reduce(true, (p, c) -> p && (c == igDir || c == (igDir + 1) % 8 || c == (igDir + 7) % 8 || MapChecker.checkOrTrue.check(gen, x + DIR_X[c], y + DIR_Y[c], (_x, _y) -> !map[_x][_y])), (b1, b2) -> b1 && b2);

            boolean check(ArdoniLikeBooleanMapGenerator gen, boolean[][] map, int x, int y, int igDir);
        }

        @FunctionalInterface
        public interface DirMapFinder {
            DirMapFinder allowMap = (gen, map, x, y) -> INDEX.stream().filter(v -> v % 2 == 0).filter(i -> MapChecker.checkOrFalse.check(gen, x + DIR_X[i], y + DIR_Y[i], (_x, _y) -> DirMapChecker.allow.check(gen, map, _x, _y, (i + 4) % 8))).toList();

            List<Integer> check(ArdoniLikeBooleanMapGenerator gen, boolean[][] map, int x, int y);
        }

        public record PointHolder(int x, int y, int size, int dir) {
        }
    }
}
