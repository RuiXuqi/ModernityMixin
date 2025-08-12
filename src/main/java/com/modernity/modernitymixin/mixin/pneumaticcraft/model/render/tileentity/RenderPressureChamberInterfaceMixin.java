package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelPressureChamberInterfaceNew;
import me.desht.pneumaticcraft.client.model.block.ModelPressureChamberInterface;
import me.desht.pneumaticcraft.client.render.tileentity.RenderPressureChamberInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderPressureChamberInterface.class, remap = false)
public class RenderPressureChamberInterfaceMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelPressureChamberInterface model = new ModelPressureChamberInterfaceNew();

}
