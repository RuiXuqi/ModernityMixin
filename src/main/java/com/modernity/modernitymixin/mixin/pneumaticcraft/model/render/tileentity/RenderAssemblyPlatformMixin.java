package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyPlatformNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyPlatform;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyPlatform;
import me.desht.pneumaticcraft.common.tileentity.TileEntityAssemblyPlatform;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderAssemblyPlatform.class, remap = false)
public class RenderAssemblyPlatformMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyPlatform model = new ModelAssemblyPlatformNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyPlatform;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityAssemblyPlatform te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_ASSEMBLY_PLATFORM);
    }

}
