package com.modernity.modernitymixin;

import com.modernity.modernitymixin.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import javax.annotation.Nullable;
import java.util.*;

@IFMLLoadingPlugin.Name(Tags.MOD_ID)
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class ModernityMixinEarly implements IFMLLoadingPlugin, IEarlyMixinLoader {

    @Override
    public List<String> getMixinConfigs() {
        List <String> mixins = new ArrayList<>();

        if (ModernityMixinConfig.Vanilla.global && ModernityMixinConfig.General.modifyButtonTextColor) {
            mixins.add("mixins.modernitymixin.early.vanilla.button.json");
        }
        if (ModernityMixinConfig.Forge.global && ModernityMixinConfig.General.modifyButtonTextColor) {
            mixins.add("mixins.modernitymixin.early.forge.button.json");
        }

        return mixins;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

}
