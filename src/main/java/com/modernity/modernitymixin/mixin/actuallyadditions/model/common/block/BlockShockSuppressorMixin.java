package com.modernity.modernitymixin.mixin.actuallyadditions.model.common.block;

import de.ellpeck.actuallyadditions.mod.blocks.BlockShockSuppressor;
import net.minecraft.block.state.IBlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = BlockShockSuppressor.class, remap = false)
public class BlockShockSuppressorMixin {

    @Unique
    @SuppressWarnings({"unused", "AddedMixinMembersNamePattern"})
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

}
