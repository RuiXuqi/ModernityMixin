package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyDrillNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyDrill;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyDrill;
import me.desht.pneumaticcraft.common.tileentity.TileEntityAssemblyDrill;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderAssemblyDrill.class, remap = false)
public class RenderAssemblyDrillMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyDrill model = new ModelAssemblyDrillNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyDrill;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityAssemblyDrill te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_ASSEMBLY_LASER_AND_DRILL);
    }

}
