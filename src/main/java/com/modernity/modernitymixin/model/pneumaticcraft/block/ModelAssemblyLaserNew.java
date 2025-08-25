package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelAssemblyLaser;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelAssemblyLaserNew extends ModelAssemblyLaser {
    private final ModelRenderer baseTurn;
    private final ModelRenderer baseTurn2_0;
    private final ModelRenderer baseTurn2_1;
    private final ModelRenderer armBase;
    private final ModelRenderer armMiddle;
    private final ModelRenderer laserBase;
    private final ModelRenderer laser;

    public ModelAssemblyLaserNew() {
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
        armMiddle.setTextureOffset(28, 10).addBox(0.0F, 2.0F, 0.0F, 2, 13, 2);
        armMiddle.setTextureOffset(12, 24).addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.3F);
        armMiddle.setTextureOffset(0, 24).addBox(0.0F, 15.0F, 0.0F, 2, 2, 2, 0.3F);
        armMiddle.setTextureOffset(14, 52).addBox(-0.5F, 15.0F, 0.0F, 3, 2, 2);
        armMiddle.setTextureOffset(60, 38).addBox(4.0F, 0.5F, 0.5F, 1, 7, 1);
        armMiddle.setTextureOffset(54, 38).addBox(2.0F, 6.5F, 0.5F, 2, 1, 1);
        armMiddle.mirror = true;

        laserBase = new ModelRenderer(this, 0, 0);
        laserBase.setRotationPoint(-4.0F, 2.0F, 5.0F);
        laserBase.setTextureOffset(46, 15).addBox(2.5F, -1.5F, -1.0F, 3, 6, 6);
        laserBase.setTextureOffset(48, 27).addBox(3.5F, -0.5F, -0.5F, 3, 6, 5);
        laserBase.setTextureOffset(48, 38).addBox(2.0F, 0.5F, 0.5F, 2, 1, 1, 0.3F);

        laser = new ModelRenderer(this, 0, 0);
        laser.setRotationPoint(0.0F, 24.0F, 0.0F);
        laser.setTextureOffset(8, 36).addBox(-0.5F, -21.5F, 1.0F, 1, 1, 27);
        laser.mirror = true;
    }

    public void renderModel(float size, float[] angles, boolean laserOn) {
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

        laserBase.render(size);
        if (laserOn) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0, 2.25 / 16D, 1 / 16D);
            GlStateManager.scale(2/8f, 2/8f, 2/8f);
            GlStateManager.disableTexture2D();
            GlStateManager.color(1.0F, 0.1F, 0, 1);
            laser.render(size);
            GlStateManager.popMatrix();
            GlStateManager.color(1, 1, 1, 1);
            GlStateManager.enableTexture2D();
        }

        GlStateManager.popMatrix();
    }
}
