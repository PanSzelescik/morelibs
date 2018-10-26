package panszelescik.morelibs.api;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
	
	public static NBTTagCompound getTagCompound(ItemStack stack) {
		if (stack.isEmpty()) {
			return null;
		}
		if (stack.getTagCompound() == null) {
			stack.setTagCompound(new NBTTagCompound());
		}
		return stack.getTagCompound();
	}

	public static boolean keyExists(ItemStack stack, String key) {
		if (stack.isEmpty()) {
			return false;
		}
		return getTagCompound(stack).hasKey(key);
	}

	public static int getInt(ItemStack stack, String key, int defaultValue) {
		if (!keyExists(stack, key)) {
			return defaultValue;
		}
		return getTagCompound(stack).getInteger(key);
	}

	public static void setInt(ItemStack stack, String key, int value) {
		getTagCompound(stack).setInteger(key, value);
	}
	public static boolean getBoolean(ItemStack stack, String key, boolean defaultValue) {
		if (!keyExists(stack, key)) {
			return defaultValue;
		}
		return getTagCompound(stack).getBoolean(key);
	}

	public static void setBoolean(ItemStack stack, String key, boolean value) {
		getTagCompound(stack).setBoolean(key, value);
	}
	
	public static String getString(ItemStack stack, String key, String defaultValue) {
		if (!keyExists(stack, key)) {
			return defaultValue;
		}
		return getTagCompound(stack).getString(key);
	}

	public static void setString(ItemStack stack, String key, String value) {
		getTagCompound(stack).setString(key, value);
	}
}