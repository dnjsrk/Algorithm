import java.util.Scanner;

public class SWEA9490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[] x = {-1, 1, 0, 0};
            int[] y = {0, 0, -1, 1};

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int sum = arr[i][j];
                    int balloon = arr[i][j];

                    for (int a = 1; a <= balloon; a++) {
                        for (int b = 0; b < 4; b++) {
                            int moveX = i + x[b] * a;
                            int moveY = j + y[b] * a;

                            if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < m) {
                                sum += arr[moveX][moveY];
                                max = (sum > max ? sum : max);
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
