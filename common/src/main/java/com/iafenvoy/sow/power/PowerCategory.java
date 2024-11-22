package com.iafenvoy.sow.power;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.power.type.AbstractSongPower;
import com.iafenvoy.sow.power.type.DummySongPower;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;

import java.util.*;

public enum PowerCategory {
    AGGRESSIUM("aggressium", new Color4i(237, 28, 36, 255), 231),
    MOBILIUM("mobilium", new Color4i(255, 242, 0, 255), 9035),
    PROTISIUM("protisium", new Color4i(115, 251, 253, 255), 4290),
    SUPPORTIUM("supportium", new Color4i(117, 249, 77, 255), 10);
    private final String id;
    private final Color4i color;
    private final long randomOffset;
    private final List<AbstractSongPower<?>> powers = new ArrayList<>();
    private final Map<String, AbstractSongPower<?>> byId = new HashMap<>();

    PowerCategory(String id, Color4i color, long randomOffset) {
        this.id = id;
        this.color = color;
        this.randomOffset = randomOffset;
    }

    public String getId() {
        return this.id;
    }

    public Color4i getColor() {
        return this.color;
    }

    public long getRandomOffset() {
        return this.randomOffset;
    }

    public MutableText appendColor(MutableText text) {
        return text.fillStyle(Style.EMPTY.withColor(this.getColor().getIntValue()));
    }

    public void registerPower(AbstractSongPower<?> power) {
        this.powers.add(power);
        AbstractSongPower<?> p = this.byId.put(power.getId(), power);
        if (p != null)
            throw new IllegalArgumentException("Duplicated id " + p.getId() + " for song power type " + this.id + "!");
    }

    public AbstractSongPower<?> getPowerById(String id) {
        return this.powers.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(DummySongPower.EMPTY);
    }

    public static Optional<PowerCategory> byId(String id) {
        return Arrays.stream(values()).filter(x -> x.getId().equals(id)).findFirst();
    }
}
