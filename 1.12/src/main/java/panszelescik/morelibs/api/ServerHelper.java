package panszelescik.morelibs.api;

import net.minecraft.world.World;

public class ServerHelper {
	
	public static boolean isClientWorld(World world) {
		return world.isRemote;
	}

	public static boolean isServerWorld(World world) {
		return !world.isRemote;
	}
}