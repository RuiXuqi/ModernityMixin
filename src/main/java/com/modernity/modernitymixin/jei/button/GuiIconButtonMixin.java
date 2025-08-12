package com.modernity.modernitymixin.jei.button;

import com.modernity.modernitymixin.ModernityMixinConfig;
import mezz.jei.gui.elements.GuiIconButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = GuiIconButton.class, remap = false)
public class GuiIconButtonMixin {

    // Modify button text color.
    @ModifyConstant(
            method = "drawButton",
            constant = @Constant(intValue = 14737632)
    )
    private int modifyNormalColor(int original) {
        return ModernityMixinConfig.General.buttonTextNormalColor;
    }

    @ModifyConstant(
            method = "drawButton",
            constant = @Constant(intValue = 10526880)
    )
    private int modifyDisabledColor(int original) {
        return ModernityMixinConfig.General.buttonTextDisabledColor;
    }

    @ModifyConstant(
            method = "drawButton",
            constant = @Constant(intValue = 16777120)
    )
    private int modifyHoveredColor(int original) {
        return ModernityMixinConfig.General.buttonTextHoveredColor;
    }

}
