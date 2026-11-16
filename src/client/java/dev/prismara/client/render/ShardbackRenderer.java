package dev.prismara.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import dev.prismara.PrismaraMod;
import dev.prismara.client.model.ShardbackModel;
import dev.prismara.entity.Shardback;

public class ShardbackRenderer extends MobRenderer<Shardback, LivingEntityRenderState, ShardbackModel> {
	private static final Identifier TEXTURE = PrismaraMod.id("textures/entity/shardback.png");

	public ShardbackRenderer(EntityRendererProvider.Context context) {
		super(context, new ShardbackModel(context.bakeLayer(ShardbackModel.LAYER)), 0.6F);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return TEXTURE;
	}
}
