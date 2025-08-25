package com.modernity.modernitymixin.model.pneumaticcraft.module;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import me.desht.pneumaticcraft.client.model.module.ModelModuleBase;
import me.desht.pneumaticcraft.client.util.GuiUtils;
import me.desht.pneumaticcraft.common.block.tubes.ModulePressureGauge;
import me.desht.pneumaticcraft.common.tileentity.TileEntityPneumaticBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class ModelGaugeNew extends ModelModuleBase {
    private final ModulePressureGauge gaugeModule;
    private final ModelRenderer tubeConnector1;
    private final ModelRenderer tubeConnector2;
    private final ModelRenderer faceplate;
    private final ModelRenderer gauge1;
    private final ModelRenderer gauge2;
    private final ModelRenderer gauge3;
    private final ModelRenderer gauge4;
    private final ModelRenderer gauge5;
    private final ModelRenderer gauge6;
    private final ModelRenderer gauge7;
    private final ModelRenderer gauge8;


    public ModelGaugeNew(ModulePressureGauge gaugeModule) {
        this.gaugeModule = gaugeModule;
        textureWidth = 64;
        textureHeight = 64;

        tubeConnector1 = new ModelRenderer(this, 0, 0);
        tubeConnector1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
        tubeConnector1.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector1.mirror = true;

        tubeConnector2 = new ModelRenderer(this, 22, 6);
        tubeConnector2.addBox(-2.0F, -2.0F, 2.0F, 7, 7, 1);
        tubeConnector2.setRotationPoint(-1.5F, 14.5F, 2.0F);
        tubeConnector2.mirror = true;

        faceplate = new ModelRenderer(this, 0, 6);
        faceplate.addBox(-1.0F, -1.0F, 0.0F, 10, 10, 1);
        faceplate.setRotationPoint(-4.0F, 12.0F, 5.0F);
        faceplate.mirror = true;

        gauge1 = new ModelRenderer(this, 0, 17);
        gauge1.addBox(-3.0F, -2.0F, 0.0F, 1, 4, 1);
        gauge1.setRotationPoint(-1.0F, 16.0F, 5.5F);

        gauge2 = new ModelRenderer(this, 4, 17);
        gauge2.addBox(4.0F, -2.0F, 0.0F, 1, 4, 1);
        gauge2.setRotationPoint(-1.0F, 16.0F, 5.5F);

        gauge3 = new ModelRenderer(this, 8, 17);
        gauge3.addBox(3.0F, -3.0F, 0.0F, 1, 1, 1);
        gauge3.setRotationPoint(-1.0F, 16.0F, 5.5F);

        gauge4 = new ModelRenderer(this, 12, 17);
        gauge4.addBox(3.0F, 2.0F, 0.0F, 1, 1, 1);
        gauge4.setRotationPoint(-1.0F, 16.0F, 5.5F);

        gauge5 = new ModelRenderer(this, 8, 19);
        gauge5.addBox(-2.0F, -3.0F, 0.0F, 1, 1, 1);
        gauge5.setRotationPoint(-1.0F, 16.0F, 5.5F);

        gauge6 = new ModelRenderer(this, 12, 19);
        gauge6.addBox(-2.0F, 2.0F, 0.0F, 1, 1, 1);
        gauge6.setRotationPoint(-1.0F, 16.0F, 5.5F);

        gauge7 = new ModelRenderer(this, 0, 24);
        gauge7.addBox(-1.0F, 3.0F, 0.0F, 4, 1, 1);
        gauge7.setRotationPoint(-1.0F, 16.0F, 5.5F);

        gauge8 = new ModelRenderer(this, 0, 22);
        gauge8.addBox(-1.0F, -4.0F, 0.0F, 4, 1, 1);
        gauge8.setRotationPoint(-1.0F, 16.0F, 5.5F);
    }

    @Override
    protected void renderDynamic(float scale, float partialTicks) {
        tubeConnector1.render(scale);
        tubeConnector2.render(scale);
        faceplate.render(scale);
        gauge1.render(scale);
        gauge2.render(scale);
        gauge3.render(scale);
        gauge4.render(scale);
        gauge5.render(scale);
        gauge6.render(scale);
        gauge7.render(scale);
        gauge8.render(scale);

        EntityPlayer player = Minecraft.getMinecraft().player;
        BlockPos blockPos = gaugeModule.getTube().pos();
        if (player != null && player.getPosition().distanceSq(blockPos) > 256) return;

        float pressure = 0f;
        float dangerPressure = 5f;
        float critPressure = 7f;
        if (gaugeModule.getTube() instanceof TileEntityPneumaticBase) {
            TileEntityPneumaticBase base = (TileEntityPneumaticBase) gaugeModule.getTube();
            pressure = base.getPressure();
            critPressure = base.criticalPressure;
            dangerPressure = base.dangerPressure;
        }
        GlStateManager.translate(0, 1, 0.378);
        double widgetScale = 0.007D;
        GlStateManager.scale(widgetScale, widgetScale, widgetScale);
        GlStateManager.rotate(180, 0, 1, 0);
        GlStateManager.disableLighting();
        GuiUtils.drawPressureGauge(FMLClientHandler.instance().getClient().fontRenderer, -1, critPressure, dangerPressure, -1.001F, pressure, 0, 0, 0);
        GlStateManager.enableLighting();
    }

    @Override
    protected ResourceLocation getTexture() {
        ResourceLocation texture;
        if (gaugeModule != null && gaugeModule.isUpgraded()) {
            texture = TexturesNew.MODEL_GAUGE_UPGRADED;
        } else {
            texture = TexturesNew.MODEL_GAUGE;
        }
        return texture;
    }
}
