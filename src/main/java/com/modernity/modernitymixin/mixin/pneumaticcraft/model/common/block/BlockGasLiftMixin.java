package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block;

import me.desht.pneumaticcraft.common.block.BlockGasLift;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = BlockGasLift.class, remap = false)
public class BlockGasLiftMixin {

    @Unique
    @SuppressWarnings({"unused", "AddedMixinMembersNamePattern"})
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
