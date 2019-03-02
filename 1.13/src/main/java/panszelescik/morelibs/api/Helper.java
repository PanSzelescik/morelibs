package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ForgeI18n;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class Helper {

    public static ItemStack get(String id, String name, int amount) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id + ":" + name));
        return item != null ? new ItemStack(item, amount) : ItemStack.EMPTY;
    }

    public static ItemStack get(String id, String name) {
        return get(id, name, 1);
    }

    public static ItemStack get(IItemProvider item, int amount) {
        return item != null ? new ItemStack(item, amount) : ItemStack.EMPTY;
    }

    public static ItemStack get(IItemProvider item) {
        return get(item, 1);
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
        return notNull(get(id, input, 1));
    }

    public static boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    public static String getRegistryName(Item item) {
        return item.getName().getString();
    }

    public static String getRegistryName(ItemStack stack) {
        return getRegistryName(stack.getItem());
    }

    public static String getRegistryName(String id, String name, int amount) {
        return getRegistryName(get(id, name, amount));
    }

    public static String getTranslationName(ItemStack stack) {
        return stack.getTranslationKey();
    }

    public static String getTranslationName(String id, String name) {
        return getTranslationName(get(id, name, 1));
    }

    public static String getTranslationName(String id, String name, int amount) {
        return getTranslationName(get(id, name, amount));
    }

    public static String translate(String key) {
        return ForgeI18n.parseFormat(key);
    }
}