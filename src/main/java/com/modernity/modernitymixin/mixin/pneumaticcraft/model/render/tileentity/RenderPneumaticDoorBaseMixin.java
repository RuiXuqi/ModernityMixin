package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelDoorBaseNew;
import me.desht.pneumaticcraft.client.model.block.ModelDoorBase;
import me.desht.pneumaticcraft.client.render.tileentity.RenderPneumaticDoorBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderPneumaticDoorBase.class, remap = false)
public class RenderPneumaticDoorBaseMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelDoorBase model = new ModelDoorBaseNew();

}
