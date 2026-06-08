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

    public static final DeferredItem<Item> EFNDISC = ITEMS.register("efn_music_disc",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .jukeboxPlayable(ResourceKey.create(
                            Registries.JUKEBOX_SONG,
                            ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "vrigger_efn")
                    ))
            )
    );

    public static final DeferredItem<Item> JAZZFNAFDISC = ITEMS.register("jazz_fnaf_music_disc",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .jukeboxPlayable(ResourceKey.create(
                            Registries.JUKEBOX_SONG,
                            ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "jazz_fnaf")
                    ))
            )
    );

    public static final DeferredItem<Item> EMPTYVINYL = ITEMS.register("empty_vinyl",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)

            )
    );

    public static final DeferredItem<Item> EPSTEIN = ITEMS.register("epstein",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            )
    );

    public static final DeferredItem<Item> NWORD = ITEMS.register("nword",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}