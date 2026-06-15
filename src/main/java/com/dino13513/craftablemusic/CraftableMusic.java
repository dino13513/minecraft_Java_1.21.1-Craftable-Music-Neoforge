package com.dino13513.craftablemusic;

import com.dino13513.craftablemusic.block.ModBlocks;
import com.dino13513.craftablemusic.item.ModCreativeModeTabs;
import com.dino13513.craftablemusic.item.ModItems;
import com.dino13513.craftablemusic.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;

// Forge 1.20.1 Imports
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;

@Mod(CraftableMusic.MOD_ID)
public class CraftableMusic {
    public static final String MOD_ID = "craftablemusic";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    // 1. Add FMLJavaModLoadingContext as a parameter here
    public CraftableMusic(FMLJavaModLoadingContext context) {

        // 2. Use the parameter instead of FMLJavaModLoadingContext.get()
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register on the standard global Forge Event Bus
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        // 3. Use the parameter directly instead of ModLoadingContext.get()
        context.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.EFNDISC.get());
            event.accept(ModItems.JAZZFNAFDISC.get());
            event.accept(ModItems.FREDDYFAZBEARREMIX.get());
            event.accept(ModItems.POLISH1.get());
            event.accept(ModItems.POLISH2.get());
            event.accept(ModItems.KEEMSTARMUSICDISC.get());
            event.accept(ModItems.ERIKAMUSICDISC.get());
            event.accept(ModItems.ZSRRMUSICDISC.get());
            event.accept(ModItems.REDSUNMUSICDISC.get());
            event.accept(ModItems.EMPTYVINYL.get());
            event.accept(ModItems.EPSTEIN.get());
            event.accept(ModItems.NWORD.get());
            event.accept(ModItems.WHITEGUY.get());
            event.accept(ModItems.POLISHFLAG.get());
            event.accept(ModItems.POLISHGUY.get());
            event.accept(ModItems.AUSTRALIANFLAG.get());
            event.accept(ModItems.AUSTRALIANPAINTER.get());
            event.accept(ModItems.HITLER.get());
            event.accept(ModItems.GERMANFLAG.get());
            event.accept(ModItems.AUSTRALIAGUY.get());
            event.accept(ModItems.FREDDYFAZBEAR.get());
            event.accept(ModItems.SAXOPHONE.get());
            event.accept(ModItems.BEER.get());
            event.accept(ModItems.TIKTOK.get());
            event.accept(ModItems.TIKTOKRED.get());
            event.accept(ModItems.TIKTOKBLACK.get());
            event.accept(ModItems.TIKTOKBLUE.get());
            event.accept(ModItems.CHINAFLAG.get());
            event.accept(ModItems.CHINAGUY.get());
            event.accept(ModItems.SOCIALCREDIT.get());
            event.accept(ModItems.STALIN.get());
            event.accept(ModItems.ZSRRFLAG.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}