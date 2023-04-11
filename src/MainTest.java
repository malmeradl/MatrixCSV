import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void getFirstMaxAfterLastMin() {
        int[][] arr = {{2, -4, 6}, {-4, 5, -8}, {-3, 7, 2}};
        int[] minIJ=Main.getLastMin(arr);
        int[] actualIJ = Main.getFirstMaxAfterMin(arr,minIJ[0],minIJ[1]);
        int[] expectedIJ = new int[2];
        expectedIJ[0] = 2;
        expectedIJ[1] = 1;
        assertArrayEquals(expectedIJ, actualIJ);
    }
    @org.junit.jupiter.api.Test
    void checkingConditions() {
        int[][] arr = {{2, -4, 6}, {-4, 5, 8}, {-4, 7, 2}};//min element in last string
        int[] minIJ=Main.getLastMin(arr);
        int[] actualIJ = Main.getFirstMaxAfterMin(arr,minIJ[0],minIJ[1]);
        int[] expectedIJ = new int[2];
        expectedIJ[0] = 0;
        expectedIJ[1] = 0;
        assertArrayEquals(expectedIJ, actualIJ);
    }

    @org.junit.jupiter.api.Test
    void getLastMinTest() {
        int[][] arr = {{2, -4, 6}, {-3, 5, 8}, {-4, 7, 2}};
        int[] actualIJ = Main.getLastMin(arr);
        int[] expectedIJ = new int[2];
        expectedIJ[0] = 2;
        expectedIJ[1] = 0;
        assertArrayEquals(expectedIJ, actualIJ);
    }
}