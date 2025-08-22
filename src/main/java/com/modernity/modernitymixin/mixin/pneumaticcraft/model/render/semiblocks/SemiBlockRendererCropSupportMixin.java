package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.semiblocks;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.semiblocks.ModelCropSupportNew;
import me.desht.pneumaticcraft.client.model.semiblocks.ModelCropSupport;
import me.desht.pneumaticcraft.client.semiblock.SemiBlockRendererCropSupport;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

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

}
