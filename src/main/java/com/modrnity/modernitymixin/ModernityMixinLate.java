package com.modrnity.modernitymixin;

import net.minecraftforge.fml.common.Loader;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ModernityMixinLate implements ILateMixinLoader {

    private static final Map<String, String> MOD_MIXINS = new HashMap<>();

    static {
        //MOD_MIXINS.put("avaritia", "mixins.modernitymixin.avaritia.json");
        //MOD_MIXINS.put("botania", "mixins.modernitymixin.botania.json");
        MOD_MIXINS.put("pneumaticcraft", "mixins.modernitymixin.pneumaticcraft.json");
    }

    @Override
    public List<String> getMixinConfigs() {
        return MOD_MIXINS.entrySet().stream()
            .filter(entry -> Loader.isModLoaded(entry.getKey()))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
    }

}
