package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAirCannonNew;
import me.desht.pneumaticcraft.client.model.block.ModelAirCannon;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAirCannon;
import me.desht.pneumaticcraft.common.tileentity.TileEntityAirCannon;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderAirCannon.class, remap = false)
public class RenderAirCannonMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAirCannon model = new ModelAirCannonNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAirCannon;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityAirCannon te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_AIR_CANNON);
    }

}
