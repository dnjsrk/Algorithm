import java.util.Scanner;

public class SWEA4615 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n ;j++) {
                    arr[i][j] = 0;
                }
            }

            // 정가운데에 배치
            arr[n / 2 - 1][n / 2] = 1;
            arr[n / 2][n / 2 - 1] = 1;
            arr[n / 2 - 1][n / 2 - 1] = 2;
            arr[n / 2][n / 2] = 2;

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int p = sc.nextInt();
                int otherPlayer = (p == 1 ? 2 : 1);

                int[] x = {-1, -1, -1, 0, 1, 1, 1, 0};
                int[] y = {-1, 0, 1, 1, 1, 0, -1, -1};

                arr[a][b] = p;

                for (int k = 0; k < 8; k++) {
                    int pX = a + x[k];
                    int pY = b + y[k];
                    boolean isOk = false;

                    while (pX >= 0 && pX < n && pY >= 0 && pY < n && arr[pX][pY] != 0) {
                        if (arr[pX][pY] == p) {
                            isOk = true;
                            break;
                        }
                        pX += x[k];
                        pY += y[k];
                    }

                    if (isOk) {
                        pX = a + x[k];
                        pY = b + y[k];

                        while (arr[pX][pY] == otherPlayer) {
                            arr[pX][pY] = p;
                            pX += x[k];
                            pY += y[k];
                        }
                    }


                }
            }

            int white = 0;
            int black = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        black++;
                    } else if (arr[i][j] == 2) {
                        white++;
                    }
                }
            }

            System.out.println("#" + tc + " " + black + " " + white);
        }
    }
}
