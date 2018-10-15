package panszelescik.morelibs.api;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item implements IModelRegister {
	
	public ItemBase(CreativeTabs tab) {
		setCreativeTab(tab);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}