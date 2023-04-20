package devtools.helper.adaptor;

import java.util.Enumeration;
import java.util.Iterator;

public class IterableEnumeration<T> implements Iterable<T> {
    private final Enumeration<T> enumeration;

    public IterableEnumeration(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            public T next() {
                return enumeration.nextElement();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static <T> Iterable<T> make(Enumeration<T> enumeration) {
        return new IterableEnumeration<T>(enumeration);
    }

    public static <T> IterableEnumeration<T> makeIterable(Enumeration<T> enumeration) {
        return new IterableEnumeration<T>(enumeration);
    }
}