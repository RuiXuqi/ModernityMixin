package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelUniversalSensor;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelUniversalSensorNew extends ModelUniversalSensor {
    private final ModelRenderer part1;
    private final ModelRenderer part2;
    private final ModelRenderer part3;
    private final ModelRenderer part4;
    private final ModelRenderer part5;
    private final ModelRenderer part6;
    private final ModelRenderer part7;
    private final ModelRenderer part8;
    private final ModelRenderer part8_r1;
    private final ModelRenderer part9;
    private final ModelRenderer part9_r1;
    private final ModelRenderer part10;
    private final ModelRenderer part10_r1;
    private final ModelRenderer part11;
    private final ModelRenderer part11_r1;
    private final ModelRenderer part12;
    private final ModelRenderer part12_r1;
    private final ModelRenderer part13;
    private final ModelRenderer part13_r1;
    private final ModelRenderer part14;
    private final ModelRenderer part14_r1;
    private final ModelRenderer part15;
    private final ModelRenderer part15_r1;

    public ModelUniversalSensorNew(){
        textureWidth = 32;
        textureHeight = 32;

        part1 = new ModelRenderer(this, 0, 0);
        part1.setRotationPoint(0.0F, 16.0F, 0.0F);
        part1.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4);
        part1.mirror = true;

        part2 = new ModelRenderer(this, 0, 9);
        part2.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part2, 0.0F, 0.0F, -0.2269F);
        part2.setTextureOffset(0, 9).addBox(-3.0F, 4.0F, 0.5F, 1, 3, 3);
        part2.mirror = true;

        part3 = new ModelRenderer(this, 16, 3);
        part3.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotation(part3, 0.0F, 0.0F, -0.2269F);
        part3.setTextureOffset(16, 3).addBox(-2.0F, 1.25F, -0.5F, 6, 1, 1);
        part3.mirror = true;

        part4 = new ModelRenderer(this, 16, 0);
        part4.setRotationPoint(0.0F, 10.2F, 0.0F);
        part4.setTextureOffset(16, 0).addBox(3.25F, 1.25F, -1.0F, 1, 1, 2);
        part4.mirror = true;

        part5 = new ModelRenderer(this, 0, 5);
        part5.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part5, 0.0F, 0.0F, -0.2269F);
        part5.setTextureOffset(0, 5).addBox(-3.0F, 3.0F, 0.5F, 1, 1, 3);
        part5.mirror = true;

        part6 = new ModelRenderer(this, 0, 5);
        part6.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part6, 0.0F, 0.0F, -0.2269F);
        part6.setTextureOffset(0, 5).addBox(-3.0F, -2.0F, 0.5F, 1, 1, 3);
        part6.mirror = true;

        part7 = new ModelRenderer(this, 18, 9);
        part7.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part7, 0.0F, 0.0F, -0.2269F);
        part7.setTextureOffset(18, 9).addBox(-2.5F, -1.0F, 0.5F, 0, 4, 3);
        part7.mirror = true;

        part8 = new ModelRenderer(this, 20, 6);
        part8.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part8, 0.0F, 0.0F, -0.2269F);


        part8_r1 = new ModelRenderer(this, 20, 6);
        part8_r1.setRotationPoint(-3.0F, 3.5F, 3.5F);
        part8.addChild(part8_r1);
        setRotation(part8_r1, 0.0F, 0.3927F, 0.0F);
        part8_r1.setTextureOffset(20, 6).addBox(0.0F, -0.5F, 0.0F, 1, 1, 5);
        part8_r1.mirror = true;

        part9 = new ModelRenderer(this, 20, 6);
        part9.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part9, 0.0F, 0.0F, -0.2269F);


        part9_r1 = new ModelRenderer(this, 20, 6);
        part9_r1.setRotationPoint(-3.0F, -1.5F, 3.5F);
        part9.addChild(part9_r1);
        setRotation(part9_r1, 0.0F, 0.3927F, 0.0F);
        part9_r1.setTextureOffset(20, 6).addBox(0.0F, -0.5F, 0.0F, 1, 1, 5);
        part9_r1.mirror = true;

        part10 = new ModelRenderer(this, 15, 2);
        part10.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part10, 0.0F, 0.0F, -0.2269F);

        part10_r1 = new ModelRenderer(this, 15, 2);
        part10_r1.setRotationPoint(-2.5F, -0.5F, 3.5F);
        part10.addChild(part10_r1);
        setRotation(part10_r1, 0.0F, 0.3927F, 0.0F);
        part10_r1.setTextureOffset(15, 2).addBox(0.0F, -0.5F, 0.0F, 0, 4, 5);
        part10_r1.mirror = true;

        part11 = new ModelRenderer(this, 8, 6);
        part11.setRotationPoint(0.0F, 9.0F, 2.0F);
        setRotation(part11, 0.0F, 0.0F, -0.2269F);


        part11_r1 = new ModelRenderer(this, 8, 6);
        part11_r1.setRotationPoint(-3.0F, 3.5F, -3.5F);
        part11.addChild(part11_r1);
        setRotation(part11_r1, 0.0F, -0.3927F, 0.0F);
        part11_r1.setTextureOffset(8, 6).addBox(0.0F, -0.5F, -5.0F, 1, 1, 5);
        part11_r1.mirror = true;

        part12 = new ModelRenderer(this, 8, 6);
        part12.setRotationPoint(0.0F, 9.0F, 2.0F);
        setRotation(part12, 0.0F, 0.0F, -0.2269F);


        part12_r1 = new ModelRenderer(this, 8, 6);
        part12_r1.setRotationPoint(-3.0F, -1.5F, -3.5F);
        part12.addChild(part12_r1);
        setRotation(part12_r1, 0.0F, -0.3927F, 0.0F);
        part12_r1.setTextureOffset(8, 6).addBox(0.0F, -0.5F, -5.0F, 1, 1, 5);
        part12_r1.mirror = true;

        part13 = new ModelRenderer(this, 8, 7);
        part13.setRotationPoint(0.0F, 9.0F, 2.0F);
        setRotation(part13, 0.0F, 0.0F, -0.2269F);


        part13_r1 = new ModelRenderer(this, 8, 7);
        part13_r1.setRotationPoint(-2.5F, -0.5F, -3.5F);
        part13.addChild(part13_r1);
        setRotation(part13_r1, 0.0F, -0.3927F, 0.0F);
        part13_r1.setTextureOffset(8, 7).addBox(0.0F, -0.5F, -5.0F, 0, 4, 5);
        part13_r1.mirror = true;

        part14 = new ModelRenderer(this, 28, 12);
        part14.setRotationPoint(0.0F, 9.0F, -2.0F);
        setRotation(part14, 0.0F, 0.0F, -0.2269F);


        part14_r1 = new ModelRenderer(this, 28, 12);
        part14_r1.setRotationPoint(-3.0F, 2.5F, 3.5F);
        part14.addChild(part14_r1);
        setRotation(part14_r1, 0.0F, 0.3927F, 0.0F);
        part14_r1.setTextureOffset(28, 12).addBox(0.0F, -3.5F, 4.0F, 1, 4, 1);
        part14_r1.mirror = true;

        part15 = new ModelRenderer(this, 28, 12);
        part15.setRotationPoint(0.0F, 9.0F, 2.0F);
        setRotation(part15, 0.0F, 0.0F, -0.2269F);


        part15_r1 = new ModelRenderer(this, 28, 12);
        part15_r1.setRotationPoint(-3.0F, 2.5F, -3.5F);
        part15.addChild(part15_r1);
        setRotation(part15_r1, 0.0F, -0.3927F, 0.0F);
        part15_r1.setTextureOffset(28, 12).addBox(0.0F, -3.5F, -5.0F, 1, 4, 1);
        part15_r1.mirror = true;
    }

    public void renderModel(float scale, float dishRotation) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(dishRotation, 0, 1, 0);
        part1.render(scale);
        part2.render(scale);
        part3.render(scale);
        part4.render(scale);
        part5.render(scale);
        part6.render(scale);
        part7.render(scale);
        part8.render(scale);
        part9.render(scale);
        part10.render(scale);
        part11.render(scale);
        part12.render(scale);
        part13.render(scale);
        part14.render(scale);
        part15.render(scale);
        GlStateManager.popMatrix();
    }
}
