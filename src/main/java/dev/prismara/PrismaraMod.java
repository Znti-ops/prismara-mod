package dev.prismara;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.prismara.registry.ModBlocks;
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
		// El orden importa: bloques -> ítems (los BlockItem usan los bloques) -> pestaña creativa.
		ModBlocks.init();
		ModItems.init();
		ModTabs.init();
		LOGGER.info("Prismara cargado: la luz se parte en colores.");
	}
}
