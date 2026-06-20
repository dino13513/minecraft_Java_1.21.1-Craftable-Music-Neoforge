package com.dino13513.craftablemusic.worldgen;

import com.dino13513.craftablemusic.CraftableMusic;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    // 1. Create your Registry Keys
    public static final ResourceKey<PlacedFeature> STEEL_ORE_PLACED_KEY = registerKey("steel_ore");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_STEEL_ORE_PLACED_KEY = registerKey("deepslate_steel_ore");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // 2. Fetch the "What" from the previous class
        var steelOreConfigured = configuredFeatures.getOrThrow(ModConfiguredFeatures.STEEL_ORE_KEY);
        var deepslateSteelOreConfigured = configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_STEEL_ORE_KEY);

        // 3. Register Regular Steel (Count: 1, Height: -24 to 56) -> 5% of Iron
        register(context, STEEL_ORE_PLACED_KEY, steelOreConfigured,
                commonOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));

        // 4. Register Deepslate Steel (Count: 2, Height: -64 to 16) -> 15% of Diamond
        register(context, DEEPSLATE_STEEL_ORE_PLACED_KEY, deepslateSteelOreConfigured,
                commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16))));
    }

    // Helper method to apply standard Ore Placement rules
    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightModifier) {
        return List.of(
                CountPlacement.of(count),
                InSquarePlacement.spread(),
                heightModifier,
                BiomeFilter.biome()
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}