import java.util.Scanner;

public class SWEA1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 0; tc < 10; tc++) {
            int t = sc.nextInt();
            int n = 100;
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                int rowSum = 0;  // 행의 합
                int colSum = 0;  // 열의 합
                for (int j = 0; j < n; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                max = (rowSum > max ? rowSum : max);
                max = (colSum > max ? colSum : max);
            }

            int diagonalSum1 = 0;
            int diagonalSum2 = 0;
            for (int i = 0; i < n - 1; i++) {
                diagonalSum1 += arr[i][i];  // 오른쪽 아래로 내려가는 대각선
                diagonalSum2 += arr[i][n - i - 1];  // 왼쪽 아래로 내려가는 대각선
            }
            max = (diagonalSum1 > max ? diagonalSum1 : max);
            max = (diagonalSum2 > max ? diagonalSum2 : max);


            System.out.println("#" + t + " " + max);
        }
    }
}
