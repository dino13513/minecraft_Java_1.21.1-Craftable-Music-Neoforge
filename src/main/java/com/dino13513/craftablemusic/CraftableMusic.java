package com.dino13513.craftablemusic;

import com.dino13513.craftablemusic.block.ModBlocks;
import com.dino13513.craftablemusic.item.ModCreativeModeTabs;
import com.dino13513.craftablemusic.item.ModItems;
import com.dino13513.craftablemusic.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.config.ModConfigs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CraftableMusic.MOD_ID)
public class CraftableMusic {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "craftablemusic";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CraftableMusic(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (CraftableMusic) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        NeoForge.EVENT_BUS.addListener(com.dino13513.craftablemusic.ModCommands::onRegisterCommands);
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.EFNDISC);
            event.accept(ModItems.JAZZFNAFDISC);
            event.accept(ModItems.FREDDYFAZBEARREMIX);
            event.accept(ModItems.POLISH1);
            event.accept(ModItems.POLISH2);
            event.accept(ModItems.KEEMSTARMUSICDISC);
            event.accept(ModItems.ERIKAMUSICDISC);
            event.accept(ModItems.ZSRRMUSICDISC);
            event.accept(ModItems.REDSUNMUSICDISC);
            event.accept(ModItems.EMPTYVINYL);
            event.accept(ModItems.EPSTEIN);
            event.accept(ModItems.NWORD);
            event.accept(ModItems.WHITEGUY);
            event.accept(ModItems.POLISHFLAG);
            event.accept(ModItems.POLISHGUY);
            event.accept(ModItems.AUSTRALIANFLAG);
            event.accept(ModItems.AUSTRALIANPAINTER);
            event.accept(ModItems.HITLER);
            event.accept(ModItems.GERMANFLAG);
            event.accept(ModItems.AUSTRALIAGUY);
            event.accept(ModItems.FREDDYFAZBEAR);
            event.accept(ModItems.SAXOPHONE);
            event.accept(ModItems.BEER);
            event.accept(ModItems.TIKTOK);
            event.accept(ModItems.TIKTOKRED);
            event.accept(ModItems.TIKTOKBLACK);
            event.accept(ModItems.TIKTOKBLUE);
            event.accept(ModItems.CHINAFLAG);
            event.accept(ModItems.CHINAGUY);
            event.accept(ModItems.SOCIALCREDIT);
            event.accept(ModItems.STALIN);
            event.accept(ModItems.ZSRRFLAG);

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
