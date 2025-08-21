package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelDoorBaseNew;
import me.desht.pneumaticcraft.client.model.block.ModelDoorBase;
import me.desht.pneumaticcraft.client.render.tileentity.RenderPneumaticDoorBase;
import me.desht.pneumaticcraft.common.tileentity.TileEntityElevatorBase;
import me.desht.pneumaticcraft.common.tileentity.TileEntityPneumaticDoorBase;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderPneumaticDoorBase.class, remap = false)
public class RenderPneumaticDoorBaseMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelDoorBase model = new ModelDoorBaseNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityPneumaticDoorBase;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityPneumaticDoorBase te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_PNEUMATIC_DOOR_BASE);
    }

}
