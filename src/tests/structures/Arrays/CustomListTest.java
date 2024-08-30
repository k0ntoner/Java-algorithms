package structures.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {

    @org.junit.jupiter.api.Test
    void bubbleSorting() {
        CustomList<Integer> list = new CustomList<>();
        list.add(12);
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(3);
        list.add(11);
        list.add(6);
        list.add(8);
        list.add(2);
        list.add(5);
        list.bubbleSorting();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
        assertEquals(7, list.get(6));
        assertEquals(8, list.get(7));
        assertEquals(9, list.get(8));
        assertEquals(10, list.get(9));
        assertEquals(11, list.get(10));
        assertEquals(12, list.get(11));


    }
    @org.junit.jupiter.api.Test
    void add() {
        CustomList<Integer> list = new CustomList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0), "First element should be 1");
        assertEquals(2, list.get(1), "Second element should be 2");
        assertEquals(2, list.get(2), "Third element should be 2");
        assertFalse(list.contains(3), "List should not contain the element 3");

    }
    @org.junit.jupiter.api.Test
    void selectionSorting() {
        CustomList<Integer> list = new CustomList<>();
        list.add(12);
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(3);
        list.add(11);
        list.add(6);
        list.add(8);
        list.add(2);
        list.add(5);
        list.selectionSorting();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
        assertEquals(7, list.get(6));
        assertEquals(8, list.get(7));
        assertEquals(9, list.get(8));
        assertEquals(10, list.get(9));
        assertEquals(11, list.get(10));
        assertEquals(12, list.get(11));
    }

    @org.junit.jupiter.api.Test
    void insertionSorting() {
        CustomList<Integer> list = new CustomList<>();
        list.add(12);
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(3);
        list.add(11);
        list.add(6);
        list.add(8);
        list.add(2);
        list.add(5);
        list.insertionSorting();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
        assertEquals(7, list.get(6));
        assertEquals(8, list.get(7));
        assertEquals(9, list.get(8));
        assertEquals(10, list.get(9));
        assertEquals(11, list.get(10));
        assertEquals(12, list.get(11));
    }
    @org.junit.jupiter.api.Test
    void mergeSorting() {
        CustomList<Integer> list = new CustomList<>();
        list.add(12);
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(3);
        list.add(11);
        list.add(6);
        list.add(8);
        list.add(2);
        list.add(5);
        list.mergeSorting();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
        assertEquals(7, list.get(6));
        assertEquals(8, list.get(7));
        assertEquals(9, list.get(8));
        assertEquals(10, list.get(9));
        assertEquals(11, list.get(10));
        assertEquals(12, list.get(11));
    }
    @org.junit.jupiter.api.Test
    void QuickSorting() {
        CustomList<Integer> list = new CustomList<>();
        list.add(12);
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(3);
        list.add(11);
        list.add(6);
        list.add(8);
        list.add(2);
        list.add(5);
        list.quickSorting();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
        assertEquals(7, list.get(6));
        assertEquals(8, list.get(7));
        assertEquals(9, list.get(8));
        assertEquals(10, list.get(9));
        assertEquals(11, list.get(10));
        assertEquals(12, list.get(11));
    }
}