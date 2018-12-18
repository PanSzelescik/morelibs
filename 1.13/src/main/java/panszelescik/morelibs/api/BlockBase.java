package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block/* implements IModelRegister*/ {

	/**
	 * Use: {@link DefaultBlockBuilder}
	 */
	//{@link DefaultBlockBuilder}
	public BlockBase(Block.Builder builder, String modid, String name) {
		super(builder);
		setRegistryName(new ResourceLocation(modid, name));
	}

	/*@Override
	public void registerModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}*/
}