package panszelescik.morelibs.config;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ModGuiConfigBase extends GuiConfig {
	
	public ModGuiConfigBase(GuiScreen guiScreen, List<IConfigElement> list, String modid, String title) {
		super(guiScreen, list, modid, false, true, title);
	}
}