package panszelescik.morelibs.api;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item/* implements IModelRegister*/ {
	
	public ItemBase(DefaultItemBuilder builder, String modid, String name) {
		super(builder);
		setRegistryName(new ResourceLocation(modid, name));
	}
	
	/*@SideOnly(Side.CLIENT)
	@Override
	public void registerModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}*/
}