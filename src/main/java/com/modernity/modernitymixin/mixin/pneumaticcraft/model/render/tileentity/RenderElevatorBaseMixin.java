package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelElevatorBaseNew;
import me.desht.pneumaticcraft.client.model.block.ModelElevatorBase;
import me.desht.pneumaticcraft.client.render.tileentity.RenderElevatorBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderElevatorBase.class, remap = false)
public class RenderElevatorBaseMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelElevatorBase model = new ModelElevatorBaseNew();

}
