package com.modernity.modernitymixin.mixin.pneumaticcraft.model;

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
    private static ResourceLocation modernityMixin$modelTexture(String img) {
        return new ResourceLocation(PNCMODEL_LOCATION + img);
    }

    @Shadow @Mutable public static final ResourceLocation MODEL_AIR_CANNON = modernityMixin$modelTexture("air_cannon.png");
    @Shadow @Mutable public static final ResourceLocation MODEL_ASSEMBLY_IO_EXPORT = modernityMixin$modelTexture("assembly_io_export.png");
    @Shadow @Mutable public static final ResourceLocation MODEL_ASSEMBLY_IO_IMPORT = modernityMixin$modelTexture("assembly_io_import.png");
    @Shadow @Mutable public static final ResourceLocation MODEL_ASSEMBLY_LASER_AND_DRILL = modernityMixin$modelTexture("assembly_laser_and_drill.png");
    @Shadow @Mutable public static final ResourceLocation MODEL_ASSEMBLY_PLATFORM = modernityMixin$modelTexture("assembly_platform.png");
    @Shadow @Mutable public static final ResourceLocation MODEL_ASSEMBLY_CONTROLLER = modernityMixin$modelTexture("assembly_controller.png");
    @Shadow @Mutable public static final ResourceLocation MODEL_PNEUMATIC_DOOR_DYNAMIC = modernityMixin$modelTexture("pneumatic_door_dynamic.png");
    @Shadow @Mutable public static final ResourceLocation MODEL_PNEUMATIC_DOOR_BASE = modernityMixin$modelTexture("pneumatic_door_base.png");

}
