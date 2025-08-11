package com.modernity.modernitymixin.jei;

import com.modernity.modernitymixin.ModernityMixinConfig;
import mezz.jei.gui.recipes.RecipeCategoryTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = RecipeCategoryTab.class, remap = false)
public class RecipeCategoryTabMixin {

    // Modify button text color.
    @ModifyConstant(
            method = "draw",
            constant = @Constant(intValue = 14737632)
    )
    private int modifyNormalColor(int original) {
        return ModernityMixinConfig.Vanilla.buttonTextNormalColor;
    }

    @ModifyConstant(
            method = "draw",
            constant = @Constant(intValue = 16777120)
    )
    private int modifyHoveredColor(int original) {
        return ModernityMixinConfig.Vanilla.buttonTextHoveredColor;
    }

}
