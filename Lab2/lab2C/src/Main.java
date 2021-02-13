import java.util.Scanner;
import java.util.Random;

public class Main {
    public static int[][] randomizeMatrix(int[][] emptyMatrix, int range) {
        Random rand = new Random();
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                emptyMatrix[i][j] = rand.nextInt(2 * range + 1) - range;
                System.out.print(emptyMatrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        return emptyMatrix;
    }

    static void removeZeroRowCol(int[][] arr) {
        int len = arr.length;
        int col[] = new int[len + 1]; //col[i]: Stores count of 0s in current column
        int row[] = new int[len + 1]; //row[i]: Stores count of 0s in current row

        for (int i = 0; i < len; ++i) {
            int count = 0; // count of 0s in current row
            for (int j = 0; j < len; ++j) {
                if (arr[i][j] != 0)
                    col[j] += 1; // Update col[j]
                else
                    col[j] += 0;

                if (arr[i][j] != 0)
                    count += 1;
                else
                    count += 0;
            }
            row[i] = count;
        }

        for (int i = 0; i < len; ++i) {
            if (row[i] == 0) { // check for zero rows
                continue;
            }
            for (int j = 0; j < len; ++j) {
                if (col[j] != 0)
                    System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = input.nextInt();
        int[][] a = new int[n][n];
        int[][] filledMatrix = randomizeMatrix(a, n);
        System.out.print("Simplified matrix: " + "\n");
        removeZeroRowCol(filledMatrix);

        System.out.print("Simple testing: " + "\n");
        int[][] testingMatrix = {{3, 1, 0, 2},
                {0, 0, 0, 0},
                {6, 1, 0, 2},
                {0, -3, 0, 1}};
        removeZeroRowCol(testingMatrix);
    }
}
