package com.modernity.modernitymixin.mixin.pneumaticcraft;

import com.llamalad7.mixinextras.sugar.Local;
import me.desht.pneumaticcraft.common.util.PastebinHandler;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = PastebinHandler.class, remap = false)
public class PastebinHandlerMixin {

    // http to https
    @ModifyArg(
            method = "loginInternal",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/apache/http/client/methods/HttpPost;<init>(Ljava/lang/String;)V"
            ),
            index = 0
    )
    private String modifyLoginUrl(String uri) {
        return uri.replace("http://", "https://");
    }

    @ModifyArg(
            method = "putInternal",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/apache/http/client/methods/HttpPost;<init>(Ljava/lang/String;)V"
            ),
            index = 0
    )
    private String modifyPutUrl(String uri) {
        return uri.replace("http://", "https://");
    }

    @ModifyArg(
            method = "getInternal",
            at = @At(
                    value = "INVOKE",
                    target = "Lme/desht/pneumaticcraft/common/util/PneumaticCraftUtils;getPage(Ljava/lang/String;)Ljava/lang/String;"
            ),
            index = 0
    )
    private String modifyGetUrl(String urlString) {
        return urlString.replace("http://", "https://");
    }

    // Add json format
    @Inject(
            method = "putInternal",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                    ordinal = 0
            )
    )
    private void addJsonFormatParam(String contents, CallbackInfoReturnable<String> cir, @Local List<NameValuePair> params) {
        params.add(new BasicNameValuePair("api_paste_format", "json"));
    }

}
