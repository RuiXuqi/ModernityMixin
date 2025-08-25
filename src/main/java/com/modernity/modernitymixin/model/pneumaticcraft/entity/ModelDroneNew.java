package com.modernity.modernitymixin.model.pneumaticcraft.entity;

import me.desht.pneumaticcraft.common.entity.living.EntityDroneBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelDroneNew extends ModelBase {
    //fields
    private final ModelRenderer done;
    private final ModelRenderer body;
    private final ModelRenderer lower_frame_r1;
    private final ModelRenderer north_west_wing;
    private final ModelRenderer prop_1;
    private final ModelRenderer blade3_connection_r1;
    private final ModelRenderer blade2_connection_r1;
    private final ModelRenderer blade1_connection_r1;
    private final ModelRenderer south_west_wing;
    private final ModelRenderer prop_2;
    private final ModelRenderer blade6_connection_r1;
    private final ModelRenderer blade5_connection_r1;
    private final ModelRenderer blade4_connection_r1;
    private final ModelRenderer south_east_wing;
    private final ModelRenderer prop_3;
    private final ModelRenderer blade9_connection_r1;
    private final ModelRenderer blade8_connection_r1;
    private final ModelRenderer blade7_connection_r1;
    private final ModelRenderer north_east_wing;
    private final ModelRenderer prop_4;
    private final ModelRenderer blade12_connection_r1;
    private final ModelRenderer blade11_connection_r1;
    private final ModelRenderer blade10_connection_r1;
    private final ModelDroneMinigunNew minigun = new ModelDroneMinigunNew();
    
    public ModelDroneNew() {
        textureWidth = 128;
        textureHeight = 128;

        done = new ModelRenderer(this);
        done.setRotationPoint(0.0F, 22.5F, 0.0F);


        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -3.0F, 0.0F);
        done.addChild(body);
        body.setTextureOffset(0, 93).addBox(-4.0F, -4.0F, -12.0F, 8, 4, 24);
        body.setTextureOffset(10, 121).addBox(4.0F, -4.0F, 6.0F, 2, 4, 3);
        body.setTextureOffset(20, 121).addBox(-6.0F, -4.0F, 6.0F, 2, 4, 3);
        body.setTextureOffset(0, 121).addBox(4.0F, -4.0F, -9.0F, 2, 4, 3);
        body.setTextureOffset(30, 121).addBox(-6.0F, -4.0F, -9.0F, 2, 4, 3);
        body.setTextureOffset(0, 67).addBox(-4.5F, -3.5F, -12.5F, 9, 1, 25);
        body.setTextureOffset(48, 106).addBox(-3.5F, -5.0F, -4.5F, 7, 6, 16);

        lower_frame_r1 = new ModelRenderer(this);
        lower_frame_r1.setRotationPoint(-0.25F, -0.75F, -31.25F);
        body.addChild(lower_frame_r1);
        setRotation(lower_frame_r1, -3.1416F, 0.0F, 3.1416F);
        lower_frame_r1.setTextureOffset(0, 67).addBox(-4.75F, -0.75F, -43.75F, 9, 1, 25);

        north_west_wing = new ModelRenderer(this);
        north_west_wing.setRotationPoint(6.0F, -5.5F, -7.5F);
        done.addChild(north_west_wing);
        setRotation(north_west_wing, 0.0F, 0.3927F, 0.0F);
        north_west_wing.setTextureOffset(0, 113).addBox(-1.0F, -1.0F, -1.0F, 7, 2, 2);
        north_west_wing.setTextureOffset(44, 110).addBox(4.5F, 1.0F, -0.5F, 1, 6, 1);
        north_west_wing.setTextureOffset(52, 107).addBox(4.5F, -3.0F, -0.5F, 1, 2, 1);

        prop_1 = new ModelRenderer(this);
        prop_1.setRotationPoint(5.0F, -2.5F, 0.0F);
        north_west_wing.addChild(prop_1);
        setRotation(prop_1, 0.0F, 0.0F, 0.0F);
        prop_1.setTextureOffset(52, 105).addBox(-0.5F, -1.5F, -0.5F, 1, 1, 1);

        blade3_connection_r1 = new ModelRenderer(this);
        blade3_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_1.addChild(blade3_connection_r1);
        setRotation(blade3_connection_r1, 0.1572F, -0.3614F, -0.4215F);
        blade3_connection_r1.setTextureOffset(52, 105).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 1);
        blade3_connection_r1.setTextureOffset(68, 93).addBox(-1.0F, -0.5F, -6.5F, 2, 1, 5);

        blade2_connection_r1 = new ModelRenderer(this);
        blade2_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_1.addChild(blade2_connection_r1);
        setRotation(blade2_connection_r1, 2.7761F, -0.7119F, -2.6117F);
        blade2_connection_r1.setTextureOffset(48, 105).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 1);
        blade2_connection_r1.setTextureOffset(54, 99).addBox(-1.0F, -0.5F, -6.5F, 2, 1, 5);

        blade1_connection_r1 = new ModelRenderer(this);
        blade1_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_1.addChild(blade1_connection_r1);
        setRotation(blade1_connection_r1, -1.5708F, 1.1781F, -1.5708F);
        blade1_connection_r1.setTextureOffset(44, 105).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 1);
        blade1_connection_r1.setTextureOffset(40, 93).addBox(-1.0F, -0.5F, -6.5F, 2, 1, 5);

        south_west_wing = new ModelRenderer(this);
        south_west_wing.setRotationPoint(6.0F, -5.5F, 7.5F);
        done.addChild(south_west_wing);
        setRotation(south_west_wing, 0.0F, -0.3927F, 0.0F);
        south_west_wing.setTextureOffset(0, 105).addBox(-1.0F, -1.0F, -1.0F, 7, 2, 2);
        south_west_wing.setTextureOffset(48, 110).addBox(4.5F, 1.0F, -0.5F, 1, 6, 1);
        south_west_wing.setTextureOffset(48, 107).addBox(4.5F, -3.0F, -0.5F, 1, 2, 1);

        prop_2 = new ModelRenderer(this);
        prop_2.setRotationPoint(5.0F, -2.5F, 0.0F);
        south_west_wing.addChild(prop_2);
        setRotation(prop_2, 0.0F, 0.0F, 0.0F);
        prop_2.setTextureOffset(48, 105).addBox(-0.5F, -1.5F, -0.5F, 1, 1, 1);

        blade6_connection_r1 = new ModelRenderer(this);
        blade6_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_2.addChild(blade6_connection_r1);
        setRotation(blade6_connection_r1, -0.1572F, 0.3614F, -0.4215F);
        blade6_connection_r1.setTextureOffset(48, 105).addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
        blade6_connection_r1.setTextureOffset(68, 99).addBox(-1.0F, -0.5F, 1.5F, 2, 1, 5);

        blade5_connection_r1 = new ModelRenderer(this);
        blade5_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_2.addChild(blade5_connection_r1);
        setRotation(blade5_connection_r1, -2.7761F, 0.7119F, -2.6117F);
        blade5_connection_r1.setTextureOffset(52, 105).addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
        blade5_connection_r1.setTextureOffset(54, 93).addBox(-1.0F, -0.5F, 1.5F, 2, 1, 5);

        blade4_connection_r1 = new ModelRenderer(this);
        blade4_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_2.addChild(blade4_connection_r1);
        setRotation(blade4_connection_r1, 1.5708F, -1.1781F, -1.5708F);
        blade4_connection_r1.setTextureOffset(40, 105).addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
        blade4_connection_r1.setTextureOffset(40, 99).addBox(-1.0F, -0.5F, 1.5F, 2, 1, 5);

        south_east_wing = new ModelRenderer(this);
        south_east_wing.setRotationPoint(-6.0F, -5.5F, 7.5F);
        done.addChild(south_east_wing);
        setRotation(south_east_wing, 0.0F, 0.3927F, 0.0F);
        south_east_wing.setTextureOffset(0, 101).addBox(-6.0F, -1.0F, -1.0F, 7, 2, 2);
        south_east_wing.setTextureOffset(52, 110).addBox(-5.5F, 1.0F, -0.5F, 1, 6, 1);
        south_east_wing.setTextureOffset(44, 107).addBox(-5.5F, -3.0F, -0.5F, 1, 2, 1);

        prop_3 = new ModelRenderer(this);
        prop_3.setRotationPoint(-5.0F, -2.5F, 0.0F);
        south_east_wing.addChild(prop_3);
        setRotation(prop_3, 0.0F, 0.0F, 0.0F);
        prop_3.setTextureOffset(44, 105).addBox(-0.5F, -1.5F, -0.5F, 1, 1, 1);

        blade9_connection_r1 = new ModelRenderer(this);
        blade9_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_3.addChild(blade9_connection_r1);
        setRotation(blade9_connection_r1, -0.1572F, -0.3614F, 0.4215F);
        blade9_connection_r1.setTextureOffset(40, 105).addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
        blade9_connection_r1.setTextureOffset(68, 93).addBox(-1.0F, -0.5F, 1.5F, 2, 1, 5);

        blade8_connection_r1 = new ModelRenderer(this);
        blade8_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_3.addChild(blade8_connection_r1);
        setRotation(blade8_connection_r1, -2.7761F, -0.7119F, 2.6117F);
        blade8_connection_r1.setTextureOffset(52, 105).addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
        blade8_connection_r1.setTextureOffset(68, 99).addBox(-1.0F, -0.5F, 1.5F, 2, 1, 5);

        blade7_connection_r1 = new ModelRenderer(this);
        blade7_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_3.addChild(blade7_connection_r1);
        setRotation(blade7_connection_r1, 1.5708F, 1.1781F, 1.5708F);
        blade7_connection_r1.setTextureOffset(44, 105).addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
        blade7_connection_r1.setTextureOffset(54, 93).addBox(-1.0F, -0.5F, 1.5F, 2, 1, 5);

        north_east_wing = new ModelRenderer(this);
        north_east_wing.setRotationPoint(-6.0F, -5.5F, -7.5F);
        done.addChild(north_east_wing);
        setRotation(north_east_wing, 0.0F, -0.3927F, 0.0F);
        north_east_wing.setTextureOffset(0, 109).addBox(-6.0F, -1.0F, -1.0F, 7, 2, 2);
        north_east_wing.setTextureOffset(40, 110).addBox(-5.5F, 1.0F, -0.5F, 1, 6, 1);
        north_east_wing.setTextureOffset(40, 107).addBox(-5.5F, -3.0F, -0.5F, 1, 2, 1);

        prop_4 = new ModelRenderer(this);
        prop_4.setRotationPoint(-5.0F, -2.5F, 0.0F);
        north_east_wing.addChild(prop_4);
        setRotation(prop_4, 0.0F, 0.0F, 0.0F);
        prop_4.setTextureOffset(40, 105).addBox(-0.5F, -1.5F, -0.5F, 1, 1, 1);

        blade12_connection_r1 = new ModelRenderer(this);
        blade12_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_4.addChild(blade12_connection_r1);
        setRotation(blade12_connection_r1, 0.1572F, 0.3614F, 0.4215F);
        blade12_connection_r1.setTextureOffset(48, 105).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 1);
        blade12_connection_r1.setTextureOffset(40, 99).addBox(-1.0F, -0.5F, -6.5F, 2, 1, 5);

        blade11_connection_r1 = new ModelRenderer(this);
        blade11_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_4.addChild(blade11_connection_r1);
        setRotation(blade11_connection_r1, 2.7761F, 0.7119F, 2.6117F);
        blade11_connection_r1.setTextureOffset(40, 105).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 1);
        blade11_connection_r1.setTextureOffset(40, 93).addBox(-1.0F, -0.5F, -6.5F, 2, 1, 5);

        blade10_connection_r1 = new ModelRenderer(this);
        blade10_connection_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
        prop_4.addChild(blade10_connection_r1);
        setRotation(blade10_connection_r1, -1.5708F, -1.1781F, 1.5708F);
        blade10_connection_r1.setTextureOffset(44, 105).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 1);
        blade10_connection_r1.setTextureOffset(54, 99).addBox(-1.0F, -0.5F, -6.5F, 2, 1, 5);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        done.render(f5);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entity, float par2, float par3, float partialTicks) {
        EntityDroneBase drone = (EntityDroneBase) entity;
        float propRotation = drone.oldPropRotation + (drone.propRotation - drone.oldPropRotation) * partialTicks;
        prop_1.rotateAngleY = propRotation;
        prop_2.rotateAngleY = propRotation;
        prop_3.rotateAngleY = -propRotation;
        prop_4.rotateAngleY = -propRotation;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
