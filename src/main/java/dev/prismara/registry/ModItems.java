package dev.prismara.registry;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import dev.prismara.CodexItem;
import dev.prismara.PrismaraMod;

public final class ModItems {
	public static final Item PRISMITE_SHARD = register("prismite_shard", Item::new, new Item.Properties());
	public static final Item PRISMARA_CODEX = register("prismara_codex", CodexItem::new, new Item.Properties().stacksTo(1));

	private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties props) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, PrismaraMod.id(name));
		return Registry.register(BuiltInRegistries.ITEM, key, factory.apply(props.setId(key)));
	}

	public static void init() {
	}

	private ModItems() {
	}
}
