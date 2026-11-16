package dev.prismara.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.Minecraft;

import dev.prismara.CodexItem;
import dev.prismara.client.model.GlimmerlingModel;
import dev.prismara.client.model.ShardbackModel;
import dev.prismara.client.render.GlimmerlingRenderer;
import dev.prismara.client.render.ShardbackRenderer;
import dev.prismara.registry.ModEntities;

public class PrismaraClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		CodexItem.openHook = player -> Minecraft.getInstance().gui.setScreen(new CodexScreen());

		ModelLayerRegistry.registerModelLayer(GlimmerlingModel.LAYER, GlimmerlingModel::createBodyLayer);
		ModelLayerRegistry.registerModelLayer(ShardbackModel.LAYER, ShardbackModel::createBodyLayer);

		EntityRendererRegistry.register(ModEntities.GLIMMERLING, GlimmerlingRenderer::new);
		EntityRendererRegistry.register(ModEntities.SHARDBACK, ShardbackRenderer::new);
	}
}
