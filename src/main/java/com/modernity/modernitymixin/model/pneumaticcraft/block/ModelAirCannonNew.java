package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelAirCannon;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelAirCannonNew extends ModelAirCannon {
    private final ModelRenderer baseTurn;
    private final ModelRenderer baseFrame1;
    private final ModelRenderer baseFrame2;
    private final ModelRenderer axis;
    private final ModelRenderer cannon;

    public ModelAirCannonNew() {
        textureWidth = 64;
        textureHeight = 64;

        baseTurn = new ModelRenderer(this, 0, 0);
        baseTurn.setRotationPoint(-3.5F, 20.0F, -5.0F);
        baseTurn.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 7, 1, 7);

        baseFrame1 = new ModelRenderer(this, 0, 0);
        baseFrame1.setRotationPoint(-3.5F, 15.0F, -3.0F);
        baseFrame1.setTextureOffset(28, 0).addBox(0.0F, 0.0F, 0.0F, 1, 5, 3);
        baseFrame1.mirror = true;

        baseFrame2 = new ModelRenderer(this, 0, 0);
        baseFrame2.setRotationPoint(2.5F, 15.0F, -3.0F);
        baseFrame2.setTextureOffset(36, 0).addBox(0.0F, 0.0F, 0.0F, 1, 5, 3);
        baseFrame2.mirror = true;

        axis = new ModelRenderer(this, 0, 0);
        axis.setRotationPoint(-3.0F, 15.5F, -2.0F);
        axis.setTextureOffset(44, 4).addBox(-1.0F, 0.0F, -0.5F, 8, 2, 2, -0.2F);
        axis.mirror = true;

        cannon = new ModelRenderer(this, 0, 0);
        cannon.setRotationPoint(-1.0F, 15.0F, -2.5F);
        cannon.setTextureOffset(0, 8).addBox(-1.0F, 0.0F, -1.0F, 4, 4, 4);
        cannon.setTextureOffset(24, 8).addBox(-0.5F, -2.0F, -0.5F, 3, 2, 3);
        cannon.setTextureOffset(36, 8).addBox(-1.0F, -3.75F, -0.5F, 1, 2, 3, -0.2F);
        cannon.setTextureOffset(44, 8).addBox(2.0F, -3.75F, -0.5F, 1, 2, 3, -0.2F);
        cannon.setTextureOffset(44, 13).addBox(-1.0F, -3.75F, -1.0F, 4, 2, 1, -0.2F);
        cannon.setTextureOffset(34, 13).addBox(-1.0F, -3.75F, 2.0F, 4, 2, 1, -0.2F);
        cannon.mirror = true;
    }

    public void renderModel(float size, float rotationAngle, float heightAngle) {
        GlStateManager.pushMatrix();

        GlStateManager.translate(0.0, 0.0, -0.09375D);
        GlStateManager.rotate(rotationAngle, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0, 0.0, 0.09375D);
        baseTurn.render(size);
        baseFrame1.render(size);
        baseFrame2.render(size);
        axis.render(size);

        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0D, 1.0D, -0.09375D);
        GlStateManager.rotate(heightAngle, 1.0F, 0.0F, 0.0F);
        GlStateManager.translate(0.0D, -1.0D, 0.09375D);
        cannon.render(size);
        GlStateManager.popMatrix();

        GlStateManager.popMatrix();
    }
}
