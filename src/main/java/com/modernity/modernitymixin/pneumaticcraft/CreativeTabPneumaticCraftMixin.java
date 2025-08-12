package com.modernity.modernitymixin.pneumaticcraft;

import me.desht.pneumaticcraft.client.CreativeTabPneumaticCraft;
import me.desht.pneumaticcraft.common.item.Itemss;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = CreativeTabPneumaticCraft.class, remap = false)
public class CreativeTabPneumaticCraftMixin {

    /**
     * @author RuiXuqi
     * @reason Change creative tab icon
     */
    @Overwrite
    public ItemStack createIcon() {
        return new ItemStack(Itemss.PRESSURE_GAUGE);
    }

}
