package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyDrillNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyDrill;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyDrill;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderAssemblyDrill.class, remap = false)
public class RenderAssemblyDrillMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyDrill model = new ModelAssemblyDrillNew();

}
