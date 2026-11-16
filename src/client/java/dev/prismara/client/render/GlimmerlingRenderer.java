package dev.prismara.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import dev.prismara.PrismaraMod;
import dev.prismara.client.model.GlimmerlingModel;
import dev.prismara.entity.Glimmerling;

public class GlimmerlingRenderer extends MobRenderer<Glimmerling, LivingEntityRenderState, GlimmerlingModel> {
	private static final Identifier TEXTURE = PrismaraMod.id("textures/entity/glimmerling.png");

	public GlimmerlingRenderer(EntityRendererProvider.Context context) {
		super(context, new GlimmerlingModel(context.bakeLayer(GlimmerlingModel.LAYER)), 0.3F);
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
