package com.dino13513.craftablemusic.datagen;

import com.dino13513.craftablemusic.CraftableMusic;
import com.dino13513.craftablemusic.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CraftableMusic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Tells the game these blocks need a pickaxe
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STEELORE.get(), ModBlocks.DEEPSLATESTEELORE.get());

        // Tells the game these blocks specifically need Diamond tier or higher
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.STEELORE.get(), ModBlocks.DEEPSLATESTEELORE.get());
    }
}