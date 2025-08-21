package com.modernity.modernitymixin.model.pneumaticcraft.module;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.client.util.RenderUtils;
import me.desht.pneumaticcraft.common.block.tubes.ModuleRedstone;
import me.desht.pneumaticcraft.lib.Textures;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemDye;
import net.minecraft.util.ResourceLocation;

public class ModelRedstoneNew extends ModelModuleBase {
    private final ModuleRedstone module;
    private final ModelRenderer redstoneConnector;
    private final ModelRenderer faceplate;
    private final ModelRenderer tubeConnector1;
    private final ModelRenderer tubeConnector2;
    private final ModelRenderer tubeConnector3;
    private final ModelRenderer tubeConnector4;
    private final ModelRenderer tubeConnector5;
    private final ModelRenderer tubeConnector6;
    private final ModelRenderer frame1;
    private final ModelRenderer frame2;
    private final ModelRenderer frame3;
    private final ModelRenderer frame4;



    public ModelRedstoneNew(ModuleRedstone module) {
        this.module = module;
        textureWidth = 64;
        textureHeight = 64;

        frame1 = new ModelRenderer(this, 32, 0);
        frame1.setRotationPoint(-4.0F, 11.5F, 6.0F);
        frame1.addBox(2.0F, 1.5F, -3.75F, 4, 1, 4);

        frame2 = new ModelRenderer(this, 32, 5);
        frame2.setRotationPoint(-4.0F, 19.5F, 6.0F);
        frame2.addBox(2.0F, -1.5F, -3.75F, 4, 1, 4);

        frame3 = new ModelRenderer(this, 0, 6);
        frame3.setRotationPoint(3.5F, 12.5F, 6.0F);
        frame3.addBox(-1.5F, 0.5F, -3.75F, 1, 6, 4);

        frame4 = new ModelRenderer(this, 0, 16);
        frame4.setRotationPoint(-4.5F, 12.5F, 6.0F);
        frame4.addBox(1.5F, 0.5F, -3.75F, 1, 6, 4);

        tubeConnector1 = new ModelRenderer(this, 12, 10);
        tubeConnector1.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector1.addBox(-2.0F, -2.0F, 1.0F, 7, 7, 1);

        tubeConnector2 = new ModelRenderer(this, 12, 18);
        tubeConnector2.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector2.addBox(-1.0F, -1.0F, 0.0F, 5, 5, 1);

        tubeConnector3 = new ModelRenderer(this, 28, 12);
        tubeConnector3.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector3.addBox(4.0F, 0.0F, 0.0F, 1, 3, 1);

        tubeConnector4 = new ModelRenderer(this, 28, 16);
        tubeConnector4.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector4.addBox(0.0F, 4.0F, 0.0F, 3, 1, 1);

        tubeConnector5 = new ModelRenderer(this, 32, 12);
        tubeConnector5.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector5.addBox(-2.0F, 0.0F, 0.0F, 1, 3, 1);

        tubeConnector6 = new ModelRenderer(this, 28, 10);
        tubeConnector6.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector6.addBox(0.0F, -2.0F, 0.0F, 3, 1, 1);

        faceplate = new ModelRenderer(this, 12, 0);
        faceplate.setRotationPoint(-4.0F, 12.0F, 5.0F);
        faceplate.addBox(0.0F, 0.0F, -1.0F, 8, 8, 2);

        redstoneConnector = new ModelRenderer(this, 0, 0);
        redstoneConnector.setRotationPoint(-1.5F, 14.5F, 6.05F);
        redstoneConnector.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
    }

    @Override
    protected void renderDynamic(float scale, float partialTicks) {
        tubeConnector1.render(scale);
        tubeConnector2.render(scale);
        tubeConnector3.render(scale);
        tubeConnector4.render(scale);
        tubeConnector5.render(scale);
        tubeConnector6.render(scale);
        faceplate.render(scale);


        if (!module.isFake()) {
            int l = module.getRedstoneDirection() == ModuleRedstone.EnumRedstoneDirection.INPUT ? module.getInputLevel() : module.getRedstoneLevel();
            RenderUtils.glColorHex(0xFF300000 | (l * 13 << 16));
            GlStateManager.pushMatrix();
            GlStateManager.translate(0, 0, 5.2f / 16f);
            GlStateManager.scale(1, 1, 0.25f + 0.75f * (module.lastExtension + (module.extension - module.lastExtension) * partialTicks));
            GlStateManager.translate(0, 0, -5.2f / 16f);
        }
        redstoneConnector.render(scale);
        if (!module.isFake()) {
            GlStateManager.popMatrix();
        }

        RenderUtils.glColorHex(0xFF000000 | ItemDye.DYE_COLORS[module.getColorChannel()]);
        frame1.render(scale);
        frame2.render(scale);
        frame3.render(scale);
        frame4.render(scale);
    }

    @Override
    protected ResourceLocation getTexture() {
        ResourceLocation texture;
        if (module.isUpgraded()) {
            texture = TexturesNew.MODEL_REDSTONE_MODULE_UPGRADED;
        } else {
            texture = TexturesNew.MODEL_REDSTONE_MODULE;
        }
        return texture;
    }
}
