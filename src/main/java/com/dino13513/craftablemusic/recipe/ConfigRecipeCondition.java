package com.dino13513.craftablemusic.recipe;

import com.dino13513.craftablemusic.Config;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.neoforge.common.conditions.ICondition;

public record ConfigRecipeCondition(String configKey) implements ICondition {
    public static final MapCodec<ConfigRecipeCondition> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    Codec.STRING.fieldOf("config_key").forGetter(ConfigRecipeCondition::configKey)
            ).apply(builder, ConfigRecipeCondition::new)
    );

    @Override
    public boolean test(IContext context) {
        // This maps the string keys in your JSON files to your actual config fields at runtime
        return switch (configKey) {
            case "ErikaMusicDisc" -> Config.ERIKADISC.get();
            case "HITLER" -> Config.HITLER.get();
            case "EfnMusicDisc" -> Config.EFNDISC.get();
            case "epstein" -> Config.EPSTEIN.get();
            case "VANILLA_CRAFTINGS" -> Config.VANILLACRAFTINGS.get();
            case "zsrrMusicDisc" -> Config.ZSRRDISC.get();
            case "STEEL" -> Config.STEEL.get();
            default -> true;
        };
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return ModConditions.CONFIG_CONDITION.get();
    }
}