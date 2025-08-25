package com.modernity.modernitymixin.mixin.pneumaticcraft.model.render;

import com.modernity.modernitymixin.model.pneumaticcraft.entity.ModelDroneMinigunNew;
import me.desht.pneumaticcraft.client.model.entity.ModelDroneMinigun;
import me.desht.pneumaticcraft.client.render.RenderItemMinigun;
import me.desht.pneumaticcraft.common.item.ItemMinigun;
import me.desht.pneumaticcraft.common.item.Itemss;
import me.desht.pneumaticcraft.common.minigun.Minigun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderItemMinigun.class, remap = false)
public class RenderItemMinigunMixin {

    @Shadow @Mutable
    private final ModelDroneMinigun model = new ModelDroneMinigunNew();

    /**
     * @author RuiXuqi
     * @reason Fix handheld
     */
    @Overwrite
    public void renderByItem(ItemStack stack, float partialTicks) {
        if (stack.getItem() == Itemss.MINIGUN && stack.hasTagCompound()) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer player = mc.player;
            int id = stack.getTagCompound().getInteger("owningPlayerId");
            Entity owningPlayer = mc.world.getEntityByID(id);
            if (owningPlayer instanceof EntityPlayer) {
                Minigun minigun = ((ItemMinigun) stack.getItem()).getMinigun(stack, (EntityPlayer) owningPlayer);
                GlStateManager.pushMatrix();
                if (mc.currentScreen instanceof GuiContainer) {
                    // our own gun in the rendered player model in inventory screen
                    GlStateManager.rotate(90, 1, 0, 0);
                    GlStateManager.translate(0.5, -1, -0.5);
                } else if (mc.gameSettings.thirdPersonView != 0 || player.getEntityId() != owningPlayer.getEntityId()) {
                        // rendering our own gun in 3rd person, or rendering someone else's gun
                        GlStateManager.scale(1, -1, -1);
                        GlStateManager.rotate(75, 1, 0, 0);
                        GlStateManager.rotate(180, 0, 1, 0);
                        GlStateManager.translate(-0.5, -2, -0.3);
                } else {
                    // Hides minigun in first person if in offhand because it's not usable in offhand anyway
                    if(player.getHeldItemOffhand() == stack) {
                        GlStateManager.scale(0f, 0f, 0f);
                    }

                    // Shows minigun in main hand appropriate to which side is set as the main hand
                    else {
                        // our own gun in 1st person
                        GlStateManager.scale(1.5, 1.5, 1.5);
                        GlStateManager.rotate(180, 0, 0, 1);
                        if (mc.gameSettings.mainHand == EnumHandSide.RIGHT) {
                            GlStateManager.translate(-1, -1.7, 0.1);
                        } else {
                            GlStateManager.translate(0.4, -1.7, 0.1);
                        }
                    }
                }
                model.renderMinigun(minigun, 1 / 16F, partialTicks, false);
                GlStateManager.popMatrix();
            }
        }
    }

}
