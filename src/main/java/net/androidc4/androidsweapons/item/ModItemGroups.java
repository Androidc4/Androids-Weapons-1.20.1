package net.androidc4.androidsweapons.item;

import net.androidc4.androidsweapons.Androidsweapons;
import net.androidc4.androidsweapons.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SHARD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Androidsweapons.MOD_ID,"androids_weapons"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.androids_weapons"))
                    .icon(() -> new ItemStack(ModItems.FROZENSHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FROZENSHARD);

                        entries.add(ModBlocks.FROZEN_BLOCK);

                        entries.add(ModItems.VOIDCRYSTAL);
                        entries.add(ModItems.VOIDINGOT);
                        entries.add(ModItems.VOIDREAPER);

                    } ).build());

    public static void registerItemGroups()
    {
        Androidsweapons.LOGGER.info("Registering Item Groups for " + Androidsweapons.MOD_ID );
    }
}
