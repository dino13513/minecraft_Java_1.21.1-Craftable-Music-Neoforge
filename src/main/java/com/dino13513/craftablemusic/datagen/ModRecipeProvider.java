package com.dino13513.craftablemusic.datagen;

import com.dino13513.craftablemusic.CraftableMusic;
import com.dino13513.craftablemusic.block.ModBlocks;
import com.dino13513.craftablemusic.item.ModItems;
import com.dino13513.craftablemusic.recipe.ConfigRecipeCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> STEEL_SMELTABLES = List.of(ModItems.RAWSTEEL, ModBlocks.DEEPSLATESTEELORE, ModBlocks.STEELORE);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STALIN.get())
                        .requires(ModItems.WHITEGUY)
                        .requires(ModItems.STEELINGOT)
                        .unlockedBy("has_steel", has(ModItems.STEELINGOT))
                        .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EFNDISC.get())
                                .requires(ModItems.EPSTEIN)
                                .requires(ModItems.NWORD)
                                .requires(ModItems.EMPTYVINYL)
                                .unlockedBy("has_emptyvinyl", has(ModItems.EMPTYVINYL))
                                .save(recipeOutput.withConditions(new ConfigRecipeCondition("EfnMusicDisc")));

         ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZSRRMUSICDISC.get())
                                .requires(ModItems.STALIN)
                                .requires(ModItems.EMPTYVINYL)
                                .unlockedBy("has_emptyvinyl", has(ModItems.EMPTYVINYL))
                                .save(recipeOutput.withConditions(new ConfigRecipeCondition("zsrrMusicDisc")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HITLER.get())
                                    .requires(ModItems.AUSTRALIANPAINTER)
                                    .requires(ModItems.GERMANFLAG)
                                    .unlockedBy("has_australianpainter", has(ModItems.AUSTRALIANPAINTER))
                                    .save(recipeOutput.withConditions(new ConfigRecipeCondition("HITLER")));


        oreBlasting(recipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEELINGOT, 1.0f, 400, "steel");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEELHELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.STEELINGOT.get())
                .unlockedBy("has_steel", has(ModItems.STEELINGOT))
                .save(recipeOutput.withConditions(new ConfigRecipeCondition("STEEL")));
        ;
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEELCHESTPLATE.get())
                        .pattern("S S")
                        .pattern("SSS")
                        .pattern("SSS")
                        .define('S', ModItems.STEELINGOT.get())
                        .unlockedBy("has_steel2", has(ModItems.STEELINGOT))
                        .save(recipeOutput.withConditions(new ConfigRecipeCondition("STEEL")));
                ;
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEELLEGGINS.get())
                        .pattern("SSS")
                        .pattern("S S")
                        .pattern("S S")
                        .define('S', ModItems.STEELINGOT.get())
                        .unlockedBy("has_steel3", has(ModItems.STEELINGOT))
                        .save(recipeOutput.withConditions(new ConfigRecipeCondition("STEEL")));
                ;
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEELBOOTS.get())
                        .pattern("   ")
                        .pattern("S S")
                        .pattern("S S")
                        .define('S', ModItems.STEELINGOT.get())
                        .unlockedBy("has_steel4", has(ModItems.STEELINGOT))
                        .save(recipeOutput.withConditions(new ConfigRecipeCondition("STEEL")));
                ;

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CraftableMusic.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
