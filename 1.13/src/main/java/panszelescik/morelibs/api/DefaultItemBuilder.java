package panszelescik.morelibs.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class DefaultItemBuilder extends Item.Builder {

    public DefaultItemBuilder(ItemGroup tab) {
        super();
        group(tab);
    }

    public static DefaultItemBuilder create(ItemGroup tab) {
        return new DefaultItemBuilder(tab);
    }
}
