package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.power.PowerCategory;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.networking.NetworkManager;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public final class SowKeybindings {
    public static final String CATEGORY = "key.category." + SongsOfWar.MOD_ID;
    public static final KeyBinding AGGRESSIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".aggressium_power", GLFW.GLFW_KEY_C, CATEGORY);
    public static final KeyBinding MOBILIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".mobilium_power", GLFW.GLFW_KEY_V, CATEGORY);
    public static final KeyBinding PROTISIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".protisium_power", GLFW.GLFW_KEY_B, CATEGORY);
    public static final KeyBinding SUPPORTIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".supportium_power", GLFW.GLFW_KEY_N, CATEGORY);
    public static final List<KeyBindingHolder> KEY_BINDINGS;
    public static final KeyBindingHolder JUMP = new KeyBindingHolder(() -> MinecraftClient.getInstance().options.jumpKey);

    public static void init() {
        KeyMappingRegistry.register(AGGRESSIUM_POWER);
        KeyMappingRegistry.register(MOBILIUM_POWER);
        KeyMappingRegistry.register(PROTISIUM_POWER);
        KeyMappingRegistry.register(SUPPORTIUM_POWER);
        ClientTickEvent.CLIENT_POST.register(client -> KEY_BINDINGS.forEach(KeyBindingHolder::tick));
        ClientTickEvent.CLIENT_POST.register(client -> JUMP.tick());
        JUMP.registerPressCallback(x -> {
            if (x) NetworkManager.sendToServer(Static.JUMP_PRESS, PacketBufferUtils.create());
        });
        for (PowerCategory type : PowerCategory.values())
            KEY_BINDINGS.get(type.ordinal()).registerPressCallback(press -> {
                if (press) {
                    PacketByteBuf buf = PacketBufferUtils.create();
                    buf.writeEnumConstant(type);
                    NetworkManager.sendToServer(Static.POWER_KEYBINDING_SYNC, buf);
                }
            });
    }

    static {
        KEY_BINDINGS = Stream.of(AGGRESSIUM_POWER, MOBILIUM_POWER, PROTISIUM_POWER, SUPPORTIUM_POWER).map(KeyBindingHolder::new).toList();
    }

    public static class KeyBindingHolder {
        public final Supplier<KeyBinding> keyBinding;
        private final List<BooleanConsumer> callback = new ArrayList<>();
        private boolean pressed;

        public KeyBindingHolder(KeyBinding keyBinding) {
            this.keyBinding = () -> keyBinding;
        }

        public KeyBindingHolder(Supplier<KeyBinding> keyBinding) {
            this.keyBinding = keyBinding;
        }

        public void registerPressCallback(BooleanConsumer consumer) {
            this.callback.add(consumer);
        }

        public void tick() {
            KeyBinding k = this.keyBinding.get();
            if (k == null) return;
            boolean curr = k.isPressed();
            if (!this.pressed && curr) this.callback.forEach(x -> x.accept(true));
            if (this.pressed && !curr) this.callback.forEach(x -> x.accept(false));
            this.pressed = curr;
        }

        public boolean isPressed() {
            return this.pressed;
        }
    }
}
