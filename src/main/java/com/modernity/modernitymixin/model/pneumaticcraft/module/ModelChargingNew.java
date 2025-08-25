package com.modernity.modernitymixin.model.pneumaticcraft.module;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.common.block.tubes.ModuleCharging;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class ModelChargingNew extends ModelModuleBase {
    private final ModuleCharging chargingModule;
    private final ModelRenderer tip;
    private final ModelRenderer body;
    private final ModelRenderer tubeConnector;
    private final ModelRenderer tipBottom;
    private final ModelRenderer tipTop;
    private final ModelRenderer tipRight;
    private final ModelRenderer tipLeft;

    public ModelChargingNew(ModuleCharging charging) {
        this.chargingModule = charging;
        textureWidth = 32;
        textureHeight = 32;

        tip = new ModelRenderer(this, 0, 11);
        tip.setRotationPoint(1.0F, 15.0F, 8.0F);
        setRotation(tip, 0.0F, 3.1416F, 0.0F);
        tip.addBox(0.0F, 0.0F, 1.5F, 2, 2, 1);
        tip.mirror = true;

        body = new ModelRenderer(this, 0, 6);
        body.setRotationPoint(1.5F, 14.5F, 6.0F);
        setRotation(body, 0.0F, 3.1416F, 0.0F);
        body.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2);
        body.mirror = true;

        tubeConnector = new ModelRenderer(this, 0, 0);
        tubeConnector.setRotationPoint(2.0F, 14.0F, 4.0F);
        setRotation(tubeConnector, 0.0F, 3.1416F, 0.0F);
        tubeConnector.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2);
        tubeConnector.mirror = true;

        tipBottom = new ModelRenderer(this, 0, 18);
        tipBottom.setRotationPoint(-1.0F, 15.0F, 7.0F);
        tipBottom.addBox(0.0F, 2.0F, -0.5F, 2, 0, 1);

        tipTop = new ModelRenderer(this, 0, 14);
        tipTop.setRotationPoint(-1.0F, 15.0F, 7.0F);
        tipTop.addBox(0.0F, 0.0F, -0.5F, 2, 0, 1);

        tipRight = new ModelRenderer(this, 2, 15);
        tipRight.setRotationPoint(-1.0F, 16.0F, 7.0F);
        tipRight.addBox(0.0F, -1.0F, -0.5F, 0, 2, 1);

        tipLeft = new ModelRenderer(this, 0, 15);
        tipLeft.setRotationPoint(1.0F, 16.0F, 7.0F);
        tipLeft.addBox(0.0F, -1.0F, -0.5F, 0, 2, 1);
    }

    @Override
    protected void renderDynamic(float scale, float partialTicks) {
        tip.render(scale);
        body.render(scale);
        tubeConnector.render(scale);
        tipBottom.render(scale);
        tipTop.render(scale);
        tipRight.render(scale);
        tipLeft.render(scale);
    }

    @Override
    protected ResourceLocation getTexture() {
        ResourceLocation texture;
        if (chargingModule.isUpgraded()) {
            texture = TexturesNew.MODEL_CHARGING_MODULE_UPGRADED;
        } else {
            texture = TexturesNew.MODEL_CHARGING_MODULE;
        }
        return texture;
    }
}
