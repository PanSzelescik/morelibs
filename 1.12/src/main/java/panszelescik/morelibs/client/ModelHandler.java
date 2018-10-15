package panszelescik.morelibs.client;

import static panszelescik.morelibs.MoreLibs.*;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import panszelescik.morelibs.api.IModelRegister;

@EventBusSubscriber(value = Side.CLIENT, modid = MODID)
public final class ModelHandler {
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		for (Item item : Item.REGISTRY) {
			if (item instanceof IModelRegister)
				((IModelRegister) item).registerModel();
		}
	}
}