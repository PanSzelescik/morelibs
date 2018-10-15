package panszelescik.morelibs;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = MoreLibs.MODID, name = MoreLibs.NAME, version = MoreLibs.VERSION, acceptedMinecraftVersions = MoreLibs.ACCEPTED_MINECRAFT_VERSIONS, updateJSON = MoreLibs.UPDATE_JSON)
public class MoreLibs {
	
	public static final String
		MODID = "morelibs",
		NAME = "More Libs",
		VERSION = "@version@",
		ACCEPTED_MINECRAFT_VERSIONS = "[1.12.2,1.13)",
		UPDATE_JSON = "https://raw.githubusercontent.com/PanSzelescik/morelibs/master/update.json";
}