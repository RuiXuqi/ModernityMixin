package com.modernity.modernitymixin.mixin.pneumaticcraft.model.common.block;

import me.desht.pneumaticcraft.common.block.BlockUVLightBox;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = BlockUVLightBox.class, remap = false)
public class BlockUVLightBoxMixin {

    @Unique
    @SuppressWarnings({"unused", "AddedMixinMembersNamePattern"})
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

}
