package net.androidc4.androidsweapons;

import net.androidc4.androidsweapons.block.ModBlocks;
import net.androidc4.androidsweapons.entity.custom.VoidReaperProjectileEntity;
import net.androidc4.androidsweapons.item.ModItemGroups;
import net.androidc4.androidsweapons.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Androidsweapons implements ModInitializer {
	public static final String MOD_ID = "androidsweapons";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<VoidReaperProjectileEntity> VOIDREAPERPROJECTILE = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "void_reaper_projectile"),
			FabricEntityTypeBuilder.<VoidReaperProjectileEntity>create(SpawnGroup.MISC, VoidReaperProjectileEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build()
	);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}