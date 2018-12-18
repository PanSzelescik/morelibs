package panszelescik.morelibs.config;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

public abstract class ModGuiFactoryBase implements IModGuiFactory {
	
	@Override
	public void initialize(Minecraft minecraftInstance) {}
	
	@Override
	public boolean hasConfigGui() { return true; }
	
	@Override
	public abstract GuiScreen createConfigGui(GuiScreen parentScreen);

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() { return null; }
}