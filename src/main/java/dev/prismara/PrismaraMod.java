package dev.prismara;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.prismara.registry.ModAttachments;
import dev.prismara.registry.ModBlocks;
import dev.prismara.registry.ModEntities;
import dev.prismara.registry.ModItems;
import dev.prismara.registry.ModTabs;

public class PrismaraMod implements ModInitializer {
	public static final String MOD_ID = "prismara";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		// El orden importa: bloques -> ítems (los BlockItem usan los bloques) -> resto.
		ModBlocks.init();
		ModItems.init();
		ModAttachments.init();
		ModEntities.init();
		ModTabs.init();

		registerWorldgen();
		registerFirstJoinCodex();

		LOGGER.info("Prismara cargado: la luz se parte en colores.");
	}

	/** La primera vez que entras a un mundo recibes el Códice; si mueres no se te regala otro (se craftea). */
	private static void registerFirstJoinCodex() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayer player = handler.getPlayer();
			if (!player.getAttachedOrCreate(ModAttachments.CODEX_GIVEN)) {
				player.setAttached(ModAttachments.CODEX_GIVEN, true);
				player.addItem(new ItemStack(ModItems.PRISMARA_CODEX));
			}
		});
	}

	private static void registerWorldgen() {
		// Mena de prismita en todo el Overworld (datos en data/prismara/worldgen/...)
		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ResourceKey.create(Registries.PLACED_FEATURE, id("prismite_ore")));

		// Glimmerling: prados y bosques floridos. Shardback: cualquier bioma del Overworld, poco frecuente.
		BiomeModifications.addSpawn(
				BiomeSelectors.includeByKey(Biomes.MEADOW, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE, Biomes.PLAINS),
				MobCategory.CREATURE, ModEntities.GLIMMERLING, 8, 2, 4);
		BiomeModifications.addSpawn(
				BiomeSelectors.foundInOverworld(),
				MobCategory.MONSTER, ModEntities.SHARDBACK, 6, 1, 2);
	}
}
