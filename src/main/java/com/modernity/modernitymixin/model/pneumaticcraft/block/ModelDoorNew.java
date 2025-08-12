package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelDoor;
import net.minecraft.client.model.ModelRenderer;

public class ModelDoorNew extends ModelDoor {
    private final ModelRenderer door_1;
    private final ModelRenderer door_0;

    public ModelDoorNew() {
        textureWidth = 64;
        textureHeight = 64;

        door_1 = new ModelRenderer(this, 0, 0);
        door_1.setRotationPoint(-8.0F, 3.0F, -8.0F);
        door_1.setTextureOffset(0, 0).addBox(0.0F, -11.0F, 0.0F, 16, 32, 3);
        door_1.mirror = true;

        door_0 = new ModelRenderer(this, 0, 0);
        door_0.setRotationPoint(-8.0F, 3.0F, -8.0F);
        door_0.setTextureOffset(42, 2).addBox(1.0F, -11.0F, 2.25F, 1, 32, 1, -0.01F);
        door_0.setTextureOffset(38, 2).addBox(3.0F, -11.0F, 2.25F, 1, 32, 1, -0.01F);
        door_0.setTextureOffset(38, 2).addBox(3.0F, -11.0F, -0.25F, 1, 32, 1, -0.01F);
        door_0.setTextureOffset(42, 2).addBox(1.0F, -11.0F, -0.25F, 1, 32, 1, -0.01F);
        door_0.setTextureOffset(0, 46).addBox(0.0F, -9.0F, 2.5F, 5, 1, 1, -0.01F);
        door_0.setTextureOffset(0, 44).addBox(0.0F, 18.0F, 2.5F, 5, 1, 1, -0.01F);
        door_0.setTextureOffset(0, 46).addBox(0.0F, -9.0F, -0.5F, 5, 1, 1, -0.01F);
        door_0.setTextureOffset(0, 44).addBox(0.0F, 18.0F, -0.5F, 5, 1, 1, -0.01F);
        door_0.setTextureOffset(16, 35).addBox(0.5F, 1.0F, 3.0F, 4, 8, 1);
        door_0.setTextureOffset(16, 35).addBox(0.5F, 1.0F, -1.0F, 4, 8, 1);
        door_0.setTextureOffset(26, 35).addBox(1.5F, 2.0F, 4.0F, 2, 2, 1);
        door_0.setTextureOffset(26, 35).addBox(1.5F, 2.0F, -2.0F, 2, 2, 1);
        door_0.setTextureOffset(26, 38).addBox(2.5F, 2.5F, 4.0F, 4, 1, 1, -0.2F);
        door_0.setTextureOffset(26, 38).addBox(2.5F, 2.5F, -2.0F, 4, 1, 1, -0.2F);
        door_0.setTextureOffset(0, 41).addBox(9.0F, -8.0F, 2.25F, 7, 2, 1, -0.01F);
        door_0.setTextureOffset(0, 38).addBox(9.0F, 9.0F, 2.25F, 7, 2, 1, -0.01F);
        door_0.setTextureOffset(0, 35).addBox(9.0F, 16.0F, 2.25F, 7, 2, 1, -0.01F);
        door_0.setTextureOffset(0, 41).addBox(9.0F, -8.0F, -0.25F, 7, 2, 1, -0.01F);
        door_0.setTextureOffset(0, 38).addBox(9.0F, 9.0F, -0.25F, 7, 2, 1, -0.01F);
        door_0.setTextureOffset(0, 35).addBox(9.0F, 16.0F, -0.25F, 7, 2, 1, -0.01F);
    }

    public void renderModel(float size) {
        door_1.render(size);
        door_0.render(size);
    }
}
