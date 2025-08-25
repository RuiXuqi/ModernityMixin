package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelAssemblyControllerScreen;
import net.minecraft.client.model.ModelRenderer;

public class ModelAssemblyControllerScreenNew extends ModelAssemblyControllerScreen {
    private final ModelRenderer screen;

    public ModelAssemblyControllerScreenNew() {
        textureWidth = 64;
        textureHeight = 64;

        screen = new ModelRenderer(this, 0, 0);
        screen.setRotationPoint(-5.0F, 8.0F, 1.0F);
        screen.setTextureOffset(16, 0).addBox(-1.0F, 0.0F, -1.0F, 12, 6, 2);
        screen.mirror = true;
        setRotation(screen, -0.5934119F, 0F, 0F);
    }

    public void renderModel(float scale) {
        screen.render(scale);
    }
}
