package com.iafenvoy.sow.item.block;

import net.minecraft.block.AbstractGlassBlock;

public class SongCubeBlock extends AbstractGlassBlock {
    private final CubeType type;

    public SongCubeBlock(CubeType type) {
        super(Settings.create().emissiveLighting((state, world, pos) -> true).luminance(state -> 15).breakInstantly().nonOpaque());
        this.type = type;
    }

    public CubeType getType() {
        return this.type;
    }

    public enum CubeType {
        AGGRESSIUM, MOBILIUM, PROTISIUM, SUPPORIUM
    }
}
