import java.util.Scanner;

public class SWEA1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = 9;
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            boolean isOk = true;

            // 가로, 세로
            for (int i = 0; i < n; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < n; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }

                if (rowSum != 45 || colSum != 45) {
                    isOk = false;
                    break;
                }
            }

            // 3x3
            for (int i = 1; i <= 3; i++) {
                int sum = 0;
                for (int j = (i - 1) * 3; j < i * 3; j++) {
                    for (int k = (i - 1) * 3; k < i * 3; k++) {
                        sum += arr[j][k];
                    }
                }

                if (sum != 45) {
                    isOk = false;
                    break;
                }
            }

            int sudoku = 1;
            if (isOk == false) {
                sudoku = 0;
            }

            System.out.println("#" + tc + " " + sudoku);
        }
    }
}
