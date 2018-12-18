package panszelescik.morelibs.api;

import net.minecraft.item.ItemStack;

public interface IItemDamageble {
	
	int getItemMaxDamage(ItemStack stack);
	int getItemDamage(ItemStack stack);
}