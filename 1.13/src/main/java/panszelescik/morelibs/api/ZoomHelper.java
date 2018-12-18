package panszelescik.morelibs.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ZoomHelper {
	
	public static float fovZoom = 1;
	public static boolean isZooming = false;
	
	public interface IZoomable {
		boolean canZoom(ItemStack stack, EntityPlayer player);
		float[] getZoomSteps(ItemStack stack, EntityPlayer player);
	}
}