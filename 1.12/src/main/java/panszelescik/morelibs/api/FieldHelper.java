package panszelescik.morelibs.api;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class FieldHelper {

    @Nullable
    public static Field getField(String clazzName, String name) {
        return getField(ClassHelper.getClass(clazzName), name);
    }

    @Nullable
    public static Field getField(Class clazz, String name) {
        try {
            Field field = clazz.getDeclaredField(name);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setField(String clazzName, String name, Object obj, Object value) {
        setField(getField(clazzName, name), obj, value);
    }

    public static void setField(Class clazz, String name, Object obj, Object value) {
        setField(getField(clazz, name), obj, value);
    }

    public static void setField(Field field, Object obj, Object value) {
        try {
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
