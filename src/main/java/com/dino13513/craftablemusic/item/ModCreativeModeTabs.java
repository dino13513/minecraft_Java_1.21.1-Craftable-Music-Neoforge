package com.dino13513.craftablemusic.item;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CraftableMusic.MOD_ID);

    public static final Supplier<CreativeModeTab> CUSTOM_MUSIC_DISCS_TAB = CREATIVE_MODE_TAB.register("custom_music_discs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EFNDISC.get()))
                    .title(Component.translatable("creativetab.craftablemusic.custom_music_discs"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.EFNDISC);
                        output.accept(ModItems.JAZZFNAFDISC);
                        output.accept(ModItems.POLISH1);
                        output.accept(ModItems.POLISH2);
                        output.accept(ModItems.KEEMSTARMUSICDISC);
                        output.accept(ModItems.EMPTYVINYL);
                        output.accept(ModItems.EPSTEIN);
                        output.accept(ModItems.NWORD);
                        output.accept(ModItems.WHITEGUY);
                        output.accept(ModItems.POLISHFLAG);
                        output.accept(ModItems.POLISHGUY);
                        output.accept(ModItems.AUSTRALIANFLAG);
                        output.accept(ModItems.AUSTRALIANPAINTER);
                        output.accept(ModItems.GERMANFLAG);
                        output.accept(ModItems.AUSTRALIAGUY);
                        output.accept(ModItems.BEER);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
