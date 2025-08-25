package com.modernity.modernitymixin.model.pneumaticcraft.module;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.common.block.tubes.ModuleAirGrate;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class ModelAirGrateNew extends ModelModuleBase {
    private final ModuleAirGrate grateModule;
    private final ModelRenderer top;
    private final ModelRenderer side1;
    private final ModelRenderer side2;
    private final ModelRenderer side3;
    private final ModelRenderer side4;
    private final ModelRenderer base1;
    private final ModelRenderer base2;
    private final ModelRenderer base3;

    public ModelAirGrateNew(ModuleAirGrate grate) {
        this.grateModule = grate;
        textureWidth = 128;
        textureHeight = 128;

        top = new ModelRenderer(this, 42, 19);
        top.addBox(0F, 0F, 0F, 14, 0, 14);
        top.setRotationPoint(-7F, 9F, 8F);
        top.mirror = true;
        setRotation(top, -1.570796F, 0F, 0F);

        side1 = new ModelRenderer(this, 0, 18);
        side1.addBox(0F, 0F, 0F, 16, 1, 1);
        side1.setRotationPoint(-8F, 23F, 7F);
        side1.mirror = true;

        side2 = new ModelRenderer(this, 0, 21);
        side2.addBox(0F, 0F, 0F, 16, 1, 1);
        side2.setRotationPoint(-8F, 8F, 7F);
        side2.mirror = true;

        side3 = new ModelRenderer(this, 50, 0);
        side3.addBox(0F, 0F, 0F, 1, 1, 14);
        side3.setRotationPoint(-8F, 23F, 7F);
        side3.mirror = true;
        setRotation(side3, 1.570796F, 0F, 0F);

        side4 = new ModelRenderer(this, 82, 0);
        side4.addBox(0F, 0F, 0F, 1, 1, 14);
        side4.setRotationPoint(7F, 23F, 7F);
        side4.mirror = true;
        setRotation(side4, 1.570796F, 0F, 0F);

        base1 = new ModelRenderer(this, 69, 0);
        base1.addBox(0F, 0F, 0F, 6, 2, 6);
        base1.setRotationPoint(-3F, 13F, 4F);
        base1.mirror = true;
        setRotation(base1, -1.570796F, 0F, 0F);

        base2 = new ModelRenderer(this, 0, 25);
        base2.addBox(0F, 0F, 0F, 12, 2, 12);
        base2.setRotationPoint(-6F, 10F, 6F);
        base2.mirror = true;
        setRotation(base2, -1.570796F, 0F, 0F);

        base3 = new ModelRenderer(this, 0, 0);
        base3.addBox(2F, 0F, 0F, 16, 1, 16);
        base3.setRotationPoint(-10F, 8F, 7F);
        base3.mirror = true;
        setRotation(base3, -1.570796F, 0F, 0F);
    }

    @Override
    protected void renderDynamic(float scale, float partialTicks) {
        top.render(scale);
        side1.render(scale);
        side2.render(scale);
        side3.render(scale);
        side4.render(scale);
        base1.render(scale);
        base2.render(scale);
        base3.render(scale);
    }

    @Override
    protected ResourceLocation getTexture() {
        ResourceLocation texture;
        if (grateModule != null && grateModule.isUpgraded()) {
            texture = TexturesNew.MODEL_AIR_GRATE_UPGRADED;
        } else {
            texture = TexturesNew.MODEL_AIR_GRATE;
        }
        return texture;
    }
}
