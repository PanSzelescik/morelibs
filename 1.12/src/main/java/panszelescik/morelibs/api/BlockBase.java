package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class BlockBase extends Block implements IModelRegister {

    public BlockBase(CreativeTabs tab, Material materialIn, String modid, String name) {
        super(materialIn);
        setTranslationKey(modid + "." + name);
        setRegistryName(new ResourceLocation(modid, name));
        setCreativeTab(tab);
    }

    @Override
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}