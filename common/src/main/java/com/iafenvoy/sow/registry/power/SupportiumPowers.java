package com.iafenvoy.sow.registry.power;

import com.iafenvoy.sow.config.SowConfig;
import com.iafenvoy.sow.entity.power.SupporekesisControllable;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.type.InstantSongPower;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.util.RecipeUtils;
import com.iafenvoy.sow.world.WorldUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Ownable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class SupportiumPowers {
    public static final InstantSongPower SUPPOREKESIS = new InstantSongPower("supporekesis", PowerCategory.SUPPORTIUM)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporekesisPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporekesisSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.supportium.supporekesisExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                double r = SowConfig.INSTANCE.supportium.supporekesisRange.getValue();
                List<Entity> controllables = world.getEntitiesByClass(Entity.class, new Box(player.getX() - r, player.getY() - r, player.getZ() - r, player.getX() + r, player.getY() + r, player.getZ() + r), c -> c instanceof SupporekesisControllable);
                for (Entity c : controllables) {
                    if (c instanceof Ownable ownable && ownable.getOwner() != null && Objects.equals(ownable.getOwner().getUuid(), player.getUuid()) && !SowConfig.INSTANCE.supportium.supporekesisControlSelf.getValue())
                        continue;
                    if (c instanceof SupporekesisControllable controllable)
                        controllable.setDisappearCd(10, true);
                }
            });
    public static final InstantSongPower SUPPOROFORM = new InstantSongPower("supporoform", PowerCategory.SUPPORTIUM)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoformPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoformSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.supportium.supporoformExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                if (!(world instanceof ServerWorld serverWorld)) return;
                final int MAX_CNT = 41;
                for (int i = 0; i < MAX_CNT; i++) {
                    ItemStack stack = player.getInventory().getStack(i);
                    if (stack.isEmpty()) continue;
                    ItemStack stack1 = ItemStack.EMPTY;
                    if (stack.isOf(Items.OBSIDIAN))
                        stack1 = switch (stack.getCount()) {
                            case 5 -> new ItemStack(SowItems.ENDER_KNIGHT_HELMET.get());
                            case 8 -> new ItemStack(SowItems.ENDER_KNIGHT_CHESTPLATE.get());
                            case 7 -> new ItemStack(SowItems.ENDER_KNIGHT_LEGGINGS.get());
                            case 4 -> new ItemStack(SowItems.ENDER_KNIGHT_BOOTS.get());
                            default -> ItemStack.EMPTY;
                        };
                    if (stack1.isEmpty()) stack1 = RecipeUtils.findSmeltResult(serverWorld, stack, player).copy();
                    if (!stack1.isEmpty()) player.getInventory().setStack(i, stack1);
                }
            });
    public static final InstantSongPower SUPPOROLIFT = new InstantSongPower("supporolift", PowerCategory.SUPPORTIUM)
            .setPrimaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoliftPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowConfig.INSTANCE.supportium.supporoliftSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowConfig.INSTANCE.supportium.supporoliftExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                EntityHitResult result = WorldUtil.raycastNearest(player, SowConfig.INSTANCE.supportium.supporoliftRange.getValue());
                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    Vec3d dir = player.getPos().subtract(living.getPos()).multiply(0.2);
                    living.setVelocity(dir.add(0, 0.3, 0));
                    living.velocityModified = true;
                } else holder.cancel();
            });

    public static void init() {
    }
}
