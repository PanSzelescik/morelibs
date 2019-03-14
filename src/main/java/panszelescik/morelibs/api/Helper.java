package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public class Helper {

    public static ItemStack get(String id, String name, int amount, int meta) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id + ":" + name));
        return item != null ? new ItemStack(item, amount, meta) : ItemStack.EMPTY;
    }

    public static ItemStack get(String id, String name, int amount) {
        return get(id, name, amount, 0);
    }

    public static ItemStack get(String id, String name) {
        return get(id, name, 1, 0);
    }

    public static ItemStack get(Block block, int meta) {
        return block != null ? new ItemStack(block, 1, meta) : ItemStack.EMPTY;
    }

    public static ItemStack get(Item item, int meta) {
        return item != null ? new ItemStack(item, 1, meta) : ItemStack.EMPTY;
    }

    public static ItemStack get(Block block) {
        return get(block, 1);
    }

    public static ItemStack get(Item item) {
        return get(item, 1);
    }

    public static ItemStack get(String ore, int amount) {
        if (!oreNameExists(ore))
            return ItemStack.EMPTY;
        return cloneStack(OreDictionary.getOres(ore, false).get(0), amount);
    }

    public static ItemStack get(String ore) {
        return get(ore, 1);
    }

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

    public static boolean notNull(String id, String input, int meta) {
        return notNull(get(id, input, 1, meta));
    }

    public static boolean oreNameExists(String oreName) {
        return OreDictionary.doesOreNameExist(oreName) && OreDictionary.getOres(oreName, false).size() > 0;
    }

    public static boolean isLoaded(String modid) {
        return Loader.isModLoaded(modid);
    }

    public static String getItemName(ItemStack stack) {
        return stack.getTranslationKey();
    }

    public static String getItemName(String oreName) {
        return getItemName(get(oreName));
    }

    public static String getItemName(String id, String name, int amount, int meta) {
        return getItemName(get(id, name, amount, meta));
    }

    public static String getItemName(String id, String name) {
        return getItemName(id, name, 1, 0);
    }

    public static String getItemName(Item item) {
        return getItemName(get(item));
    }

    public static String translate(String key) {
        return I18n.translateToLocal(key);
    }
}