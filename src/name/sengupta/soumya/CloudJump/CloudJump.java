package name.sengupta.soumya.CloudJump;

import java.util.ArrayList;
import java.util.List;

public class CloudJump {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */
    public static int jumpingOnClouds(List<Integer> c) {
        System.out.format("Cloud array: %s\n", c);

        List<Integer> path = new ArrayList<Integer>();

        if (c != null && c.size() >= 2 && c.size() <= 100) {
            Object[] cloudArray = c.toArray();
            path.add(0);
            for (int index = 0; index < cloudArray.length;) {
                System.out.format("Index: %s, Path currently: %s\n", index, path);
                int cloudTypeAtIndex = (Integer)cloudArray[index];
                if (cloudTypeAtIndex != 0 && cloudTypeAtIndex != 1) {
                    path = new ArrayList<Integer>();
                    index = cloudArray.length + 1;
                } else {
                    int oneStepAhead = index + 1;
                    int twoStepsAhead = index + 2;

                    if (oneStepAhead < cloudArray.length && twoStepsAhead < cloudArray.length) {
                        int cloudTypeOneStepAhead = (Integer)cloudArray[oneStepAhead];
                        int cloudTypeTwoStepsAhead = (Integer)cloudArray[twoStepsAhead];

                        if (cloudTypeTwoStepsAhead == 0) {
                            index = twoStepsAhead;
                        } else {
                            if (cloudTypeOneStepAhead == 0) {
                                index = oneStepAhead;
                            } else {
                                index = cloudArray.length + 1;
                            }
                        }

                        if (index > cloudArray.length) {
                            path = new ArrayList<Integer>();
                        } else {
                            path.add(index);
                        }
                    } else {
                        if (oneStepAhead < cloudArray.length && twoStepsAhead >= cloudArray.length) {
                            if ((Integer)cloudArray[oneStepAhead] == 0) {
                                path.add(cloudArray.length - 1);
                            }
                        }

                        index = cloudArray.length + 1;
                    }
                }
            }
        }

        System.out.format("Min path: %s\n", path);
        return path.size() == 0 ? 0 : path.size() - 1;
    }
}
