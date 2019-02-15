package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    public static ItemStack get(Block block, int amount) {
        return block != null ? new ItemStack(block, amount) : ItemStack.EMPTY;
    }

    public static ItemStack get(Item item, int amount) {
        return item != null ? new ItemStack(item, amount) : ItemStack.EMPTY;
    }

    public static ItemStack get(Block block) {
        return get(block, 1);
    }

    public static ItemStack get(Item item) {
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

    public static String getItemName(ItemStack stack) {
        return stack.getTranslationKey();
    }

    public static String getItemName(String id, String name, int amount) {
        return getItemName(get(id, name, amount));
    }

    public static String getItemName(String id, String name) {
        return getItemName(id, name, 1);
    }

    public static String getItemName(Item item) {
        return getItemName(get(item));
    }

    @OnlyIn(Dist.CLIENT)
    public static String translate(String key) {
        return I18n.format(key);
    }
}