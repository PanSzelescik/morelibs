package panszelescik.morelibs.api;

import java.util.Comparator;

public class ClassComparator implements Comparator<Class> {

    public ClassComparator() {
    }

    @Override
    public int compare(Class c1, Class c2) {
        return c1.getName().compareTo(c2.getName());
    }
}