package com.modernity.modernitymixin.model.pneumaticcraft.semiblocks;

import me.desht.pneumaticcraft.client.model.semiblocks.ModelHeatFrame;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHeatFrameNew extends ModelHeatFrame {
    //fields
    private final ModelRenderer bottom;
    private final ModelRenderer side1;
    private final ModelRenderer side2;
    private final ModelRenderer side3;
    private final ModelRenderer side4;
    private final ModelRenderer topCorner1;
    private final ModelRenderer topCorner2;
    private final ModelRenderer topCorner3;
    private final ModelRenderer topCorner4;
    private final ModelRenderer top1;
    private final ModelRenderer top2;
    private final ModelRenderer top3;
    private final ModelRenderer top4;
    private final ModelRenderer top5;
    private final ModelRenderer top6;
    private final ModelRenderer top7;
    private final ModelRenderer top8;
    private final ModelRenderer top9;
    private final ModelRenderer top10;
    private final ModelRenderer top11;
    private final ModelRenderer top12;

    public ModelHeatFrameNew() {
        textureWidth = 128;
        textureHeight = 128;

        bottom = new ModelRenderer(this);
        bottom.setRotationPoint(4.5F, 20.5F, -8.5F);
        bottom.setTextureOffset(0, 0).addBox(-13.0F, -1.0F, 0.0F, 17, 5, 17);
        bottom.mirror = true;

        side1 = new ModelRenderer(this);
        side1.setRotationPoint(-8.5F, 11.5F, -8.5F);
        side1.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
        side1.mirror = true;

        side2 = new ModelRenderer(this);
        side2.setRotationPoint(7.5F, 11.5F, -8.5F);
        side2.setTextureOffset(4, 0).addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
        side2.mirror = true;

        side3 = new ModelRenderer(this);
        side3.setRotationPoint(-8.5F, 11.5F, 7.5F);
        side3.setTextureOffset(12, 0).addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
        side3.mirror = true;

        side4 = new ModelRenderer(this);
        side4.setRotationPoint(7.5F, 11.5F, 7.5F);
        side4.setTextureOffset(8, 0).addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
        side4.mirror = true;

        topCorner1 = new ModelRenderer(this);
        topCorner1.setRotationPoint(-8.5F, 7.5F, 4.5F);
        topCorner1.setTextureOffset(48, 24).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
        topCorner1.mirror = true;

        topCorner2 = new ModelRenderer(this);
        topCorner2.setRotationPoint(4.5F, 7.5F, -8.5F);
        topCorner2.setTextureOffset(0, 24).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
        topCorner2.mirror = true;

        topCorner3 = new ModelRenderer(this);
        topCorner3.setRotationPoint(-8.5F, 7.5F, -8.5F);
        topCorner3.setTextureOffset(16, 24).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
        topCorner3.mirror = true;

        topCorner4 = new ModelRenderer(this);
        topCorner4.setRotationPoint(4.5F, 7.5F, 4.5F);
        topCorner4.setTextureOffset(32, 24).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
        topCorner4.mirror = true;

        top1 = new ModelRenderer(this);
        top1.setRotationPoint(-4.5F, 7.5F, 7.5F);
        top1.setTextureOffset(64, 26).addBox(0.0F, 0.0F, 0.0F, 9, 2, 1);
        top1.mirror = true;

        top2 = new ModelRenderer(this);
        top2.setRotationPoint(-4.5F, 7.5F, -8.5F);
        top2.setTextureOffset(64, 29).addBox(0.0F, 0.0F, 0.0F, 9, 2, 1);
        top2.mirror = true;

        top3 = new ModelRenderer(this);
        top3.setRotationPoint(7.5F, 7.5F, -4.5F);
        top3.setTextureOffset(51, 0).addBox(0.0F, 0.0F, 0.0F, 1, 2, 9);
        top3.mirror = true;

        top4 = new ModelRenderer(this);
        top4.setRotationPoint(-8.5F, 7.5F, -4.5F);
        top4.setTextureOffset(71, 10).addBox(0.0F, 0.0F, 0.0F, 1, 2, 9);
        top4.mirror = true;

        top5 = new ModelRenderer(this);
        top5.setRotationPoint(-8.5F, 9.5F, -4.5F);
        top5.setTextureOffset(91, 0).addBox(0.0F, 0.0F, 0.0F, 1, 1, 9);
        top5.mirror = true;

        top6 = new ModelRenderer(this);
        top6.setRotationPoint(7.5F, 9.5F, -4.5F);
        top6.setTextureOffset(71, 0).addBox(0.0F, 0.0F, 0.0F, 1, 1, 9);
        top6.mirror = true;

        top7 = new ModelRenderer(this);
        top7.setRotationPoint(-4.5F, 9.5F, -8.5F);
        top7.setTextureOffset(84, 30).addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        top7.mirror = true;

        top8 = new ModelRenderer(this);
        top8.setRotationPoint(-4.5F, 9.5F, 7.5F);
        top8.setTextureOffset(84, 28).addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        top8.mirror = true;

        top9 = new ModelRenderer(this);
        top9.setRotationPoint(-8.5F, 9.5F, -4.5F);
        top9.setTextureOffset(91, 10).addBox(0.0F, 1.0F, 0.0F, 1, 1, 9);
        top9.mirror = true;

        top10 = new ModelRenderer(this);
        top10.setRotationPoint(7.5F, 9.5F, -4.5F);
        top10.setTextureOffset(102, 5).addBox(0.0F, 1.0F, 0.0F, 1, 1, 9);
        top10.mirror = true;

        top11 = new ModelRenderer(this);
        top11.setRotationPoint(-4.5F, 9.5F, 7.5F);
        top11.setTextureOffset(84, 26).addBox(0.0F, 1.0F, 0.0F, 9, 1, 1);
        top11.mirror = true;

        top12 = new ModelRenderer(this);
        top12.setRotationPoint(-4.5F, 9.5F, -8.5F);
        top12.setTextureOffset(84, 24).addBox(0.0F, 1.0F, 0.0F, 9, 1, 1);
        top12.mirror = true;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        bottom.render(f5);
        side1.render(f5);
        side2.render(f5);
        side3.render(f5);
        side4.render(f5);
        topCorner1.render(f5);
        topCorner2.render(f5);
        topCorner3.render(f5);
        topCorner4.render(f5);
        top1.render(f5);
        top2.render(f5);
        top3.render(f5);
        top4.render(f5);
        top5.render(f5);
        top6.render(f5);
        top7.render(f5);
        top8.render(f5);
        top9.render(f5);
        top10.render(f5);
        top11.render(f5);
        top12.render(f5);
    }
}
