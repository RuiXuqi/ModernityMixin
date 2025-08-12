package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.api.client.assemblymachine.IAssemblyRenderOverriding;
import me.desht.pneumaticcraft.client.GuiRegistry;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyPlatform;
import me.desht.pneumaticcraft.client.render.tileentity.AbstractModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;

public class ModelAssemblyPlatformNew extends ModelAssemblyPlatform {
    private final ModelRenderer claw1;
    private final ModelRenderer claw2;

    private RenderEntityItem customRenderItem = null;
    // the backported number should be doubled
    private static final float ITEM_SCALE = 1.0F;

    public ModelAssemblyPlatformNew() {
        textureWidth = 64;
        textureHeight = 64;

        claw1 = new ModelRenderer(this, 0, 0);
        claw1.setRotationPoint(-1.0F, 17.0F, 0.0F);
        claw1.setTextureOffset(0, 12).addBox(-0.5F, 0.0F, 0.1F, 3, 1, 1, -0.1F);
        claw1.setTextureOffset(8, 14).addBox(-0.5F, 0.0F, 0.6F, 3, 1, 1);

        claw2 = new ModelRenderer(this, 0, 0);
        claw2.setRotationPoint(-1.0F, 17.0F, -1.0F);
        claw2.setTextureOffset(0, 14).addBox(-0.5F, 0.0F, -0.1F, 3, 1, 1, -0.1F);
        claw2.setTextureOffset(8, 12).addBox(-0.5F, 0.0F, -0.6F, 3, 1, 1);
    }

    public void renderModel(float size, float progress, EntityItem carriedItem) {
        float clawTrans;

        if (customRenderItem == null) {
            customRenderItem = new AbstractModelRenderer.NoBobItemRenderer();
        }

        IAssemblyRenderOverriding renderOverride = null;
        if (carriedItem != null) {
            renderOverride = GuiRegistry.renderOverrides.get(carriedItem.getItem().getItem().getRegistryName());
            if(renderOverride != null) {
                clawTrans = renderOverride.getPlatformClawShift(carriedItem.getItem());
            } else {
                if (carriedItem.getItem().getItem() instanceof ItemBlock) {
                    clawTrans = 1.5F / 16F - progress * 0.1F / 16F;
                } else {
                    clawTrans = 1.5F / 16F - progress * 1.4F / 16F;
                }
            }
        } else {
            clawTrans = 1.5F / 16F - progress * 1.5F / 16F;
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate(0, 0, clawTrans);
        claw1.render(size);
        GlStateManager.translate(0, 0, -2 * clawTrans);
        claw2.render(size);
        GlStateManager.popMatrix();

        if (carriedItem != null) {
            if (renderOverride == null || renderOverride.applyRenderChangePlatform(carriedItem.getItem())) {
                GlStateManager.rotate(180, 1, 0, 0);
                double yOffset = carriedItem.getItem().getItem() instanceof ItemBlock ? -16.5 / 16F : -17.5 / 16F;
                GlStateManager.translate(0, yOffset - 0.2, 0);
                GlStateManager.scale(ITEM_SCALE, ITEM_SCALE, ITEM_SCALE);
                customRenderItem.doRender(carriedItem, 0, 0, 0, 0, 0);
            }
        }
    }
}
