package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block;

import me.desht.pneumaticcraft.common.block.Blockss;
import me.desht.pneumaticcraft.common.tileentity.TileEntityOmnidirectionalHopper;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraftforge.client.event.ColorHandlerEvent;

@Mixin(value = Blockss.class, remap = false)
public class BlockssMixin {

    @Inject(
            method = "registerBlockColorHandlers",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/client/event/ColorHandlerEvent$Block;getBlockColors()Lnet/minecraft/client/renderer/color/BlockColors;",
                    shift = At.Shift.AFTER
            )
    )
    private static void modifyHopperColor(ColorHandlerEvent.Block event, CallbackInfo ci) {
        event.getBlockColors().registerBlockColorHandler((state, blockAccess, pos, tintIndex) -> {
            if (blockAccess != null && pos != null) {
                TileEntity te = blockAccess.getTileEntity(pos);
                if (te instanceof TileEntityOmnidirectionalHopper) {
                    return ((TileEntityOmnidirectionalHopper) te).isCreative ? 0xFFDB46CF : 0xFF2b2727;
                }
            }
            return 0xFFFFFFFF;
        }, Blockss.OMNIDIRECTIONAL_HOPPER, Blockss.LIQUID_HOPPER);
    }

}
