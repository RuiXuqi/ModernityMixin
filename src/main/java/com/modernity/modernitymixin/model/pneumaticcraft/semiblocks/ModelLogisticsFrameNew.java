package com.modernity.modernitymixin.model.pneumaticcraft.semiblocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLogisticsFrameNew extends ModelBase {
	private final ModelRenderer frame;
	private final ModelRenderer face;

	public ModelLogisticsFrameNew() {
		textureWidth = 32;
		textureHeight = 32;

		frame = new ModelRenderer(this);
		frame.setRotationPoint(8.0F, 21.0F, 0.0F);
		setRotationAngle(frame, 0.0F, -1.5708F, 0.0F);
		frame.setTextureOffset(0, 0).addBox(-6.0F, -11.0F, -1.0F, 4, 12, 1);
		frame.setTextureOffset(20, 0).addBox(-2.0F, -11.0F, -1.0F, 4, 4, 1);
		frame.setTextureOffset(10, 0).addBox(2.0F, -11.0F, -1.0F, 4, 12, 1);
		frame.setTextureOffset(20, 5).addBox(-2.0F, -3.0F, -1.0F, 4, 4, 1);

		face = new ModelRenderer(this);
		face.setRotationPoint(8.0F, 21.0F, 0.0F);
		setRotationAngle(face, 0.0F, -1.5708F, 0.0F);
		face.setTextureOffset(8, 13).addBox(2.5F, -10.5F, -1.5F, 3, 11, 1);
		face.setTextureOffset(0, 13).addBox(-5.5F, -10.5F, -1.5F, 3, 11, 1);
		face.setTextureOffset(16, 17).addBox(-2.5F, -2.5F, -1.5F, 5, 3, 1);
		face.setTextureOffset(16, 13).addBox(-2.5F, -10.5F, -1.5F, 5, 3, 1);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		frame.render(f5);
		face.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
