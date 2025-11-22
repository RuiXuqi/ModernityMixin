package com.modernity.modernitymixin.mixin.ae2.early;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(value = GuiScreen.class, remap = false)
public interface GuiScreenAccessor {
    @Accessor("buttonList")
    List<GuiButton> getButtonList();
}
