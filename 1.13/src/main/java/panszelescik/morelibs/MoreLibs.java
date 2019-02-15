package panszelescik.morelibs;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import panszelescik.morelibs.register.Registerer;

@Mod(MoreLibs.MODID)
public class MoreLibs {

    public static final String MODID = "morelibs";
    public static final Logger logger = LogManager.getFormatterLogger(MODID);

    public MoreLibs() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent e) {
        //Registerer.addRegistryClasses();
    }
}