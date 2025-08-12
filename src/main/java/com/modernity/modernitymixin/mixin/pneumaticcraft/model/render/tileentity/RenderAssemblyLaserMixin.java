package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyLaserNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyLaser;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyLaser;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderAssemblyLaser.class, remap = false)
public class RenderAssemblyLaserMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyLaser model = new ModelAssemblyLaserNew();

}
