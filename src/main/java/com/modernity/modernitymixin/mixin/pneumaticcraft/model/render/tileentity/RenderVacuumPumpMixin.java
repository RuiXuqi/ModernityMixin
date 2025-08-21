package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelVacuumPumpNew;
import me.desht.pneumaticcraft.client.model.block.ModelVacuumPump;
import me.desht.pneumaticcraft.client.render.tileentity.RenderVacuumPump;
import me.desht.pneumaticcraft.common.tileentity.TileEntityUniversalSensor;
import me.desht.pneumaticcraft.common.tileentity.TileEntityVacuumPump;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = RenderVacuumPump.class, remap = false)
public class RenderVacuumPumpMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelVacuumPump model = new ModelVacuumPumpNew();

    @ModifyArgs(
            method = "renderModel*",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/GlStateManager;rotate(FFFF)V"
            )
    )
    private void modifyRotateArgs(Args args) {
        args.set(1, 1.0F);
        args.set(2, 0.0F);
    }

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityVacuumPump;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityVacuumPump te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_VACUUM_PUMP);
    }

}
