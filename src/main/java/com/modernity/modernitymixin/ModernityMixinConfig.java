package com.modernity.modernitymixin;

import com.cleanroommc.configanytime.ConfigAnytime;
import com.modernity.modernitymixin.Tags;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Tags.MOD_ID)
@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class ModernityMixinConfig {

    @Config.Name("Vanilla")
    public static final Vanilla Vanilla = new Vanilla();

    public static class Vanilla {
        @Config.Comment({"If disabled, the mod will not apply any changes to vanilla minecraft and forge."})
        @Config.Name("Global")
        @Config.RequiresMcRestart
        public boolean global = true;

//        @Config.Comment({"Lit the boarder when focused."})
//        @Config.Name("Lit TextField Boarder")
//        public boolean litTextFieldBoarder = true;

        @Config.Comment({
                "Edit the color of the text on buttons when normal.",
                "Vanilla: 14737632"
        })
        @Config.Name("Button Text Normal Color")
        public int buttonTextNormalColor = 16777215;

        @Config.Comment({
                "Edit the color of the text on buttons when disabled.",
                "Vanilla: 10526880"
        })
        @Config.Name("Button Text Disabled Color")
        public int buttonTextDisabledColor = 10526880;

        @Config.Comment({
                "Edit the color of the text on buttons when hovered.",
                "Vanilla: 16777120"
        })
        @Config.Name("Button Text Hovered Color")
        public int buttonTextHoveredColor = 16777215;
    }

    @Config.Name("PneumaticCraft")
    public static final PnC PnC = new PnC();

    public static class PnC{
        @Config.Comment({"If disabled, the mod will not apply any changes to PneumaticCraft mod."})
        @Config.Name("Global")
        @Config.RequiresMcRestart
        public boolean global = true;

        @Config.Comment({"Replace the http ones with https."})
        @Config.Name("Fix Pastebin APIs")
        public boolean fixPastebinAPIs = true;

        @Config.Comment({"Set Json format for Pastebin Uploads."})
        @Config.Name("Set Pastebin Json")
        public boolean setPastebinJson = true;
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
