package com.iafenvoy.sow.util;

import net.minecraft.util.math.MathHelper;

import java.util.Objects;

public class Color4i {
    public static final Color4i ZERO = new Color4i(0, 0, 0, 0);
    public final int r;
    public final int g;
    public final int b;
    public final int a;
    public final int intValue;

    public Color4i(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public Color4i(int r, int g, int b, int a) {
        this.r = MathHelper.clamp(r, 0, 255);
        this.g = MathHelper.clamp(g, 0, 255);
        this.b = MathHelper.clamp(b, 0, 255);
        this.a = MathHelper.clamp(a, 0, 255);

        this.intValue = (a << 24) | (r << 16) | (g << 8) | b;
    }

    public static Color4i fromColor(int color) {
        int alpha = (color & 0xFF000000) >>> 24;
        return fromColor(color, alpha);
    }

    public static Color4i fromColor(int color, int alpha) {
        int r = (color & 0x00FF0000) >>> 16;
        int g = (color & 0x0000FF00) >>> 8;
        int b = (color & 0x000000FF);
        return new Color4i(r, g, b, alpha);
    }

    public static Color4i fromColor(Color4i color, int alpha) {
        return new Color4i(color.r, color.g, color.b, alpha);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Color4i other = (Color4i) obj;
        return this.intValue == other.intValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.intValue);
    }

    public String toHexString() {
        return String.format("#%08X", this.intValue);
    }

    @Override
    public String toString() {
        return this.toHexString();
    }

    public float floatR() {
        return MathHelper.clamp(0, 1, this.r / 255.0F);
    }

    public float floatG() {
        return MathHelper.clamp(0, 1, this.g / 255.0F);
    }

    public float floatB() {
        return MathHelper.clamp(0, 1, this.b / 255.0F);
    }

    public float floatA() {
        return MathHelper.clamp(0, 1, this.a / 255.0F);
    }
}
