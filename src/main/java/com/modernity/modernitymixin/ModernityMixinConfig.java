package com.modernity.modernitymixin;

import com.cleanroommc.configanytime.ConfigAnytime;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Tags.MOD_ID)
@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class ModernityMixinConfig {
    private static final String PREFIX = Tags.MOD_ID + ".config.";

    private static final String GENERAL_KEY = PREFIX + "general";
    @Config.LangKey(GENERAL_KEY)
    public static final General General = new General();
    public static class General {
        @Config.Comment({
                "Allow you to modify the color of the text on the buttons.",
                "This also modifies the text on the buttons in other mods."
        })
        @Config.LangKey(GENERAL_KEY + ".modify_button_text_color")
        @Config.RequiresMcRestart
        public boolean modifyButtonTextColor = true;

        @Config.Comment({
                "Edit the color of the text on buttons when normal.",
                "Vanilla: 14737632",
                "Will not work if Modify Button Text Color is set false."
        })
        @Config.LangKey(GENERAL_KEY + ".button_text_normal_color")
        public int buttonTextNormalColor = 16777215;

        @Config.Comment({
                "Edit the color of the text on buttons when disabled.",
                "Vanilla: 10526880",
                "Will not work if Modify Button Text Color is set false."
        })
        @Config.LangKey(GENERAL_KEY + ".button_text_disabled_color")
        public int buttonTextDisabledColor = 10526880;

        @Config.Comment({
                "Edit the color of the text on buttons when hovered.",
                "Vanilla: 16777120",
                "Will not work if Modify Button Text Color is set false."
        })
        @Config.LangKey(GENERAL_KEY + ".button_text_hovered_color")
        public int buttonTextHoveredColor = 16777215;
    }

    private static final String VANILLA_KEY = PREFIX + "vanilla";
    @Config.LangKey(VANILLA_KEY)
    public static final Vanilla Vanilla = new Vanilla();
    public static class Vanilla {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to vanilla minecraft."})
        @Config.LangKey(VANILLA_KEY + ".global")
        @Config.RequiresMcRestart
        public boolean global = true;

        @Config.Comment({"Lit the border when focused."})
        @Config.LangKey(VANILLA_KEY + ".lit_text_field_border")
        @Config.RequiresMcRestart
        public boolean litTextFieldBorder = true;
    }

    private static final String FORGE_KEY = PREFIX + "forge";
    @Config.LangKey(FORGE_KEY)
    public static final Forge Forge = new Forge();
    public static class Forge {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to Forge."})
        @Config.LangKey(FORGE_KEY + ".global")
        @Config.RequiresMcRestart
        public boolean global = true;
    }

    private static final String CATALOGUE_KEY = PREFIX + "catalogue";
    @Config.LangKey(CATALOGUE_KEY)
    public static final Catalogue Catalogue = new Catalogue();
    public static class Catalogue {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to Catalogue Vintage mod."})
        @Config.LangKey(CATALOGUE_KEY + ".global")
        @Config.RequiresMcRestart
        public boolean global = true;
    }

    private static final String JEI_KEY = PREFIX + "jei";
    @Config.LangKey(JEI_KEY)
    public static final JEI JEI = new JEI();
    public static class JEI {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to Just Enough Items mod."})
        @Config.LangKey(JEI_KEY + ".global")
        @Config.RequiresMcRestart
        public boolean global = true;
    }

    private static final String PNC_KEY = PREFIX + "pnc";
    @Config.LangKey(PNC_KEY)
    public static final PnC PnC = new PnC();
    public static class PnC {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to PneumaticCraft mod."})
        @Config.LangKey(PNC_KEY + ".global")
        @Config.RequiresMcRestart
        public boolean global = true;

        @Config.Comment({"If disabled, builtin models for PneumaticCraft mod will not be applied."})
        @Config.LangKey(PNC_KEY + ".model")
        @Config.RequiresMcRestart
        public boolean model = true;

        @Config.Comment({"If disabled, ModernityMixin will not modify GUIs of PneumaticCraft."})
        @Config.LangKey(PNC_KEY + ".gui")
        @Config.RequiresMcRestart
        public boolean gui = true;

        @Config.Comment({"Replace the http APIs with https ones and set Json format for Pastebin Uploads."})
        @Config.LangKey(PNC_KEY + ".modify_pastebin_uploads")
        @Config.RequiresMcRestart
        public boolean modifyPastebinUploads = true;

        @Config.Comment({"Change the PnC tab icon from Air Cannon block to Pressure Gauge item."})
        @Config.LangKey(PNC_KEY + ".modify_creative_tab_icon")
        @Config.RequiresMcRestart
        public boolean modifyCreativeTabIcon = true;
    }

    static {
        ConfigAnytime.register(ModernityMixinConfig.class);
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Tags.MOD_ID)) {
            ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
        }
    }

}
