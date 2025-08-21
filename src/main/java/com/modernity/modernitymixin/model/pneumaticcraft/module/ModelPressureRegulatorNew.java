package com.modernity.modernitymixin.model.pneumaticcraft.module;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.common.block.tubes.ModuleRegulatorTube;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class ModelPressureRegulatorNew extends ModelModuleBase {
    private final ModuleRegulatorTube module;
    private final ModelRenderer tubeConnector;
    private final ModelRenderer valve1;
    private final ModelRenderer valve2;


    public ModelPressureRegulatorNew(ModuleRegulatorTube module) {
        this.module = module;
        textureWidth = 32;
        textureHeight = 32;

        tubeConnector = new ModelRenderer(this, 0, 0);
        tubeConnector.setRotationPoint(-3.5F, 12.5F, -3.0F);
        tubeConnector.addBox(0.0F, 0.0F, 0.0F, 7, 7, 4);
        tubeConnector.mirror = true;

        valve1 = new ModelRenderer(this, 0, 11);
        valve1.setRotationPoint(-2.0F, 14.0F, 4.0F);
        valve1.addBox(-0.5F, -0.5F, -3.0F, 5, 5, 4);
        valve1.mirror = true;

        valve2 = new ModelRenderer(this, 0, 21);
        valve2.setRotationPoint(-2.0F, 14.0F, 4.0F);
        valve2.addBox(-1.0F, -1.0F, 1.0F, 6, 6, 2);
        valve2.mirror = true;
    }

    @Override
    protected void renderDynamic(float scale, float partialTicks) {
        tubeConnector.render(scale);
        valve1.render(scale);
        valve2.render(scale);
    }

    @Override
    protected ResourceLocation getTexture() {
        ResourceLocation texture;
        if (module.isUpgraded()) {
            texture = TexturesNew.MODEL_REGULATOR_MODULE_UPGRADED;
        } else {
            texture = TexturesNew.MODEL_REGULATOR_MODULE;
        }
        return texture;
    }
}
