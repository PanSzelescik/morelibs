package panszelescik.morelibs.register;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Register {
    String modid();

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public static @interface RegisterBlock {
        String registryName();

        String translationKey() default "";

        boolean setTranslationKey() default true;

        boolean registerItemBlock() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public static @interface RegisterItem {
        String registryName();

        String translationKey() default "";

        boolean setTranslationKey() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public static @interface RegisterItemBlock {
        String registryName() default "";

        String translationKey() default "";

        boolean setTranslationKey() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public static @interface RegisterBlockInit {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public static @interface RegisterItemInit {
    }

}
