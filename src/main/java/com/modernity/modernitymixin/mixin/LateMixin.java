package com.modernity.modernitymixin.mixin;

import com.modernity.modernitymixin.ModernityMixinConfig;
import net.minecraftforge.fml.common.Loader;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class LateMixin implements ILateMixinLoader {

    @Override
    public List<String> getMixinConfigs() {
        List<String> mixins = new ArrayList<>();

        if (ModernityMixinConfig.JEI.global && Loader.isModLoaded("jei")) {
            if (ModernityMixinConfig.General.modifyButtonTextColor) {
                mixins.add("mixins.modernitymixin.late.jei.button.json");
            }
        }
        if (ModernityMixinConfig.PnC.global && Loader.isModLoaded("pneumaticcraft")) {
            if (ModernityMixinConfig.PnC.render) {
                mixins.add("mixins.modernitymixin.late.pneumaticcraft.render.json");
            }
            if (ModernityMixinConfig.PnC.modifyPastebinUploads) {
                mixins.add("mixins.modernitymixin.late.pneumaticcraft.pastebin.json");
            }
            if (ModernityMixinConfig.PnC.modifyCreativeTabIcon) {
                mixins.add("mixins.modernitymixin.late.pneumaticcraft.creativetabicon.json");
            }
        }

        return mixins;
    }

}
