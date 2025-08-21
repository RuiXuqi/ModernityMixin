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

    @Config.Name("General")
    public static final General General = new General();
    public static class General {
        @Config.Comment({
                "Allow you to modify the color of the text on the buttons.",
                "This also modifies the text on the buttons in other mods."
        })
        @Config.Name("ModifyButtonTextColor")
        @Config.RequiresMcRestart
        public boolean modifyButtonTextColor = true;

        @Config.Comment({
                "Edit the color of the text on buttons when normal.",
                "Vanilla: 14737632",
                "Will not work if Modify Button Text Color is set false."
        })
        @Config.Name("ButtonTextNormalColor")
        public int buttonTextNormalColor = 16777215;

        @Config.Comment({
                "Edit the color of the text on buttons when disabled.",
                "Vanilla: 10526880",
                "Will not work if Modify Button Text Color is set false."
        })
        @Config.Name("ButtonTextDisabledColor")
        public int buttonTextDisabledColor = 10526880;

        @Config.Comment({
                "Edit the color of the text on buttons when hovered.",
                "Vanilla: 16777120",
                "Will not work if Modify Button Text Color is set false."
        })
        @Config.Name("ButtonTextHoveredColor")
        public int buttonTextHoveredColor = 16777215;
    }

    @Config.Name("Vanilla")
    public static final Vanilla Vanilla = new Vanilla();
    public static class Vanilla {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to vanilla minecraft."})
        @Config.Name("Global")
        @Config.RequiresMcRestart
        public boolean global = true;

        @Config.Comment({"Lit the boarder when focused."})
        @Config.Name("LitTextFieldBoarder")
        @Config.RequiresMcRestart
        public boolean litTextFieldBoarder = true;
    }

    @Config.Name("Forge")
    public static final Forge Forge = new Forge();
    public static class Forge {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to Forge."})
        @Config.Name("Global")
        @Config.RequiresMcRestart
        public boolean global = true;
    }

    @Config.Name("Catalogue")
    public static final Catalogue Catalogue = new Catalogue();
    public static class Catalogue {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to Catalogue Vintage mod."})
        @Config.Name("Global")
        @Config.RequiresMcRestart
        public boolean global = true;
    }

    @Config.Name("JustEnoughItems")
    public static final JEI JEI = new JEI();
    public static class JEI{
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to Just Enough Items mod."})
        @Config.Name("Global")
        @Config.RequiresMcRestart
        public boolean global = true;
    }

    @Config.Name("PneumaticCraft")
    public static final PnC PnC = new PnC();
    public static class PnC {
        @Config.Comment({"If disabled, ModernityMixin will not apply any changes to PneumaticCraft mod."})
        @Config.Name("Global")
        @Config.RequiresMcRestart
        public boolean global = true;

        @Config.Comment({"Mixin render to apply builtin models."})
        @Config.Name("Render")
        @Config.RequiresMcRestart
        public boolean render = true;

        @Config.Comment({"Replace the http APIs with https ones and set Json format for Pastebin Uploads."})
        @Config.Name("ModifyPastebinUploads")
        @Config.RequiresMcRestart
        public boolean modifyPastebinUploads = true;

        @Config.Comment({"Change the PnC tab icon from Air Cannon block to Pressure Gauge item."})
        @Config.Name("ModifyCreativeTabIcon")
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
