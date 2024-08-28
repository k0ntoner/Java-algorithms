package structures.Arrays;

import java.util.*;

public class CustomList<T> implements List<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)!=1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex<size && elements[currentIndex]!=null;
            }
            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                return (T)elements[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if(a.length < size) return (T1[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if(a.length > size) a[size] = null;
        return a;
    }

    @Override
    public boolean add(T t) {
        if(size== elements.length) elements = Arrays.copyOf(elements, size*2);
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index>=0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for(int i=0; i<size; i++) {
            elements[i] = null;
        }
        size=0;
    }

    @Override
    public T get(int index) {
        if(checkIndex(index)) return (T)elements[index];
        else throw new IndexOutOfBoundsException();

    }
    public boolean checkIndex(int index){
        return index>=0 && index<size;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}




}
