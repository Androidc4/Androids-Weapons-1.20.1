package net.androidc4.androidsweapons.datagen;

import net.androidc4.androidsweapons.block.ModBlocks;
import net.androidc4.androidsweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROZEN_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FROZENSHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOIDCRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOIDINGOT, Models.GENERATED);
    }
}
