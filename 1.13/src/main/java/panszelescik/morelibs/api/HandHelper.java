package panszelescik.morelibs.api;

import net.minecraft.util.EnumHand;

public class HandHelper {
	
	public static int encrypt(EnumHand hand) {
		switch (hand) {
			case MAIN_HAND:
				return 0;
			case OFF_HAND:
				return 1;
			default:
				return 2;
		}
	}
	
	public static EnumHand decrypt(int number) {
		switch (number) {
			case 1:
				return EnumHand.OFF_HAND;
			default:
				return EnumHand.MAIN_HAND;
		}
	}
}