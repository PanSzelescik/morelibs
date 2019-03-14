package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {

    public BlockBase(Block.Properties prop, String modid, String name) {
        super(prop);
        setRegistryName(new ResourceLocation(modid, name));
    }
}