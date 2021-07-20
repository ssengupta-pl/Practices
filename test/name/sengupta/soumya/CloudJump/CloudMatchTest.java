package name.sengupta.soumya.CloudJump;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloudMatchTest {

    private List<Integer> makeCloudsList(int[] cloudsArray) {
        List<Integer> cloudsList = new ArrayList<Integer>();
        for (int i : cloudsArray) {
            cloudsList.add(i);
        }

        return cloudsList;
    }

    @Test
    void testLessThanTwoClouds() {
        int[] cloudsArray = new int[] { 0 };

        assertEquals(0, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testMoreThanHundredClouds() {
        int[] cloudsArray = new int[101];

        assertEquals(0, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testNullCloudArray() {
        assertEquals(0, CloudJump.jumpingOnClouds(null));
    }

    @Test
    void testWithCloudTypesOtherThanZeroAndOne() {
        int[] cloudsArray = new int[] { 0, 1, 2 };

        assertEquals(0, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testWithConsecutiveOnes() {
        int[] cloudsArray = new int[] { 0, 1, 1 };

        assertEquals(0, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testStartWithOne() {
        int[] cloudsArray = new int[] { 1 };

        assertEquals(0, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testWithZeroAndOneOnly() {
        int[] cloudsArray = new int[] { 0, 1 };

        assertEquals(0, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testForOnePath() {
        int[] cloudsArray = new int[] { 0, 1, 0 };

        assertEquals(1, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testForMinimumPath1() {
        int[] cloudsArray = new int[] { 0, 1, 0, 0, 0, 1, 0 };

        assertEquals(3, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));

    }

    @Test
    void testForMinimumPath2() {
        int[] cloudsArray = new int[] { 0, 0, 0, 0, 1, 0 };

        assertEquals(3, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testForMinimumPath3() {
        int[] cloudsArray = new int[] { 0, 0, 0, 1, 0, 0 };

        assertEquals(3, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }

    @Test
    void testForNoPath() {
        int[] cloudsArray = new int[] { 0, 1, 1 };

        assertEquals(0, CloudJump.jumpingOnClouds(makeCloudsList(cloudsArray)));
    }
}
