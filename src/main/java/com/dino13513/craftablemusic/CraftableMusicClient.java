package com.dino13513.craftablemusic;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

// Forge 1.20.1 routes client setups through dedicated mod event bus subscriber annotations
@Mod.EventBusSubscriber(modid = CraftableMusic.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CraftableMusicClient {

    // Note: Automated on-the-fly config UI generations are features unique to NeoForge.
    // In Forge 1.20.1, to achieve config menus in the mod list, developers use third-party
    // visual rendering setups such as Cloth Config alongside standard ConfigScreenHandler hooks.

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        CraftableMusic.LOGGER.info("HELLO FROM CLIENT SETUP");
        CraftableMusic.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}