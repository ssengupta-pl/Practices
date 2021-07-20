package name.sengupta.soumya.SockMatch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SockMatchTest {

    private List<Integer> makeSocksList(int[] socksArray) {
        List<Integer> socksList = new ArrayList<Integer>();
        for (int i : socksArray) {
            socksList.add(i);
        }

        return socksList;
    }

    @Test
    void testSomeBalancedAndSomeNotBalanced() {
        int[] socksArray = new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20};
        List<Integer> allSocks = makeSocksList(socksArray);

        assertEquals(3, SockMatch.sockMerchant(allSocks.size(), allSocks));
    }

    @Test
    void testNoneBalanced() {
        int[] socksArray = new int[] {10, 20, 30, 50};
        List<Integer> allSocks = makeSocksList(socksArray);

        assertEquals(0, SockMatch.sockMerchant(allSocks.size(), allSocks));
    }

    @Test
    void testAllBalanced() {
        int[] socksArray = new int[] {10, 10, 30, 30};
        List<Integer> allSocks = makeSocksList(socksArray);

        assertEquals(2, SockMatch.sockMerchant(allSocks.size(), allSocks));
    }

    @Test
    void testSameTypeAllBalanced() {
        int[] socksArray = new int[] {10, 10, 10, 10};
        List<Integer> allSocks = makeSocksList(socksArray);

        assertEquals(2, SockMatch.sockMerchant(allSocks.size(), allSocks));
    }

    @Test
    void testSameTypeNotAllBalanced() {
        int[] socksArray = new int[] {10, 10, 10};
        List<Integer> allSocks = makeSocksList(socksArray);

        assertEquals(1, SockMatch.sockMerchant(allSocks.size(), allSocks));
    }

    @Test
    void testWithZeroCountAndNullSocks() {
        assertEquals(0, SockMatch.sockMerchant(0, null));
    }

    @Test
    void testWithZeroCountAndNotNullSocks() {
        int[] socksArray = new int[] {10, 10, 10};
        List<Integer> allSocks = makeSocksList(socksArray);

        assertEquals(0, SockMatch.sockMerchant(0, allSocks));
    }

    @Test
    void testWithNotZeroCountAndNullSocks() {
        assertEquals(0, SockMatch.sockMerchant(1, null));
    }
}