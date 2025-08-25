package com.modernity.modernitymixin.mixin.pneumaticcraft;

import me.desht.pneumaticcraft.client.CreativeTabPneumaticCraft;
import me.desht.pneumaticcraft.common.item.Itemss;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CreativeTabPneumaticCraft.class, remap = false)
public class CreativeTabPneumaticCraftMixin {
    
    @Inject(method = "createIcon", at = @At("HEAD"), cancellable = true)
    public void modifyIcon(CallbackInfoReturnable<ItemStack> cir) {
        cir.setReturnValue(new ItemStack(Itemss.PRESSURE_GAUGE));
    }

}
