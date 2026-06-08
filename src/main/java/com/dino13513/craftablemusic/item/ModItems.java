package com.dino13513.craftablemusic.item;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.registries.Registries; // Make sure this import is exactly like this
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
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
    public static final DeferredItem<Item> POLISH1 = ITEMS.register("polish1_music_disc",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .jukeboxPlayable(ResourceKey.create(
                            Registries.JUKEBOX_SONG,
                            ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "alan_aztec_polska")
                    ))
            )
    );
    public static final DeferredItem<Item> POLISH2 = ITEMS.register("polish2_music_disc",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .jukeboxPlayable(ResourceKey.create(
                            Registries.JUKEBOX_SONG,
                            ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "veegas_piwo_paliwo")
                    ))
            )
    );
    public static final DeferredItem<Item> KEEMSTARMUSICDISC = ITEMS.register("keemstar_says_it_for_the_3rd_time_music_disc",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .jukeboxPlayable(ResourceKey.create(
                            Registries.JUKEBOX_SONG,
                            ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, "keemstar_says_it_for_the_3rd_time")
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
    public static final DeferredItem<Item> WHITEGUY = ITEMS.register("white_guy",
                () -> new Item(new Item.Properties()
                        .stacksTo(64)
                )
        );
    public static final DeferredItem<Item> POLISHFLAG = ITEMS.register("polish_flag",
                () -> new Item(new Item.Properties()
                        .stacksTo(64)
                )
        );
    public static final DeferredItem<Item> POLISHGUY = ITEMS.register("polish_guy",
                () -> new Item(new Item.Properties()
                        .stacksTo(64)
                )
        );
    public static final DeferredItem<Item> AUSTRALIANFLAG = ITEMS.register("australian_flag",
                () -> new Item(new Item.Properties()
                        .stacksTo(64)
                )
        );
    public static final DeferredItem<Item> GERMANFLAG = ITEMS.register("german_flag",
                () -> new Item(new Item.Properties()
                        .stacksTo(64)
                )
        );
    public static final DeferredItem<Item> AUSTRALIAGUY = ITEMS.register("australian_guy",
                () -> new Item(new Item.Properties()
                        .stacksTo(64)
                )
        );
    public static final DeferredItem<Item> AUSTRALIANPAINTER = ITEMS.register("australian_painter",
                () -> new Item(new Item.Properties()
                        .stacksTo(64)
                )
        );
    public static final DeferredItem<Item> BEER = ITEMS.register("beer",
            () -> new com.dino13513.craftablemusic.item.BeerItem(new Item.Properties()
                    .stacksTo(8)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationModifier(1.0f)
                            .alwaysEdible()
                            .build() // Converts to nothing by default!
                    )
            )
    );
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}