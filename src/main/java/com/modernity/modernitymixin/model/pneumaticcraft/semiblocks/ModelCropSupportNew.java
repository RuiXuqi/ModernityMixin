package com.modernity.modernitymixin.model.pneumaticcraft.semiblocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCropSupportNew extends ModelBase {
    private final ModelRenderer stick1;
    private final ModelRenderer stick2;
    private final ModelRenderer stick3;
    private final ModelRenderer stick4;
    private final ModelRenderer stick5;
    private final ModelRenderer stick6;
    private final ModelRenderer stick6_r1;
    private final ModelRenderer stick7;
    private final ModelRenderer stick8;
    private final ModelRenderer stick8_r1;

    public ModelCropSupportNew() {
        textureWidth = 64;
        textureHeight = 64;

        stick1 = new ModelRenderer(this);
        stick1.setRotationPoint(-8.5F, 11.5F, -8.5F);
        stick1.setTextureOffset(48, 0).addBox(0.0F, 0.0F, 0.0F, 1, 13, 1);
        stick1.mirror = true;

        stick2 = new ModelRenderer(this);
        stick2.setRotationPoint(7.5F, 11.5F, -8.5F);
        stick2.setTextureOffset(44, 0).addBox(0.0F, 0.0F, 0.0F, 1, 13, 1);
        stick2.mirror = true;

        stick3 = new ModelRenderer(this);
        stick3.setRotationPoint(-8.5F, 11.5F, 7.5F);
        stick3.setTextureOffset(40, 0).addBox(0.0F, 0.0F, 0.0F, 1, 13, 1);
        stick3.mirror = true;

        stick4 = new ModelRenderer(this);
        stick4.setRotationPoint(7.5F, 11.5F, 7.5F);
        stick4.setTextureOffset(52, 0).addBox(0.0F, 0.0F, 0.0F, 1, 13, 1);
        stick4.mirror = true;

        stick5 = new ModelRenderer(this);
        stick5.setRotationPoint(0.0F, 24.0F, 0.0F);
        stick5.setTextureOffset(0, 2).addBox(-9.5F, -13.5F, -8.5F, 19, 1, 1);
        stick5.mirror = true;

        stick6 = new ModelRenderer(this);
        stick6.setRotationPoint(0.0F, 24.0F, 0.0F);

        stick6_r1 = new ModelRenderer(this);
        stick6_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        stick6.addChild(stick6_r1);
        setRotation(stick6_r1, 0.0F, -1.5708F, 0.0F);
        stick6_r1.setTextureOffset(0, 4).addBox(-9.5F, -13.5F, -8.5F, 19, 1, 1);
        stick6_r1.mirror = true;

        stick7 = new ModelRenderer(this);
        stick7.setRotationPoint(0.0F, 24.0F, 0.0F);
        stick7.setTextureOffset(0, 0).addBox(-9.5F, -13.5F, 7.5F, 19, 1, 1);
        stick7.mirror = true;

        stick8 = new ModelRenderer(this);
        stick8.setRotationPoint(0.0F, 24.0F, 0.0F);

        stick8_r1 = new ModelRenderer(this);
        stick8_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        stick8.addChild(stick8_r1);
        setRotation(stick8_r1, 0.0F, -1.5708F, 0.0F);
        stick8_r1.setTextureOffset(0, 6).addBox(-9.5F, -13.5F, 7.5F, 19, 1, 1);
        stick8_r1.mirror = true;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        stick1.render(f5);
        stick2.render(f5);
        stick3.render(f5);
        stick4.render(f5);
        stick5.render(f5);
        stick6.render(f5);
        stick7.render(f5);
        stick8.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
