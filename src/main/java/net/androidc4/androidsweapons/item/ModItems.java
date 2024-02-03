package net.androidc4.androidsweapons.item;

import net.androidc4.androidsweapons.Androidsweapons;
import net.androidc4.androidsweapons.item.custom.VoidReaperItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FROZENSHARD = registerItem("frozen_shard", new Item(new FabricItemSettings()));
    public static final Item VOIDCRYSTAL = registerItem("void_crystal", new Item(new FabricItemSettings()));
    public static final Item VOIDINGOT = registerItem("void_ingot", new Item(new FabricItemSettings()));

    public static final Item VOIDREAPER = registerItem("void_reaper", new VoidReaperItem(ModToolMaterial.VOID, 10, 4f, new FabricItemSettings()));
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {

        entries.add(FROZENSHARD);
        entries.add(VOIDCRYSTAL);
        entries.add(VOIDINGOT);
        entries.add(VOIDREAPER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Androidsweapons.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Androidsweapons.LOGGER.info("Registering Mod Items for " + Androidsweapons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
