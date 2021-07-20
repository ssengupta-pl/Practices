package name.sengupta.soumya.counterfeitcurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CounterfeitCurrency {

    /*
     * Complete the 'countCounterfeit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY serialNumber as parameter.
     */

    public static int countCounterfeit(List<String> serialNumber) {
        System.out.format("All serial numbers: %s\n", serialNumber);
        String pattern = "(^[A-Z]{3})([0-9]{4})(10|20|50|100|200|500|1000)([A-Z]$)";

        int totalValidCurrencyValue =
                serialNumber.stream()
                        .filter((indvSerialNumber) -> {
                            return indvSerialNumber.matches(pattern);
                        })
                        .filter((indvSerialNumber) -> {
                            HashSet<Character> characters = new HashSet<Character>();
                            boolean repeated = false;
                            for (int i = 0; i < 3; i++) {
                                if (characters.contains(indvSerialNumber.charAt(i))) {
                                    repeated = true;
                                    i = 4;
                                } else {
                                    characters.add(indvSerialNumber.charAt(i));
                                }
                            }

                            return !repeated;
                        })
                        .filter((indvSerialNumber) -> {
                            int yearPrinted = Integer.parseInt(indvSerialNumber.substring(3, 7));
                            return (yearPrinted >= 1900 && yearPrinted <= 2019) ? true : false;
                        })
                        .mapToInt((indvSerialNumber) -> {
                            int startPosition = 7;
                            int endPosition = indvSerialNumber.length() - 1;
                            int denomination = Integer.parseInt(indvSerialNumber.substring(startPosition, endPosition));

                            System.out.format("\tAccepted serial number (s): %s, denomination: $%s\n", indvSerialNumber, denomination);

                            return denomination;
                        })
                        .sum();


        return totalValidCurrencyValue;
    }
}
