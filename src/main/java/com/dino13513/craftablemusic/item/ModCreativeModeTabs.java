package com.dino13513.craftablemusic.item;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

// Forge 1.20.1 Imports
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CraftableMusic.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CUSTOM_MUSIC_DISCS_TAB = CREATIVE_MODE_TAB.register("custom_music_discs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EFNDISC.get()))
                    .title(Component.translatable("creativetab.craftablemusic.custom_music_discs"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Appended .get() to extract item wrappers cleanly for Forge's handler mappings
                        output.accept(ModItems.EFNDISC.get());
                        output.accept(ModItems.JAZZFNAFDISC.get());
                        output.accept(ModItems.FREDDYFAZBEARREMIX.get());
                        output.accept(ModItems.POLISH1.get());
                        output.accept(ModItems.POLISH2.get());
                        output.accept(ModItems.KEEMSTARMUSICDISC.get());
                        output.accept(ModItems.ERIKAMUSICDISC.get());
                        output.accept(ModItems.ZSRRMUSICDISC.get());
                        output.accept(ModItems.REDSUNMUSICDISC.get());
                        output.accept(ModItems.EMPTYVINYL.get());
                        output.accept(ModItems.EPSTEIN.get());
                        output.accept(ModItems.NWORD.get());
                        output.accept(ModItems.WHITEGUY.get());
                        output.accept(ModItems.POLISHFLAG.get());
                        output.accept(ModItems.POLISHGUY.get());
                        output.accept(ModItems.AUSTRALIANFLAG.get());
                        output.accept(ModItems.AUSTRALIANPAINTER.get());
                        output.accept(ModItems.HITLER.get());
                        output.accept(ModItems.GERMANFLAG.get());
                        output.accept(ModItems.AUSTRALIAGUY.get());
                        output.accept(ModItems.BEER.get());
                        output.accept(ModItems.FREDDYFAZBEAR.get());
                        output.accept(ModItems.SAXOPHONE.get());
                        output.accept(ModItems.TIKTOK.get());
                        output.accept(ModItems.TIKTOKRED.get());
                        output.accept(ModItems.TIKTOKBLACK.get());
                        output.accept(ModItems.TIKTOKBLUE.get());
                        output.accept(ModItems.CHINAFLAG.get());
                        output.accept(ModItems.CHINAGUY.get());
                        output.accept(ModItems.SOCIALCREDIT.get());
                        output.accept(ModItems.STALIN.get());
                        output.accept(ModItems.ZSRRFLAG.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}