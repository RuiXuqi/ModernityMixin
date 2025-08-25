package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelElevatorBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelElevatorBaseNew extends ModelElevatorBase {
    private static final float FACTOR = 9F / 16;
    private final ModelRenderer pole1;
    private final ModelRenderer pole2;
    private final ModelRenderer pole3;
    private final ModelRenderer pole4;
    private final ModelRenderer floor;

    public ModelElevatorBaseNew() {
        textureWidth = 64;
        textureHeight = 64;

        pole1 = new ModelRenderer(this, 28, 41);
        pole1.setRotationPoint(17.0F, 9.0F, -1.0F);
        pole1.addBox(-19.5F, 0.0F, -1.5F, 5, 14, 5);
        pole1.mirror = true;

        pole2 = new ModelRenderer(this, 32, 19);
        pole2.setRotationPoint(12.0F, 9.0F, -2.0F);
        pole2.addBox(-15.0F, 0.0F, -1.0F, 6, 14, 6);
        pole2.mirror = true;

        pole3 = new ModelRenderer(this, 0, 39);
        pole3.setRotationPoint(5.0F, 9.0F, -12.0F);
        pole3.addBox(-8.5F, 0.0F, 8.5F, 7, 14, 7);
        pole3.mirror = true;

        pole4 = new ModelRenderer(this, 0, 17);
        pole4.setRotationPoint(-4.0F, 9.0F, -4.0F);
        pole4.addBox(0.0F, 0.0F, 0.0F, 8, 14, 8);
        pole4.mirror = true;

        floor = new ModelRenderer(this, 0, 0);
        floor.setRotationPoint(-8.0F, 8.0F, -8.0F);
        floor.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16);
    }

    public void renderModel(float scale, float extension) {
        renderPole(pole4, 0, scale, extension);
        renderPole(pole3, 1, scale, extension);
        renderPole(pole2, 2, scale, extension);
        renderPole(pole1, 3, scale, extension);
        GlStateManager.color(1, 1, 1,1 );
        floor.render(scale);
    }

    private void renderPole(ModelRenderer pole, int idx, float scale, float extension) {
        GlStateManager.translate(0, -extension / 4, 0);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0, FACTOR, 0);
        GlStateManager.scale(1, extension * 16 / 14 / 4, 1);
        GlStateManager.translate(0, -FACTOR, 0);
        GlStateManager.color(1 - idx * 0.15f, 1 - idx * 0.15f, 1 - idx * 0.15f, 1);
        pole.render(scale);
        GlStateManager.popMatrix();
    }
}
