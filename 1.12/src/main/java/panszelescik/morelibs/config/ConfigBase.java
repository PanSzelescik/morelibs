package panszelescik.morelibs.config;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigBase {

    private static Configuration cfg;
    private static String modid;

    public ConfigBase(String dir, String modid) {
        cfg = new Configuration(new File(Loader.instance().getConfigDir(), "/" + dir + ".cfg"));
        MinecraftForge.EVENT_BUS.register(this);
        loadConfig();
        this.modid = modid;
    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(modid))
            loadConfig();
    }

    public void loadConfig() {
        if (cfg.hasChanged())
            cfg.save();
    }

    public static Configuration getCfg() {
        return cfg;
    }

    public static String getModId() {
        return modid;
    }

    public static boolean getBoolean(String name, String category, boolean defaultValue, String comment) {
        return getCfg().getBoolean(name, category, defaultValue, comment);
    }

    public static boolean getBoolean(String name, String category, String comment) {
        return getCfg().getBoolean(name, category, true, comment);
    }

    public static float getFloat(String name, String category, float defaultValue, String comment) {
        return getCfg().getFloat(name, category, defaultValue, Float.MIN_VALUE, Float.MAX_VALUE, comment);
    }

    public static int getInt(String name, String category, int intName, String comment) {
        return getCfg().getInt(name, category, intName, 1, Integer.MAX_VALUE, comment);
    }

    public static String getString(String name, String category, String defaultValue, String comment) {
        return getCfg().getString(name, category, defaultValue, comment);
    }

    public static String[] getStrings(String name, String category, String[] defaultValues, String comment) {
        return getCfg().getStringList(name, category, defaultValues, comment);
    }

}