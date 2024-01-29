package net.androidc4.androidsweapons;

import net.androidc4.androidsweapons.block.ModBlocks;
import net.androidc4.androidsweapons.item.ModItemGroups;
import net.androidc4.androidsweapons.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Androidsweapons implements ModInitializer {
	public static final String MOD_ID = "androidsweapons";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}