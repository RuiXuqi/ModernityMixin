package com.modernity.modernitymixin.mixin.ae2.late;

import appeng.client.gui.AEBaseGui;
import appeng.client.gui.widgets.GuiImgButton;
import com.modernity.modernitymixin.mixin.ae2.early.GuiAccessor;
import com.modernity.modernitymixin.mixin.ae2.early.GuiScreenAccessor;
import com.modernity.modernitymixin.mixininterface.ae2.GuiImgButtonInterface;
import com.modernity.modernitymixin.util.ae2.Point;
import com.modernity.modernitymixin.util.ae2.VerticalButtonBar;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = AEBaseGui.class, remap = false)
public class AEBaseGuiMixin {
    @Unique
    VerticalButtonBar modernityMixin$buttonBar = new VerticalButtonBar();

    @Inject(
            method = "drawGuiContainerBackgroundLayer",
            at = @At(
                    value = "INVOKE",
                    target = "Lappeng/client/gui/AEBaseGui;drawBG(IIII)V",
                    shift = At.Shift.AFTER
            )
    )
    private void drawBarBG(float f, int mouseX, int mouseY, CallbackInfo ci) {
        AEBaseGui self = (AEBaseGui) (Object) this;

        this.modernityMixin$buttonBar.setPosition(new Point(self.getGuiLeft() + 3, self.getGuiTop() + 1));

        List<GuiButton> buttonList = ((GuiScreenAccessor) self).getButtonList();
        if (buttonList != null && !buttonList.isEmpty()) {
            List<GuiImgButton> newButtonList = new ArrayList<>();
            int xOffset = self.getGuiLeft() - 18;
            buttonList.forEach(s -> {
                if (
                        s instanceof GuiImgButton button
                        && (((GuiImgButtonInterface) button).modernityMixin$getIsSidedButton() || (!button.isHalfSize() && button.x == xOffset))
                ) {
                    ((GuiImgButtonInterface) button).modernityMixin$setIsSidedButton(true);
                    newButtonList.add(button);
                }
            });
            this.modernityMixin$buttonBar.updateBeforeRender(newButtonList);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.modernityMixin$buttonBar.drawBackgroundLayer(self.mc);
        }
    }
}
