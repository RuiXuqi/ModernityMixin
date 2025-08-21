package com.modernity.modernitymixin.mixin.pneumaticcraft.model.model.block;

import com.modernity.modernitymixin.model.pneumaticcraft.entity.ModelDroneMinigunNew;
import me.desht.pneumaticcraft.client.model.block.ModelSentryTurret;
import me.desht.pneumaticcraft.client.model.entity.ModelDroneMinigun;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = ModelSentryTurret.class, remap = false)
public class ModelSentryTurretMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelDroneMinigun model = new ModelDroneMinigunNew();

}
