package com.iafenvoy.sow.item.block;

import net.minecraft.block.AbstractGlassBlock;

public class PrimeSongBlock extends AbstractGlassBlock {
    private final SongType type;

    public PrimeSongBlock(SongType type) {
        super(Settings.create().emissiveLighting((state, world, pos) -> true).luminance(state -> 15).breakInstantly().nonOpaque());
        this.type = type;
    }

    public SongType getType() {
        return this.type;
    }

    public enum SongType {
        AGGRESSIUM, MOBILIUM, PROTISIUM, SUPPORIUM
    }
}
