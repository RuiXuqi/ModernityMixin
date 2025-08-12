package com.modernity.modernitymixin.pneumaticcraft.model.block;

import me.desht.pneumaticcraft.client.model.block.ModelAirCannon;
import me.desht.pneumaticcraft.client.render.tileentity.AbstractModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModelAirCannon.class, remap = false)
public class ModelAirCannonMixin extends AbstractModelRenderer.BaseModel {
    @Unique
    private ModelRenderer modernityMixin$baseTurn;
    @Unique
    private ModelRenderer modernityMixin$baseFrame1;
    @Unique
    private ModelRenderer modernityMixin$baseFrame2;
    @Unique
    private ModelRenderer modernityMixin$axis;
    @Unique
    private ModelRenderer modernityMixin$cannon;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void ModelAirCannonNew(CallbackInfo ci) {
        textureWidth = 64;
        textureHeight = 64;

        modernityMixin$baseTurn = new ModelRenderer(this, 0, 0);
        modernityMixin$baseTurn.setRotationPoint(-3.5F, 20.0F, -5.0F);
        modernityMixin$baseTurn.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 7, 1, 7);

        modernityMixin$baseFrame1 = new ModelRenderer(this, 0, 0);
        modernityMixin$baseFrame1.setRotationPoint(-3.5F, 15.0F, -3.0F);
        modernityMixin$baseFrame1.setTextureOffset(28, 0).addBox(0.0F, 0.0F, 0.0F, 1, 5, 3);
        modernityMixin$baseFrame1.mirror = true;

        modernityMixin$baseFrame2 = new ModelRenderer(this, 0, 0);
        modernityMixin$baseFrame2.setRotationPoint(2.5F, 15.0F, -3.0F);
        modernityMixin$baseFrame2.setTextureOffset(36, 0).addBox(0.0F, 0.0F, 0.0F, 1, 5, 3);
        modernityMixin$baseFrame2.mirror = true;

        modernityMixin$axis = new ModelRenderer(this, 0, 0);
        modernityMixin$axis.setRotationPoint(-3.0F, 15.5F, -2.0F);
        modernityMixin$axis.setTextureOffset(44, 4).addBox(-1.0F, 0.0F, -0.5F, 8, 2, 2, -0.2F);
        modernityMixin$axis.mirror = true;

        modernityMixin$cannon = new ModelRenderer(this, 0, 0);
        modernityMixin$cannon.setRotationPoint(-1.0F, 15.0F, -2.5F);
        modernityMixin$cannon.setTextureOffset(0, 8).addBox(-1.0F, 0.0F, -1.0F, 4, 4, 4);
        modernityMixin$cannon.setTextureOffset(24, 8).addBox(-0.5F, -2.0F, -0.5F, 3, 2, 3);
        modernityMixin$cannon.setTextureOffset(36, 8).addBox(-1.0F, -3.75F, -0.5F, 1, 2, 3, -0.2F);
        modernityMixin$cannon.setTextureOffset(44, 8).addBox(2.0F, -3.75F, -0.5F, 1, 2, 3, -0.2F);
        modernityMixin$cannon.setTextureOffset(44, 13).addBox(-1.0F, -3.75F, -1.0F, 4, 2, 1, -0.2F);
        modernityMixin$cannon.setTextureOffset(34, 13).addBox(-1.0F, -3.75F, 2.0F, 4, 2, 1, -0.2F);
        modernityMixin$cannon.mirror = true;
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public void renderModel(float size, float rotationAngle, float heightAngle) {
        GlStateManager.pushMatrix();

        GlStateManager.translate(0.0, 0.0, -0.09375D);
        GlStateManager.rotate(rotationAngle, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0, 0.0, 0.09375D);
        modernityMixin$baseTurn.render(size);
        modernityMixin$baseFrame1.render(size);
        modernityMixin$baseFrame2.render(size);
        modernityMixin$axis.render(size);

        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0D, 1.0D, -0.09375D);
        GlStateManager.rotate(heightAngle, 1.0F, 0.0F, 0.0F);
        GlStateManager.translate(0.0D, -1.0D, 0.09375D);
        modernityMixin$cannon.render(size);
        GlStateManager.popMatrix();

        GlStateManager.popMatrix();
    }
}
