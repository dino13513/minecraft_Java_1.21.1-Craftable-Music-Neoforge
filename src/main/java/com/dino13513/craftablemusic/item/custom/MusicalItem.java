package com.dino13513.craftablemusic.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class MusicalItem extends Item {
    private final Supplier<SoundEvent> soundEventSupplier;
    private final float volume;
    private final float pitch;

    public MusicalItem(Properties properties, Supplier<SoundEvent> soundEventSupplier, float volume, float pitch) {
        super(properties);
        this.soundEventSupplier = soundEventSupplier;
        this.volume = volume;
        this.pitch = pitch;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }

    // FIXED: Removed the 1.21 LivingEntity parameter
    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            // FIXED: Swapped to 1.20.1 coordinate-based player playback
            // Setting the first argument to null ensures the player using the item also hears it from the server!
            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    this.soundEventSupplier.get(),
                    SoundSource.PLAYERS,
                    this.volume,
                    this.pitch
            );

            // 7 seconds cooldown (140 ticks)
            player.getCooldowns().addCooldown(this, 140);
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }
}