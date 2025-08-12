package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block;

import me.desht.pneumaticcraft.common.block.BlockVacuumPump;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = BlockVacuumPump.class, remap = false)
public class BlockVacuumPumpMixin {

    // Set the render layer translucent. Do not add @Unique.
    @SuppressWarnings({"unused", "MissingUnique", "AddedMixinMembersNamePattern"})
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

}
