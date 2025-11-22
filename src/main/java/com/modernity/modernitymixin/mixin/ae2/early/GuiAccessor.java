package com.modernity.modernitymixin.mixin.ae2.early;

import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Gui.class)
public interface GuiAccessor {
    @Invoker("drawHorizontalLine")
    void invokeDrawHorizontalLine(int startX, int endX, int y, int color);
    @Invoker("drawVerticalLine")
    void invokeDrawVerticalLine(int x, int startY, int endY, int color);
    @Invoker("drawGradientRect")
    void invokeDrawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor);
}
