package name.sengupta.soumya.SockMatch;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SockMatch {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        System.out.format("Inputs - count: %s, socks: %s\n\n", n, ar);

        int numPairs = 0;

        if (n!= 0 && ar != null && ar.size() > 0) {
            Map<String, List<Integer>> sockTypes = ar.stream()
                    .sorted()
                    .collect(Collectors.groupingBy(p -> p.toString()));

            for (Map.Entry<String, List<Integer>> entry : sockTypes.entrySet()) {
                String sockType = entry.getKey();
                List<Integer> socks = entry.getValue();
                numPairs += Math.floor(socks.size() / 2);
                System.out.format("Sock type: %s, Num socks: %s, Total pairs: %s\n", sockType, socks, numPairs);
            }
        }

        return numPairs;
    }
}
