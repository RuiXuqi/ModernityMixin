package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block;

import me.desht.pneumaticcraft.common.block.BlockLiquidCompressor;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = BlockLiquidCompressor.class, remap = false)
public class BlockLiquidCompressorMixin {

    @Unique
    @SuppressWarnings({"unused", "AddedMixinMembersNamePattern"})
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
