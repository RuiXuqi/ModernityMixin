package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAirCannonNew;
import me.desht.pneumaticcraft.client.model.block.ModelAirCannon;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAirCannon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderAirCannon.class, remap = false)
public class RenderAirCannonMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAirCannon model = new ModelAirCannonNew();

}
