package panszelescik.morelibs.api;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item {

    public ItemBase(Item.Properties prop, String modid, String name) {
        super(prop);
        setRegistryName(new ResourceLocation(modid, name));
    }
}