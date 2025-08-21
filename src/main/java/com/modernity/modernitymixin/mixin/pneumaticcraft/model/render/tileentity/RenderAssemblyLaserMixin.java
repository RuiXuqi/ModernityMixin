package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyLaserNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyLaser;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyLaser;
import me.desht.pneumaticcraft.common.tileentity.TileEntityAssemblyDrill;
import me.desht.pneumaticcraft.common.tileentity.TileEntityAssemblyLaser;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderAssemblyLaser.class, remap = false)
public class RenderAssemblyLaserMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyLaser model = new ModelAssemblyLaserNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyLaser;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityAssemblyLaser te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_ASSEMBLY_LASER_AND_DRILL);
    }

}
