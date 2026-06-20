package com.dino13513.craftablemusic.recipe;

import com.dino13513.craftablemusic.CraftableMusic;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import java.util.function.Supplier;

public class ModConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, CraftableMusic.MOD_ID);

    public static final Supplier<MapCodec<ConfigRecipeCondition>> CONFIG_CONDITION =
            CONDITION_CODECS.register("config_condition", () -> ConfigRecipeCondition.CODEC);

    // 🌟 ADD THIS HELPER METHOD HERE:
    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        CONDITION_CODECS.register(eventBus);
    }
}