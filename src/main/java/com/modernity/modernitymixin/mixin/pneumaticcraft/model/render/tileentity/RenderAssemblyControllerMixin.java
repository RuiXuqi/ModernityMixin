package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.tileentity;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.block.ModelAssemblyControllerScreenNew;
import me.desht.pneumaticcraft.client.model.block.ModelAssemblyControllerScreen;
import me.desht.pneumaticcraft.client.render.tileentity.RenderAssemblyController;
import me.desht.pneumaticcraft.common.tileentity.TileEntityAssemblyController;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = RenderAssemblyController.class, remap = false)
public class RenderAssemblyControllerMixin {

    @Unique
    private static final double TEXT_SIZE = 0.007F;

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelAssemblyControllerScreen model = new ModelAssemblyControllerScreenNew();

    @ModifyArgs(
            method = "renderModel(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyController;F)V", // 目标方法
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/GlStateManager;translate(DDD)V"
            )
    )
    private void modifyTranslateArgs(Args args) {
        args.set(0, -0.23D);
        args.set(1, 0.50D);
        args.set(2, -0.04D);
    }

    @ModifyArgs(
            method = "renderModel(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyController;F)V", // 目标方法
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/GlStateManager;scale(DDD)V"
            )
    )
    private void modifyScaleArgs(Args args) {
        args.set(0, TEXT_SIZE);
        args.set(1, TEXT_SIZE);
        args.set(2, TEXT_SIZE);
    }

    @ModifyArgs(
            method = "renderModel(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyController;F)V", // 目标方法
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/FontRenderer;drawString(Ljava/lang/String;III)I"
            )
    )
    private void modifyDrawStringArgs(Args args) {
        args.set(0, "> " + args.get(0));
        args.set(3, 0xFF4ce568);
    }

    @ModifyArgs(
            method = "renderModel(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyController;F)V", // 目标方法
            at = @At(
                    value = "INVOKE",
                    target = "Lme/desht/pneumaticcraft/client/gui/GuiPneumaticContainerBase;drawTexture(Lnet/minecraft/util/ResourceLocation;II)V"
            )
    )
    private void modifyDrawTextureArgs(Args args) {
        args.set(0, TexturesNew.GUI_GREEN_PROBLEMS_TEXTURE);
        args.set(1, 0);
        args.set(2, 18);
    }

    @Inject(method = "getTexture(Lme/desht/pneumaticcraft/common/tileentity/TileEntityAssemblyController;)Lnet/minecraft/util/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    void modifyTexture(TileEntityAssemblyController te, CallbackInfoReturnable<ResourceLocation> cir) {
        cir.setReturnValue(TexturesNew.MODEL_ASSEMBLY_CONTROLLER);
    }

}
