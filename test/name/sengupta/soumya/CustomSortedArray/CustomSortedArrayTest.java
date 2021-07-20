package name.sengupta.soumya.CustomSortedArray;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomSortedArrayTest {

    private List<Integer> makeList(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : array) {
            list.add(i);
        }

        return list;
    }

    private int runActualTest(int[] array) {
        return CustomSortedArray.moves(makeList(array));
    }

    @Test
    void testWithNullArray() {
        assertEquals(0, CustomSortedArray.moves(null));
    }

    @Test
    void testWithEmptyArray() {
        assertEquals(0, CustomSortedArray.moves(new ArrayList<Integer>()));
    }

    @Test
    void testWithOneElement() {
        int[] arr = new int[] {0};

        assertEquals(0, runActualTest(arr));
    }

    @Test
    void testWithMoreThan100000Elements() {
        int[] arr = new int[100000];

        assertEquals(0, runActualTest(arr));
    }

    @Test
    void testAllOdds() {
        int[] arr = new int[] {15, 13, 17};

        assertEquals(0, runActualTest(arr));
    }

    @Test
    void testAllEvens() {
        int[] arr = new int[] {2, 4, 6};

        assertEquals(0, runActualTest(arr));
    }

    @Test
    void testValidCase1() {
        int[] arr = new int[] {6, 3, 4, 5};

        assertEquals(1, runActualTest(arr));
    }

    @Test
    void testValidCase2() {
        int[] arr = new int[] {13, 10, 21, 20};

        assertEquals(1, runActualTest(arr));
    }

    @Test
    void testValidCase3() {
        int[] arr = new int[] {8, 5, 11, 4, 6};

        assertEquals(2, runActualTest(arr));
    }

    @Test
    void testValidCase4() {
        int[] arr = new int[] {15, 10, 8, 11, 6, 13, 4, 20};

        assertEquals(2, runActualTest(arr));
    }
}