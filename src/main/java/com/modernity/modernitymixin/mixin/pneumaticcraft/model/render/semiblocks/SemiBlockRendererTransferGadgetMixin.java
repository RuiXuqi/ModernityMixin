package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.semiblocks;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.semiblocks.ModelTransferGadgetNew;
import me.desht.pneumaticcraft.client.semiblock.SemiBlockRendererTransferGadget;
import me.desht.pneumaticcraft.common.config.ConfigHandler;
import me.desht.pneumaticcraft.common.semiblock.SemiBlockTransferGadget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SemiBlockRendererTransferGadget.class, remap = false)
public class SemiBlockRendererTransferGadgetMixin {

/*    @Unique
    private static final AxisAlignedBB DEFAULT_BOX = new AxisAlignedBB((double)0.0625F, (double)0.0625F, (double)0.0625F, (double)0.9375F, (double)0.9375F, (double)0.9375F);

    @Unique
    private final ModelTransferGadgetNew modernityMixin$modelNew = new ModelTransferGadgetNew();


    @Inject(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockTransferGadget;F)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void modifyRender(SemiBlockTransferGadget semiBlock, float partialTick, CallbackInfo ci) {
        ResourceLocation texture;
        switch (semiBlock.getInputOutput()) {
            case INPUT:
                texture = TexturesNew.MODEL_TRANSFER_GADGET_IN;
                break;
            case OUTPUT:
                texture = TexturesNew.MODEL_TRANSFER_GADGET_OUT;
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
        EnumFacing side = semiBlock.getFacing();
        GlStateManager.translate(0.5, side.getAxis() == EnumFacing.Axis.Y ? 0.5 : -0.5, 0.5);
        switch (side) {
            case UP:
                GlStateManager.translate(1, 0, 0);
                GlStateManager.rotate(90, 0, 0, 1);
                break;
            case DOWN:
                GlStateManager.translate(-1, 0, 0);
                GlStateManager.rotate(-90, 0, 0, 1);
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
        float lightMul = this.modernityMixin$getLightMultiplier(semiBlock);
        GlStateManager.color(lightMul, lightMul, lightMul, 1.0F);

        this.modernityMixin$modelNew.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        ci.cancel();
    }

    @Unique
    private float modernityMixin$getLightMultiplier(SemiBlockTransferGadget semiBlock) {
        return ConfigHandler.client.semiBlockLighting ? Math.max(0.05F, (float) Minecraft.getMinecraft().world.getLight(semiBlock.getPos()) / 15.0F) : 1.0F;
    }*/

}
