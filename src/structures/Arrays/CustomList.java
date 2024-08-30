package structures.Arrays;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        return indexOf(o)>0;
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
        checkIndex(index);
        return (T)elements[index];


    }


    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T old = get(index);
        elements[index] = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        checkIndexForAdd(index);
        ensureCapacity(size+1);
        System.arraycopy(elements, index, elements, index+1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T old = get(index);
        int numMoved = size - index - 1;
        System.arraycopy(elements, index+1, elements, index, numMoved);
        elements[--size] = null;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) return -1;
        for(int i=0; i<size; i++) {
            if(elements[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    /**
     * Check if index is available to avoid null reference error
     *
     * @param index
     */
    private void  checkIndex(int index){
        if( index>=0 && index<size) return;
        else throw new IndexOutOfBoundsException();
    }

    /**
     * Check if index is available to avoid null reference error
     *
     * @param index
     */
    private void  checkIndexForAdd(int index){
        if( index>=0 && index<=size) return;
        else throw new IndexOutOfBoundsException();
    }

    /**
     * Check capacity and increase it if needed
     *
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Sorting list using bubble sorting
     */
    @SuppressWarnings("unchecked")
    public void bubbleSorting(){

        for(int i=0; i<size-1; i++) {
            for(int j=0; j<size-1; j++){
                Comparable<T> element1 = (Comparable<T>) elements[j];
                Comparable<T> element2 = (Comparable<T>) elements[j+1];
                if(element1.compareTo((T) element2) > 0){
                    T mix=(T) elements[j];
                    elements[j]=elements[j+1];
                    elements[j+1]=mix;
                }


            }
        }
    }

    /**
     * Sorting list using selection sorting
     */
    @SuppressWarnings("unchecked")
    public void selectionSorting(){
        for(int i=0; i<size-1; i++) {
            T smallest = (T) elements[i];
            for(int j=i+1; j<size; j++) {

                Comparable<T> element = (Comparable<T>) elements[j];
                if(element.compareTo(smallest) < 0){
                    T mix=smallest;
                    smallest=(T) elements[j];
                    elements[j]=mix;

                }
            }
            elements[i]=smallest;

        }
    }
    /**
     * Sorting list using insertion sorting
     */
    @SuppressWarnings("unchecked")
    public void insertionSorting(){
        T compareElement = (T) elements[0];
        for(int i=0; i<size-1; i++) {

            T mix=null;
            Comparable<T> element = (Comparable<T>) elements[i+1];
            if(element.compareTo(compareElement) < 0){
                mix=(T) elements[i+1];
                elements[i+1]=compareElement;
                elements[i]=mix;
                for(int j=i; j>0; j--) {
                    Comparable<T> element1 = (Comparable<T>) elements[j];
                    Comparable<T> element2 = (Comparable<T>) elements[j-1];
                    if(element1.compareTo((T) element2)<0){
                        mix=(T) elements[j];
                        elements[j]=elements[j-1];
                        elements[j-1]=mix;
                    }
                }
            }
            else compareElement=(T) element;

        }
    }

    /**
     * Divide array on two parts: first and second
     * @param firstArray contain first part
     * @param secondArray contain second part
     * @param arrayToDivide array to divide
     */
    private void divide(Object[] firstArray,Object[] secondArray, Object[] arrayToDivide){
        System.arraycopy(arrayToDivide, 0, firstArray, 0, arrayToDivide.length/2 );
        System.arraycopy(arrayToDivide, arrayToDivide.length/2, secondArray, 0, arrayToDivide.length-arrayToDivide.length/2 );
    }

    /**
     * Merge two arrays to one with sorting
     * @param firstArray
     * @param secondArray
     * @return Sorted array
     */
    @SuppressWarnings("unchecked")
    private Object[] merge(Object[] firstArray,Object[] secondArray){
        Object[] mergedArray= new Object[firstArray.length+ secondArray.length];
        int firstIndex=0;
        int secondIndex=0;
        for(int i=0; i<mergedArray.length; i++){
            Comparable<T> elementFromFirstArray = firstIndex==firstArray.length? null :(Comparable<T>) firstArray[firstIndex];
            Comparable<T> elementFromSecondArray = secondIndex==secondArray.length? null :(Comparable<T>) secondArray[secondIndex];
            if(elementFromSecondArray==null || elementFromFirstArray!=null &&  elementFromFirstArray.compareTo((T) elementFromSecondArray)<0){
                mergedArray[i]=elementFromFirstArray;
                firstIndex++;

            }
            else{
                mergedArray[i]=elementFromSecondArray;
                secondIndex++;
            }
        }
        return mergedArray;
    }

    /**
     * Recursive method provide merge sorting
     * @param arrayToSort
     * @return
     */
    private Object[] mergeSorting(Object[] arrayToSort){

        if(arrayToSort.length>1){
            Object[] firstArray =new Object[arrayToSort.length/2];
            Object[] secondArray =new Object[arrayToSort.length-arrayToSort.length/2];
            divide(firstArray,secondArray, arrayToSort);
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<Object[]> firstSortingFuture = executorService.submit( ()->mergeSorting(firstArray));
            Future<Object[]> secondSortingFuture = executorService.submit( ()->mergeSorting(secondArray));
            try{
                Object[] firstSortingArray= firstSortingFuture.get();
                Object[] secondSortingArray= secondSortingFuture.get();
                executorService.shutdown();
                return merge(firstSortingArray, secondSortingArray);

            }
            catch(InterruptedException | ExecutionException e){
                throw new RuntimeException(e);
            }

        }
        return arrayToSort;



    }
    /**
     * Sorting list using merge sorting
     */
    public void mergeSorting(){
        Object[] arrayToSort= new Object[size];
        System.arraycopy(elements, 0, arrayToSort, 0, size );
        elements= mergeSorting(arrayToSort);
    }

    /**
     * Divides array on two parts, first part contain numbers before pivot and second after pivot
     * @param firstArray
     * @param secondArray
     * @param arrayToDivide
     * @param pivotIndex
     */
    private void divideByPivot(Object[] firstArray,Object[] secondArray, Object[] arrayToDivide, int pivotIndex){
        System.arraycopy(arrayToDivide, 0, firstArray, 0, firstArray.length );
        System.arraycopy(arrayToDivide, pivotIndex+1, secondArray, 0, secondArray.length);
    }

    /**
     * Merges two parts and put pivot between them
     * @param firstArray
     * @param secondArray
     * @param pivot
     * @return
     */
    private Object[] mergeByPivot(Object[] firstArray,Object[] secondArray, T pivot){
        Object[] mergedArray= new Object[firstArray.length+secondArray.length+1];
        System.arraycopy(firstArray, 0, mergedArray, 0, firstArray.length );
        mergedArray[firstArray.length]=pivot;
        System.arraycopy(secondArray, 0, mergedArray, firstArray.length+1, secondArray.length );
        return mergedArray;
    }

    /**
     * Recursive method provide quick sorting
     * @param arrayToSort
     * @return
     */
    @SuppressWarnings("unchecked")
    private Object[] partition(Object[] arrayToSort ){

        if(arrayToSort.length>1) {
            T pivot = (T) arrayToSort[arrayToSort.length-1];

            int indexToSwap = 0;
            for (int i = 0; i < arrayToSort.length; i++) {
                Comparable<T> element = (Comparable<T>) arrayToSort[i];
                if (element.compareTo( pivot) < 0) {
                    T mix = (T) element;
                    arrayToSort[i] = arrayToSort[indexToSwap];
                    arrayToSort[indexToSwap] = mix;
                    indexToSwap++;
                }

            }
            T mix = (T) arrayToSort[arrayToSort.length - 1];
            arrayToSort[arrayToSort.length - 1] = arrayToSort[indexToSwap];
            arrayToSort[indexToSwap] = mix;
            Object[] firstArray = new Object[indexToSwap];
            Object[] secondArray = new Object[arrayToSort.length - indexToSwap - 1];
            divideByPivot(firstArray, secondArray, arrayToSort, indexToSwap);
            Object[] firstSortedArray = partition(firstArray);
            Object[] secondSortedArray = partition(secondArray);

            return mergeByPivot(firstSortedArray, secondSortedArray, pivot);
        }
        return arrayToSort;

    }

    /**
     * Sorts list using quick sorting
     */
    public void quickSorting(){
        Object[] arrayToSort= new Object[size];
        System.arraycopy(elements, 0, arrayToSort, 0, size );
        elements= partition(arrayToSort);
    }

}





