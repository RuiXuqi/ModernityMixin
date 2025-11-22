package com.modernity.modernitymixin.mixin.ae2.early;

import appeng.client.gui.AEBaseGui;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiContainer.class)
public class GuiContainerMixin {
    @Redirect(
            method = "drawScreen",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/inventory/GuiContainer;drawGradientRect(IIIIII)V",
                    ordinal = 0
            )
    )
    private void cancelHighlight(GuiContainer instance, int left, int top, int right, int bottom, int startColor, int endColor) {
        GuiContainer self = (GuiContainer) (Object) this;
        GuiAccessor accessor = (GuiAccessor) self;
        if (self instanceof AEBaseGui) {
            accessor.invokeDrawHorizontalLine(left, left + 16, top - 1, 0xFFdaffff);
            accessor.invokeDrawHorizontalLine(left - 1, left + 16, top + 16, 0xFFdaffff);
            accessor.invokeDrawVerticalLine(left - 1, top - 2, top + 16, 0xFFdaffff);
            accessor.invokeDrawVerticalLine(left + 16, top - 2, top + 16, 0xFFdaffff);
            accessor.invokeDrawGradientRect(left, top, left + 16, top + 16, 0x669cd3ff, 0x669cd3ff);
        } else {
            accessor.invokeDrawGradientRect(left, top, right, bottom, startColor, endColor);
        }
    }
}
