package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block.tubes;

import com.modernity.modernitymixin.model.pneumaticcraft.module.ModelRedstoneNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.common.block.tubes.ModuleRedstone;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ModuleRedstone.class, remap = false)
public class ModuleRedstoneMixin {

    @Inject(method = "getModelClass", at = @At("HEAD"), cancellable = true)
    public void modifyModel(CallbackInfoReturnable<Class<? extends ModelModuleBase>> cir) {
        cir.setReturnValue(ModelRedstoneNew.class);
    }

}
