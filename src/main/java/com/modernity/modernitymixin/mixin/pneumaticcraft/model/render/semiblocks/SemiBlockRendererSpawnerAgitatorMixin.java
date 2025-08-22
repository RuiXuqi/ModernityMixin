package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render.semiblocks;

import com.modernity.modernitymixin.model.pneumaticcraft.TexturesNew;
import com.modernity.modernitymixin.model.pneumaticcraft.semiblocks.ModelSpawnerAgitatorNew;
import me.desht.pneumaticcraft.client.model.semiblocks.ModelHeatFrame;
import me.desht.pneumaticcraft.client.semiblock.SemiBlockRendererSpawnerAgitator;
import me.desht.pneumaticcraft.common.config.ConfigHandler;
import me.desht.pneumaticcraft.common.semiblock.SemiBlockSpawnerAgitator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = SemiBlockRendererSpawnerAgitator.class, remap = false)
public class SemiBlockRendererSpawnerAgitatorMixin {

    @Shadow
    @Mutable
    @SuppressWarnings("unused")
    private final ModelHeatFrame model = null;

    @Unique
    private final ModelSpawnerAgitatorNew modernityMixin$modelNew = new ModelSpawnerAgitatorNew();

    @Redirect(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockSpawnerAgitator;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lme/desht/pneumaticcraft/client/model/semiblocks/ModelHeatFrame;render(Lnet/minecraft/entity/Entity;FFFFFF)V"
            )
    )
    private void modifyModel(ModelHeatFrame instance, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.modernityMixin$modelNew.render(entity, f, f1, f2, f3, f4, f5);
    }

    @ModifyArg(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockSpawnerAgitator;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V"
            )
    )
    private ResourceLocation modifyTexture(ResourceLocation original) {
        return TexturesNew.MODEL_SPAWNER_AGITATOR;
    }

    @Unique
    private float modernityMixin$lightMul;

    @Inject(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockSpawnerAgitator;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/GlStateManager;pushMatrix()V"
            )
    )
    private void getSemiblock(SemiBlockSpawnerAgitator semiBlock, float partialTick, CallbackInfo ci) {
        this.modernityMixin$lightMul = modernityMixin$getLightMultiplier(semiBlock);
        GlStateManager.rotate(180, 1, 0, 0);
        GlStateManager.translate(0, -1, -1);
    }

    @ModifyArgs(
            method = "render(Lme/desht/pneumaticcraft/common/semiblock/SemiBlockSpawnerAgitator;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/GlStateManager;color(FFFF)V",
                    ordinal = 0
            )
    )
    private void modifyColor(Args args) {
        args.set(0, this.modernityMixin$lightMul);
        args.set(1, this.modernityMixin$lightMul);
        args.set(2, this.modernityMixin$lightMul);
    }

    @Unique
    private float modernityMixin$getLightMultiplier(SemiBlockSpawnerAgitator semiBlock) {
        if (!ConfigHandler.client.semiBlockLighting) {
            return 1.0F;
        } else {
            return Math.max(0.05F, (float) Minecraft.getMinecraft().world.getLight(semiBlock.getPos()) / 15.0F);
        }
    }

}
