package com.modernity.modernitymixin.jei;

import com.modernity.modernitymixin.ModernityMixinConfig;
import mezz.jei.gui.elements.GuiLabelButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = GuiLabelButton.class, remap = false)
public class GuiLabelButtonMixin {

    // Modify button text color.
    @ModifyConstant(
            method = "drawButton",
            constant = @Constant(intValue = 14737632)
    )
    private int modifyNormalColor(int original) {
        return ModernityMixinConfig.Vanilla.buttonTextNormalColor;
    }

    @ModifyConstant(
            method = "drawButton",
            constant = @Constant(intValue = 10526880)
    )
    private int modifyDisabledColor(int original) {
        return ModernityMixinConfig.Vanilla.buttonTextDisabledColor;
    }

    @ModifyConstant(
            method = "drawButton",
            constant = @Constant(intValue = 16777120)
    )
    private int modifyHoveredColor(int original) {
        return ModernityMixinConfig.Vanilla.buttonTextHoveredColor;
    }

}
