package com.dino13513.craftablemusic.sound;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, CraftableMusic.MOD_ID);

    private static DeferredHolder<SoundEvent, SoundEvent> REGISTER(String name) {


        return SOUND_EVENTS.register(
                name,
                () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, name))
        );
    }

    public static final DeferredHolder<SoundEvent, SoundEvent> VRIGGER_EFN = SOUND_EVENTS.register(
            "vrigger_efn",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "vrigger_efn"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> JAZZ_FNAF = SOUND_EVENTS.register(
            "jazz_fnaf",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "jazz_fnaf"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AlanAztecPolska = SOUND_EVENTS.register(
            "alan_aztec_polska",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "alan_aztec_polska"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> VeegasPiwoPaliwo = SOUND_EVENTS.register(
            "veegas_piwo_paliwo",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "veegas_piwo_paliwo"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> KEEMSTAR3RD = SOUND_EVENTS.register(
            "keemstar_says_it_for_the_3rd_time",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "keemstar_says_it_for_the_3rd_time"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> FREDDYFAZBEARREMIX = REGISTER("freddyfazbear_remix");

    public static final DeferredHolder<SoundEvent, SoundEvent> FREDDYFAZBEAR = REGISTER("freddyfazbear");

    public static final DeferredHolder<SoundEvent, SoundEvent> ERIKA = REGISTER("erika");

    public static final DeferredHolder<SoundEvent, SoundEvent> SAXOPHONE = REGISTER("saxophone");

    public static final DeferredHolder<SoundEvent, SoundEvent> REDSUNCHINA = REGISTER("red_sun_china");

    public static final DeferredHolder<SoundEvent, SoundEvent> ZSRR = REGISTER("zsrr");





    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}