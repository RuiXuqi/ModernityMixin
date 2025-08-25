package com.modernity.modernitymixin.model.pneumaticcraft.block;

import me.desht.pneumaticcraft.client.model.block.ModelDoorBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelDoorBaseNew extends ModelDoorBase {
    private final ModelRenderer cylinder1;
    private final ModelRenderer cylinder2;
    private final ModelRenderer cylinder3;

    public ModelDoorBaseNew() {
        textureWidth = 64;
        textureHeight = 64;

        cylinder1 = new ModelRenderer(this, 0, 0);
        cylinder1.addBox(0F, 0F, 0F, 3, 3, 10);
        cylinder1.setRotationPoint(2.5F, 8.5F, -6F);
        cylinder1.mirror = true;
        cylinder2 = new ModelRenderer(this, 0, 13);
        cylinder2.addBox(0F, 0F, 0F, 2, 2, 10);
        cylinder2.setRotationPoint(3F, 9F, -6F);
        cylinder2.mirror = true;
        cylinder3 = new ModelRenderer(this, 0, 25);
        cylinder3.addBox(0F, 0F, 0F, 1, 1, 10);
        cylinder3.setRotationPoint(3.5F, 9.5F, -6F);
        cylinder3.mirror = true;
    }

    public void renderModel(float size, float progress, boolean rightGoing) {
        float cosinus = /*12 / 16F -*/(float) Math.sin(Math.toRadians((1 - progress) * 90)) * 12 / 16F;
        float sinus = 9 / 16F - (float) Math.cos(Math.toRadians((1 - progress) * 90)) * 9 / 16F;
        double extension = Math.sqrt(Math.pow(sinus, 2) + Math.pow(cosinus + 4 / 16F, 2));
        GlStateManager.translate(((rightGoing ? -4 : 0) + 2.5) / 16F, 0, -6 / 16F);
        double cylinderAngle = Math.toDegrees(Math.atan(sinus / (cosinus + 14 / 16F)));
        GlStateManager.rotate((float) cylinderAngle, 0f, rightGoing ? 1f : -1f, 0f);
        GlStateManager.translate(((rightGoing ? -3 : 0) - 2.5) / 16F, 0, 6 / 16F);
        double extensionPart = extension * 0.5D;
        cylinder1.render(size);
        GlStateManager.translate(0, 0, extensionPart);
        cylinder2.render(size);
        GlStateManager.translate(0, 0, extensionPart);
        cylinder3.render(size);
    }
}
