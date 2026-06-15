package com.dino13513.craftablemusic;

// Forge 1.20.1 Config Import
import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ERIKADISC;
    public static final ForgeConfigSpec.BooleanValue HITLER;
    public static final ForgeConfigSpec.BooleanValue EFNDISC;
    public static final ForgeConfigSpec.BooleanValue EPSTEIN;
    // Set to public so custom 1.20.1 recipe condition registration hooks can read state variables
    public static final ForgeConfigSpec.BooleanValue VANILLA_CRAFTINGS;

    static {
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

        VANILLA_CRAFTINGS = BUILDER
                .worldRestart()
                .comment("Whether to enable craftings for every vanilla music disc")
                .define("VANILLA_CRAFTINGS", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}