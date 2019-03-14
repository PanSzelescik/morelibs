package panszelescik.morelibs.api;

import javax.annotation.Nullable;

public class ClassHelper {

    @Nullable
    public static Class getClass(String clazzName) {
        try {
            return Class.forName(clazzName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
