package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.AbstractSongCubeBlock;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.world.song.SongChunkData;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Collection;

public final class SowCommands {
    public static void init() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> dispatcher
                .register(CommandManager.literal("sow")
                        .then(CommandManager.literal("power")
                                .requires(ServerCommandSource::isExecutedByPlayer)
                                .requires(source -> source.hasPermissionLevel(source.getServer().isDedicated() ? 4 : 0))
                                .then(CommandManager.argument("players", EntityArgumentType.players())
                                        .then(CommandManager.literal("use").executes(SowCommands::useSong))
                                        .then(CommandManager.literal("enable").executes(SowCommands::enableSong))
                                        .then(CommandManager.literal("disable").executes(SowCommands::disableSong))
                                ))
                        .then(CommandManager.literal("chunk")
                                .requires(ServerCommandSource::isExecutedByPlayer)
                                .requires(source -> source.hasPermissionLevel(source.getServer().isDedicated() ? 4 : 0))
                                .executes(ctx -> {
                                    ServerCommandSource source = ctx.getSource();
                                    PlayerEntity player = source.getPlayerOrThrow();
                                    source.sendFeedback(() -> Text.of("Remain notes: " + SongChunkData.byChunk(player.getWorld().getWorldChunk(player.getBlockPos())).getRemainNotes()), false);
                                    return 1;
                                })
                        )));
    }

    public static int useSong(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource source = context.getSource();
        Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
        ItemStack stack = source.getPlayerOrThrow().getMainHandStack();
        if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof AbstractSongCubeBlock songCube) {
            for (ServerPlayerEntity player : players)
                SongPowerData.byPlayer(player).get(songCube.getCategory()).setHoldItem(stack);
            source.sendFeedback(() -> Text.translatable("command." + SongsOfWar.MOD_ID + ".use_song.success"), false);
            return 1;
        }
        source.sendFeedback(() -> Text.translatable("command." + SongsOfWar.MOD_ID + ".use_song.invalid"), false);
        return 0;
    }

    public static int enableSong(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
        for (ServerPlayerEntity player : players) SongPowerData.byPlayer(player).enable();
        context.getSource().sendFeedback(() -> Text.literal("Success!"), true);
        return 1;
    }

    public static int disableSong(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
        for (ServerPlayerEntity player : players) SongPowerData.byPlayer(player).disable();
        context.getSource().sendFeedback(() -> Text.literal("Success!"), true);
        return 1;
    }
}
