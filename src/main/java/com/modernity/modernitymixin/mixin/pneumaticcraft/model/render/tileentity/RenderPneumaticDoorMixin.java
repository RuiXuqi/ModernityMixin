package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelDoorNew;
import me.desht.pneumaticcraft.client.model.block.ModelDoor;
import me.desht.pneumaticcraft.client.render.tileentity.RenderPneumaticDoor;
import me.desht.pneumaticcraft.common.tileentity.TileEntityPneumaticDoor;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderPneumaticDoor.class, remap = false)
public class RenderPneumaticDoorMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelDoor modelDoor = new ModelDoorNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityPneumaticDoor;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityPneumaticDoor te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_PNEUMATIC_DOOR_DYNAMIC);
    }

}
