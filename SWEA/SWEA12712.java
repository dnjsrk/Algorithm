import java.util.Scanner;

public class SWEA12712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[] x1 = {-1, 1, 0, 0};
            int[] y1 = {0, 0, -1, 1};
            int[] x2 = {-1, -1, 1, 1};
            int[] y2 = {-1, 1, -1, 1};


            int maxSum = 0;

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int sum1 = arr[x][y];
                    int sum2 = arr[x][y];
                    for (int i = 1; i < m; i++) {
                        for (int j = 0; j < 4; j++) {
                            int newX1 = x + (x1[j] * i);
                            int newY1 = y + (y1[j] * i);
                            int newX2 = x + (x2[j] * i);
                            int newY2 = y + (y2[j] * i);

                            if (newX1 >= 0 && newX1 < n && newY1 >= 0 && newY1 < n) {
                                sum1 += arr[newX1][newY1];
                            }
                            if (newX2 >= 0 && newX2 < n && newY2 >= 0 && newY2 < n) {
                                sum2 += arr[newX2][newY2];
                            }
                        }
                    }
                    maxSum = Math.max(maxSum, Math.max(sum1, sum2));
                }
            }

            System.out.println("#" + tc + " " + maxSum);
        }
    }
}
