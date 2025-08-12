package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.api.client.assemblymachine.IAssemblyRenderOverriding;
import me.desht.pneumaticcraft.client.GuiRegistry;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyIOUnit;
import me.desht.pneumaticcraft.client.render.tileentity.AbstractModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;

public class ModelAssemblyIOUnitNew extends ModelAssemblyIOUnit {
    private final ModelRenderer baseTurn;
    private final ModelRenderer baseTurn2_0;
    private final ModelRenderer baseTurn2_1;
    private final ModelRenderer armBase;
    private final ModelRenderer armMiddle;
    private final ModelRenderer clawBase;
    private final ModelRenderer clawAxle;
    private final ModelRenderer clawTurn;
    private final ModelRenderer claw1;
    private final ModelRenderer claw2;

    private RenderEntityItem customRenderer = null;
    // the backported number should be doubled
    private static final float ITEM_SCALE = 1.0F;

    public ModelAssemblyIOUnitNew() {
        textureWidth = 64;
        textureHeight = 64;

        baseTurn = new ModelRenderer(this, 0, 0);
        baseTurn.setRotationPoint(-3.5F, 22.0F, -3.5F);
        baseTurn.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 9, 1, 9);
        baseTurn.mirror = true;

        baseTurn2_0 = new ModelRenderer(this, 0, 0);
        baseTurn2_0.setRotationPoint(-2.0F, 17.0F, -2.0F);
        baseTurn2_0.setTextureOffset(0, 30).addBox(-2.0F, -0.5F, 0.5F, 2, 6, 3, 0.2F);

        baseTurn2_1 = new ModelRenderer(this, 0, 0);
        baseTurn2_1.setRotationPoint(-2.0F, 17.0F, -2.0F);
        baseTurn2_1.setTextureOffset(0, 10).addBox(-2.0F, 3.75F, -2.0F, 2, 2, 8);
        baseTurn2_1.setTextureOffset(10, 30).addBox(4.0F, -0.5F, 0.5F, 2, 6, 3, 0.2F);
        baseTurn2_1.setTextureOffset(0, 20).addBox(4.0F, 3.75F, -2.0F, 2, 2, 8);
        baseTurn2_1.mirror = true;

        armBase = new ModelRenderer(this, 0, 0);
        armBase.setRotationPoint(-3.0F, 17.0F, -1.0F);
        armBase.setTextureOffset(0, 49).addBox(2.0F, 0.0F, 1.0F, 2, 2, 5, 0.3F);
        armBase.setTextureOffset(0, 43).addBox(1.5F, -0.5F, -0.5F, 3, 3, 3);
        armBase.setTextureOffset(12, 43).addBox(1.5F, -0.5F, 5.5F, 3, 3, 3);
        armBase.setTextureOffset(0, 39).addBox(-1.5F, 0.0F, 0.0F, 9, 2, 2);
        armBase.mirror = true;

        armMiddle = new ModelRenderer(this, 0, 0);
        armMiddle.setRotationPoint(-4.0F, 2.0F, 5.0F);
        armMiddle.setTextureOffset(20, 10).addBox(0.0F, 2.0F, 0.0F, 2, 13, 2);
        armMiddle.setTextureOffset(12, 24).addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.3F);
        armMiddle.setTextureOffset(0, 24).addBox(0.0F, 15.0F, 0.0F, 2, 2, 2, 0.3F);
        armMiddle.setTextureOffset(14, 52).addBox(-0.5F, 15.0F, 0.0F, 3, 2, 2);
        armMiddle.mirror = true;


        clawBase = new ModelRenderer(this, 0, 0);
        clawBase.setRotationPoint(-1.0F, 2.0F, 4.5F);
        clawBase.setTextureOffset(46, 0).addBox(-1.0F, -1.0F, 0.0F, 4, 4, 5);
        clawBase.mirror = true;

        clawAxle = new ModelRenderer(this, 0, 0);
        clawAxle.setRotationPoint(-0.5F, 2.5F, 4.0F);
        clawAxle.setTextureOffset(58, 9).addBox(-0.5F, -0.5F, 0.0F, 2, 2, 1);
        clawAxle.mirror = true;

        clawTurn = new ModelRenderer(this, 0, 0);
        clawTurn.setRotationPoint(-2.0F, 2.0F, 3.0F);
        clawTurn.setTextureOffset(54, 12).addBox(0.0F, -0.5F, 0.0F, 4, 3, 1, 0.1F);
        clawTurn.mirror = true;

        claw1 = new ModelRenderer(this, 0, 0);
        claw1.setRotationPoint(0.0F, 2.0F, 2.25F);
        claw1.setTextureOffset(52, 21).addBox(-0.1F, -0.5F, -1.35F, 1, 3, 2, -0.1F);
        claw1.setTextureOffset(58, 21).addBox(0.25F, 0.0F, -1.35F, 1, 2, 2);
        claw1.mirror = true;

        claw2 = new ModelRenderer(this, 0, 0);
        claw2.setRotationPoint(-1.0F, 2.0F, 2.25F);
        claw2.setTextureOffset(52, 16).addBox(0.1F, -0.5F, -1.35F, 1, 3, 2, -0.1F);
        claw2.setTextureOffset(58, 16).addBox(-0.25F, 0.0F, -1.35F, 1, 2, 2);
        claw2.mirror = true;
    }

    public void renderModel(float size, float[] angles, float clawProgress, EntityItem carriedItem) {
        float clawTrans;

        if (customRenderer == null) {
            customRenderer = new AbstractModelRenderer.NoBobItemRenderer();
        }

        IAssemblyRenderOverriding renderOverride = null;
        if (carriedItem != null) {
            renderOverride = GuiRegistry.renderOverrides.get(carriedItem.getItem().getItem().getRegistryName());
            if (renderOverride != null) {
                clawTrans = renderOverride.getIOUnitClawShift(carriedItem.getItem());
            } else {
                if (carriedItem.getItem().getItem() instanceof ItemBlock) {
                    clawTrans = 1.5F / 16F - clawProgress * 0.1F / 16F;
                } else {
                    clawTrans = 1.5F / 16F - clawProgress * 1.4F / 16F;
                }
            }
        } else {
            clawTrans = 1.5F / 16F - clawProgress * 1.5F / 16F;
        }

        GlStateManager.pushMatrix();

        GlStateManager.rotate(angles[0], 0, 1, 0);

        baseTurn.render(size);
        baseTurn2_0.render(size);
        baseTurn2_1.render(size);

        GlStateManager.translate(0, 18 / 16F, 0);
        GlStateManager.rotate(angles[1], 1, 0, 0);
        GlStateManager.translate(0, -18 / 16F, 0);

        armBase.render(size);

        GlStateManager.translate(0, 18 / 16F, 6 / 16F);
        GlStateManager.rotate(angles[2], 1, 0, 0);
        GlStateManager.translate(0, -18 / 16F, -6 / 16F);

        armMiddle.render(size);

        GlStateManager.translate(0, 3 / 16F, 6 / 16F);
        GlStateManager.rotate(angles[3], 1, 0, 0);
        GlStateManager.translate(0, -3 / 16F, -6 / 16F);

        clawBase.render(size);

        GlStateManager.translate(0, 3 / 16F, 0);
        GlStateManager.rotate(angles[4], 0, 0, 1);
        GlStateManager.translate(0, -3 / 16F, 0);

        clawAxle.render(size);
        clawTurn.render(size);

        GlStateManager.pushMatrix();
        GlStateManager.translate(clawTrans, 0, 0);

        claw1.render(size);

        GlStateManager.translate(-2 * clawTrans, 0, 0);

        claw2.render(size);

        GlStateManager.popMatrix();

        if (carriedItem != null) {
            if (renderOverride == null || renderOverride.applyRenderChangeIOUnit(carriedItem.getItem())) {
                GlStateManager.rotate(90, 1, 0, 0);
                double yOffset = carriedItem.getItem().getItem() instanceof ItemBlock ? 1.5 / 16D : 0.5 / 16D;
                GlStateManager.translate(0, yOffset - 0.2, -3 / 16D);
                GlStateManager.rotate(-90, 0, 1, 0);
                GlStateManager.scale(ITEM_SCALE, ITEM_SCALE, ITEM_SCALE);
                customRenderer.doRender(carriedItem, 0, 0, 0, 0, 0);
            }
        }

        GlStateManager.popMatrix();
    }
}
