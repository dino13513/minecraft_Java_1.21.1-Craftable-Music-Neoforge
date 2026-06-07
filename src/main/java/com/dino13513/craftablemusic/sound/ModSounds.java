package com.dino13513.craftablemusic.sound;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, CraftableMusic.MOD_ID);

    // This officially registers "craftablemusic:vrigger_efn" to stop the crash!
    public static final DeferredHolder<SoundEvent, SoundEvent> VRIGGER_EFN = SOUND_EVENTS.register(
            "vrigger_efn",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "vrigger_efn"))
    );

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}