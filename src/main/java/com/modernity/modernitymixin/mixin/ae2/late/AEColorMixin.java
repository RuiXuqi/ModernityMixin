package com.modernity.modernitymixin.mixin.ae2.late;

import appeng.api.util.AEColor;
import net.minecraft.item.EnumDyeColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nonnull;

@Mixin(value = AEColor.class, remap = false)
public class AEColorMixin {

    @Shadow @Final @Mutable public int blackVariant;
    @Shadow @Final @Mutable public int mediumVariant;
    @Shadow @Final @Mutable public int whiteVariant;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(@Nonnull String enumName, int ordinal, String unlocalizedName, EnumDyeColor dye, int blackHex, int medHex, int whiteHex, CallbackInfo ci) {
        switch (enumName) {
            case "WHITE":
                this.blackVariant = 0xB4B4B4;
                this.mediumVariant = 0xE0E0E0;
                this.whiteVariant = 0xF9F9F9;
                break;
            case "ORANGE":
                this.blackVariant = 0xD9782F;
                this.mediumVariant = 0xECA23C;
                this.whiteVariant = 0xF2BA49;
                break;
            case "MAGENTA":
                this.blackVariant = 0xC15189;
                this.mediumVariant = 0xD5719C;
                this.whiteVariant = 0xE69EBF;
                break;
            case "LIGHT_BLUE":
                this.blackVariant = 0x69B9FF;
                this.mediumVariant = 0x70D2FF;
                this.whiteVariant = 0x80F7FF;
                break;
            case "YELLOW":
                this.blackVariant = 0xFFCF40;
                this.mediumVariant = 0xFFE359;
                this.whiteVariant = 0xF4FF80;
                break;
            case "LIME":
                this.blackVariant = 0x4EC04E;
                this.mediumVariant = 0x70E259;
                this.whiteVariant = 0xB3F86D;
                break;
            case "PINK":
                this.blackVariant = 0xD86EAA;
                this.mediumVariant = 0xFF99BB;
                this.whiteVariant = 0xFBCAD5;
                break;
            case "GRAY":
                this.blackVariant = 0x4F4F4F;
                this.mediumVariant = 0x6C6B6C;
                this.whiteVariant = 0x949294;
                break;
            case "LIGHT_GRAY":
                this.blackVariant = 0x7E7E7E;
                this.mediumVariant = 0xA09FA0;
                this.whiteVariant = 0xC4C4C4;
                break;
            case "CYAN":
                this.blackVariant = 0x22B0AE;
                this.mediumVariant = 0x2FCCB7;
                this.whiteVariant = 0x65E8C9;
                break;
            case "PURPLE":
                this.blackVariant = 0x6E5CB8;
                this.mediumVariant = 0x915DCD;
                this.whiteVariant = 0xB06FDD;
                break;
            case "BLUE":
                this.blackVariant = 0x337FF0;
                this.mediumVariant = 0x3894FF;
                this.whiteVariant = 0x40C1FF;
                break;
            case "BROWN":
                this.blackVariant = 0x6E4A12;
                this.mediumVariant = 0x7E5C16;
                this.whiteVariant = 0x8E6E1A;
                break;
            case "GREEN":
                this.blackVariant = 0x079B6B;
                this.mediumVariant = 0x17B86D;
                this.whiteVariant = 0x32D850;
                break;
            case "RED":
                this.blackVariant = 0xAA212B;
                this.mediumVariant = 0xD73E42;
                this.whiteVariant = 0xF07665;
                break;
            case "BLACK":
                this.blackVariant = 0x131313;
                this.mediumVariant = 0x272727;
                this.whiteVariant = 0x3B3B3B;
                break;
            case "TRANSPARENT":
                this.blackVariant = 0x5A479E;
                this.mediumVariant = 0x915DCD;
                this.whiteVariant = 0xE2A3E3;
                break;
        }
    }
}
