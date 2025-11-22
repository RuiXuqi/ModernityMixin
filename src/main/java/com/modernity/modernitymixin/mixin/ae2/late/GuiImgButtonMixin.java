package com.modernity.modernitymixin.mixin.ae2.late;

import appeng.client.gui.widgets.GuiImgButton;
import com.modernity.modernitymixin.mixininterface.ae2.GuiImgButtonInterface;
import com.modernity.modernitymixin.util.ae2.RenderUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mixin(value = GuiImgButton.class, remap = false)
public class GuiImgButtonMixin implements GuiImgButtonInterface {
    @Unique @Nullable
    private String modernityMixin$newIconTextureName;
    @Unique
    private ResourceLocation modernityMixin$originalIconTexture;
    @Unique
    private TextureManager modernityMixin$textureManager;

    @Inject(method = "getIconIndex", at = @At("RETURN"))
    private void identifyTexture(@Nonnull CallbackInfoReturnable<Integer> cir) {
        this.modernityMixin$newIconTextureName = switch (cir.getReturnValue()) {
            case 6 -> "clear";
            case 52 -> "substitution_enabled";
            case 55 -> "substitution_disabled";
            case 65 -> "sort_by_amount";
            case 68 -> "sort_by_inventory_tweaks";
            case 69 -> "sort_by_mod";
            case 64 -> "sort_by_name";
            case 208 -> "terminal_style_tall";
            case 209 -> "terminal_style_small";
            case 210 -> "terminal_style_full";
            default -> null;
        };
    }

    /*
    For half size buttons (8x8)
     */

    @Redirect(
            method = "drawButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V",
                    ordinal = 0
            )
    )
    private void catchHalfIconTexture(@Nonnull TextureManager instance, ResourceLocation resource) {
        this.modernityMixin$originalIconTexture = resource;
        this.modernityMixin$textureManager = instance;
        instance.bindTexture(resource);
    }

    @Redirect(
            method = "drawButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lappeng/client/gui/widgets/GuiImgButton;drawTexturedModalRect(IIIIII)V",
                    ordinal = 0
            )
    )
    private void cancelHalfBG(GuiImgButton instance, int x, int y, int textureX, int textureY, int width, int height) {
        if (this.modernityMixin$newIconTextureName == null) {
            instance.drawTexturedModalRect(x, y, textureX, textureY, width, height);
        }
    }

    @Redirect(
            method = "drawButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lappeng/client/gui/widgets/GuiImgButton;drawTexturedModalRect(IIIIII)V",
                    ordinal = 1
            )
    )
    private void drawHalfIcon(GuiImgButton instance, int x, int y, int textureX, int textureY, int width, int height) {
        if (this.modernityMixin$newIconTextureName == null) {
            instance.drawTexturedModalRect(x, y, textureX, textureY, width, height);
            return;
        }

        this.modernityMixin$textureManager.bindTexture(RenderUtils.makeId("gui/icons/s_" + this.modernityMixin$newIconTextureName));
        Gui.drawScaledCustomSizeModalRect(
                x, y, 0, 0,
                8, 8, width, height,
                8, 8
        );
    }

    /*
    For normal size buttons (Actual 16x16;Render 18x20)
     */

    @Redirect(
            method = "drawButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V",
                    ordinal = 1
            )
    )
    private void catchNormalIconTexture(@Nonnull TextureManager instance, ResourceLocation resource) {
        this.modernityMixin$originalIconTexture = resource;
        this.modernityMixin$textureManager = instance;
        instance.bindTexture(resource);
    }

    @Redirect(
            method = "drawButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lappeng/client/gui/widgets/GuiImgButton;drawTexturedModalRect(IIIIII)V",
                    ordinal = 2
            )
    )
    private void modifyNormalBG(@Nonnull GuiImgButton instance, int x, int y, int textureX, int textureY, int width, int height) {
        this.modernityMixin$textureManager.bindTexture(
                RenderUtils.makeId("gui/icons/" +
                        (instance.isMouseOver() ? "toolbar_button_background_hover" : "toolbar_button_background")
                ));
        Gui.drawScaledCustomSizeModalRect(
                x - 1, y - 1, 0, 0,
                18, 20, width + 2, height + 4,
                18, 20
        );
        this.modernityMixin$textureManager.bindTexture(this.modernityMixin$originalIconTexture);
    }

    @Redirect(
            method = "drawButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lappeng/client/gui/widgets/GuiImgButton;drawTexturedModalRect(IIIIII)V",
                    ordinal = 3
            )
    )
    private void drawNormalIcon(@Nonnull GuiImgButton instance, int x, int y, int textureX, int textureY, int width, int height) {
        y += instance.isMouseOver() ? 1 : 0;
        if (this.modernityMixin$newIconTextureName == null) {
            instance.drawTexturedModalRect(x, y, textureX, textureY, width, height);
            return;
        }

        this.modernityMixin$textureManager.bindTexture(RenderUtils.makeId("gui/icons/" + this.modernityMixin$newIconTextureName));
        Gui.drawScaledCustomSizeModalRect(
                x, y, 0, 0,
                16, 16, width, height,
                16, 16
        );
    }

    @Unique
    private boolean modernityMixin$isSidedButton = false;

    @Unique
    @Override
    public boolean modernityMixin$getIsSidedButton() {
        return this.modernityMixin$isSidedButton;
    }

    @Unique
    @Override
    public void modernityMixin$setIsSidedButton(boolean isSidedButton) {
        this.modernityMixin$isSidedButton = isSidedButton;
    }
}
