package panszelescik.morelibs.api;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

public class Helper {
	
	public static ItemStack get(String id, String name, int amount, @Nullable NBTTagCompound nbt) {
		IItemProvider item = GameRegistry.findRegistry(Item.class).getValue(new ResourceLocation(id + ":" + name));
		return item != null ? new ItemStack(item, amount, nbt) : ItemStack.EMPTY;
	}
	
	public static ItemStack get(String id, String name, int amount) {
		return get(id, name, amount, null);
	}
	
	public static ItemStack get(String id, String name) {
		return get(id, name, 1);
	}
	
	public static ItemStack get(IItemProvider item, @Nullable NBTTagCompound nbt) {
		return item != null ? new ItemStack(item, 1, nbt) : ItemStack.EMPTY;
	}
	
	public static ItemStack get(IItemProvider item) {
		return get(item, 1);
	}
	
	/*public static ItemStack get(String ore, int amount) {
		if (!oreNameExists(ore))
			return ItemStack.EMPTY;
		return cloneStack(OreDictionary.getOres(ore, false).get(0), amount);
	}
	
	public static ItemStack get(String ore) {
		return get(ore, 1);
	}*/
	
	public static ItemStack cloneStack(ItemStack stack, int stackSize) {
		if (stack.isEmpty())
			return ItemStack.EMPTY;
		ItemStack retStack = stack.copy();
		retStack.setCount(stackSize);

		return retStack;
	}
	
	public static boolean notNull(ItemStack stack) {
		return stack != ItemStack.EMPTY && stack != null;
	}
	
	public static boolean notNull(String id, String input) {
		return notNull(id, input, 0);
	}
	
	public static boolean notNull(String id, String input, @Nullable NBTTagCompound nbt) {
		return notNull(get(id, input, 1, nbt));
	}
	
	/*public static boolean oreNameExists(String oreName) {
		return OreDictionary.doesOreNameExist(oreName) && OreDictionary.getOres(oreName, false).size() > 0;
	}
	
	public static boolean isLoaded(String modid) {
		return ModList.isLoaded(modid);
	}*/
	
	public static String getItemName(ItemStack stack) {
		return stack.getTranslationKey();
	}
	
	public static String getItemName(String oreName) {
		return getItemName(get(oreName));
	}
	
	public static String getItemName(String id, String name, int amount, @Nullable NBTTagCompound nbt) {
		return getItemName(get(id, name, amount, nbt));
	}
	
	public static String getItemName(String id, String name) {
		return getItemName(id, name, 1, 0);
	}
	
	public static String getItemName(Item item) {
		return getItemName(get(item));
	}

	@OnlyIn(Dist.CLIENT)
	public static String translate(String key) {
		return I18n.format(key);
	}
}