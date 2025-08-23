package com.modernity.modernitymixin.model.pneumaticcraft;

import com.modernity.modernitymixin.Tags;
import net.minecraft.util.ResourceLocation;

public class TexturesNew {

    public static final String ICON_LOCATION = Tags.MOD_ID + ":" + "pneumaticcraft/";
    public static final String MODEL_LOCATION = ICON_LOCATION + "textures/pnc_model/";
    public static final String TUBE_MODULE_MODEL_LOCATION = MODEL_LOCATION + "modules/";
    public static final String GUI_LOCATION = ICON_LOCATION + "textures/gui/";
    public static final String DRONE_LOCATION = ICON_LOCATION + "textures/entities/drone/";

    private static ResourceLocation modelTexture(String img) {
        return new ResourceLocation(MODEL_LOCATION + img);
    }

    private static ResourceLocation guiIconTexture(String img) {
        return new ResourceLocation(GUI_LOCATION + "icon/" + img);
    }

    private static ResourceLocation tubeModuleTexture(String img) {
        return new ResourceLocation(TUBE_MODULE_MODEL_LOCATION + img);
    }

    private static ResourceLocation droneTexture(String img) {
        return new ResourceLocation(DRONE_LOCATION + img);
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
    public static final ResourceLocation MODEL_DRONE_MINIGUN = modelTexture("drone_minigun.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_NORMAL = modelTexture("heat_frame_normal.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_COLD = modelTexture("heat_frame_cold.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_COOL = modelTexture("heat_frame_cool.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_HOT = modelTexture("heat_frame_hot.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_SUPER_COLD = modelTexture("heat_frame_super_cold.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_SUPER_HOT = modelTexture("heat_frame_super_hot.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_VERY_COLD = modelTexture("heat_frame_very_cold.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_VERY_HOT = modelTexture("heat_frame_very_hot.png");
    public static final ResourceLocation MODEL_HEAT_FRAME_WARM = modelTexture("heat_frame_warm.png");
    public static final ResourceLocation MODEL_LOGISTICS_FRAME_ACTIVE_PROVIDER = modelTexture("logistics_frame_active_provider.png");
    public static final ResourceLocation MODEL_LOGISTICS_FRAME_PASSIVE_PROVIDER = modelTexture("logistics_frame_passive_provider.png");
    public static final ResourceLocation MODEL_LOGISTICS_FRAME_DEFAULT_STORAGE = modelTexture("logistics_frame_default_storage.png");
    public static final ResourceLocation MODEL_LOGISTICS_FRAME_STORAGE = modelTexture("logistics_frame_storage.png");
    public static final ResourceLocation MODEL_LOGISTICS_FRAME_REQUESTER = modelTexture("logistics_frame_requester.png");
    public static final ResourceLocation MODEL_CROP_SUPPORT = modelTexture("crop_support.png");
    public static final ResourceLocation MODEL_SPAWNER_AGITATOR = modelTexture("spawner_agitator.png");
    public static final ResourceLocation MODEL_TRANSFER_GADGET_IN = modelTexture("transfer_gadget_in.png");
    public static final ResourceLocation MODEL_TRANSFER_GADGET_OUT = modelTexture("transfer_gadget_out.png");

    // Tube Module textures
    public static final ResourceLocation MODEL_FLOW_DETECTOR = tubeModuleTexture("flow_detector.png");
    public static final ResourceLocation MODEL_LOGISTICS_MODULE = tubeModuleTexture("logistics_module.png");
    public static final ResourceLocation MODEL_GAUGE = tubeModuleTexture("gauge_module.png");
    public static final ResourceLocation MODEL_GAUGE_UPGRADED = tubeModuleTexture("gauge_module_upgraded.png");
    public static final ResourceLocation MODEL_AIR_GRATE = tubeModuleTexture("air_grate.png");
    public static final ResourceLocation MODEL_AIR_GRATE_UPGRADED = tubeModuleTexture("air_grate_upgraded.png");
    public static final ResourceLocation MODEL_CHARGING_MODULE = tubeModuleTexture("charging_module.png");
    public static final ResourceLocation MODEL_CHARGING_MODULE_UPGRADED = tubeModuleTexture("charging_module_upgraded.png");
    public static final ResourceLocation MODEL_SAFETY_VALVE = tubeModuleTexture("safety_valve.png");
    public static final ResourceLocation MODEL_SAFETY_VALVE_UPGRADED = tubeModuleTexture("safety_valve_upgraded.png");
    public static final ResourceLocation MODEL_REGULATOR_MODULE = tubeModuleTexture("regulator.png");
    public static final ResourceLocation MODEL_REGULATOR_MODULE_UPGRADED = tubeModuleTexture("regulator_upgraded.png");
    public static final ResourceLocation MODEL_REDSTONE_MODULE = tubeModuleTexture("redstone.png");
    public static final ResourceLocation MODEL_REDSTONE_MODULE_UPGRADED = tubeModuleTexture("redstone_upgraded.png");
//    public static final ResourceLocation MODEL_VACUUM_MODULE = tubeModuleTexture("vacuum.png");
//    public static final ResourceLocation MODEL_VACUUM_MODULE_UPGRADED = tubeModuleTexture("vacuum_upgraded.png");
//    public static final ResourceLocation MODEL_THERMOSTAT_MODULE = tubeModuleTexture("thermostat_module.png");
//    public static final ResourceLocation MODEL_THERMOSTAT_MODULE_UPGRADED = tubeModuleTexture("thermostat_module_upgraded.png");

    // entities
    public static final ResourceLocation DRONE_ENTITY = droneTexture("default_drone.png");
    //    public static final ResourceLocation GUARD_DRONE_ENTITY = droneTexture("guard_drone.png");
    public static final ResourceLocation HARVESTING_DRONE_ENTITY = droneTexture("harvesting_drone.png");
    public static final ResourceLocation LOGISTICS_DRONE_ENTITY = droneTexture("logistics_drone.png");
    //    public static final ResourceLocation COLLECTOR_DRONE_ENTITY = droneTexture("collector_drone.png");
//    public static final ResourceLocation AMADRONE_ENTITY = droneTexture("amadrone.png");
//    public static final ResourceLocation VORTEX_ENTITY = entityTexture("vortex.png");
}
