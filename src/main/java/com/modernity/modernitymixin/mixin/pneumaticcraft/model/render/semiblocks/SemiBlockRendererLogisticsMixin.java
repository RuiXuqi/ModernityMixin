package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.semiblocks;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.semiblocks.ModelLogisticsFrameNew;
import me.desht.pneumaticcraft.client.semiblock.SemiBlockRendererLogistics;
import me.desht.pneumaticcraft.common.semiblock.ISemiBlock;
import me.desht.pneumaticcraft.common.semiblock.SemiBlockLogistics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SemiBlockRendererLogistics.class, remap = false)
public class SemiBlockRendererLogisticsMixin {

    @Unique
    private static final AxisAlignedBB DEFAULT_BOX = new AxisAlignedBB((double)0.0625F, (double)0.0625F, (double)0.0625F, (double)0.9375F, (double)0.9375F, (double)0.9375F);

    @Unique
    private final ModelLogisticsFrameNew modernityMixin$modelNew = new ModelLogisticsFrameNew();

    @Shadow
    private native float getLightMultiplier(ISemiBlock semiBlock);

    @Inject(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockLogistics;F)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void modifyRender(SemiBlockLogistics semiBlock, float partialTick, CallbackInfo ci) {
        ResourceLocation texture;
        switch (semiBlock.getColor()) {
            case -7134580:
                texture = TexturesNew.MODEL_LOGISTICS_FRAME_ACTIVE_PROVIDER;
                break;
            case -16742400:
                texture = TexturesNew.MODEL_LOGISTICS_FRAME_DEFAULT_STORAGE;
                break;
            case -65536:
                texture = TexturesNew.MODEL_LOGISTICS_FRAME_PASSIVE_PROVIDER;
                break;
            case -16776961:
                texture = TexturesNew.MODEL_LOGISTICS_FRAME_REQUESTER;
                break;
            case -256:
                texture = TexturesNew.MODEL_LOGISTICS_FRAME_STORAGE;
                break;
            default:
                return;
        }

        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        // Tweak scale to fit the box
        AxisAlignedBB aabb = semiBlock.getWorld() != null ? semiBlock.getBlockState().getBoundingBox(semiBlock.getWorld(), semiBlock.getPos()) : DEFAULT_BOX;
        GlStateManager.translate(aabb.minX, aabb.minY, aabb.minZ);
        GlStateManager.scale(aabb.maxX - aabb.minX, aabb.maxY - aabb.minY, aabb.maxZ - aabb.minZ);

        // Rotate
        EnumFacing side = semiBlock.getSide();
        GlStateManager.translate(0.5, side.getAxis() == EnumFacing.Axis.Y ? 0.5 : -0.5, 0.5);
        switch (side) {
            case UP:
                GlStateManager.rotate(90, 0, 0, 1);
                GlStateManager.translate(0, -1, 0);
                break;
            case DOWN:
                GlStateManager.rotate(-90, 0, 0, 1);
                GlStateManager.translate(0, -1, 0);
                break;
            case NORTH:
                GlStateManager.rotate(90, 0, 1, 0);
                break;
            case SOUTH:
                GlStateManager.rotate(-90, 0, 1, 0);
                break;
            case WEST:
                GlStateManager.rotate(180, 0, 1, 0);
                break;
            case EAST:
                break;
        }

        // Set light
        float lightMul = this.getLightMultiplier(semiBlock);
        GlStateManager.color(lightMul, lightMul, lightMul, 1.0F);

        this.modernityMixin$modelNew.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        ci.cancel();
    }

}
