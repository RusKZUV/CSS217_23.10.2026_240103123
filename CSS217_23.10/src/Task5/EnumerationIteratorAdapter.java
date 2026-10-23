package Task5;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIteratorAdapter<T> implements Iterator<T> {
    private Enumeration<T> enumeration;

    public EnumerationIteratorAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }


    public T next() {
        return enumeration.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported");
    }
}