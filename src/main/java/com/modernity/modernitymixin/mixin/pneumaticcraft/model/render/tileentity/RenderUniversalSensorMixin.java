package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelUniversalSensorNew;
import me.desht.pneumaticcraft.client.model.block.ModelUniversalSensor;
import me.desht.pneumaticcraft.client.render.tileentity.RenderUniversalSensor;
import me.desht.pneumaticcraft.common.tileentity.TileEntityPressureChamberInterface;
import me.desht.pneumaticcraft.common.tileentity.TileEntityUniversalSensor;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderUniversalSensor.class, remap = false)
public class RenderUniversalSensorMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelUniversalSensor model = new ModelUniversalSensorNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityUniversalSensor;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityUniversalSensor te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_UNIVERSAL_SENSOR);
    }

}
