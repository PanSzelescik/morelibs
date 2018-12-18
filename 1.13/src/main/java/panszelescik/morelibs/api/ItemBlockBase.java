package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;

public class ItemBlockBase extends ItemBlock {

    public ItemBlockBase(Block block, ItemGroup tab) {
        super(block, new DefaultItemBuilder(tab));
    }
}
