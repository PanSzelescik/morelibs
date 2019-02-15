package panszelescik.morelibs.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import panszelescik.morelibs.api.ZoomHelper.IZoomable;

import java.util.HashMap;

public class ClientHelper {

    /*static HashMap<String, ResourceLocation> resourceMap = new HashMap<String, ResourceLocation>();

    public static Minecraft mc() {
        return Minecraft.getInstance();
    }

    public static FontRenderer font() {
        return mc().fontRenderer;
    }

    public static void bindTexture(String path) {
        mc().getTextureManager().bindTexture(getResource(path));
    }

    public static ResourceLocation getResource(String path) {
        ResourceLocation rl = resourceMap.containsKey(path) ? resourceMap.get(path) : new ResourceLocation(path);
        if (!resourceMap.containsKey(path))
            resourceMap.put(path, rl);
        return rl;
    }

    public static void drawColouredRect(int x, int y, int w, int h, int colour) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldrenderer = tessellator.getBuffer();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(x, y + h, 0).color(colour >> 16 & 255, colour >> 8 & 255, colour & 255, colour >> 24 & 255).endVertex();
        worldrenderer.pos(x + w, y + h, 0).color(colour >> 16 & 255, colour >> 8 & 255, colour & 255, colour >> 24 & 255).endVertex();
        worldrenderer.pos(x + w, y, 0).color(colour >> 16 & 255, colour >> 8 & 255, colour & 255, colour >> 24 & 255).endVertex();
        worldrenderer.pos(x, y, 0).color(colour >> 16 & 255, colour >> 8 & 255, colour & 255, colour >> 24 & 255).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawTexturedRect(float x, float y, float w, float h, double... uv) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldrenderer = tessellator.getBuffer();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x, y + h, 0).tex(uv[0], uv[3]).endVertex();
        worldrenderer.pos(x + w, y + h, 0).tex(uv[1], uv[3]).endVertex();
        worldrenderer.pos(x + w, y, 0).tex(uv[1], uv[2]).endVertex();
        worldrenderer.pos(x, y, 0).tex(uv[0], uv[2]).endVertex();
        tessellator.draw();
    }

    public static void drawTexturedRect(int x, int y, int w, int h, float picSize, int... uv) {
        double[] d_uv = new double[]{uv[0] / picSize, uv[1] / picSize, uv[2] / picSize, uv[3] / picSize};
        drawTexturedRect(x, y, w, h, d_uv);
    }

    public static ItemStack getZoomable(EntityPlayerSP player) {
        ItemStack main = player.getHeldItem(EnumHand.MAIN_HAND);
        if (main.isEmpty() || !(main.getItem() instanceof IZoomable)) {
            ItemStack off = player.getHeldItem(EnumHand.OFF_HAND);
            if (!off.isEmpty() && off.getItem() instanceof IZoomable)
                return off;
            else
                return ItemStack.EMPTY;
        } else if (!main.isEmpty() && main.getItem() instanceof IZoomable)
            return main;
        return ItemStack.EMPTY;
    }*/
}