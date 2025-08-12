package com.modernity.modernitymixin.mixin.pneumaticcraft;

import me.desht.pneumaticcraft.client.CreativeTabPneumaticCraft;
import me.desht.pneumaticcraft.common.item.Itemss;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = CreativeTabPneumaticCraft.class, remap = false)
public class CreativeTabPneumaticCraftMixin {
    
    @ModifyArg(
            method = "createIcon",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/Item;)V"
            )
    )
    public Item modifyIcon(Item itemIn) {
        return Itemss.PRESSURE_GAUGE;
    }

}
