package com.modernity.modernitymixin.model.pneumaticcraft.entity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.entity.ModelDroneMinigun;
import me.desht.pneumaticcraft.client.util.RenderUtils;
import me.desht.pneumaticcraft.common.entity.living.EntityDrone;
import me.desht.pneumaticcraft.common.minigun.Minigun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelDroneMinigunNew extends ModelDroneMinigun {
    //fields
    private final ModelRenderer barrel;
    private final ModelRenderer support1;
    private final ModelRenderer support2;
    private final ModelRenderer support3;
    private final ModelRenderer support4;
    private final ModelRenderer support5;
    private final ModelRenderer main;
    private final ModelRenderer magazine;
    private final ModelRenderer mount;
    private final ModelRenderer mount_r1;
    private final ModelRenderer mount_r2;
    private final ModelRenderer magazineColor;

    public ModelDroneMinigunNew() {
        textureWidth = 64;
        textureHeight = 64;

        barrel = new ModelRenderer(this, 0, 3);
        barrel.setRotationPoint(0.0F, 20.9667F, -8.0F);
        barrel.addBox(-0.5F, 1.4333F, -4.0F, 1, 1, 20);

        support1 = new ModelRenderer(this, 0, 0);
        support1.setRotationPoint(0.0F, 21.0F, -6.0F);
        support1.setTextureOffset(22, 16).addBox(-1.5F, -1.5F, -5.0F, 3, 3, 4);
        support1.setTextureOffset(0, 13).addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1);
        support1.setTextureOffset(0, 13).addBox(-1.5F, -1.5F, 5.0F, 3, 3, 1);
        support1.setTextureOffset(0, 13).addBox(-1.5F, -1.5F, 7.0F, 3, 3, 1);
        support1.setTextureOffset(0, 13).addBox(-1.5F, -1.5F, 13.0F, 3, 3, 1);

        support2 = new ModelRenderer(this, 0, 4);
        support2.setRotationPoint(0.0F, 21.0F, -6.0F);
        support2.setTextureOffset(22, 8).addBox(-1.5F, 1.5F, -5.0F, 3, 1, 4);
        support2.setTextureOffset(0, 11).addBox(-1.5F, 1.5F, 0.0F, 3, 1, 1);
        support2.setTextureOffset(0, 21).addBox(-1.5F, 1.5F, 5.0F, 3, 1, 1);
        support2.setTextureOffset(0, 21).addBox(-1.5F, 1.5F, 7.0F, 3, 1, 1);
        support2.setTextureOffset(0, 21).addBox(-1.5F, 1.5F, 13.0F, 3, 1, 1);

        support3 = new ModelRenderer(this, 0, 6);
        support3.setRotationPoint(0.0F, 21.0F, -6.0F);
        support3.setTextureOffset(22, 8).addBox(-1.5F, -2.5F, -5.0F, 3, 1, 4);
        support3.setTextureOffset(0, 11).addBox(-1.5F, -2.5F, 0.0F, 3, 1, 1);
        support3.setTextureOffset(0, 11).addBox(-1.5F, -2.5F, 5.0F, 3, 1, 1);
        support3.setTextureOffset(0, 11).addBox(-1.5F, -2.5F, 7.0F, 3, 1, 1);
        support3.setTextureOffset(0, 11).addBox(-1.5F, -2.5F, 13.0F, 3, 1, 1);

        support4 = new ModelRenderer(this, 0, 8);
        support4.setRotationPoint(0.0F, 21.0F, -6.0F);
        support4.setTextureOffset(22, 1).addBox(1.5F, -1.5F, -5.0F, 1, 3, 4);
        support4.setTextureOffset(0, 17).addBox(1.5F, -1.5F, 0.0F, 1, 3, 1);
        support4.setTextureOffset(4, 17).addBox(1.5F, -1.5F, 5.0F, 1, 3, 1);
        support4.setTextureOffset(4, 17).addBox(1.5F, -1.5F, 7.0F, 1, 3, 1);
        support4.setTextureOffset(4, 17).addBox(1.5F, -1.5F, 13.0F, 1, 3, 1);

        support5 = new ModelRenderer(this, 0, 11);
        support5.setRotationPoint(0.0F, 21.0F, -6.0F);
        support5.setTextureOffset(32, 1).addBox(-2.5F, -1.5F, -5.0F, 1, 3, 4);
        support5.setTextureOffset(0, 17).addBox(-2.5F, -1.5F, 0.0F, 1, 3, 1);
        support5.setTextureOffset(0, 17).addBox(-2.5F, -1.5F, 5.0F, 1, 3, 1);
        support5.setTextureOffset(4, 17).addBox(-2.5F, -1.5F, 7.0F, 1, 3, 1);
        support5.setTextureOffset(4, 17).addBox(-2.5F, -1.5F, 13.0F, 1, 3, 1);

        main = new ModelRenderer(this, 36, 0);
        main.setRotationPoint(-3.0F, 18.0F, 8.0F);
        main.setTextureOffset(36, 18).addBox(0.0F, 0.0F, 1.0F, 6, 6, 8);
        main.setTextureOffset(34, 3).addBox(0.5F, 0.5F, 0.0F, 5, 5, 10);

        magazine = new ModelRenderer(this, 0, 14);
        magazine.setRotationPoint(3.0F, 22.0F, 9.0F);
        magazine.setTextureOffset(0, 0).addBox(-8.0F, -2.0F, 2.5F, 5, 6, 5, 0);
        magazine.mirror = true;

        mount = new ModelRenderer(this, 0, 23);
        mount.setRotationPoint(-1.0F, 15.0F, 11.0F);


        mount_r1 = new ModelRenderer(this, 0, 23);
        mount_r1.setRotationPoint(1.0F, 2.0F, 2.0F);
        mount.addChild(mount_r1);
        setRotation(mount_r1, -0.3927F, 0.0F, 0.0F);
        mount_r1.setTextureOffset(60, 0).addBox(-0.5F, -3.0F, -0.75F, 1, 2, 1);

        mount_r2 = new ModelRenderer(this, 0, 23);
        mount_r2.setRotationPoint(1.0F, 2.0F, 2.0F);
        mount.addChild(mount_r2);
        setRotation(mount_r2, -0.2618F, 0.0F, 0.0F);
        mount_r2.setTextureOffset(54, 3).addBox(-1.0F, -5.0F, -1.0F, 2, 1, 3);
        mount_r2.setTextureOffset(56, 18).addBox(-1.0F, -4.0F, 0.0F, 2, 6, 2);

        magazineColor = new ModelRenderer(this, 54, 7);
        magazineColor.setRotationPoint(4.3F, 22.5F, 10.0F);
        magazineColor.addBox(-9.6F, -2.0F, 2.0F, 1, 2, 4);
        magazineColor.mirror = true;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        EntityDrone drone = (EntityDrone) entity;
        renderMinigun(drone != null ? drone.getMinigun() : null, f5, 0, true);
    }

    public void renderMinigun(Minigun minigun, float size, float partialTick, boolean renderMount) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(TexturesNew.MODEL_DRONE_MINIGUN);
        GlStateManager.color(1, 1, 1, 1);
        GlStateManager.pushMatrix();
        if (renderMount) {
            GlStateManager.translate(0, 5 / 16D, -12 / 16D);
            mount.render(size);
            GlStateManager.translate(0, -5 / 16D, 12 / 16D);
        }

        float barrelRotation = 0;
        if (minigun != null) {
            barrelRotation = (float) (minigun.getOldMinigunRotation() + partialTick * (minigun.getMinigunRotation() - minigun.getOldMinigunRotation()));
            double yaw = minigun.oldMinigunYaw + partialTick * (minigun.minigunYaw - minigun.oldMinigunYaw);
            double pitch = minigun.oldMinigunPitch + partialTick * (minigun.minigunPitch - minigun.oldMinigunPitch);

            GlStateManager.translate(0, 23 / 16D, 0);
            GlStateManager.rotate((float)yaw, 0, 1, 0);
            GlStateManager.rotate((float)pitch, 1, 0, 0);
            GlStateManager.translate(0, -18 / 16D, -12 / 16D);
        }
        barrel.rotateAngleY = 0;
        barrel.rotateAngleX = 0;
        for (int i = 0; i < 6; i++) {
            barrel.rotateAngleZ = (float) (Math.PI / 3 * i) + barrelRotation;
            barrel.render(size);
        }
        support1.rotateAngleZ = barrelRotation;
        support2.rotateAngleZ = barrelRotation;
        support3.rotateAngleZ = barrelRotation;
        support4.rotateAngleZ = barrelRotation;
        support5.rotateAngleZ = barrelRotation;
        support1.render(size);
        support2.render(size);
        support3.render(size);
        support4.render(size);
        support5.render(size);
        magazine.render(size);
        main.render(size);
        GlStateManager.disableTexture2D();
        RenderUtils.glColorHex(minigun != null ? 0xFF000000 | minigun.getAmmoColor() : 0xFF313131);
        magazineColor.render(size);
        GlStateManager.color(1, 1, 1, 1);
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
