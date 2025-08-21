package com.modernity.modernitymixin.model.pneumaticcraft.module;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.client.util.RenderUtils;
import me.desht.pneumaticcraft.common.block.tubes.ModuleLogistics;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemDye;
import net.minecraft.util.ResourceLocation;

public class ModelLogisticsNew extends ModelModuleBase {
    private final ModuleLogistics module;
    private final ModelRenderer base2;
    private final ModelRenderer shape1;
    private final ModelRenderer shape2;
    private final ModelRenderer shape3;
    private final ModelRenderer shape4;
    private final ModelRenderer notPowered, powered, action, notEnoughAir;


    public ModelLogisticsNew(ModuleLogistics module) {
        this.module = module;
        textureWidth = 64;
        textureHeight = 64;

        notPowered = new ModelRenderer(this, 24, 8);
        notPowered.addBox(0F, 0F, 0F, 6, 2, 6);
        notPowered.setRotationPoint(-3F, 13F, 4F);
        notPowered.mirror = true;
        setRotation(notPowered, -1.570796F, 0F, 0F);
        powered = new ModelRenderer(this, 0, 8);
        powered.addBox(0F, 0F, 0F, 6, 2, 6);
        powered.setRotationPoint(-3F, 13F, 4F);
        powered.mirror = true;
        setRotation(powered, -1.570796F, 0F, 0F);
        action = new ModelRenderer(this, 24, 0);
        action.addBox(0F, 0F, 0F, 6, 2, 6);
        action.setRotationPoint(-3F, 13F, 4F);
        action.mirror = true;
        setRotation(action, -1.570796F, 0F, 0F);
        notEnoughAir = new ModelRenderer(this, 0, 0);
        notEnoughAir.addBox(0F, 0F, 0F, 6, 2, 6);
        notEnoughAir.setRotationPoint(-3F, 13F, 4F);
        notEnoughAir.mirror = true;
        setRotation(notEnoughAir, -1.570796F, 0F, 0F);

        base2 = new ModelRenderer(this, 0, 25);
        base2.addBox(0F, 0F, 0F, 12, 2, 12);
        base2.setRotationPoint(-6F, 10F, 6F);
        base2.mirror = true;
        setRotation(base2, -1.570796F, 0F, 0F);

        shape1 = new ModelRenderer(this, 0, 39);
        shape1.addBox(0F, 0F, 0F, 1, 13, 1);
        shape1.setRotationPoint(5.5F, 9.5F, 5.5F);
        shape1.mirror = true;
        setRotation(shape1, 0F, 0F, 0F);

        shape2 = new ModelRenderer(this, 4, 39);
        shape2.addBox(0F, 0F, 0F, 1, 13, 1);
        shape2.setRotationPoint(-6.5F, 9.5F, 5.5F);
        shape2.mirror = true;
        setRotation(shape2, 0F, 0F, 0F);

        shape3 = new ModelRenderer(this, 8, 39);
        shape3.addBox(0F, 0F, 0F, 11, 1, 1);
        shape3.setRotationPoint(-5.5F, 9.5F, 5.5F);
        shape3.mirror = true;
        setRotation(shape3, 0F, 0F, 0F);

        shape4 = new ModelRenderer(this, 8, 41);
        shape4.addBox(0F, 0F, 0F, 11, 1, 1);
        shape4.setRotationPoint(-5.5F, 21.5F, 5.5F);
        shape4.mirror = true;
        setRotation(shape4, 0F, 0F, 0F);
    }

    private void renderChannelColorFrame(float size) {
        RenderUtils.glColorHex(0xFF000000 | ItemDye.DYE_COLORS[module.getColorChannel()]);
        shape1.render(size);
        shape2.render(size);
        shape3.render(size);
        shape4.render(size);
        GlStateManager.color(1, 1, 1, 1);
    }

    @Override
    protected void renderDynamic(float scale, float partialTicks) {
        ModelRenderer base;
        if (module.getTicksSinceAction() >= 0) {
            base = action;
        } else if (module.getTicksSinceNotEnoughAir() >= 0) {
            base = notEnoughAir;
        } else {
            base = module.hasPower() ? powered : notPowered;
        }
        base.render(scale);
        base2.render(scale);
        renderChannelColorFrame(scale);
    }

    @Override
    protected ResourceLocation getTexture() {
        return TexturesNew.MODEL_LOGISTICS_MODULE;
    }
}
