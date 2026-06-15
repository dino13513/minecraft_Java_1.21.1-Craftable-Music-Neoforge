package com.dino13513.craftablemusic.sound;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

// Forge 1.20.1 Imports
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CraftableMusic.MOD_ID);

    private static RegistryObject<SoundEvent> REGISTER(String name) {
        return SOUND_EVENTS.register(
                name,
                () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CraftableMusic.MOD_ID, name))
        );
    }

    public static final RegistryObject<SoundEvent> VRIGGER_EFN = SOUND_EVENTS.register(
            "vrigger_efn",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CraftableMusic.MOD_ID, "vrigger_efn"))
    );

    public static final RegistryObject<SoundEvent> JAZZ_FNAF = SOUND_EVENTS.register(
            "jazz_fnaf",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CraftableMusic.MOD_ID, "jazz_fnaf"))
    );

    public static final RegistryObject<SoundEvent> ALANAZTECPOLSKA = SOUND_EVENTS.register(
            "alan_aztec_polska",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CraftableMusic.MOD_ID, "alan_aztec_polska"))
    );

    public static final RegistryObject<SoundEvent> VEEGAS_PIWO_PALIWO = SOUND_EVENTS.register(
            "veegas_piwo_paliwo",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CraftableMusic.MOD_ID, "veegas_piwo_paliwo"))
    );

    public static final RegistryObject<SoundEvent> KEEMSTAR3RD = SOUND_EVENTS.register(
            "keemstar_says_it_for_the_3rd_time",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CraftableMusic.MOD_ID, "keemstar_says_it_for_the_3rd_time"))
    );

    public static final RegistryObject<SoundEvent> FREDDYFAZBEARREMIX = REGISTER("freddyfazbear_remix");
    public static final RegistryObject<SoundEvent> FREDDYFAZBEAR = REGISTER("freddyfazbear");
    public static final RegistryObject<SoundEvent> ERIKA = REGISTER("erika");
    public static final RegistryObject<SoundEvent> SAXOPHONE = REGISTER("saxophone");
    public static final RegistryObject<SoundEvent> REDSUNCHINA = REGISTER("red_sun_china");
    public static final RegistryObject<SoundEvent> ZSRR = REGISTER("zsrr");

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}