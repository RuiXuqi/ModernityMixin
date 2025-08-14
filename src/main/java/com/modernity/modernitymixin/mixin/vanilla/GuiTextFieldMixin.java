package com.modernity.modernitymixin.mixin.vanilla;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GuiTextField.class)
public class GuiTextFieldMixin {

    @ModifyArg(
            method = "drawTextBox",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiTextField;drawRect(IIIII)V",
                    ordinal = 0
            ),
            index = 4
    )
    private int drawRact(int originalColor) {
        GuiTextField self = (GuiTextField)(Object)this;
        return self.isFocused() ? 0xFFFFFFFF : originalColor;
    }

}
