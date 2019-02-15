package panszelescik.morelibs.register;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import panszelescik.morelibs.MoreLibs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//@Mod.EventBusSubscriber(modid = MoreLibs.MODID)
public class Registerer {

    /*private static HashMap<String, List<Class>> registryClasses = new HashMap<>();
    private static List<Item> registeredItems = new ArrayList<>();
    private static List<Block> registeredBlocks = new ArrayList<>();

    public static void addRegistryClasses(ASMDataTable dataTable) {
        for (ASMDataTable.ASMData data : dataTable.getAll(Register.class.getName())) {
            try {
                String modid = (String) data.getAnnotationInfo().get("modid");
                if (!registryClasses.containsKey(modid))
                    registryClasses.put(modid, new ArrayList<>());
                registryClasses.get(modid).add(Class.forName(data.getClassName()));
                MoreLibs.logger.info("Found registerer class: " + data.getClassName());
            } catch (Exception e) {
                MoreLibs.logger.error("Unable to add registerer class: " + data.getClassName() + "! An error occurred:");
                MoreLibs.logger.catching(Level.ERROR, e);
            }
        }
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        MoreLibs.logger.info("Searching for items to register");
        for (Entry<String, List<Class>> entry : registryClasses.entrySet()) {
            Loader.instance().setActiveModContainer(Loader.instance().getIndexedModList().get(entry.getKey()));
            for (Class clazz : entry.getValue()) {
                for (Method method : clazz.getMethods()) {
                    if (method.isAnnotationPresent(Register.RegisterItemInit.class)) {
                        try {
                            method.invoke(null);
                        } catch (Exception e) {
                            MoreLibs.logger.error("Unable to initialise items using init method: " + method.getName()
                                    + "! The following error was thrown:");
                            MoreLibs.logger.catching(Level.ERROR, e);
                        }
                    }
                }
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Register.RegisterItem.class)) {
                        try {
                            Register.RegisterItem details = field.getAnnotation(Register.RegisterItem.class);
                            Item item = (Item) field.get(null);
                            if (item == null) {
                                item = (Item) field.getType().newInstance();
                                field.set(null, item);
                            }
                            if (item.getRegistryName() == null)
                                item.setRegistryName(new ResourceLocation(entry.getKey(), details.registryName()));
                            event.getRegistry().register(item);
                            registeredItems.add(item);
                        } catch (Exception e) {
                            MoreLibs.logger.error("Unable to register item: " + field.getName()
                                    + "! The following error was thrown:");
                            MoreLibs.logger.catching(Level.ERROR, e);
                        }
                    }
                    if (field.isAnnotationPresent(Register.RegisterBlock.class)) {
                        try {
                            Register.RegisterBlock details = field.getAnnotation(Register.RegisterBlock.class);
                            if (details.registerItemBlock()) {
                                Block block = (Block) field.get(null);
                                if (block == null) {
                                    block = (Block) field.getType().newInstance();
                                    field.set(null, block);
                                }

                                ItemBlock item;
                                item = new ItemBlock(block, new Item.Properties());

                                if (item.getRegistryName() == null)
                                    item.setRegistryName(new ResourceLocation(entry.getKey(), details.registryName()));
                                event.getRegistry().register(item);
                                registeredItems.add(item);
                            }
                        } catch (Exception e) {
                            MoreLibs.logger.error("Unable to register item block: " + field.getName()
                                    + "! The following error was thrown:");
                            MoreLibs.logger.catching(Level.ERROR, e);
                        }
                    }
                    if (field.isAnnotationPresent(Register.RegisterItemBlock.class)) {
                        try {
                            Register.RegisterItemBlock details = field.getAnnotation(Register.RegisterItemBlock.class);
                            Block block = (Block) field.get(null);
                            if (block == null) {
                                block = (Block) field.getType().newInstance();
                                field.set(null, block);
                            }

                            ItemBlock item;
                            item = new ItemBlock(block, new Item.Properties());

                            if (item.getRegistryName() == null)
                                item.setRegistryName(new ResourceLocation(entry.getKey(), details.registryName()));
                            event.getRegistry().register(item);
                            registeredItems.add(item);
                        } catch (Exception e) {
                            MoreLibs.logger.error("Unable to register item block: " + field.getName()
                                    + "! The following error was thrown:");
                            MoreLibs.logger.catching(Level.ERROR, e);
                        }
                    }
                }
            }

        }
        Loader.instance().setActiveModContainer(Loader.instance().getIndexedModList().get(MoreLibs.MODID));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        MoreLibs.logger.info("Searching for blocks and tiles to register");
        for (Entry<String, List<Class>> entry : registryClasses.entrySet()) {
            Loader.instance().setActiveModContainer(Loader.instance().getIndexedModList().get(entry.getKey()));
            for (Class clazz : entry.getValue()) {
                for (Method method : clazz.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Register.RegisterBlockInit.class)) {
                        try {
                            method.invoke(null);
                        } catch (Exception e) {
                            MoreLibs.logger.error("Unable to initialise items using init method: " + method.getName()
                                    + "! The following error was thrown:");
                            MoreLibs.logger.catching(Level.ERROR, e);
                        }
                    }
                }
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Register.RegisterBlock.class)) {
                        try {
                            Register.RegisterBlock details = field.getAnnotation(Register.RegisterBlock.class);
                            Block block = (Block) field.get(null);
                            if (block == null) {
                                block = (Block) field.getType().newInstance();
                                field.set(null, block);
                            }

                            if (block.getRegistryName() == null)
                                block.setRegistryName(new ResourceLocation(entry.getKey(), details.registryName()));
                            event.getRegistry().register(block);
                            registeredBlocks.add(block);
                        } catch (Exception e) {
                            MoreLibs.logger.error("Unable to register block: " + field.getName()
                                    + "! The following error was thrown:");
                            MoreLibs.logger.catching(Level.ERROR, e);
                        }
                    }
                }
            }
        }
        Loader.instance().setActiveModContainer(Loader.instance().getIndexedModList().get(MoreLibs.MODID));
    }*/
}
