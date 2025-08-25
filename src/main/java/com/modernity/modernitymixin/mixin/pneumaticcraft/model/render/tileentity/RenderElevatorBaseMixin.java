package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelElevatorBaseNew;
import me.desht.pneumaticcraft.client.model.block.ModelElevatorBase;
import me.desht.pneumaticcraft.client.render.tileentity.RenderElevatorBase;
import me.desht.pneumaticcraft.common.tileentity.TileEntityElevatorBase;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderElevatorBase.class, remap = false)
public class RenderElevatorBaseMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelElevatorBase model = new ModelElevatorBaseNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityElevatorBase;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityElevatorBase te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_ELEVATOR);
    }

}
