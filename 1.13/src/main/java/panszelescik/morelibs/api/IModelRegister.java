package panszelescik.morelibs.api;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface IModelRegister {
	
	@OnlyIn(Dist.CLIENT)
	void registerModel();
}