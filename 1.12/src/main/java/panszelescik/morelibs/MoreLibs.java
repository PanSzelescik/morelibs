package panszelescik.morelibs;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import panszelescik.morelibs.register.Registerer;

@Mod(modid = MoreLibs.MODID, name = "More Libs", version = "@version@", acceptedMinecraftVersions = "[1.12.2,1.13)", updateJSON = "https://raw.githubusercontent.com/PanSzelescik/morelibs/master/update.json")
public class MoreLibs {

    public static final String MODID = "morelibs";
    public static final Logger logger = LogManager.getFormatterLogger(MODID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Registerer.addRegistryClasses(e.getAsmData());
    }
}