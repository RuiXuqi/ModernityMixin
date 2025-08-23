package com.modernity.modernitymixin.model.pneumaticcraft.semiblocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpawnerAgitatorNew extends ModelBase {
    //fields
    private final ModelRenderer top1;
    private final ModelRenderer top2;
    private final ModelRenderer top3;
    private final ModelRenderer top4;
    private final ModelRenderer side1;
    private final ModelRenderer side2;
    private final ModelRenderer side3;
    private final ModelRenderer side4;
    private final ModelRenderer bottom1;
    private final ModelRenderer bottom2;
    private final ModelRenderer bottom3;
    private final ModelRenderer bottom4;

    public ModelSpawnerAgitatorNew() {
        textureWidth = 64;
        textureHeight = 64;

        top1 = new ModelRenderer(this);
        top1.setRotationPoint(-8.5F, 7.5F, 4.5F);
        top1.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 1.0F, 17, 3, 3);
        top1.mirror = true;

        top2 = new ModelRenderer(this);
        top2.setRotationPoint(-8.5F, 7.5F, -8.5F);
        top2.setTextureOffset(0, 6).addBox(0.0F, 0.0F, 0.0F, 17, 3, 3);
        top2.mirror = true;

        top3 = new ModelRenderer(this);
        top3.setRotationPoint(4.5F, 7.5F, 4.5F);
        top3.setTextureOffset(0, 24).addBox(1.0F, 0.0F, -10.0F, 3, 3, 11);
        top3.mirror = true;

        top4 = new ModelRenderer(this);
        top4.setRotationPoint(-7.5F, 7.5F, 4.5F);
        top4.setTextureOffset(0, 38).addBox(-1.0F, 0.0F, -10.0F, 3, 3, 11);
        top4.mirror = true;

        side1 = new ModelRenderer(this);
        side1.setRotationPoint(-8.5F, 11.5F, -8.5F);
        side1.setTextureOffset(28, 52).addBox(0.0F, -1.0F, 0.0F, 1, 11, 1);
        side1.setTextureOffset(32, 52).addBox(2.0F, -1.0F, 0.0F, 1, 11, 1);
        side1.setTextureOffset(24, 52).addBox(0.0F, -1.0F, 2.0F, 1, 11, 1);
        side1.mirror = true;

        side2 = new ModelRenderer(this);
        side2.setRotationPoint(7.5F, 11.5F, -8.5F);
        side2.setTextureOffset(40, 52).addBox(0.0F, -1.0F, 0.0F, 1, 11, 1);
        side2.setTextureOffset(44, 52).addBox(0.0F, -1.0F, 2.0F, 1, 11, 1);
        side2.setTextureOffset(36, 52).addBox(-2.0F, -1.0F, 0.0F, 1, 11, 1);
        side2.mirror = true;

        side3 = new ModelRenderer(this);
        side3.setRotationPoint(-8.5F, 11.5F, 7.5F);
        side3.setTextureOffset(16, 52).addBox(0.0F, -1.0F, 0.0F, 1, 11, 1);
        side3.setTextureOffset(12, 52).addBox(2.0F, -1.0F, 0.0F, 1, 11, 1);
        side3.setTextureOffset(20, 52).addBox(0.0F, -1.0F, -2.0F, 1, 11, 1);
        side3.mirror = true;

        side4 = new ModelRenderer(this);
        side4.setRotationPoint(7.5F, 11.5F, 7.5F);
        side4.setTextureOffset(4, 52).addBox(0.0F, -1.0F, 0.0F, 1, 11, 1);
        side4.setTextureOffset(8, 52).addBox(-2.0F, -1.0F, 0.0F, 1, 11, 1);
        side4.setTextureOffset(0, 52).addBox(0.0F, -1.0F, -2.0F, 1, 11, 1);
        side4.mirror = true;

        bottom1 = new ModelRenderer(this);
        bottom1.setRotationPoint(-8.5F, 21.5F, 4.5F);
        bottom1.setTextureOffset(0, 12).addBox(0.0F, 0.0F, 1.0F, 17, 3, 3);
        bottom1.mirror = true;

        bottom2 = new ModelRenderer(this);
        bottom2.setRotationPoint(-7.5F, 21.5F, 4.5F);
        bottom2.setTextureOffset(28, 38).addBox(-1.0F, 0.0F, -10.0F, 3, 3, 11);
        bottom2.mirror = true;
        
        bottom3 = new ModelRenderer(this);
        bottom3.setRotationPoint(4.5F, 21.5F, 4.5F);
        bottom3.setTextureOffset(28, 24).addBox(1.0F, 0.0F, -10.0F, 3, 3, 11);
        bottom3.mirror = true;
        
        bottom4 = new ModelRenderer(this);
        bottom4.setRotationPoint(-8.5F, 21.5F, -8.5F);
        bottom4.setTextureOffset(0, 18).addBox(0.0F, 0.0F, 0.0F, 17, 3, 3);
        bottom4.mirror = true;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        top1.render(f5);
        top2.render(f5);
        top3.render(f5);
        top4.render(f5);
        side1.render(f5);
        side2.render(f5);
        side3.render(f5);
        side4.render(f5);
        bottom1.render(f5);
        bottom2.render(f5);
        bottom3.render(f5);
        bottom4.render(f5);
    }
}
