import java.util.*;

public class Determinant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размер матрицы (n): ");
        int n = sc.nextInt();
        int[][] a = createMatrix(n, sc);

        int det = findDeterminant(a, n);
        System.out.println("Определитель матрицы: " + det);
    }

    private static int[][] createMatrix(int n, Scanner sc) {
        System.out.println("Введите элементы матрицы: ");
        int[][] a = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                a[x][y] = sc.nextInt();
            }
        }
        return a;
    }

    private static int determinant2(int[][] a) {
        return a[0][0] * a[1][1] - a[0][1] * a[1][0];
    }

    private static int findDeterminant(int[][] a, int n) {

        if (n == 1) {
            return a[0][0];
        }

        if (n == 2) {
            return determinant2(a);
        }

        int determinant = 0;

        for (int c = 0; c < n; c++) {
            int[][] submatrix = new int[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < c) {
                        submatrix[i - 1][j] = a[i][j];
                    }
                    else if (j > c) {
                        submatrix[i - 1][j - 1] = a[i][j];
                    }
                }
                determinant += a[0][c] * Math.pow(-1, c) * findDeterminant(submatrix, n - 1);
            }
        }

        return determinant;

    }
}
