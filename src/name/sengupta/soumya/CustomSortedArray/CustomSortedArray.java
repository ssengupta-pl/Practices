package name.sengupta.soumya.CustomSortedArray;

import java.util.List;

public class CustomSortedArray {
    /*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int moves(List<Integer> arr) {
        int minMovesReqd = 0;

        if (arr != null && arr.size() >= 2 && arr.size() < 100000) {
            boolean needsFurtherSorting = false;

            do {
                System.out.format("Before move %s: %s\n", minMovesReqd, arr);
                int minPositionWithOdd = -1, maxPositionWithEven = -1;

                for (int i = 0; i < arr.size(); i++) {
                    if ((arr.get(i) & 1) != 0) {
                        minPositionWithOdd = i;
                        i = arr.size() + 1;
                    }
                }

                for (int j = arr.size() - 1; j >= 0; j--) {
                    if ((arr.get(j) & 1) == 0){
                        maxPositionWithEven = j;
                        j = -1;
                    }
                }

                // Ensures that at least one odd or one even is found.
                if (maxPositionWithEven != -1 && minPositionWithOdd != -1) {
                    // Is there room for any more swapping?
                    needsFurtherSorting = maxPositionWithEven < minPositionWithOdd ? false : true;

                    // Do the swap.
                    int temp = arr.get(minPositionWithOdd);
                    arr.set(minPositionWithOdd, arr.get(maxPositionWithEven));
                    arr.set(maxPositionWithEven, temp);

                    // If there is room to swap, increment min move count.
                    if (needsFurtherSorting)
                        minMovesReqd++;
                }
            } while (needsFurtherSorting);
        }

        return minMovesReqd;
    }
}
