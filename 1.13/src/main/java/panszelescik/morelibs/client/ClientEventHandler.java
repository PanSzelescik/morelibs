package panszelescik.morelibs.client;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import panszelescik.morelibs.api.ZoomHelper;
import panszelescik.morelibs.api.ZoomHelper.IZoomable;

/*
 * @author BluSunrize
 * https://github.com/BluSunrize/ImmersiveEngineering/blob/master/src/main/java/blusunrize/immersiveengineering/client/ClientEventHandler.java
 */
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ClientEventHandler {

    /*@SubscribeEvent
    public static void onRenderOverlayPre(RenderGameOverlayEvent.Pre event) {
        if (ZoomHelper.isZooming && event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            event.setCanceled(true);
            if (ZoomHelper.isZooming && ClientHelper.mc().gameSettings.thirdPersonView == 0) {
                ClientHelper.bindTexture("morelibs:textures/gui/scope.png");
                int width = event.getResolution().getScaledWidth();
                int height = event.getResolution().getScaledHeight();
                int resMin = Math.min(width, height);
                float offsetX = (width - resMin) / 2f;
                float offsetY = (height - resMin) / 2f;
                if (resMin == width) {
                    ClientHelper.drawColouredRect(0, 0, width, (int) offsetY + 1, 0xff000000);
                    ClientHelper.drawColouredRect(0, (int) offsetY + resMin, width, (int) offsetY + 1, 0xff000000);
                } else {
                    ClientHelper.drawColouredRect(0, 0, (int) offsetX + 1, height, 0xff000000);
                    ClientHelper.drawColouredRect((int) offsetX + resMin, 0, (int) offsetX + 1, height, 0xff000000);
                }
                GlStateManager.enableBlend();
                OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                GlStateManager.translate(offsetX, offsetY, 0);
                ClientHelper.drawTexturedRect(0, 0, resMin, resMin, 0f, 1f, 0f, 1f);
                ClientHelper.bindTexture("morelibs:textures/gui/hud_elements.png");
                ClientHelper.drawTexturedRect(218 / 256f * resMin, 64 / 256f * resMin, 24 / 256f * resMin, 128 / 256f * resMin, 64 / 256f, 88 / 256f, 96 / 256f, 224 / 256f);
                ItemStack equipped = ClientHelper.getZoomable(ClientHelper.mc().player);
                if (equipped != ItemStack.EMPTY) {
                    IZoomable tool = (IZoomable) equipped.getItem();
                    float[] steps = tool.getZoomSteps(equipped, ClientHelper.mc().player);
                    if (steps != null && steps.length > 1) {
                        int curStep = -1;
                        float dist = 0;
                        float totalOffset = 0;
                        float stepLength = 118 / (float) steps.length;
                        float stepOffset = (stepLength - 7) / 2f;
                        GlStateManager.translate(223 / 256f * resMin, 64 / 256f * resMin, 0);
                        GlStateManager.translate(0, (5 + stepOffset) / 256 * resMin, 0);
                        for (int i = 0; i < steps.length; i++) {
                            ClientHelper.drawTexturedRect(0, 0, 8 / 256f * resMin, 7 / 256f * resMin, 88 / 256f, 96 / 256f, 96 / 256f, 103 / 256f);
                            GlStateManager.translate(0, stepLength / 256 * resMin, 0);
                            totalOffset += stepLength;
                            if (curStep == -1 || Math.abs(steps[i] - ZoomHelper.fovZoom) < dist) {
                                curStep = i;
                                dist = Math.abs(steps[i] - ZoomHelper.fovZoom);
                            }
                        }
                        GlStateManager.translate(0, -totalOffset / 256 * resMin, 0);
                        if (curStep >= 0 && curStep < steps.length) {
                            GlStateManager.translate(6 / 256f * resMin, curStep * stepLength / 256 * resMin, 0);
                            ClientHelper.drawTexturedRect(0, 0, 8 / 256f * resMin, 7 / 256f * resMin, 88 / 256f, 98 / 256f, 103 / 256f, 110 / 256f);
                            ClientHelper.font().drawString((1 / steps[curStep]) + "x", (int) (16 / 256f * resMin), 0, 0xffffff);
                            GlStateManager.translate(-6 / 256f * resMin, -curStep * stepLength / 256 * resMin, 0);
                        }
                        GlStateManager.translate(0, -((5 + stepOffset) / 256 * resMin), 0);
                        GlStateManager.translate(-223 / 256f * resMin, -64 / 256f * resMin, 0);
                    }
                }
                GlStateManager.translate(-offsetX, -offsetY, 0);
            }
        }
    }

    @SubscribeEvent
    public static void onFOVUpdate(FOVUpdateEvent event) {
        EntityPlayer player = ClientHelper.mc().player;
        ItemStack equipped = ClientHelper.getZoomable(ClientHelper.mc().player);
        if (equipped != ItemStack.EMPTY) {
            if (player.isSneaking() && player.onGround && ClientHelper.mc().gameSettings.thirdPersonView == 0) {
                IZoomable tool = (IZoomable) equipped.getItem();
                if (tool.canZoom(equipped, player)) {
                    if (!ZoomHelper.isZooming) {
                        float[] steps = tool.getZoomSteps(equipped, player);
                        if (steps != null && steps.length > 0) {
                            int curStep = -1;
                            float dist = 0;
                            for (int i = 0; i < steps.length; i++)
                                if (curStep == -1 || Math.abs(steps[i] - ZoomHelper.fovZoom) < dist) {
                                    curStep = i;
                                    dist = Math.abs(steps[i] - ZoomHelper.fovZoom);
                                }
                            if (curStep != -1)
                                ZoomHelper.fovZoom = steps[curStep];
                            else
                                ZoomHelper.fovZoom = event.getFov();
                        }
                        ZoomHelper.isZooming = true;
                    }
                    event.setNewfov(ZoomHelper.fovZoom);
                } else if (ZoomHelper.isZooming)
                    ZoomHelper.isZooming = false;
            } else if (ZoomHelper.isZooming)
                ZoomHelper.isZooming = false;
        } else if (ZoomHelper.isZooming)
            ZoomHelper.isZooming = false;

    }

    @SubscribeEvent
    public static void onMouseEvent(MouseEvent event) {
        if (event.getDwheel() != 0 && ClientHelper.mc().gameSettings.thirdPersonView == 0) {
            EntityPlayer player = ClientHelper.mc().player;
            if (player.isSneaking()) {
                ItemStack equipped = ClientHelper.getZoomable(ClientHelper.mc().player);
                if (equipped != ItemStack.EMPTY) {
                    IZoomable tool = (IZoomable) equipped.getItem();
                    if (tool.canZoom(equipped, player)) {
                        float[] steps = tool.getZoomSteps(equipped, player);
                        if (steps != null && steps.length > 0) {
                            int curStep = -1;
                            float dist = 0;
                            for (int i = 0; i < steps.length; i++)
                                if (curStep == -1 || Math.abs(steps[i] - ZoomHelper.fovZoom) < dist) {
                                    curStep = i;
                                    dist = Math.abs(steps[i] - ZoomHelper.fovZoom);
                                }
                            if (curStep != -1) {
                                int newStep = curStep + (event.getDwheel() > 0 ? -1 : 1);
                                if (newStep >= 0 && newStep < steps.length)
                                    ZoomHelper.fovZoom = steps[newStep];
                                event.setCanceled(true);
                            }
                        }
                    }
                }
            }
        }
    }*/
}