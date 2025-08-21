package com.modernity.modernitymixin.mixin.pneumaticcraft.model;

import com.modernity.modernitymixin.model.pneumaticcraft.entity.RenderDroneNew;
import me.desht.pneumaticcraft.proxy.ClientProxy;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = ClientProxy.class, remap = false)
public class ClientProxyMixin {

    @ModifyArg(
            method = "preInit",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/fml/client/registry/RenderingRegistry;registerEntityRenderingHandler(Ljava/lang/Class;Lnet/minecraftforge/fml/client/registry/IRenderFactory;)V",
                    ordinal = 1
            ),
            index = 1
    )
    private IRenderFactory<? extends Entity> modifyRegularFactory(IRenderFactory<?> renderFactory) {
        return RenderDroneNew.REGULAR_FACTORY;
    }

    @ModifyArg(
            method = "preInit",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/fml/client/registry/RenderingRegistry;registerEntityRenderingHandler(Ljava/lang/Class;Lnet/minecraftforge/fml/client/registry/IRenderFactory;)V",
                    ordinal = 2
            ),
            index = 1
    )
    private IRenderFactory<? extends Entity> modifyLogisticsFactory(IRenderFactory<?> renderFactory) {
        return RenderDroneNew.LOGISTICS_FACTORY;
    }

    @ModifyArg(
            method = "preInit",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/fml/client/registry/RenderingRegistry;registerEntityRenderingHandler(Ljava/lang/Class;Lnet/minecraftforge/fml/client/registry/IRenderFactory;)V",
                    ordinal = 3
            ),
            index = 1
    )
    private IRenderFactory<? extends Entity> modifyHarvestingFactory(IRenderFactory<?> renderFactory) {
        return RenderDroneNew.HARVESTING_FACTORY;
    }

    @ModifyArg(
            method = "preInit",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/fml/client/registry/RenderingRegistry;registerEntityRenderingHandler(Ljava/lang/Class;Lnet/minecraftforge/fml/client/registry/IRenderFactory;)V",
                    ordinal = 4
            ),
            index = 1
    )
    private IRenderFactory<? extends Entity> modifyProgrammableControllerFactory(IRenderFactory<?> renderFactory) {
        return RenderDroneNew.PROGRAMMABLE_CONTROLLER_FACTORY;
    }

}
