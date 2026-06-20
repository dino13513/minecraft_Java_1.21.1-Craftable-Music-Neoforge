package com.dino13513.craftablemusic.datagen;

import com.dino13513.craftablemusic.CraftableMusic;
import com.dino13513.craftablemusic.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;


public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CraftableMusic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.EFNDISC.get());
        basicItem(ModItems.JAZZFNAFDISC.get());
        basicItem(ModItems.FREDDYFAZBEARREMIX.get());
        basicItem(ModItems.POLISH1.get());
        basicItem(ModItems.POLISH2.get());
        basicItem(ModItems.KEEMSTARMUSICDISC.get());
        basicItem(ModItems.ERIKAMUSICDISC.get());
        basicItem(ModItems.ZSRRMUSICDISC.get());
        basicItem(ModItems.REDSUNMUSICDISC.get());
        basicItem(ModItems.EMPTYVINYL.get());
        basicItem(ModItems.EPSTEIN.get());
        basicItem(ModItems.NWORD.get());
        basicItem(ModItems.WHITEGUY.get());
        basicItem(ModItems.POLISHFLAG.get());
        basicItem(ModItems.POLISHGUY.get());
        basicItem(ModItems.AUSTRALIANFLAG.get());
        basicItem(ModItems.AUSTRALIANPAINTER.get());
        basicItem(ModItems.HITLER.get());
        basicItem(ModItems.GERMANFLAG.get());
        basicItem(ModItems.AUSTRALIAGUY.get());
        basicItem(ModItems.BEER.get());
        basicItem(ModItems.FREDDYFAZBEAR.get());
        basicItem(ModItems.SAXOPHONE.get());
        basicItem(ModItems.TIKTOK.get());
        basicItem(ModItems.TIKTOKRED.get());
        basicItem(ModItems.TIKTOKBLACK.get());
        basicItem(ModItems.TIKTOKBLUE.get());
        basicItem(ModItems.CHINAFLAG.get());
        basicItem(ModItems.CHINAGUY.get());
        basicItem(ModItems.SOCIALCREDIT.get());
        basicItem(ModItems.STALIN.get());
        basicItem(ModItems.ZSRRFLAG.get());
        basicItem(ModItems.RAWSTEEL.get());
        basicItem(ModItems.STEELINGOT.get());

        trimmedArmorItem(ModItems.STEELHELMET);
        trimmedArmorItem(ModItems.STEELCHESTPLATE);
        trimmedArmorItem(ModItems.STEELLEGGINS);
        trimmedArmorItem(ModItems.STEELBOOTS);

    }
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = CraftableMusic.MOD_ID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }


}
