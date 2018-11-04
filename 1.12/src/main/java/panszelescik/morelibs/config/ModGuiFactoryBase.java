package panszelescik.morelibs.config;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

public class ModGuiFactoryBase implements IModGuiFactory {
	
	@Override
	public void initialize(Minecraft minecraftInstance) {}
	
	@Override
	public boolean hasConfigGui() { return true; }
	
	/* This must be overrided! */
	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) { return null; }

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() { return null; }
}