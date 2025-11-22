package com.modernity.modernitymixin.util.ae2;

import java.util.List;

import appeng.client.gui.widgets.GuiImgButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import javax.annotation.Nonnull;

/**
 * A stacked button panel on the left or right side of our UIs.
 */
public class VerticalButtonBar {
    // Vertical space between buttons
    private static final int VERTICAL_SPACING = 6;
    // The margin between the right side of the buttons and the GUI
    private static final int MARGIN = 2;
    // This bounding rectangle relative to the screens origin
    private Rect2i bounds = new Rect2i(0, 0, 0, 0);
    private Point position;

    public VerticalButtonBar() {
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * We need to update every frame because buttons can become visible/invisible at any point in time.
     */
    public void updateBeforeRender(@Nonnull List<GuiImgButton> buttons) {
        int currentY = this.position.getY() + MARGIN;
        int maxWidth = 0;

        // Align the button's right edge with the UI and account for margin
        for (GuiImgButton button : buttons) {
            if (!button.visible) {
                continue;
            }

            // Vanilla widgets need to be in window space
            button.x = position.getX() - MARGIN - button.width;
            button.y = currentY + 1;

            currentY += button.height + VERTICAL_SPACING;
            maxWidth = Math.max(button.width, maxWidth);
        }

        // Set up a bounding rectangle for JEI exclusion zones
        if (maxWidth == 0) {
            this.bounds = new Rect2i(0, 0, 0, 0);
        } else {
            int boundX = this.position.getX() - maxWidth - 2 * MARGIN;
            int boundY = this.position.getY();
            this.bounds = new Rect2i(
                    boundX,
                    boundY,
                    maxWidth + 2 * MARGIN,
                    currentY - boundY);
        }
    }

    public void drawBackgroundLayer(@Nonnull Minecraft mc) {
        mc.getTextureManager().bindTexture(RenderUtils.makeId("gui/vertical_buttons_bg"));
        RenderUtils.blitNineSlicedSprite(
                new NineSlice(21, 26, new NineSlice.Border(0, 2, 0, 4)),
                this.bounds.getX() - 2,
                this.bounds.getY() - 1,
                1,
                this.bounds.getWidth() + 1,
                this.bounds.getHeight() + 4
        );
    }
}
