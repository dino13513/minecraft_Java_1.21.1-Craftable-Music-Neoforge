package com.dino13513.craftablemusic.worldgen;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    // 1. Create your Registry Key
    public static final ResourceKey<BiomeModifier> ADD_STEEL_ORES = registerKey("add_steel_ores");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // 2. Target the Overworld
        var overworldBiomes = biomes.getOrThrow(BiomeTags.IS_OVERWORLD);

        // 3. Inject both of your placed features in one clean step
        context.register(ADD_STEEL_ORES, new BiomeModifiers.AddFeaturesBiomeModifier(
                overworldBiomes,
                HolderSet.direct(
                        placedFeatures.getOrThrow(ModPlacedFeatures.STEEL_ORE_PLACED_KEY),
                        placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_STEEL_ORE_PLACED_KEY)
                ),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, name));
    }
}