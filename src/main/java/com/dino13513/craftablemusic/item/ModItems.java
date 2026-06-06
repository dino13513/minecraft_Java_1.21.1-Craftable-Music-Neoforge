package com.dino13513.craftablemusic.item;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.registries.Registries; // Make sure this import is exactly like this
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CraftableMusic.MOD_ID);

    public static final DeferredItem<Item> EFNDISK = ITEMS.register("efn_music_disc",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .jukeboxPlayable(ResourceKey.create(
                            Registries.JUKEBOX_SONG,
                            ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "vrigger_efn")
                    ))
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}