package com.dino13513.craftablemusic.item; // Make sure this matches your package structure

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

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
}