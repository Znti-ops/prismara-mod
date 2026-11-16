package dev.prismara.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

import dev.prismara.PrismaraMod;

public final class ModTabs {
	public static final ResourceKey<CreativeModeTab> MAIN = ResourceKey.create(Registries.CREATIVE_MODE_TAB, PrismaraMod.id("main"));

	public static void init() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MAIN, FabricCreativeModeTab.builder()
				.title(Component.translatable("itemGroup.prismara.main"))
				.icon(() -> new ItemStack(ModItems.PRISMITE_SHARD))
				.displayItems((context, entries) -> {
					entries.accept(ModItems.PRISMARA_CODEX);
					entries.accept(ModItems.PRISMITE_SHARD);
					entries.accept(ModBlocks.PRISMITE_ORE);
					entries.accept(ModBlocks.PRISMITE_BLOCK);
				})
				.build());
	}

	private ModTabs() {
	}
}
