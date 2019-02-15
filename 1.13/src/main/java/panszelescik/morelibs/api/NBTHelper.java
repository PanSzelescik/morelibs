package panszelescik.morelibs.api;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {

    public static NBTTagCompound getTagCompound(ItemStack stack) {
        if (stack.isEmpty()) {
            return null;
        }
        if (stack.getTag() == null) {
            stack.setTag(new NBTTagCompound());
        }
        return stack.getTag();
    }

    public static boolean keyExists(ItemStack stack, String key) {
        if (stack.isEmpty()) {
            return false;
        }
        return getTagCompound(stack).contains(key);
    }

    public static boolean getBoolean(ItemStack stack, String key, boolean defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getBoolean(key);
    }

    public static void setBoolean(ItemStack stack, String key, boolean value) {
        getTagCompound(stack).putBoolean(key, value);
    }

    public static byte getByte(ItemStack stack, String key, byte defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getByte(key);
    }

    public static void setByte(ItemStack stack, String key, byte value) {
        getTagCompound(stack).putByte(key, value);
    }

    public static byte[] getByteArray(ItemStack stack, String key, byte[] defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getByteArray(key);
    }

    public static void setByteArray(ItemStack stack, String key, byte[] value) {
        getTagCompound(stack).putByteArray(key, value);
    }

    public static double getDouble(ItemStack stack, String key, double defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getDouble(key);
    }

    public static void setDouble(ItemStack stack, String key, double value) {
        getTagCompound(stack).putDouble(key, value);
    }

    public static float getFloat(ItemStack stack, String key, float defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getFloat(key);
    }

    public static void setFloat(ItemStack stack, String key, float value) {
        getTagCompound(stack).putFloat(key, value);
    }

    public static int getInt(ItemStack stack, String key, int defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getInt(key);
    }

    public static void setInt(ItemStack stack, String key, int value) {
        getTagCompound(stack).putInt(key, value);
    }

    public static int[] getIntArray(ItemStack stack, String key, int[] defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getIntArray(key);
    }

    public static void setIntArray(ItemStack stack, String key, int[] value) {
        getTagCompound(stack).putIntArray(key, value);
    }

    public static long getLong(ItemStack stack, String key, long defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getLong(key);
    }

    public static void setLong(ItemStack stack, String key, long value) {
        getTagCompound(stack).putLong(key, value);
    }

    public static short getShort(ItemStack stack, String key, short defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getShort(key);
    }

    public static void setShort(ItemStack stack, String key, short value) {
        getTagCompound(stack).putShort(key, value);
    }

    public static String getString(ItemStack stack, String key, String defaultValue) {
        if (!keyExists(stack, key)) {
            return defaultValue;
        }
        return getTagCompound(stack).getString(key);
    }

    public static void setString(ItemStack stack, String key, String value) {
        getTagCompound(stack).putString(key, value);
    }
}