package com.modernity.modernitymixin.mixin.pneumaticcraft.render;

import me.desht.pneumaticcraft.lib.Textures;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import static me.desht.pneumaticcraft.lib.Textures.ICON_LOCATION;

@SuppressWarnings("unused")
@Mixin(value = Textures.class, remap = false)
public class TexturesMixin {

    @Unique
    private static final String PNCMODEL_LOCATION = ICON_LOCATION + "textures/pnc_model/";

    @Unique
    private static ResourceLocation modernityMixin$modelTextureNew(String img) {
        return new ResourceLocation(PNCMODEL_LOCATION + img);
    }

    @Shadow
    @Mutable
    public static final ResourceLocation MODEL_AIR_CANNON = modernityMixin$modelTextureNew("air_cannon.png");

}
