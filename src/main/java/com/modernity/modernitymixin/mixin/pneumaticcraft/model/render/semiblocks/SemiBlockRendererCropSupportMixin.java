package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.semiblocks;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.semiblocks.ModelCropSupportNew;
import me.desht.pneumaticcraft.client.model.semiblocks.ModelCropSupport;
import me.desht.pneumaticcraft.client.semiblock.SemiBlockRendererCropSupport;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = SemiBlockRendererCropSupport.class, remap = false)
public class SemiBlockRendererCropSupportMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelCropSupport model = new ModelCropSupportNew();

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
