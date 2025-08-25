package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyIOUnitNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyIOUnit;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyIOUnit;
import me.desht.pneumaticcraft.common.tileentity.TileEntityAssemblyIOUnit;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderAssemblyIOUnit.class, remap = false)
public class RenderAssemblyIOUnitMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyIOUnit model = new ModelAssemblyIOUnitNew();

    @Inject(
            method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyIOUnit;)Lnet/minecraft/util/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    void modifyTexture(TileEntityAssemblyIOUnit te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(te != null && te.isImportUnit() ? TexturesNew.MODEL_ASSEMBLY_IO_IMPORT : TexturesNew.MODEL_ASSEMBLY_IO_EXPORT);
    }

}
