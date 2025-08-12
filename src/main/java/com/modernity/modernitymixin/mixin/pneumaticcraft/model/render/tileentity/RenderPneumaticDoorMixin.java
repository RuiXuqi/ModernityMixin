package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelDoorNew;
import me.desht.pneumaticcraft.client.model.block.ModelDoor;
import me.desht.pneumaticcraft.client.render.tileentity.RenderPneumaticDoor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderPneumaticDoor.class, remap = false)
public class RenderPneumaticDoorMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelDoor modelDoor = new ModelDoorNew();

}
