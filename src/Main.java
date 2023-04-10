import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int[][] arr = getMatrixFromFile();
        int[] minIJ = getLastMin(arr);
        int[] maxIJ = getFirstMax(arr, minIJ[0], minIJ[1]);

        System.out.println("Last min element in matrix [" + minIJ[0] + "]" + "[" + minIJ[1] + "] = " + arr[minIJ[0]][minIJ[1]]);
        System.out.println("First max element in matrix(bottom left) [" + maxIJ[0] + "]" + "[" + maxIJ[1] + "] = " + arr[maxIJ[0]][maxIJ[1]]);
    }

    public static int[][] getMatrixFromFile() {
        String line;
        int[][] arr = null;

        try (BufferedReader br = new BufferedReader(new FileReader("file.csv"))) {
            int j = 0;
            while ((line = br.readLine()) != null) {
                String[] arrayLineString = line.split(";");//строка матрицы

                for (int i = 0; i < arrayLineString.length; i++) {
                    if (arr == null) {
                        arr = new int[arrayLineString.length][arrayLineString.length];
                    }
                    arr[j][i] = Integer.parseInt(arrayLineString[i]);
                }
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static int[] getFirstMax(int[][] arr, int minIndexI, int minIndexJ) {
        int[] ij = new int[2];

        if (minIndexI == arr.length - 1) {
            System.err.println("There is nothing below than min element.");
        } else if (minIndexJ == 0) {
            System.err.println("There is nothing to the left than min element.");
        } else {
            int max = arr[0][0];
            for (int i = minIndexI + 1; i < arr.length; i++) {
                for (int j = 0; j < minIndexJ; j++) {
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                        ij[0] = i;
                        ij[1] = j;
                    }
                }
            }
        }
        return ij;
    }

    public static int[] getLastMin(int[][] arr) {
        int[] ij = new int[2];
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] <= min) {
                    min = arr[i][j];
                    ij[0] = i;
                    ij[1] = j;
                }
            }
        }
        return ij;
    }


}