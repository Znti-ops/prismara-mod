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

/** Cuadrúpedo robusto con tres espinas de cristal en el lomo y un cuerno. Textura 64x64. */
public class ShardbackModel extends EntityModel<LivingEntityRenderState> {
	public static final ModelLayerLocation LAYER = new ModelLayerLocation(PrismaraMod.id("shardback"), "main");

	private final ModelPart head;
	private final ModelPart spine1;
	private final ModelPart spine2;
	private final ModelPart spine3;
	private final ModelPart legFL;
	private final ModelPart legFR;
	private final ModelPart legBL;
	private final ModelPart legBR;

	public ShardbackModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.spine1 = root.getChild("spine1");
		this.spine2 = root.getChild("spine2");
		this.spine3 = root.getChild("spine3");
		this.legFL = root.getChild("leg_fl");
		this.legFR = root.getChild("leg_fr");
		this.legBL = root.getChild("leg_bl");
		this.legBR = root.getChild("leg_br");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 7.0F, 12.0F),
				PartPose.offset(0.0F, 15.0F, 0.0F));

		root.addOrReplaceChild("spine1", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 11.0F, -3.0F));
		root.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(52, 0).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 11.0F, 0.0F));
		root.addOrReplaceChild("spine3", CubeListBuilder.create().texOffs(42, 8).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 11.0F, 3.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-3.5F, -3.0F, -6.0F, 7.0F, 6.0F, 6.0F),
				PartPose.offset(0.0F, 14.0F, -6.0F));
		head.addOrReplaceChild("horn", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F),
				PartPose.offset(0.0F, -3.0F, -3.0F));

		root.addOrReplaceChild("leg_fl", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(2.5F, 18.0F, -3.5F));
		root.addOrReplaceChild("leg_fr", CubeListBuilder.create().texOffs(14, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-2.5F, 18.0F, -3.5F));
		root.addOrReplaceChild("leg_bl", CubeListBuilder.create().texOffs(28, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(2.5F, 18.0F, 3.5F));
		root.addOrReplaceChild("leg_br", CubeListBuilder.create().texOffs(42, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-2.5F, 18.0F, 3.5F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(LivingEntityRenderState state) {
		this.resetPose();

		float rad = (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * rad;
		this.head.xRot = state.xRot * rad;

		float pos = state.walkAnimationPos;
		float speed = state.walkAnimationSpeed;
		this.legFL.xRot = (float) Math.cos(pos * 0.7F) * 1.1F * speed;
		this.legBR.xRot = this.legFL.xRot;
		this.legFR.xRot = (float) Math.cos(pos * 0.7F + Math.PI) * 1.1F * speed;
		this.legBL.xRot = this.legFR.xRot;

		float t = state.ageInTicks;
		this.spine1.zRot = (float) Math.sin(t * 0.07F) * 0.05F;
		this.spine2.zRot = (float) Math.sin(t * 0.07F + 1.0F) * 0.05F;
		this.spine3.zRot = (float) Math.sin(t * 0.07F + 2.0F) * 0.05F;
	}
}
