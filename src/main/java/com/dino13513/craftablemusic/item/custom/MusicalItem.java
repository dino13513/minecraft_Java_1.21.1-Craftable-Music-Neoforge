package com.dino13513.craftablemusic.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
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

    // The constructor now accepts custom volume and pitch parameters
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

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            // Correct overload matching your IDE candidates:
            // 1st arg: player (excludes them from global packet to prevent double-audio)
            // 2nd arg: player (tells the engine WHICH entity the sound physically follows)
            level.playSound(
                    null,
                    player,
                    this.soundEventSupplier.get(), // Pass the raw SoundEvent directly, no Holder needed!
                    SoundSource.PLAYERS,
                    this.volume,
                    this.pitch
            );

            // 7 seconds cooldown
            player.getCooldowns().addCooldown(this, 140);
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }
}