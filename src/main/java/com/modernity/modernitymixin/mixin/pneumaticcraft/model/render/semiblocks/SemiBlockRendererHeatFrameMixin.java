package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.semiblocks;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.semiblocks.ModelHeatFrameNew;
import me.desht.pneumaticcraft.client.model.semiblocks.ModelHeatFrame;
import me.desht.pneumaticcraft.client.semiblock.SemiBlockRendererHeatFrame;
import me.desht.pneumaticcraft.common.semiblock.SemiBlockHeatFrame;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = SemiBlockRendererHeatFrame.class, remap = false)
public class SemiBlockRendererHeatFrameMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelHeatFrame model = null;

    @Unique
    private final ModelHeatFrameNew modernityMixin$modelNew = new ModelHeatFrameNew();

    @Shadow
    private native float getLightMultiplier(SemiBlockHeatFrame semiBlock);

    @Unique
    private float modernityMixin$lightMul;

    @Unique
    private double modernityMixin$heatLevel;

    @Redirect(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockHeatFrame;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lme/desht/pneumaticcraft/client/model/semiblocks/ModelHeatFrame;render(Lnet/minecraft/entity/Entity;FFFFFF)V"
            )
    )
    private void modifyModel(ModelHeatFrame instance, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.modernityMixin$modelNew.render(entity, f, f1, f2, f3, f4, f5);
    }

    // TODO: Get temperature
    @ModifyArg(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockHeatFrame;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V"
            )
    )
    private ResourceLocation modifyTexture(ResourceLocation original) {
        if (modernityMixin$heatLevel == 0) {
            return TexturesNew.MODEL_HEAT_FRAME_SUPER_COLD;
        } else if (modernityMixin$heatLevel <= 7) {
            return TexturesNew.MODEL_HEAT_FRAME_VERY_COLD;
        } else if (modernityMixin$heatLevel < 10) {
            return TexturesNew.MODEL_HEAT_FRAME_COLD;
        } else if (modernityMixin$heatLevel < 11) {
            return TexturesNew.MODEL_HEAT_FRAME_COOL;
        } else if (modernityMixin$heatLevel < 13) {
            return TexturesNew.MODEL_HEAT_FRAME_NORMAL;
        } else if (modernityMixin$heatLevel < 15) {
            return TexturesNew.MODEL_HEAT_FRAME_WARM;
        } else if (modernityMixin$heatLevel < 16) {
            return TexturesNew.MODEL_HEAT_FRAME_HOT;
        } else if (modernityMixin$heatLevel < 17) {
            return TexturesNew.MODEL_HEAT_FRAME_VERY_HOT;
        } else {
            return TexturesNew.MODEL_HEAT_FRAME_SUPER_HOT;
        }
    }

    @Inject(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockHeatFrame;F)V",
            at = @At("HEAD")
    )
    private void getSemiblock(SemiBlockHeatFrame semiBlock, float partialTick, CallbackInfo ci) {
        this.modernityMixin$lightMul = this.getLightMultiplier(semiBlock);
        this.modernityMixin$heatLevel = semiBlock.getHeatLevel();
    }

    @ModifyArgs(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockHeatFrame;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/GlStateManager;color(FFFF)V",
                    ordinal = 0
            )
    )
    private void modifyColor(Args args) {
        args.set(0, modernityMixin$lightMul);
        args.set(1, modernityMixin$lightMul);
        args.set(2, modernityMixin$lightMul);
    }

}
