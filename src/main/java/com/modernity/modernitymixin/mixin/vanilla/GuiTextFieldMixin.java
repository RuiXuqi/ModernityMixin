package com.modernity.modernitymixin.mixin.vanilla;

import com.modernity.modernitymixin.ModernityMixinConfig;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GuiTextField.class)
public class GuiTextFieldMixin {

    // Not working now. It just mixins the third drawRect even with slice. Why?
//    @ModifyArg(
//            method = "drawTextBox",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lnet/minecraft/client/gui/Gui;drawRect(IIIII)V",
//                    ordinal = 0
//            ),
//            index = 4
//    )
//    private int modifyBorderColor(int originalColor) {
//        GuiTextField self = (GuiTextField)(Object)this;
//        return ModernityMixinConfig.Vanilla.litTextFieldBoarder && self.isFocused() ? 0xFFFFFFFF : originalColor;
//    }

}
