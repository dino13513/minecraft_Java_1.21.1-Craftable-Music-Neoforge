package com.dino13513.craftablemusic.block;

import com.dino13513.craftablemusic.CraftableMusic;
import com.dino13513.craftablemusic.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CraftableMusic.MOD_ID);

    public static <T extends  Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static final DeferredBlock<Block> DEEPSLATESTEELORE = registerBlock("deepslate_steel_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(10.0f)              // Hardness (Time it takes to mine). Obsidian is 50.0, Diamond Block is 5.0, Stone is 1.5.
                    .explosionResistance(12.0f)     // Blast resistance.
                    .sound(SoundType.METAL)          // Footsteps, placement, and breaking audio.
                    .requiresCorrectToolForDrops() // Requires a pickaxe (must be assigned in your item/block tags) to drop item

            )
    );
    public static final DeferredBlock<Block> STEELORE = registerBlock("steel_ore",
                () -> new Block(BlockBehaviour.Properties.of()
                        .destroyTime(10.0f)              // Hardness (Time it takes to mine). Obsidian is 50.0, Diamond Block is 5.0, Stone is 1.5.
                        .explosionResistance(12.0f)     // Blast resistance.
                        .sound(SoundType.METAL)          // Footsteps, placement, and breaking audio.
                        .requiresCorrectToolForDrops() // Requires a pickaxe (must be assigned in your item/block tags) to drop item

                )
        );

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
