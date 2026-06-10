package com.dino13513.craftablemusic.item.custom; // Make sure this matches your package structure

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BeerItem extends Item {
    public BeerItem(Properties properties) {
        super(properties);
    }

    // This switches the animation from "chewing" to "drinking" (tilting back)
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }



    // This overrides the crunchy eating sound and makes it play the fluid drinking sound
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // Let vanilla handle food/hunger/saturation first
        ItemStack result = super.finishUsingItem(stack, level, entity);

        // Server-side effects
        if (!level.isClientSide) {
            entity.addEffect(new MobEffectInstance(
                    MobEffects.CONFUSION,
                    350,
                    5
            ));

            entity.addEffect(new MobEffectInstance(
                    MobEffects.DAMAGE_BOOST,
                    450,
                    0
            ));
        }

        // Stats/advancements
        if (entity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        return result;
    }

}
