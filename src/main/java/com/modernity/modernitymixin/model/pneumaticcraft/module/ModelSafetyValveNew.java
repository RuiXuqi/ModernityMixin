package com.modernity.modernitymixin.model.pneumaticcraft.module;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.common.block.tubes.ModuleSafetyValve;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class ModelSafetyValveNew extends ModelModuleBase {
    private final ModuleSafetyValve valveModule;
    private final ModelRenderer tubeConnector;
    private final ModelRenderer valve0;
    private final ModelRenderer valveHandle;
    private final ModelRenderer valveLid;


    public ModelSafetyValveNew(ModuleSafetyValve valve){
        this.valveModule = valve;
        textureWidth = 32;
        textureHeight = 32;

        tubeConnector = new ModelRenderer(this, 0, 0);
        tubeConnector.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector.addBox(-0.5F, -0.5F, 0.0F, 4, 4, 2);
        tubeConnector.mirror = true;

        valve0 = new ModelRenderer(this, 0, 6);
        valve0.setRotationPoint(-1.0F, 15.0F, 4.0F);
        valve0.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
        valve0.mirror = true;

        valveHandle = new ModelRenderer(this, 0, 16);
        valveHandle.setRotationPoint(2.0F, 15.5F, 4.0F);
        setRotation(valveHandle, 0.0F, -0.5934F, 0.0F);
        valveHandle.addBox(0.5592F, 0.0F, 0.829F, 1, 1, 3);
        valveHandle.mirror = true;

        valveLid = new ModelRenderer(this, 0, 12);
        valveLid.setRotationPoint(1.5F, 15.5F, 7.25F);
        valveLid.addBox(-3.0F, -1.0F, 0.0F, 3, 3, 1);
    }

    @Override
    protected void renderDynamic(float scale, float partialTicks) {
        tubeConnector.render(scale);
        valve0.render(scale);
        valveHandle.render(scale);
        valveLid.render(scale);
    }

    @Override
    protected ResourceLocation getTexture() {
        ResourceLocation texture;
        if (valveModule != null && valveModule.isUpgraded()) {
            texture = TexturesNew.MODEL_SAFETY_VALVE_UPGRADED;
        } else {
            texture = TexturesNew.MODEL_SAFETY_VALVE;
        }
        return texture;
    }
}
