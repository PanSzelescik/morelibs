package panszelescik.morelibs.api;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

public class MethodHelper {

    @Nullable
    public static Method getMethod(String clazzName, String name) {
        return getMethod(ClassHelper.getClass(clazzName), name);
    }

    @Nullable
    public static Method getMethod(Class clazz, String name) {
        try {
            Method method = clazz.getDeclaredMethod(name);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static Method getMethod(String clazzName, String name, Class<?>... parameterTypes) {
        return getMethod(ClassHelper.getClass(clazzName), name, parameterTypes);
    }

    @Nullable
    public static Method getMethod(Class clazz, String name, Class<?>... parameterTypes) {
        try {
            Method method = clazz.getDeclaredMethod(name, parameterTypes);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void invoke(String clazzName, String name, @Nullable Object obj, Object... args) {
        invoke(getMethod(clazzName, name), obj, args);
    }

    public static void invoke(Class clazz, String name, @Nullable Object obj, Object... args) {
        invoke(getMethod(clazz, name), obj, args);
    }

    public static void invoke(Method method, @Nullable Object obj, Object... args) {
        try {
            method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invoke(String clazzName, String name, @Nullable Object obj) {
        invoke(getMethod(clazzName, name), obj);
    }

    public static void invoke(Class clazz, String name, @Nullable Object obj) {
        invoke(getMethod(clazz, name), obj);
    }

    public static void invoke(Method method, @Nullable Object obj) {
        try {
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
