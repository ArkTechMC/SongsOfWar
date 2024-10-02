package com.iafenvoy.sow.screen;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.Static;
import com.iafenvoy.sow.data.BeaconData;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class BeaconTeleportScreen extends Screen {
    private static final Identifier ARROW = new Identifier("textures/gui/recipe_book.png");
    private static final int COUNT_PER_PAGE = 5;
    private final BeaconData beaconData;
    private final List<BeaconData.SingleBeaconData> data;
    private final BlockPos pos;
    private final int maxPage;
    private final int page;

    public BeaconTeleportScreen(BeaconData beaconData, BlockPos pos, int page) {
        super(beaconData.get(pos).map(BeaconData.SingleBeaconData::name).orElse(Text.literal("")));
        this.beaconData = beaconData;
        this.data = new ArrayList<>(beaconData.getBeaconPos());
        this.data.removeIf(x -> x.pos().equals(pos));
        this.pos = pos;
        this.maxPage = (int) Math.ceil(1.0 * this.data.size() / COUNT_PER_PAGE) - 1;
        this.page = page;
    }

    @Override
    protected void init() {
        super.init();
        int middleX = this.width / 2, middleY = this.height / 2;
        this.addDrawableChild(new TexturedButtonWidget(middleX - 44, middleY + 75, 14, 18, 13, 207, ARROW, button -> {
            assert this.client != null;
            this.client.setScreen(new BeaconTeleportScreen(this.beaconData, this.pos, this.page - 1));
        })).visible = this.page > 0;
        this.addDrawableChild(new TexturedButtonWidget(middleX + 30, middleY + 75, 14, 18, 0, 207, ARROW, button -> {
            assert this.client != null;
            this.client.setScreen(new BeaconTeleportScreen(this.beaconData, this.pos, this.page + 1));
        })).visible = this.page < this.maxPage;
        for (int i = 0; i < COUNT_PER_PAGE; i++) {
            int index = page * COUNT_PER_PAGE + i;
            if (this.data.size() <= index) break;
            BeaconData.SingleBeaconData d = this.data.get(index);
            this.addDrawableChild(ButtonWidget.builder(d.name(), button -> {
                PacketByteBuf buf = PacketBufferUtils.create();
                buf.writeBlockPos(this.pos);
                buf.writeBlockPos(d.pos());
                NetworkManager.sendToServer(Static.BEACON_TELEPORT, buf);
                this.close();
            }).dimensions(middleX - 50, middleY + (i - 2) * 25, 100, 20).build());
        }
    }

    @Override
    public void tick() {
        super.tick();
        assert this.client != null && this.client.player != null;
        if (this.client.player.getBlockPos().getSquaredDistance(this.pos) > 10 * 10)
            this.close();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, this.height / 2 - 85, -1);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal(String.format("x=%d y=%d z=%d", this.pos.getX(), this.pos.getY(), this.pos.getZ())), this.width / 2, this.height / 2 - 70, -1);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal(String.format("%d/%d", this.page + 1, this.maxPage + 1)), this.width / 2, this.height / 2 + 80, -1);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
