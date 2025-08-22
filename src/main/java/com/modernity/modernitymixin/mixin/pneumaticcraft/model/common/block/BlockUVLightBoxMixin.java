package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block;

import me.desht.pneumaticcraft.common.block.BlockUVLightBox;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockUVLightBox.class, remap = false)
public class BlockUVLightBoxMixin {

    @Inject(method = "getRenderLayer", at = @At("HEAD"), cancellable = true)
    public void modifyIcon(CallbackInfoReturnable<BlockRenderLayer> cir) {
        cir.setReturnValue(BlockRenderLayer.TRANSLUCENT);
    }

}
