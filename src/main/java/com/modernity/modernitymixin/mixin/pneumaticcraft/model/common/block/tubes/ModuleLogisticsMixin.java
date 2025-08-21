package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block.tubes;

import com.modernity.modernitymixin.model.pneumaticcraft.module.ModelLogisticsNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.common.block.tubes.ModuleLogistics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ModuleLogistics.class, remap = false)
public class ModuleLogisticsMixin {

    @Inject(method = "getModelClass", at = @At("HEAD"), cancellable = true)
    public void modifyModel(CallbackInfoReturnable<Class<? extends ModelModuleBase>> cir) {
        cir.setReturnValue(ModelLogisticsNew.class);
    }

}
