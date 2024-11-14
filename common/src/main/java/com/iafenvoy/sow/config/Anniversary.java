package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.interfaces.IConfigEnumEntry;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Anniversary {
    public static boolean shouldInvoke() {
        if (SowConfig.INSTANCE.common.anniversary.getValue() instanceof InvokeType type) {
            if (type == InvokeType.TRUE) return true;
            if (type == InvokeType.FALSE) return false;
            return isDateInRange(LocalDate.now());
        }
        return false;
    }

    public static boolean isDateInRange(LocalDate currentDate) {
        LocalDate startDate = LocalDate.of(currentDate.getYear(), 11, 23);
        LocalDate endDate = LocalDate.of(currentDate.getYear(), 11, 29);
        return !currentDate.isBefore(startDate) && !currentDate.isAfter(endDate);
    }

    public enum InvokeType implements IConfigEnumEntry {
        TRUE, NORMAL, FALSE;

        @Override
        public String getName() {
            return this.name();
        }

        @Override
        public @NotNull IConfigEnumEntry getByName(String s) {
            return valueOf(s);
        }

        @Override
        public IConfigEnumEntry cycle(boolean b) {
            InvokeType[] types = values();
            return types[(this.ordinal() + (b ? 1 : -1)) % types.length];
        }
    }
}
