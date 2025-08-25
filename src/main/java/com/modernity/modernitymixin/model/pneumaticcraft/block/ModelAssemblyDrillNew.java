package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelAssemblyDrill;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelAssemblyDrillNew extends ModelAssemblyDrill {
    private final ModelRenderer baseTurn;
    private final ModelRenderer baseTurn2_0;
    private final ModelRenderer baseTurn2_1;
    private final ModelRenderer armBase;
    private final ModelRenderer armMiddle;
    private final ModelRenderer drillBase;
    private final ModelRenderer drill;

    public ModelAssemblyDrillNew() {
        textureWidth = 64;
        textureHeight = 64;

        baseTurn = new ModelRenderer(this, 0, 0);
        baseTurn.setRotationPoint(-3.5F, 22.0F, -3.5F);
        baseTurn.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 9, 1, 9);
        baseTurn.mirror = true;

        baseTurn2_0 = new ModelRenderer(this, 0, 0);
        baseTurn2_0.setRotationPoint(-2.0F, 17.0F, -2.0F);
        baseTurn2_0.setTextureOffset(0, 30).addBox(-2.0F, -0.5F, 0.5F, 2, 6, 3, 0.2F);

        baseTurn2_1 = new ModelRenderer(this, 0, 0);
        baseTurn2_1.setRotationPoint(-2.0F, 17.0F, -2.0F);
        baseTurn2_1.setTextureOffset(0, 10).addBox(-2.0F, 3.75F, -2.0F, 2, 2, 8);
        baseTurn2_1.setTextureOffset(10, 30).addBox(4.0F, -0.5F, 0.5F, 2, 6, 3, 0.2F);
        baseTurn2_1.setTextureOffset(0, 20).addBox(4.0F, 3.75F, -2.0F, 2, 2, 8);
        baseTurn2_1.mirror = true;

        armBase = new ModelRenderer(this, 0, 0);
        armBase.setRotationPoint(-3.0F, 17.0F, -1.0F);
        armBase.setTextureOffset(0, 49).addBox(2.0F, 0.0F, 1.0F, 2, 2, 5, 0.3F);
        armBase.setTextureOffset(0, 43).addBox(1.5F, -0.5F, -0.5F, 3, 3, 3);
        armBase.setTextureOffset(12, 43).addBox(1.5F, -0.5F, 5.5F, 3, 3, 3);
        armBase.setTextureOffset(0, 39).addBox(-1.5F, 0.0F, 0.0F, 9, 2, 2);
        armBase.mirror = true;

        armMiddle = new ModelRenderer(this, 0, 0);
        armMiddle.setRotationPoint(-4.0F, 2.0F, 5.0F);
        armMiddle.setTextureOffset(20, 10).addBox(0.0F, 2.0F, 0.0F, 2, 13, 2);
        armMiddle.setTextureOffset(12, 24).addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.3F);
        armMiddle.setTextureOffset(0, 24).addBox(0.0F, 15.0F, 0.0F, 2, 2, 2, 0.3F);
        armMiddle.setTextureOffset(14, 52).addBox(-0.5F, 15.0F, 0.0F, 3, 2, 2);
        armMiddle.mirror = true;

        drillBase = new ModelRenderer(this, 0, 0);
        drillBase.setRotationPoint(-3.0F, 2.0F, 4.5F);
        drillBase.setTextureOffset(46, 0).addBox(1.0F, -1.0F, -1.0F, 4, 4, 5);
        drillBase.setTextureOffset(56, 9).addBox(1.5F, -0.5F, -2.0F, 3, 3, 1);
        drillBase.mirror = true;

        drill = new ModelRenderer(this, 0, 0);
        drill.setRotationPoint(-2.5F, 2.5F, 1.0F);
        drill.setTextureOffset(50, 9).addBox(2.0F, 0.0F, -2.0F, 1, 1, 4);
        drill.mirror = true;
    }

    public void renderModel(float size, float[] angles) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(angles[0], 0, 1, 0);

        baseTurn.render(size);
        baseTurn2_0.render(size);
        baseTurn2_1.render(size);

        GlStateManager.translate(0, 18 / 16F, 0);
        GlStateManager.rotate(angles[1], 1, 0, 0);
        GlStateManager.translate(0, -18 / 16F, 0);

        armBase.render(size);

        GlStateManager.translate(0, 18 / 16F, 6 / 16F);
        GlStateManager.rotate(angles[2], 1, 0, 0);
        GlStateManager.translate(0, -18 / 16F, -6 / 16F);

        armMiddle.render(size);

        GlStateManager.translate(0, 3 / 16F, 6 / 16F);
        GlStateManager.rotate(angles[3], 1, 0, 0);
        GlStateManager.translate(0, -3 / 16F, -6 / 16F);

        drillBase.render(size);

        GlStateManager.translate(0, 3 / 16F, 0);
        GlStateManager.rotate(angles[4], 0, 0, 1);
        GlStateManager.translate(0, -3 / 16F, 0);

        drill.render(size);

        GlStateManager.popMatrix();
    }
}
