package com.dino13513.craftablemusic.worldgen;

import com.dino13513.craftablemusic.CraftableMusic;
import com.dino13513.craftablemusic.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    // 1. Create your Registry Keys
    public static final ResourceKey<ConfiguredFeature<?, ?>> STEEL_ORE_KEY = registerKey("steel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_STEEL_ORE_KEY = registerKey("deepslate_steel_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // Define what blocks are allowed to be replaced
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // 2. Register Regular Steel Ore (Replaces Stone, Vein Size 9)
        List<OreConfiguration.TargetBlockState> steelOreTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.STEELORE.get().defaultBlockState())
        );
        register(context, STEEL_ORE_KEY, Feature.ORE, new OreConfiguration(steelOreTargets, 9));

        // 3. Register Deepslate Steel Ore (Replaces Deepslate, Vein Size 8)
        List<OreConfiguration.TargetBlockState> deepslateSteelOreTargets = List.of(
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATESTEELORE.get().defaultBlockState())
        );
        register(context, DEEPSLATE_STEEL_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateSteelOreTargets, 8));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(CraftableMusic.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}