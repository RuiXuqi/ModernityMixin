package com.modernity.modernitymixin.model.pneumaticcraft.semiblocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTransferGadgetNew extends ModelBase {
    private final ModelRenderer inPart1;
    private final ModelRenderer inPart2;
    private final ModelRenderer betweenPart;
    private final ModelRenderer outPart1;
    private final ModelRenderer outPart2;

    public ModelTransferGadgetNew() {
        textureWidth = 64;
        textureHeight = 64;

        inPart1 = new ModelRenderer(this);
        inPart1.setRotationPoint(12.0F, 10.0F, 0.0F);
        inPart1.setTextureOffset(32, 0).addBox(-1.5F, 2.0F, -4.0F, 1, 8, 8);

        inPart2 = new ModelRenderer(this);
        inPart2.setRotationPoint(8.0F, 10.0F, 0.0F);
        inPart2.setTextureOffset(30, 0).addBox(0.5F, 4.0F, -2.0F, 1, 4, 4);

        betweenPart = new ModelRenderer(this);
        betweenPart.setRotationPoint(10.0F, 10.0F, 0.0F);
        betweenPart.setTextureOffset(18, 4).addBox(-0.5F, 3.0F, -3.0F, 1, 6, 6);

        outPart1 = new ModelRenderer(this);
        outPart1.setRotationPoint(8.0F, 10.0F, 0.0F);
        outPart1.setTextureOffset(0, 0).addBox(0.5F, 2.0F, -4.0F, 1, 8, 8);

        outPart2 = new ModelRenderer(this);
        outPart2.setRotationPoint(10.0F, 10.0F, 0.0F);
        outPart2.setTextureOffset(10, 0).addBox(0.5F, 4.0F, -2.0F, 1, 4, 4);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        inPart1.render(f5);
        inPart2.render(f5);
        betweenPart.render(f5);
        outPart1.render(f5);
        outPart2.render(f5);
    }
}
