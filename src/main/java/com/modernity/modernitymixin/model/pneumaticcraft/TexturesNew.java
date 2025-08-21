package com.modernity.modernitymixin.model.pneumaticcraft;

import com.modernity.modernitymixin.Tags;
import net.minecraft.util.ResourceLocation;

public class TexturesNew {

    private static final String ICON_LOCATION = Tags.MOD_ID + ":" + "pneumaticcraft/";
    private static final String PNCMODEL_LOCATION = ICON_LOCATION + "textures/pnc_model/";
    private static final String GUI_LOCATION = ICON_LOCATION + "textures/gui/";

    private static ResourceLocation modelTexture(String img) {
        return new ResourceLocation(PNCMODEL_LOCATION + img);
    }

    private static ResourceLocation guiIconTexture(String img) {
        return new ResourceLocation(GUI_LOCATION + "icon/" + img);
    }

    public static final ResourceLocation GUI_GREEN_PROBLEMS_TEXTURE = guiIconTexture("gui_green_problem.png");

    public static final ResourceLocation MODEL_AIR_CANNON = modelTexture("air_cannon.png");
    public static final ResourceLocation MODEL_ASSEMBLY_IO_EXPORT = modelTexture("assembly_io_export.png");
    public static final ResourceLocation MODEL_ASSEMBLY_IO_IMPORT = modelTexture("assembly_io_import.png");
    public static final ResourceLocation MODEL_ASSEMBLY_LASER_AND_DRILL = modelTexture("assembly_laser_and_drill.png");
    public static final ResourceLocation MODEL_ASSEMBLY_PLATFORM = modelTexture("assembly_platform.png");
    public static final ResourceLocation MODEL_ASSEMBLY_CONTROLLER = modelTexture("assembly_controller.png");
    public static final ResourceLocation MODEL_ELEVATOR = modelTexture("elevator.png");
    public static final ResourceLocation MODEL_PNEUMATIC_DOOR_DYNAMIC = modelTexture("pneumatic_door_dynamic.png");
    public static final ResourceLocation MODEL_PNEUMATIC_DOOR_BASE = modelTexture("pneumatic_door_base.png");
    public static final ResourceLocation MODEL_PRESSURE_CHAMBER_INTERFACE = modelTexture("pressure_chamber_interface.png");
    public static final ResourceLocation MODEL_UNIVERSAL_SENSOR = modelTexture("universal_sensor.png");
    public static final ResourceLocation MODEL_VACUUM_PUMP = modelTexture("vacuum_pump.png");

}
