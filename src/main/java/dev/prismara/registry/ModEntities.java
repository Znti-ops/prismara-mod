package dev.prismara.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;

import dev.prismara.PrismaraMod;
import dev.prismara.entity.Glimmerling;
import dev.prismara.entity.Shardback;

public final class ModEntities {
	public static final EntityType<Glimmerling> GLIMMERLING = register("glimmerling",
			FabricEntityType.Builder.createMob(Glimmerling::new, MobCategory.CREATURE, mob -> mob
					.spawnPlacement(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules)
					.defaultAttributes(Glimmerling::createAttributes))
					.sized(0.6F, 0.6F));

	public static final EntityType<Shardback> SHARDBACK = register("shardback",
			FabricEntityType.Builder.createMob(Shardback::new, MobCategory.MONSTER, mob -> mob
					.spawnPlacement(SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules)
					.defaultAttributes(Shardback::createAttributes))
					.sized(1.0F, 1.2F));

	private static <T extends Mob> EntityType<T> register(String name, EntityType.Builder<T> builder) {
		ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, PrismaraMod.id(name));
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
	}

	public static void init() {
	}

	private ModEntities() {
	}
}
