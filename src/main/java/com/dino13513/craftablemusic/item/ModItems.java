package com.dino13513.craftablemusic.item;

import com.dino13513.craftablemusic.CraftableMusic;
import com.dino13513.craftablemusic.sound.ModSounds;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.sounds.SoundEvent;
import java.util.function.Supplier;

// Forge 1.20.1 Imports
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.dino13513.craftablemusic.item.custom.MusicalItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftableMusic.MOD_ID);

    private static RegistryObject<Item> registerDisc(String name, Supplier<SoundEvent> sound) {
        return ITEMS.register(name + "_music_disc",
                () -> new RecordItem(1, sound, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2400)
        );
    }

    public static RegistryObject<Item> registerCraftingItem(String name) {
        return ITEMS.register(name,
                () -> new Item(new Item.Properties().stacksTo(64))
        );
    }

    public static final RegistryObject<Item> EFNDISC = ITEMS.register("efn_music_disc",
            () -> new RecordItem(1, ModSounds.VRIGGER_EFN, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2400)
    );

    public static final RegistryObject<Item> JAZZFNAFDISC = ITEMS.register("jazz_fnaf_music_disc",
            () -> new RecordItem(1, ModSounds.JAZZ_FNAF, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2400)
    );

    public static final RegistryObject<Item> POLISH1 = ITEMS.register("polish1_music_disc",
            () -> new RecordItem(1, ModSounds.ALANAZTECPOLSKA, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2400)
    );

    public static final RegistryObject<Item> POLISH2 = ITEMS.register("polish2_music_disc",
            () -> new RecordItem(1, ModSounds.VEEGAS_PIWO_PALIWO, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2400)
    );

    public static final RegistryObject<Item> KEEMSTARMUSICDISC = ITEMS.register("keemstar_says_it_for_the_3rd_time_music_disc",
            () -> new RecordItem(1, ModSounds.KEEMSTAR3RD, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2400)
    );

    public static final RegistryObject<Item> ERIKAMUSICDISC = registerDisc("erika", ModSounds.ERIKA);
    public static final RegistryObject<Item> REDSUNMUSICDISC = registerDisc("red_sun_china", ModSounds.REDSUNCHINA);
    public static final RegistryObject<Item> FREDDYFAZBEARREMIX = registerDisc("freddyfazbear_remix", ModSounds.FREDDYFAZBEARREMIX);
    public static final RegistryObject<Item> ZSRRMUSICDISC = registerDisc("zsrr", ModSounds.ZSRR);

    public static final RegistryObject<Item> EMPTYVINYL = ITEMS.register("empty_vinyl",
            () -> new Item(new Item.Properties().stacksTo(1))
    );

    public static final RegistryObject<Item> EPSTEIN = ITEMS.register("epstein",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> NWORD = ITEMS.register("nword",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> WHITEGUY = ITEMS.register("white_guy",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> POLISHFLAG = ITEMS.register("polish_flag",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> POLISHGUY = ITEMS.register("polish_guy",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> AUSTRALIANFLAG = ITEMS.register("australian_flag",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> GERMANFLAG = ITEMS.register("german_flag",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> AUSTRALIAGUY = ITEMS.register("australian_guy",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> AUSTRALIANPAINTER = ITEMS.register("australian_painter",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> HITLER = ITEMS.register("hitler",
            () -> new Item(new Item.Properties().stacksTo(64))
    );

    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            () -> new com.dino13513.craftablemusic.item.custom.BeerItem(new Item.Properties()
                    .stacksTo(8)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(1.0f)
                            .alwaysEat()
                            .build()
                    )
            )
    );

    public static final RegistryObject<Item> FREDDYFAZBEAR = ITEMS.register("freddyfazbear",
            () -> new MusicalItem(
                    new Item.Properties().stacksTo(1),
                    ModSounds.FREDDYFAZBEAR,
                    5.0f,
                    1.0f
            )
    );

    public static final RegistryObject<Item> SAXOPHONE = ITEMS.register("saxophone",
            () -> new MusicalItem(
                    new Item.Properties().stacksTo(1),
                    ModSounds.SAXOPHONE,
                    3.5f,
                    1.0f
            )
    );

    public static final RegistryObject<Item> TIKTOKBLUE = registerCraftingItem("tiktok_blue");
    public static final RegistryObject<Item> TIKTOKRED = registerCraftingItem("tiktok_red");
    public static final RegistryObject<Item> TIKTOKBLACK = registerCraftingItem("tiktok_black");
    public static final RegistryObject<Item> TIKTOK = registerCraftingItem("tiktok");
    public static final RegistryObject<Item> CHINAFLAG = registerCraftingItem("china_flag");
    public static final RegistryObject<Item> CHINAGUY = registerCraftingItem("china_guy");
    public static final RegistryObject<Item> SOCIALCREDIT = registerCraftingItem("social_credit");
    public static final RegistryObject<Item> STALIN = registerCraftingItem("stalin");
    public static final RegistryObject<Item> ZSRRFLAG = registerCraftingItem("zsrr_flag");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}