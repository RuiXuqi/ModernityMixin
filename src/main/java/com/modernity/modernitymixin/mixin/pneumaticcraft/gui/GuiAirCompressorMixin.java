package com.modernity.modernitymixin.mixin.pneumaticcraft.gui;

import me.desht.pneumaticcraft.client.gui.GuiAirCompressor;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GuiAirCompressor.class, remap = false)
public class GuiAirCompressorMixin {

    @Redirect(
            method = "drawGuiContainerForegroundLayer",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/FontRenderer;drawString(Ljava/lang/String;III)I"
            )
    )
    private int removeUpgr(FontRenderer instance, String text, int x, int y, int color) {
        if ("Upgr.".equals(text)) return 0;
        return instance.drawString(text, x, y, color);
    }

}
