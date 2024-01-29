package net.androidc4.androidsweapons.datagen;

import net.androidc4.androidsweapons.block.ModBlocks;
import net.androidc4.androidsweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FROZEN_BLOCK, 1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', ModItems.FROZENSHARD)
                .input('C', Items.STONE)
                .criterion(hasItem(ModItems.FROZENSHARD), conditionsFromItem(ModItems.FROZENSHARD))
                .offerTo(exporter);
        
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FROZENSHARD, 8)
                .input(ModBlocks.FROZEN_BLOCK)
                .criterion(hasItem(ModBlocks.FROZEN_BLOCK), conditionsFromItem(ModBlocks.FROZEN_BLOCK))
                .offerTo(exporter);
    }
}
