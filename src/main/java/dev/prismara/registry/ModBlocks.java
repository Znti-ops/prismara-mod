package dev.prismara.registry;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import dev.prismara.PrismaraMod;

public final class ModBlocks {
	public static final Block PRISMITE_ORE = register("prismite_ore",
			props -> new Block(props),
			BlockBehaviour.Properties.of()
					.strength(3.0F, 3.0F)
					.requiresCorrectToolForDrops()
					.lightLevel(state -> 6)
					.sound(SoundType.AMETHYST));

	public static final Block PRISMITE_BLOCK = register("prismite_block",
			props -> new Block(props),
			BlockBehaviour.Properties.of()
					.strength(4.0F, 6.0F)
					.requiresCorrectToolForDrops()
					.lightLevel(state -> 11)
					.sound(SoundType.AMETHYST));

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties props) {
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, PrismaraMod.id(name));
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, PrismaraMod.id(name));
		Block block = Registry.register(BuiltInRegistries.BLOCK, blockKey, factory.apply(props.setId(blockKey)));
		Registry.register(BuiltInRegistries.ITEM, itemKey, new BlockItem(block, new Item.Properties().setId(itemKey)));
		return block;
	}

	public static void init() {
		// Cargar la clase dispara el registro de los campos estáticos.
	}

	private ModBlocks() {
	}
}
