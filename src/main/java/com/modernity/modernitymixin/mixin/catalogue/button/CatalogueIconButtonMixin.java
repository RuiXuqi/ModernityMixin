package com.modernity.modernitymixin.mixin.catalogue.button;

import com.modernity.modernitymixin.ModernityMixinConfig;
import com.mrcrayfish.catalogue.client.screen.widget.CatalogueIconButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CatalogueIconButton.class, remap = false)
public class CatalogueIconButtonMixin {

    // Modify button text color.
    @ModifyConstant(
            method = "getFGColor",
            constant = @Constant(intValue = 14737632)
    )
    private int modifyNormalColor(int original) {
        return ModernityMixinConfig.General.buttonTextNormalColor;
    }

    @ModifyConstant(
            method = "getFGColor",
            constant = @Constant(intValue = 10526880)
    )
    private int modifyDisabledColor(int original) {
        return ModernityMixinConfig.General.buttonTextDisabledColor;
    }

    @ModifyConstant(
            method = "getFGColor",
            constant = @Constant(intValue = 16777120)
    )
    private int modifyHoveredColor(int original) {
        return ModernityMixinConfig.General.buttonTextHoveredColor;
    }

}
