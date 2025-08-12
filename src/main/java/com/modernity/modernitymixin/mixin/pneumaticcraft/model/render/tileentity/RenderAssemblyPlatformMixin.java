package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyPlatformNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyPlatform;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyPlatform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderAssemblyPlatform.class, remap = false)
public class RenderAssemblyPlatformMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyPlatform model = new ModelAssemblyPlatformNew();

}
