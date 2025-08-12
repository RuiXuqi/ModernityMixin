package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelUniversalSensorNew;
import me.desht.pneumaticcraft.client.model.block.ModelUniversalSensor;
import me.desht.pneumaticcraft.client.render.tileentity.RenderUniversalSensor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderUniversalSensor.class, remap = false)
public class RenderUniversalSensorMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelUniversalSensor model = new ModelUniversalSensorNew();

}
