package panszelescik.morelibs.api;

import net.minecraft.util.EnumHand;

public class HandHelper {

    public static int encrypt(EnumHand hand) {
        if (hand == EnumHand.MAIN_HAND)
            return 0;
        else if (hand == EnumHand.OFF_HAND)
            return 1;
        else
            return 2;
    }

    public static EnumHand decrypt(int number) {
        if (number == 0)
            return EnumHand.MAIN_HAND;
        else if (number == 1)
            return EnumHand.OFF_HAND;
        else
            return EnumHand.MAIN_HAND;
    }
}