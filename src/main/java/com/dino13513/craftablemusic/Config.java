package com.dino13513.craftablemusic;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue ERIKADISC;
    public static final ModConfigSpec.BooleanValue HITLER;
    public static final ModConfigSpec.BooleanValue EFNDISC;
    public static final ModConfigSpec.BooleanValue EPSTEIN;

    static {
        // Creates the "items" category group
        BUILDER.comment("Craftable Music Item Toggles").push("items");

        ERIKADISC = BUILDER
                .worldRestart()
                .comment("Whether to enable the erika disc crafting recipe")
                .define("ErikaMusicDisc", true);

        HITLER = BUILDER
                .worldRestart()
                .comment("Whether to enable hitler item crafting recipe")
                .define("HITLER", true);

        EFNDISC = BUILDER
                .worldRestart()
                .comment("Whether to enable EFN Music Disc")
                .define("EfnMusicDisc", true);

        EPSTEIN = BUILDER
                .worldRestart()
                .comment("Whether to enable epstein crafting recipe")
                .define("epstein", true);

        BUILDER.pop(); // Closes the "items" category group
        SPEC = BUILDER.build();
    }
}