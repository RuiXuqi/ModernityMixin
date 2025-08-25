package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.semiblocks;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.semiblocks.ModelCropSupportNew;
import me.desht.pneumaticcraft.client.model.semiblocks.ModelCropSupport;
import me.desht.pneumaticcraft.client.semiblock.SemiBlockRendererCropSupport;
import me.desht.pneumaticcraft.common.config.ConfigHandler;
import me.desht.pneumaticcraft.common.semiblock.SemiBlockCropSupport;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SemiBlockRendererCropSupport.class, remap = false)
public class SemiBlockRendererCropSupportMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelCropSupport model = null;

    @Unique
    private final ModelCropSupportNew modernityMixin$modelNew = new ModelCropSupportNew();

    @Redirect(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockCropSupport;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lme/desht/pneumaticcraft/client/model/semiblocks/ModelCropSupport;render(Lnet/minecraft/entity/Entity;FFFFFF)V"
            )
    )
    private void modifyModel(ModelCropSupport instance, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.modernityMixin$modelNew.render(entity, f, f1, f2, f3, f4, f5);
    }

    @ModifyArg(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockCropSupport;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V"
            )
    )
    private ResourceLocation modifyTexture(ResourceLocation original) {
        return TexturesNew.MODEL_CROP_SUPPORT;
    }

    @Inject(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockCropSupport;F)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void modifyRender(SemiBlockCropSupport semiBlock, float partialTick, CallbackInfo ci) {
        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        Minecraft.getMinecraft().renderEngine.bindTexture(TexturesNew.MODEL_CROP_SUPPORT);

        // Set light
        float lightMul = this.modernityMixin$getLightMultiplier(semiBlock);
        GlStateManager.color(lightMul, lightMul, lightMul, 1.0F);

        // Tweak scale
        AxisAlignedBB aabb = new AxisAlignedBB(0.1875F, 0.1875F, 0.1875F, 0.8125F, 0.8125F, 0.8125F);
        GlStateManager.translate(aabb.minX, aabb.minY, aabb.minZ);
        GlStateManager.scale(aabb.maxX - aabb.minX, aabb.maxY - aabb.minY, aabb.maxZ - aabb.minZ);

        GlStateManager.rotate(180, 1, 0, 0);
        GlStateManager.translate(0, -1, -1);

        GlStateManager.translate(0.5F, -0.5F, 0.5F);
        
        GlStateManager.translate(0, 0.3F, 0);

        this.modernityMixin$modelNew.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        ci.cancel();
    }

    @Unique
    private float modernityMixin$getLightMultiplier(SemiBlockCropSupport semiBlock) {
        return ConfigHandler.client.semiBlockLighting ? Math.max(0.05F, (float) Minecraft.getMinecraft().world.getLight(semiBlock.getPos()) / 15.0F) : 1.0F;
    }

}
