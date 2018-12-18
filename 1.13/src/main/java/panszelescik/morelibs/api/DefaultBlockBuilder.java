package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DefaultBlockBuilder {

    public static Block.Builder create(Material material) {
        return Block.Builder.create(material);
    }
}
