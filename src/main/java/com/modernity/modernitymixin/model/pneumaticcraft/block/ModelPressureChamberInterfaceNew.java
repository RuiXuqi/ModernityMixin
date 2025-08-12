package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelPressureChamberInterface;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderEntityItem;

public class ModelPressureChamberInterfaceNew extends ModelPressureChamberInterface {
    private final ModelRenderer inputLeft;
    private final ModelRenderer inputRight;
    private final ModelRenderer inputBottom;
    private final ModelRenderer inputTop;
    private final ModelRenderer outputLeft;
    private final ModelRenderer outputRight;
    private final ModelRenderer outputBottom;
    private final ModelRenderer outputTop;

    private RenderEntityItem customRenderItem = null;

    public ModelPressureChamberInterfaceNew() {
        textureWidth = 32;
        textureHeight = 32;

        // just the doors; rest of the block is a static OBJ model
        inputLeft = new ModelRenderer(this, 0, 0);
        inputLeft.addBox(-4.0F, -12.0F, -6.0F, 4, 8, 1);
        inputLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
        inputLeft.mirror = true;

        inputRight = new ModelRenderer(this, 10, 0);
        inputRight.addBox(0.0F, -12.0F, -6.0F, 4, 8, 1);
        inputRight.setRotationPoint(0.0F, 24.0F, 0.0F);
        inputRight.mirror = true;

        inputBottom = new ModelRenderer(this, 0, 9);
        inputBottom.addBox(-4.0F, -8.0F, -5.0F, 8, 4, 1);
        inputBottom.setRotationPoint(0.0F, 24.0F, 0.0F);
        inputBottom.mirror = false;

        inputTop = new ModelRenderer(this, 0, 14);
        inputTop.addBox(-4.0F, -12.0F, -5.0F, 8, 4, 1);
        inputTop.setRotationPoint(0.0F, 24.0F, 0.0F);
        inputTop.mirror = false;

        outputLeft = new ModelRenderer(this, 0, 19);
        outputLeft.addBox(-4.0F, -12.0F, 5.0F, 4, 8, 1);
        outputLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
        outputLeft.mirror = true;

        outputRight = new ModelRenderer(this, 10, 19);
        outputRight.addBox(0.0F, -12.0F, 5.0F, 4, 8, 1);
        outputRight.setRotationPoint(0.0F, 24.0F, 0.0F);
        outputRight.mirror = true;

        outputBottom = new ModelRenderer(this, 0, 9);
        outputBottom.addBox(-4.0F, -8.0F, 4.0F, 8, 4, 1);
        outputBottom.setRotationPoint(0.0F, 24.0F, 0.0F);
        outputBottom.mirror = false;

        outputTop = new ModelRenderer(this, 0, 14);
        outputTop.addBox(-4.0F, -12.0F, 4.0F, 8, 4, 1);
        outputTop.setRotationPoint(0.0F, 24.0F, 0.0F);
        outputTop.mirror = false;
    }

    private void renderDoors(float size, float inputDoor, float outputDoor){
        if (inputDoor <= 1f) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((1F - (float) Math.cos(inputDoor * Math.PI)) * 0.122F + 0.25, 0, 0);
            inputLeft.render(size);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate((-1F + (float) Math.cos(inputDoor * Math.PI)) * 0.122F - 0.25, 0, 0);
            inputRight.render(size);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(0, (1F - (float) Math.cos(inputDoor * Math.PI)) * 0.122F, 0);
            inputBottom.render(size);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(0, (-1F + (float) Math.cos(inputDoor * Math.PI)) * 0.122F, 0);
            inputTop.render(size);
            GlStateManager.popMatrix();
        }
        if (outputDoor < 1f) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((1F - (float) Math.cos(outputDoor * Math.PI)) * 0.122F + 0.25, 0, 0);
            outputLeft.render(size);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate((-1F + (float) Math.cos(outputDoor * Math.PI)) * 0.122F - 0.25, 0, 0);
            outputRight.render(size);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(0, (1F - (float) Math.cos(outputDoor * Math.PI)) * 0.122F, 0);
            outputBottom.render(size);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(0, (-1F + (float) Math.cos(outputDoor * Math.PI)) * 0.122F, 0);
            outputTop.render(size);
            GlStateManager.popMatrix();
        }
    }
}
