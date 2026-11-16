package dev.prismara.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import dev.prismara.PrismaraMod;

/** Cuerpo pequeño y redondo, orejas de cristal y cola que se menea. Textura 64x32. */
public class GlimmerlingModel extends EntityModel<LivingEntityRenderState> {
	public static final ModelLayerLocation LAYER = new ModelLayerLocation(PrismaraMod.id("glimmerling"), "main");

	private final ModelPart head;
	private final ModelPart earL;
	private final ModelPart earR;
	private final ModelPart tail;
	private final ModelPart legFL;
	private final ModelPart legFR;
	private final ModelPart legBL;
	private final ModelPart legBR;

	public GlimmerlingModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.earL = this.head.getChild("ear_l");
		this.earR = this.head.getChild("ear_r");
		this.tail = root.getChild("tail");
		this.legFL = root.getChild("leg_fl");
		this.legFR = root.getChild("leg_fr");
		this.legBL = root.getChild("leg_bl");
		this.legBR = root.getChild("leg_br");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 5.0F, 8.0F),
				PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 0).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 5.0F, 5.0F),
				PartPose.offset(0.0F, 18.0F, -4.0F));
		head.addOrReplaceChild("ear_l", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -5.0F, -0.5F, 2.0F, 5.0F, 1.0F),
				PartPose.offset(2.0F, -3.0F, -2.0F));
		head.addOrReplaceChild("ear_r", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -5.0F, -0.5F, 2.0F, 5.0F, 1.0F),
				PartPose.offset(-2.0F, -3.0F, -2.0F));

		root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F),
				PartPose.offset(0.0F, 18.0F, 4.0F));

		root.addOrReplaceChild("leg_fl", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(2.0F, 21.0F, -3.0F));
		root.addOrReplaceChild("leg_fr", CubeListBuilder.create().texOffs(10, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, -3.0F));
		root.addOrReplaceChild("leg_bl", CubeListBuilder.create().texOffs(20, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(2.0F, 21.0F, 3.0F));
		root.addOrReplaceChild("leg_br", CubeListBuilder.create().texOffs(30, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-2.0F, 21.0F, 3.0F));

		return LayerDefinition.create(mesh, 64, 32);
	}

	@Override
	public void setupAnim(LivingEntityRenderState state) {
		this.resetPose();

		float rad = (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * rad;
		this.head.xRot = state.xRot * rad;

		float pos = state.walkAnimationPos;
		float speed = state.walkAnimationSpeed;
		this.legFL.xRot = (float) Math.cos(pos * 1.2F) * 1.3F * speed;
		this.legBR.xRot = this.legFL.xRot;
		this.legFR.xRot = (float) Math.cos(pos * 1.2F + Math.PI) * 1.3F * speed;
		this.legBL.xRot = this.legFR.xRot;

		float t = state.ageInTicks;
		this.earL.zRot = 0.25F + (float) Math.sin(t * 0.12F) * 0.12F;
		this.earR.zRot = -0.25F - (float) Math.sin(t * 0.12F + 1.0F) * 0.12F;
		this.tail.yRot = (float) Math.sin(t * 0.25F) * 0.5F;
	}
}
